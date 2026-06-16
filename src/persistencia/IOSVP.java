package persistencia;

import modelo.*; //Llama todo
import utilidades.IdPersona;
import utilidades.Rut;
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
    public Object[] readDatosIniciales() {
        /*Lee el contenido del archivo de texto SVPDatosIniciales.txt y
        construye los objetos correspondientes de la capa modelo,
        incluyendo las asociaciones requeridas, si estas no se crean
        automáticamente en los constructores, u otros métodos
        invocados. Retorna un arreglo con todos los objetos creados. Lanza
        SVPException cuando no es posible abrir y/o leer el archivo
        asociando a la excepción un mensaje con el problema ocurrido*/
    }

    public void saveControladores(Object controladores) {
        /*Almacena los objetos que recibe como parámetro en un archivo de
        objetos llamado SVPObjetos.obj. Si no es posible abrir/crear el
        archivo o no se puede grabar por problemas en el dispositivo lanza
        SVPException indicando problema concreto*/
    }

    public Object[] readControladores() {
        /*Retorna un arreglo con los objetos que lee desde el archivo
        SVPObjetos.obj. Si no es posible abrir el archivo o leer los objetos
        almacenados en él, lanza SVPException indicando el problema
        concreto*/
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
