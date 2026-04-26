import java.time.LocalDate; //Linea 22
import java.time.LocalTime; //Linea 22

public class SistemaVentasPasajes {

    /*Por lo visto el Metodo createCliente utiliza como Parametro el Atributo de la Clase Persona idPersona.
    Y tambien utiliza como Parametro la Clase Nombre para
     */
    public boolean createCliente(idPersona id, Nombre nom, String fono, String email) {

    }

    //Aqui el Metodo createPasajero, usa como Parametro la Interface IdPersona y la Clase Nombre 2 veces
    public boolean createPasajero(IdPersona id, Nombre nom, String fono, Nombre nomContacto, String fonoContacto) {

    }

    public boolean createBus(String patente, String marca, String modelo, int nroAsientos) {

    }

    public boolean createViaje(LocalDate fecha, LocalTime hora, int precio, String patBus) {

    }

    //El Metodo iniciaVenta usa el Parametro TipoDocumento, el cual es un Enum, y idPersona, Atributo de la Clase Persona
    public boolean iniciaVenta(String idDoc, TipoDocumento tipo, LocalDate fechaVenta, idPersona idCliente) {

    }

    public String[][] getHorariosDisponibles(LocalDate fechaViaje) {

    }

    public String[][] listAsientosDeViaje(LocalDate fecha, LocalTime hora, String patBus) {

    }

    //La Clase getMontoVenta usa el Parametro TipoDocumento el cual es un Enum
    public int getMontoVenta(String idDocumento, TipoDocumento tipo) {

    }

    //La Clase getNombrePasajero utiliza la Interface IdPersona
    public String getNombrePasajero(IdPersona idPasajero) {

    }

    public boolean vendePasaje(String idDoc, LocalDate fecha, LocalTime hora, String patBus, int asiento, int idPasajero) { //Supongo que el idPasajero es int, a lo mejor no

    }

    public String[][] listVentas() {

    }

    public String[][] listViajes() {

    }

    public String[][] listPasajeros(LocalDate fecha, LocalTime hora, String patBus) {

    }


    private Cliente findCliente(IdPersona id) {

    }

    private Venta findVenta(String idDocumento, TipoDocumento tipoDocumento) {

    }

    private Bus findBus(String patente) {

    }

    private Viaje findViaje(String fecha, String hora, String patenteBus) {

    }

    private Pasajero findPasajero(IdPersona idPersona) {

    }

    //Faltan los returns https://www.youtube.com/watch?v=oUMsNjCDT8I

}
