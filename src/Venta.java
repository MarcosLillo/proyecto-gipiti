//Marcos Lillo
import java.time.LocalDate;

public class Venta {
    private  String idDocumento;
    private TipoDocumento tipo;
    private LocalDate fecha;

    public Venta(String id, TipoDocumento tipo, LocalDate fecha, Cliente cli) {
        this.id = id;
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
        return cliente;

    }

}
