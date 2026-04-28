//Marcos Lillo
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private Scanner sc = new Scanner(System.in);
    private SistemaVentaPasajes sistema = new SistemaVentaPasajes();
    public static void main(String[] args) {
        new Main().menu();
    }

    private void menu() {
        int opcion = 0;

        while (opcion != 9) {
            System.out.println("============================");
            System.out.println("...::: Menu principal :::...");
            System.out.println("1) Crear cliente");
            System.out.println("2) Crear bus");
            System.out.println("3) Crear viaje ");
            System.out.println("4) Vender pasaje");
            System.out.println("5) Lista de pasajeros");
            System.out.println("6) Lista de ventas");
            System.out.println("7) Lista de viajes");
            System.out.println("8) Consulta Viajes disponibles por fecha");
            System.out.println("9) Salir");
            System.out.println("-------------");
            System.out.print("Ingrese opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    createCliente();
                    break;
                case 2:
                    createBus();
                    break;
                case 3:
                    createViaje();
                    break;
                case 4:
                    vendePasajes();
                    break;
                case 5:
                    listPasajerosViaje();
                    break;
                case 6:
                    listVentas();
                    break;
                case 7:
                    listViajes();
                    break;
                case 8:
                    consultaViajesDisponibles();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
    private void createCliente(){
        System.out.println("...:::Crear nuevo cliente:::...");
        System.out.println("-------------------------------");
        System.out.println("Rut[1] o Pasaporte[2]: ");
        int tipoDoc = sc.nextInt();
        IdPersona id = null;

        if (tipoDoc == 1) {
            System.out.print("R.U.T : ");
            id = Rut.of(sc.nextLine());
        } else if (tipoDoc == 2) {
            System.out.print("Pasaporte : ");
            String num = sc.nextLine();
        } else {
            System.out.println("Tipo de documento inválido");
            return;
        }
        System.out.print("Sr.[1] o Sra. [2] : ");
        int genero = Integer.parseInt(sc.nextLine());
        Tratamiento titulo = (genero == 1) ? Tratamiento.SR : Tratamiento.SRA;
        System.out.print("Nombres : ");
        String nombres = sc.nextLine();

        System.out.print("Apellido Paterno : ");
        String apellidoPaterno = sc.nextLine();

        System.out.print("Apellido Materno : ");
        String apellidoMaterno = sc.nextLine();

        System.out.print("Telefono movil : ");
        String telefono = sc.nextLine();
        System.out.print("Email : ");
        String email = sc.nextLine();
        Nombre nombreCompleto = new Nombre(titulo, nombres, apellidoPaterno, apellidoMaterno);
        boolean exito = sistema.createCliente(id, nombreCompleto, telefono, email);
        if (exito) {
            System.out.println("...::::Cliente guardado exitosamente::::...");
        } else {
            System.out.println("El cliente ya existe ");
        }
    }
    private void createBus(){
        System.out.println("...::::Creacion de un nuevo BUS::::...");
        System.out.println("--------------------------------------");
        System.out.println("Patente: ");
        String patente = sc.nextLine();
        System.out.println("Marca: ");
        String marca = sc.nextLine();
        System.out.println("Modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Numero de asientos: ");
        int nroAsientos = sc.nextInt();
        boolean exito = sistema.createBus(patente, marca, modelo, nroAsientos);
        if(exito) {
            System.out.println("...::::Bus guardado exitosamente::::...");
        } else {
            System.out.println("Error, patente ya registrada.");
        }

    }
    private void createViaje(){
        System.out.println("...::::Creacion nuevo viaje::::...");
        System.out.println("Fecha [dd/mm/yyyyy]: ");
        System.out.println("Hora [hh:mm]: ");
        System.out.println("Precio: ");
        int precio = sc.nextInt();
        System.out.println("Patente bus: ");
    }
    private void vendePasajes(){
        System.out.println("...::::Venta de pasajes::::...");
        System.out.println("::::Datos de la venta");
        System.out.println("ID Documento: ");
        int idDocumento = sc.nextInt();
        System.out.println("Tipo documento: [1]Boleta [2]Factura: ");
        int tipoDocumento = sc.nextInt();
        System.out.println("Fecha de venta [dd/mm/yyyy]: ");
        System.out.println("::::Datos del cliente");
        System.out.println("Rut[1] o pasaporte[2]");
        int tipoId = sc.nextInt();
        System.out.println("R.U.T");
        String rut = sc.nextLine();
        System.out.println("Nombre cliente: ");




    }
    private void listPasajerosViaje(){
        System.out.println("...::::Listado de pasajeros de un viaje::::...");
        System.out.println("Fecha del viaje [dd/mm(yyyy]");
        LocalDate f = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Hora del viaje[hh:mm]");
        LocalTime h = LocalTime.parse(sc.nextLine());
        System.out.println("Patente bus: ");
        String patente = sc.nextLine();
        System.out.printf("| %-13s| %-13s| %-13s| %-13s| %-13s|%n",
                "ASIENTO", "RUT/PASS", "PASAJERO", "CONTACTO", "TELEFONO");
    }
    private void listVentas() {
        System.out.println("...::::Listado de ventas::::...");
        String[][] ventas = sistema.listVentas();

        if (ventas.length == 0) {
            System.out.println("No existen ventas registradas.");
            return;
        }
        System.out.printf("| %-13s| %-13s| %-13s| %-13s| %-13s| %-13s| %-13s|%n",
                "ID DOCUMENTO", "TIPO DOCU", "FECHA", "RUT/PASS", "CLIENTE", "CANT BOLETOS", "TOTAL VENTA");
        for (String[] v : ventas) {
            System.out.printf("| %-10s | %-10s | %-10s | $%-10s |\n", v[0], v[1], v[2], v[4]);
        }
        }

    }
    private void listViajes(){
        System.out.println("...::::Listado de viajes::::...");
        String[][] viajes = sistema.listViajes();
        if(viajes.length == 0){
            System.out.println("No existen viajes registrados.");
            return;
        }
        System.out.printf("| %-13s| %-13s| %-13s| %-13s| %-13s|%n",
                "FECHA", "HORA", "PRECIO", "DIPONIBLES", "PATENTE");
        for (String[] v : viajes) {
            System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", v[0], v[1], v[3], v[4]);
        }
    }
}



