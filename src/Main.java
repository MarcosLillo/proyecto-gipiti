//Marcos Lillo
import java.util.Scanner;

public class Main { //Testeo
    private Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        private void menu() {
            int opcion = 0;

            while (opcion != 5) {
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
                        crearBus();
                        break;
                    case 3:
                        crearViaje();
                        break;
                    case 4:
                        venderPasaje();
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
            String id = "";

            if (tipoDoc == 1) {
                System.out.print("R.U.T : ");
                id = sc.nextLine();
            } else if (tipoDoc == 2) {
                System.out.print("Pasaporte : ");
                id = sc.nextLine();
            } else {
                System.out.println("Tipo de documento inválido");
                return;
            }
            System.out.print("Sr.[1] o Sra. [2] : ");
            int genero = sc.nextInt();
            sc.nextLine();
            String titulo = "";
            if (genero == 1) {
                titulo = "Sr.";
            } else if (genero == 2) {
                titulo = "Sra.";
            } else {
                System.out.println("Genero incorrecto");
                return;
            }
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
            Cliente cliente = new Cliente(id, titulo, nombres, apellidoPaterno, apellidoMaterno, telefono, email);
            clientes.add(cliente);
            System.out.println("...::::Cliente guardado exitosamente::::...");
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
            for (Bus b : buses){
                if(b.getPatente().equalas(patente)){
                    System.out.println("Error, patente ya registrada: "+patente);
                    return;
                }
            }
            Bus bus = new Bus(patente, marca, modelo, nroAsientos);
            buses.add(bus);

            System.out.println("...::::Bus guardado exitosamente::::...");
        }
        private void createViaje(){
            System.out.println("...::::Creacion nuevo viaje::::...");
            System.out.println("Fecha [dd/mm/yyyyy]: ");
            System.out.println("Hora [hh:mm]: ");
            System.out.println("Precio: ");
            int precio = sc.nextInt();
            System.out.println("Patente bus: ");
        }

    }
}
