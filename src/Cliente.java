public class Cliente {

    private String email;

    //Faltan las Clases Id y Nombre
    public Cliente(IdPersona id, Nombre nom, String email) {

        this.email = email;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    //Pos la Clase Venta
    public void addVenta(Venta venta) {

        this.venta = venta;

    }

    public Venta[] getVentas() {

        return ventas; //:v

    }

}
