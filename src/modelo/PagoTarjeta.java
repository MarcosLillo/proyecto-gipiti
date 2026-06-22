//Marcos Lillo
package modelo;

public class PagoTarjeta extends Pago implements java.io.Serializable {
    private long nroTarjeta;

    public PagoTarjeta(int monto, long nroTarjeta) {
        super(monto);
        this.nroTarjeta = nroTarjeta;
    }

    public long getNroTarjeta() {
        return this.nroTarjeta;
    }
}