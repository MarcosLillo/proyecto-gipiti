package persistencia;

import excepciones.SVPException;
import java.io.*;
import modelo.*; //Llama todo
import utilidades.*;

import javax.imageio.event.IIOWriteProgressListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IOSVP {

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

    //UML
    public Object[] readDatosIniciales() throws SVPException {

        /*Lee el contenido del archivo de texto SVPDatosIniciales.txt y
        construye los objetos correspondientes de la capa modelo,
        incluyendo las asociaciones requeridas, si estas no se crean
        automáticamente en los constructores, u otros métodos
        invocados. Retorna un arreglo con todos los objetos creados. Lanza
        SVPException cuando no es posible abrir y/o leer el archivo
        asociando a la excepción un mensaje con el problema ocurrido*/

        File archivo = new File("SVPDatosIniciales.txt");
        ArrayList<Object> objectList = new ArrayList<>();

        //Inicializar los objetos, falta incluir mas weas ptm
        Auxiliar aux = null;
        Bus bus = null;
        Cliente cliente = null;
        Conductor conductor = null;
        Empresa empresa = null;
        Pago pago = null;
        Pasaje pasaje = null;
        Pasajero pasajero = null;
        Persona persona = null;
        Terminal terminal = null;
        Tripulante tripulante = null;
        Venta venta = null;
        Viaje viaje = null;

        //Me centro mejor en lo demas por ahora
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

            return obj;

        } catch (FileNotFoundException e) {
            throw new SVPException("Ah ocurrido un error al crear el archivo SVPObjetos.obj");
        } catch (IOException e) {
            throw new SVPException("No se puede leer el archivo SVPObject.obj");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePasajesDeVentas(Pasaje[] pasajes, String nombreArchivo) {
        /*Graba los pasajes que recibe como primer parámetro en el archivo
        de texto cuyo nombre recibe como segundo parámetro. El formato
        que deben tener los pasajes se muestra en la Figura 3. Se debe
        cuidar de separar adecuadamente los pasajes en el archivo. Si no
        es posible abrir/crear el archivo o grabar en él, lanza SVPException*/
    }

    //3 Optional

    /*Revisa la colección recibida como primer parámetro y retorna un
    objeto Optional con el objeto contenido en la colección que
    satisfaga el criterio de búsqueda dado por el segundo parámetro.
    Retorna un objeto Optional vacío si la búsqueda no es exitosa*/

    private Optional<Empresa> findEmpresa(List<Empresa> empresas, Rut rut) {
    }

    private Optional<Tripulante> findTripulante(Empresa empresa, IdPersona id) {
    }

    private Optional<Bus> findBus(List<Bus> buses, String patente) {
    }

    private Optional<Terminal> findTerminal(List<Terminal> terminales, String nombre) {
        /*Revisa los tripulantes contratados por la empresa que recibe como
        primer parámetro y retorna un objeto Optional con el tripulante
        cuyo id coincide con el recibido como segundo parámetro y que
        desempeñe el rol indicado como tercer parámetro (los roles son
                “Auxiliar” o “Conductor”). Retorna un objeto Optional vacío si la
        búsqueda no es exitosa*/
    }

}
