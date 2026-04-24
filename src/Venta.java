//Marcos Lillo
import java.time.LocalDate;

public class Venta {
    private  String idDocumento;
    private TipoDocumento tipo;
    private LocalDate fecha;
    private Cliente cli;

    public Venta(String id, TipoDocumento tipo, LocalDate fecha, Cliente cli) {
        this.idDocumento = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.cli = cli;
    }

    public String getIdDocumento() {

        return idDocumento;
    }

    public TipoDocumento getTipo() {

        return tipo;
    }

    public LocalDate getFecha() {

        return fecha;
    }
    public Cliente getCliente(){
        return cli;

    }
    public Pasaje[] getPasajes() {
        return pasajes.toArray(new Pasaje[0]);
    }
    public void createPasaje(int asiento, Viaje viaje, Pasajero pasajero){
        Pasaje pasaje = new Pasaje(asiento, viaje, pasajero, this);
        pasajes.add(pasaje);
    }

    public int getMonto() {

    }


}
