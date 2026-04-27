import java.time.LocalDate;
import java.time.LocalTime;

public class Viaje {

    private LocalDate fecha;
    private LocalTime hora;
    private int precio;
    //Se aparentemente infiere por el UML
    private Bus bus;
    private String[][] asientos;
    private Pasaje pasaje;
    private String[][] listaPasajeros;
    private int nroAsientosDisponibles;

    //Clase Bus
    public Viaje(LocalDate fecha, LocalTime hora, int precio, Bus bus) {

        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;

        //Inferidos
        this.bus = bus;
        this.asientos = new String[bus.getNroAsientos()][1]; //Se medio acomoda automaticamente el diablo
        this.listaPasajeros = new String[bus.getNroAsientos()][1];
        this.nroAsientosDisponibles = bus.getNroAsientos();

        for (int i = 0; i < asientos.length; i++) {
            asientos[i][0] = "V"; //V de Vacio
        }

        /*Crea un nuevo Viaje con los datos que recibe como parámetro,
        los cuales supone correctos, asegurándose que el objeto Bus
        correspondiente agregue a su colección este viaje*/

    }

    public LocalDate getFecha() {

        return fecha;

    }

    public LocalTime getHora() {

        return hora;

    }

    public int getPrecio() {

        return precio;

    }

    public void setPrecio(int precio) {

        this.precio = precio;

    }

    public Bus getBus() {

        return bus;

    }

    public String[][] getAsientos() {

        return asientos;

        /*Retorna un arreglo bidimensional donde, por cada asiento
        existente en el bus para este viaje, indica su número (valor
        mayor o igual a 1) y si este se encuentra libre u ocupado*/

    }

    public void addPasaje(Pasaje pasaje) {

        int asiento = pasaje.getAsiento();
        asiento = asiento - 1;

        //Rango
        if (asiento < 0 || asiento >= asientos.length) {
            System.out.println("Asiento no valido");
            return;
        }

        //(asientos[asiento][0].equals("O"), tambien sirve
        //Si el asiento es distinto a Vacio osea 0cupado, creo
        if (!asientos[asiento][0].equals("V")) {
            System.out.println("Asiento Ocupado");
            return;
        }

            //V de vacio, O de ocupado
            asientos[asiento][0] = "O";
            listaPasajeros[asiento][0] = pasaje.getPasajero().getNombreCompleto();
            nroAsientosDisponibles--;

    }

    public String[][] getListaPasajeros() {

        return listaPasajeros;

        /*Retorna un arreglo bidimensional con los datos de los pasajeros
        que tienen un pasaje asignado. Por cada pasajero (fila) indica:
        id, nombre, nombre del contacto y número de teléfono del
        contacto, cada uno de estos datos en una columna separada*/


    }

    public boolean existeDisponibilidad() {

        return nroAsientosDisponibles > 0;

        /*Retorna true si para este viaje existe, al menos, un asiento
        disponible*/

    }

    public int getNroAsientosDisponibles() {

        return nroAsientosDisponibles;

        /*Retorna el número de asientos que aún tiene disponibles (no se
        han vendido)*/

    }

}
