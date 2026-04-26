import java.time.LocalDate;
import java.time.LocalTime;

public class Viaje {

    private LocalDate fecha;
    private LocalTime hora;
    private int precio;

    //Clase Bus
    public Viaje(LocalDate fecha, LocalTime hora, int precio, Bus bus) {

        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;

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

    }

    public void addPasaje(Pasaje pasaje) {

        this.pasaje = pasaje;

    }

    public String[][] getListaPasajeros() {

        return listaPasajeros;

    }

    public boolean existeDisponibilidad() {
        //Holy shit
        return 0;

    }

    public int getNroAsientosDisponibles() {

        return nroAsientosDisponibles;

    }

}
