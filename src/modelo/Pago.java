package modelo;

public abstract class Pago implements java.io.Serializable {
    private int monto;

    public Pago(int monto){
        this.monto = monto;
    }

    public int getMonto() {
        return this.monto;
    }
}
