import java.time.LocalDate;
import java.time.LocalTime;

public class Viaje {

    private LocalDate fecha;
    private LocalTime hora;
    private int precio;

    //Se aparentemente infiere por el UML
    private Bus bus;
    private String[][] asientos; //Vacio o Ocupado
    private String[][] listaPasajeros;
    private int nroAsientosDisponibles;

    //Crea cada vez, un viaje nuevo, guarda fecha, precio y el bus
    public Viaje(LocalDate fecha, LocalTime hora, int precio, Bus bus) {

        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;

        this.bus = bus;
        int capacidad = bus.getNroAsientos(); //Para resumir
        this.asientos = new String[capacidad][1];
        this.listaPasajeros = new String[capacidad][4];
        this.nroAsientosDisponibles = capacidad;

        for (int i = 0; i < capacidad; i++) {
            asientos[i][0] = "V";
        }

    }

    //Fecha local, el cuando es el viaje
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

        int index = pasaje.getAsiento() - 1;

        if (index < 0 || index >= asientos.length) {
            System.out.println("Asiento no válido");
            return;
        }

        if (!asientos[index][0].equals("V")) {
            System.out.println("Asiento ocupado");
            return;
        }

        asientos[index][0] = "O"; //Ocupado

        listaPasajeros[index][0] = pasaje.getPasajero().getIdPersona().toString();
        listaPasajeros[index][1] = pasaje.getPasajero().getNombreCompleto();
        listaPasajeros[index][2] = pasaje.getPasajero().getNomContacto();
        listaPasajeros[index][3] = pasaje.getPasajero().getFonoContacto();

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
