import java.time.LocalDate; //Linea 22
import java.time.LocalTime; //Linea 22

public class SistemaVentaPasajes {

    /*Por lo visto el Metodo createCliente utiliza como Parametro el Atributo de la Clase Persona idPersona.
    Y tambien utiliza como Parametro la Clase Nombre para*/
    public boolean createCliente(IdPersona id, Nombre nom, String fono, String email) {

        /*Crea un objeto Cliente con los datos que se reciben como
        parámetro y se almacena en la colección correspondiente,
        siempre que no exista otro cliente con el mismo idPersona.
        Retorna true si la acción se puede realizar, false en caso
        contrario*/


    }

    //Aqui el Metodo createPasajero, usa como Parametro la Interface IdPersona y la Clase Nombre 2 veces
    public boolean createPasajero(IdPersona id, Nombre nom, String fono, Nombre nomContacto, String fonoContacto) {

       /*Crea un objeto Pasajero con los datos que se reciben como
        parámetro y se almacena en la colección correspondiente,
        siempre que no exista otro pasajero con el mismo idPersona.
        Retorna true si la acción se puede realizar, false en caso
        contrario*/

    }

    public boolean createBus(String patente, String marca, String modelo, int nroAsientos) {

        /*Crea un objeto Bus con los datos que se reciben como
        parámetro y se almacena en la colección correspondiente,
        siempre que no exista otro bus con la misma patente. Retorna
        true si la acción se puede realizar, false en caso contrario*/

    }

    public boolean createViaje(LocalDate fecha, LocalTime hora, int precio, String patBus) {

        /*Crea un objeto Viaje a partir de los datos que se reciben como
        parámetro y se almacena en la colección correspondiente,
        siempre que no exista otro viaje con la misma fecha y hora de
        salida para el bus que se indica. Retorna true si la acción se
        puede realizar, false en caso contrario*/

    }

    //El Metodo iniciaVenta usa el Parametro TipoDocumento, el cual es un Enum, y idPersona, Atributo de la Clase Persona
    public boolean iniciaVenta(String idDoc, TipoDocumento tipo, LocalDate fechaVenta, IdPersona idCliente) {

        /*Crea una nueva venta con los datos que se reciben como
        parámetro. Nótese que el cliente cuyo id se recibe como
        parámetro ya debiera existir en el sistema. El método retorna
        true si se puede realizar la acción y false si no es posible llevarlo
        a cabo porque ya existe una venta con el idDocumento dado o
        si no existe un cliente con el id dado*/


    }

    public String[][] getHorariosDisponibles(LocalDate fechaViaje) {

        /*Retorna un arreglo bidimensional con datos relevantes de los
        viajes que se realizarán/realizaron en la fecha que se pasa como
        parámetro. Los datos que se incluyen por cada viaje son patente
        del bus que lo realiza, hora, precio de un pasaje y el número de
        asientos disponibles de. Si no existen viajes en la fecha que se
        indica, el método retorna un arreglo de tamaño cero*/

    }

    public String[][] listAsientosDeViaje(LocalDate fecha, LocalTime hora, String patBus) {

        /*Retorna un arreglo unidimensional donde, por cada asiento del
        viaje con fecha y hora que se indican como parámetro, que
        posee el bus cuya patente se recibe como tercer parámetro,
        indica si se encuentra ocupado o libre. El método retorna un
        arreglo de tamaño cero si no existe un viaje con los datos que se
        indican*/

    }

    //La Clase getMontoVenta usa el Parametro TipoDocumento el cual es un Enum
    public int getMontoVenta(String idDocumento, TipoDocumento tipo) {

        /*Retorna el monto de la venta cuyo idDocumento y tipo se pasan
        como parámetro. Si no existe una venta con los datos que se
        indican, retorna cero*/

    }

    //La Clase getNombrePasajero utiliza la Interface IdPersona
    public String getNombrePasajero(IdPersona idPasajero) {

        /*Retorna el nombre del pasajero cuyo idPasajero se pasa como
        parámetro, null en caso de que no exista un pasajero con el id
        dado*/


    }

    public boolean vendePasaje(String idDoc, LocalDate fecha, LocalTime hora, String patBus, int asiento, int idPasajero) { //Supongo que el idPasajero es int, a lo mejor no

        /*Solicita a la venta, cuyo idDocumento y tipo se recibe como
        parámetros, crear un nuevo pasaje asociado al viaje cuya fecha
        y hora de salida se indican asociado al bus con la patente dada,
        ligando al nuevo pasaje, el pasajero correspondiente. Respecto
        de este último, el método recupera el pasajero cuyo idPersona
        se recibe como parámetro. El método retorna true si es posible
        crear el nuevo pasaje asociándolo a la venta. Si no es posible
        crear el nuevo pasaje porque no existe una venta con el
        idDocumento y tipo dados o no existe un viaje con los datos
        dados o no existe un bus cuya patente se indica o no existe un
        pasajero con el id dado, el método retorna false*/


    }

    public String[][] listVentas() {

        /*Retorna un arreglo bidimensional con los datos que se observan
        en el listado de ventas realizadas de la Figura 12*/

    }

    public String[][] listViajes() {

        /*Retorna un arreglo bidimensional con los datos que se observan
        en el listado de viajes registrados de la Figura 13*/

    }

    public String[][] listPasajeros(LocalDate fecha, LocalTime hora, String patBus) {

        /*Retorna un arreglo bidimensional con los datos que se observan
        en el listado de pasajeros del viaje cuyos datos se indican
        incluyendo la patente del bus que realiza dicho viaje*/

    }


    //No datos
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
