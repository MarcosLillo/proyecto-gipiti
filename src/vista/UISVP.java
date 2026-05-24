package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

//Singleton
public class UISVP {

    //Lo que carateriza a un singleton
    private static UISVP instance;

    private Scanner sc;

    private UISVP() {
        Scanner sc = new Scanner(System.in);
    }

    //Esto asegura que se cree una instancia si no la hay, si la hay, que se mantenga igual osea que se reutilize, es caracteristico de los singleton
    public static UISVP getInstance() {
        if (instance == null) {
            instance = new UISVP();
        }
        return instance;
    }

    //Lo que se vera como menu so...
    public void menu() {
        boolean salir = false;

        while (salir != true) { //(!salir)

            System.out.println("===============================================");
            System.out.println("          ...::: Menú principal :::...         ");
            System.out.println("1)  Crear empresa");
            System.out.println("2)  Contratar tripulante");
            System.out.println("3)  Crear terminal");
            System.out.println("4)  Crear cliente");
            System.out.println("5)  Crear bus");
            System.out.println("6)  Crear viaje");
            System.out.println("7)  Vender pasajes");
            System.out.println("8)  Listar ventas");
            System.out.println("9)  Listar viajes");
            System.out.println("10) Listar pasajeros de viaje");
            System.out.println("11) Listar empresas");
            System.out.println("12) Listar llegadas/salidas de terminal");
            System.out.println("13) Listar ventas de empresa");
            System.out.println("14) Salir");
            System.out.println("------------------------------------------------");
            System.out.print("..:: Ingrese número de opción: ");
            int opcion;
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opcion elegida invalida, ingresela nuevamente: ");
                opcion = sc.nextInt();
               //sc.nextLine(); //buffer, problemas de los next"Int"
            }

            switch (opcion) {
                case 1:
                    createEmpresa();
                    break;
                case 2:
                    contrataTripulante();
                    break;
                case 3:
                    createTerminal();
                    break;
                case 4:
                    createCliente();
                    break;
                case 5:
                    createBus();
                    break;
                case 6:
                    createViaje();
                    break;
                case 7:
                    vendePasajes();
                    break;
                case 8:
                    listVentas();
                    break;
                case 9:
                    listViajes();
                    break;
                case 10:
                    listPasajerosViaje();
                    break;
                case 11:
                    listEmpresas();
                    break;
                case 12:
                    listLlegadasSalidasTerminal();
                    break;
                case 13:
                    listVentasEmpresa();
                    break;
                case 14:
                    salir = true;
                    break;
                default:
                    System.out.println("????");
            }
        }
    }


}
