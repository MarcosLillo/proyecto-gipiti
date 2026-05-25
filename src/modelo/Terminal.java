package modelo;
import java.util.*;
import utilidades.Direccion;
public class Terminal {
    private String nombre;
    private Direccion dir;
    private List<Viaje> viajesLlegada, viajesSalida;

    public Terminal(String nombre, Direccion dir) {
        this.nombre = nombre;
        this.dir = dir;
        this.viajesLlegada = new ArrayList<>();
        this.viajesSalida = new ArrayList<>();
    }
}
