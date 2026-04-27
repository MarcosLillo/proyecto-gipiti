import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String email;
    private List<Venta> ventas;

    public Cliente(IdPersona id, Nombre nom, String email) {

        this.email = email;
        this.ventas = new ArrayList<>();

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public void addVenta(Venta venta) {

        this.ventas.add(venta);

    }

    public Venta[] getVentas() {

        return ventas.toArray(new Venta[0]);

    }

}