package persistencia;

import excepciones.SVPException;
import java.io.*;
import modelo.*;
import utilidades.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class IOSVP {

    private List<Empresa> empresas = new ArrayList<>();
    private List<Terminal> terminales = new ArrayList<>();
    private List<Tripulante> tripulantes = new ArrayList<>();
    private List<Bus> buses = new ArrayList<>();

    private static IOSVP instance;

    private IOSVP() {

    }

    //Propio de un singleton
    public static IOSVP getInstance() {

        if (instance == null) {
            instance = new IOSVP();
        }
        return instance;
    }

    public Object[] readDatosIniciales() throws SVPException {

        String[] linea;
        int cantPlus = 0;

        File archivo = new File("SVPDatosIniciales.txt");

        ArrayList<Object> objetosList = new ArrayList<>();

        //Inicializar los objetos, ordenado

        //Atributos compartidos por cliente y pasajero
        IdPersona id = null;
        Nombre nom = null;

        //Atributos Cliente
        Cliente cliente = null;

        //Atributos Pasajero
        Pasajero pasa = null;
        Nombre nomContacto = null;

        //Atributos Nombre
        Tratamiento tratamiento = null;

        //Atributos viaje
        Viaje viaje = null;

        //Atributos empresa
        Empresa emp = null;
        Rut rutEmp = null;

        //Atributos tripulante
        Conductor cond = null;
        Auxiliar aux = null;

        //Atributos terminal
        Direccion dir = null;
        Terminal terminal = null;

        Optional<Tripulante> condOpt = Optional.empty(), auxOpt = Optional.empty();
        Terminal terminalLlegada = null, terminalSalida = null;

        Optional<Terminal> termOpt = Optional.empty();

        //Atributos Bus
        Bus bus = null;
        Optional<Bus> busOpt = Optional.empty();

        //Fechas
        LocalDate fecha = null;
        LocalTime hora = null;

        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter horaFormato = DateTimeFormatter.ofPattern("HH:mm");

        //Scanner
        Scanner leer;

        try {
            leer = new Scanner(archivo);
        } catch (FileNotFoundException e) {
            throw new SVPException("No se puede leer o abrir el archivo SVPDatosIniciales.txt");
        }

        while (leer.hasNextLine()) {
            linea = leer.nextLine().split(";");

            if (linea[0].charAt(0) == ('+')) {
                cantPlus++;
                if (leer.hasNextLine()) {
                    linea = leer.nextLine().split(";");
                }
            }

            switch (cantPlus) {
                case 0: //Clientes y pasajeros
                    id = parseRut(linea[1]);

                    if (linea[2].equalsIgnoreCase("sr")) {
                        tratamiento = Tratamiento.SR;
                    } else {
                        tratamiento = Tratamiento.SRA;
                    }

                    nom = new Nombre(linea[3], linea[4], linea[5], tratamiento);

                    if (linea[0].equalsIgnoreCase("c")) {
                        cliente = new Cliente(id, nom, linea[6], linea[7]);
                        objetosList.add(cliente);
                    } else {
                        if (linea[0].equalsIgnoreCase("p")) {
                            if (linea[7].equalsIgnoreCase("sr")) {
                                tratamiento = Tratamiento.SR;
                            } else {
                                tratamiento = Tratamiento.SRA;
                            }

                            nomContacto = new Nombre(linea[8], linea[9], linea[10], tratamiento);
                            pasa = new Pasajero(id, nom);
                            pasa.setTelefono(linea[6]);
                            pasa.setNomContacto(nomContacto);
                            pasa.setFonoContacto(linea[11]);

                            objetosList.add(pasa);
                        } else {
                            if (linea[0].equalsIgnoreCase("cp")) {
                                if (linea[8].equalsIgnoreCase("sr")) {
                                    tratamiento = Tratamiento.SR;
                                } else {
                                    tratamiento = Tratamiento.SRA;
                                }

                                nomContacto = new Nombre(linea[9], linea[10], linea[11], tratamiento);
                                cliente = new Cliente(id, nom, linea[6], linea[7]);

                                pasa = new Pasajero(id, nom);
                                pasa.setTelefono(linea[6]);
                                pasa.setNomContacto(nomContacto);
                                pasa.setFonoContacto(linea[12]);

                                objetosList.add(cliente);
                                objetosList.add(pasa);
                            }
                        }
                    }
                    break;

                case 1: //Empresas
                    rutEmp = parseRut(linea[0]);

                    emp = new Empresa(rutEmp, linea[1]);
                    emp.setUrl(linea[2]);

                    objetosList.add(emp);
                    empresas.add(emp);
                    break;

                case 2: //Tripulantes (Conductores y Auxiliares)
                    id = parseRut(linea[1]);

                    if (linea[2].equalsIgnoreCase("sr")) {
                        tratamiento = Tratamiento.SR;
                    } else {
                        tratamiento = Tratamiento.SRA;
                    }

                    nom = new Nombre(linea[3], linea[4], linea[5], tratamiento);
                    dir = new Direccion(linea[6], Integer.parseInt(linea[7]), linea[8]);

                    Optional<Empresa> empOpt = findEmpresa(empresas, parseRut(linea[9]));

                    if (empOpt.isPresent()) {
                        emp = empOpt.get();

                        if (linea[0].equalsIgnoreCase("c")) {
                            emp.addConductor(id, nom, dir);

                            Optional<Tripulante> condRecuperado = findTripulante(emp, id);
                            if (condRecuperado.isPresent()) {
                                cond = (Conductor) condRecuperado.get();
                                objetosList.add(cond);
                                tripulantes.add(cond);
                            }

                        } else if (linea[0].equalsIgnoreCase("a")) {
                            emp.addAuxiliar(id, nom, dir);

                            Optional<Tripulante> auxRecuperado = findTripulante(emp, id);
                            if (auxRecuperado.isPresent()) {
                                aux = (Auxiliar) auxRecuperado.get();
                                objetosList.add(aux);
                                tripulantes.add(aux);
                            }
                        }
                    } else {
                        System.out.println("Empresa no encontrada para el tripulante con ID: " + id);
                    }
                    break;

                case 3: //Terminales
                    dir = new Direccion(linea[1], Integer.parseInt(linea[2]), linea[3]);
                    terminal = new Terminal(linea[0], dir);

                    objetosList.add(terminal);
                    terminales.add(terminal);
                    break;

                case 4: //Buses
                    Optional<Empresa> empBusOpt = findEmpresa(empresas, parseRut(linea[4]));

                    if (empBusOpt.isPresent()) {
                        emp = empBusOpt.get();

                        bus = new Bus(linea[0], Integer.parseInt(linea[3]), emp);
                        emp.addBus(bus);

                        objetosList.add(bus);
                        buses.add(bus);
                    } else {
                        System.out.println("Empresa no encontrada para el Bus: " + linea[0]);
                    }
                    break;

                case 5:
                    bus = null;
                    aux = null;
                    cond = null;
                    terminalSalida = null;
                    terminalLlegada = null;

                    fecha = LocalDate.parse(linea[0], fechaFormato);
                    hora = LocalTime.parse(linea[1], horaFormato);

                    busOpt = findBus(buses, linea[4]);

                    if (busOpt.isPresent()) {
                        bus = busOpt.get();

                        Empresa empresaDelViaje = bus.getEmpresa();

                        id = parseRut(linea[5]);
                        auxOpt = findTripulante(empresaDelViaje, id);

                        id = parseRut(linea[6]);
                        condOpt = findTripulante(empresaDelViaje, id);

                        if (auxOpt.isPresent() && auxOpt.get() instanceof Auxiliar) {
                            aux = (Auxiliar) auxOpt.get();
                        }

                        if (condOpt.isPresent() && condOpt.get() instanceof Conductor) {
                            cond = (Conductor) condOpt.get();
                        }
                    }

                    termOpt = findTerminal(terminales, linea[7]);
                    if (termOpt.isPresent()) {
                        terminalSalida = termOpt.get();
                    }

                    termOpt = findTerminal(terminales, linea[8]);
                    if (termOpt.isPresent()) {
                        terminalLlegada = termOpt.get();
                    }

                    if (bus != null && terminalLlegada != null && terminalSalida != null && aux != null && cond != null) {
                        viaje = new Viaje(fecha, hora, Integer.parseInt(linea[2]), Integer.parseInt(linea[3]), bus, aux, cond, terminalSalida, terminalLlegada);
                        objetosList.add(viaje);
                    } else {
                        System.out.println("..:: Error al recuperar viaje ::..");
                    }
                    break;
            }
        }

        leer.close();
        return objetosList.toArray();
    }

    public void saveControladores(Object controladores) throws SVPException {

        try {
            File archivo = new File("SVPObjetos.obj"); //Referencia del archivo en la memoria
            FileOutputStream fileOutput = new FileOutputStream(archivo); //Prepara el escribir datos en el archivo, si algo ya exoste se sobrescribe
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput); //La serializacion, guarda el estado del objeto

            objOutput.writeObject(controladores); //Envia el objeto controlador

            objOutput.close();
            fileOutput.close();

        } catch (FileNotFoundException e) { //FileOutputStream
            throw new SVPException("Ah ocurrido un error al crear el archivo SVPObjetos.obj");
        } catch (IOException e) { //ObjectOutputStream
            throw new SVPException("No se puede guardar en el archivo SVPObjetos.obj");
        }
    }

    public Object[] readControladores() throws SVPException {

        try {
            File archivo = new File("SVPObjetos.obj");
            FileInputStream input = new FileInputStream(archivo);
            ObjectInputStream objInput = new ObjectInputStream(input);

            Object[] obj = (Object[])objInput.readObject();

            if (obj.length == 0) {
                System.out.println("No se pudo leer los datos");
            }

            objInput.close();
            input.close();

            return obj;

        } catch (FileNotFoundException e) {
            throw new SVPException("Ah ocurrido un error al crear el archivo SVPObjetos.obj");
        } catch (IOException e) {
            throw new SVPException("No se puede leer el archivo SVPObject.obj");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePasajesDeVenta(Pasaje[] pasajes, String nombreArchivo) throws SVPException {

        try {

            File archivo = new File(nombreArchivo);

            archivo.createNewFile();
            PrintWriter print = new PrintWriter(archivo);
            IntStream.range(0, pasajes.length).filter(i -> pasajes[i] != null).forEach(i -> print.write(pasajes[i].toString()));
            print.close();

        } catch (IOException e) {
            throw new SVPException("El archivo: " + nombreArchivo + ", no se puede abrir o crear");
        }
    }

    //Optional
    private Optional<Empresa> findEmpresa(List<Empresa> empresas, Rut rut) {
        return empresas.stream().filter(e -> e.getRut().equals(rut)).findFirst();
    }

    private Optional<Tripulante> findTripulante(Empresa empresa, IdPersona id) {

        if (empresa == null || id == null) {
            return Optional.empty();
        }

        for (Tripulante t : empresa.getTripulantes()) {
            if (t != null && t.getIdPersona().equals(id)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    private Optional<Bus> findBus(List<Bus> buses, String patente) {
        return buses.stream().filter(b -> b.getPatente().equals(patente)).findFirst();
    }

    private Optional<Terminal> findTerminal(List<Terminal> terminales, String nombre) {
        return terminales.stream().filter(t -> t.getNombre().equals(nombre)).findFirst();
    }

    //Metodo privado, su uso es un tanto auto explicativo :v
    private Rut parseRut(String rut) {

        if (rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-[0-9Kk]")) {
            String[] rutStr = rut.split("[.-]");
            return new Rut((Integer.parseInt(rutStr[0] + rutStr[1] + rutStr[2])), rutStr[3].charAt(0));
        } else {
            if (rut.matches("\\d{7,8}-[0-9Kk]")) {
                String[] rutStr = rut.split("-");
                return new Rut(Integer.parseInt(rutStr[0]), rutStr[1].charAt(0));
            }
        }
        return null;
    }

}
