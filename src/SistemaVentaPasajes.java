import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SistemaVentaPasajes {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Bus> buses = new ArrayList<>();
    private List<Viaje> viajes = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();
    private List<Pasajero> pasajeros = new ArrayList<>();



    public boolean createCliente(IdPersona id, Nombre nom, String fono, String email) {
        if (findCliente(id) != null) return false;
        Cliente nuevo = new Cliente(id, nom, email);
        return clientes.add(nuevo);
    }

    public boolean createPasajero(IdPersona id, Nombre nom, String fono, Nombre nomContacto, String fonoContacto) {
        if (findPasajero(id) != null) return false;
        Pasajero nuevo = new Pasajero(id, nom);
        nuevo.setTelefono(fono);
        nuevo.setNomContacto(nomContacto);
        nuevo.setFonoContacto(fonoContacto);
        return pasajeros.add(nuevo);
    }

    public boolean createBus(String patente, String marca, String modelo, int nroAsientos) {
        if (findBus(patente) != null) return false; // Valida patente única
        Bus nuevo = new Bus(patente, nroAsientos);
        nuevo.setMarca(marca);
        nuevo.setModelo(modelo);
        return buses.add(nuevo);
    }

    public boolean createViaje(LocalDate fecha, LocalTime hora, int precio, String patBus) {
        Bus busEncontrado = findBus(patBus);
        if (busEncontrado == null) return false;

        // Valida que no exista otro viaje para el mismo bus en ese horario
        for (Viaje v : viajes) {
            if (v.getFecha().equals(fecha) && v.getHora().equals(hora) && v.getBus().getPatente().equals(patBus)) {
                return false;
            }
        }

        Viaje nuevo = new Viaje(fecha, hora, precio, busEncontrado);
        return viajes.add(nuevo);
    }

    // --- GESTIÓN DE VENTAS Y PASAJES [cite: 108, 111, 113, 669] ---

    public boolean iniciaVenta(String idDoc, TipoDocumento tipo, LocalDate fechaVenta, IdPersona idCliente) {
        if (findVenta(idDoc, tipo) != null) return false;
        Cliente cli = findCliente(idCliente);
        if (cli == null) return false; // El cliente debe existir previamente

        Venta nueva = new Venta(idDoc, tipo, fechaVenta, cli);
        return ventas.add(nueva);
    }

    public boolean vendePasaje(String idDoc, LocalDate fecha, LocalTime hora, String patBus, int asiento, IdPersona idPasajero) {
        Venta v = findVenta(idDoc, TipoDocumento.BOLETA);
        if (v == null) v = findVenta(idDoc, TipoDocumento.FACTURA);

        Viaje viaje = null;
        for (Viaje temp : viajes) {
            if (temp.getFecha().equals(fecha) && temp.getHora().equals(hora) && temp.getBus().getPatente().equals(patBus)) {
                viaje = temp;
                break;
            }
        }

        Pasajero p = findPasajero(idPasajero);

        if (v == null || viaje == null || p == null) return false;

        v.createPasaje(asiento, viaje, p); // Liga el pasaje a la venta y viaje [cite: 669]
        return true;
    }

    public int getMontoVenta(String idDoc, TipoDocumento tipo) {
        Venta v = findVenta(idDoc, tipo);
        return (v != null) ? v.getMonto() : 0;
    }

    public String getNombrePasajero(IdPersona id) {
        Pasajero p = findPasajero(id);
        return (p != null) ? p.getNombreCompleto().toString() : null;
    }

    // --- MÉTODOS DE CONSULTA Y LISTADOS [cite: 109, 110, 114, 115, 665, 669] ---

    public String[][] getHorariosDisponibles(LocalDate fecha) {
        List<Viaje> filtrados = new ArrayList<>();
        for (Viaje v : viajes) {
            if (v.getFecha().equals(fecha) && v.existeDisponibilidad()) {
                filtrados.add(v);
            }
        }

        String[][] data = new String[filtrados.size()][4];
        for (int i = 0; i < filtrados.size(); i++) {
            Viaje v = filtrados.get(i);
            data[i][0] = v.getBus().getPatente();
            data[i][1] = v.getHora().toString();
            data[i][2] = String.valueOf(v.getPrecio());
            data[i][3] = String.valueOf(v.getNroAsientosDisponibles());
        }
        return data;
    }

    public String[] listAsientosDeViaje(LocalDate fecha, LocalTime hora, String patBus) {
        for (Viaje v : viajes) {
            if (v.getFecha().equals(fecha) && v.getHora().equals(hora) && v.getBus().getPatente().equals(patBus)) {
                String[][] matriz = v.getAsientos(); // Obtiene matriz del objeto Viaje [cite: 662]
                String[] listado = new String[matriz.length];
                for (int i = 0; i < matriz.length; i++) {
                    listado[i] = matriz[i][1]; // "LIBRE" u "OCUPADO"
                }
                return listado;
            }
        }
        return new String[0];
    }

    public String[][] listVentas() {
        String[][] list = new String[ventas.size()][5];
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            list[i][0] = v.getIdDocumento();
            list[i][1] = v.getTipo().toString();
            list[i][2] = v.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            list[i][3] = v.getCliente().getIdPersona().toString();
            list[i][4] = String.valueOf(v.getMonto());
        }
        return list;
    }

    public String[][] listViajes() {
        String[][] list = new String[viajes.size()][5];
        for (int i = 0; i < viajes.size(); i++) {
            Viaje v = viajes.get(i);
            list[i][0] = v.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            list[i][1] = v.getHora().toString();
            list[i][2] = String.valueOf(v.getPrecio());
            list[i][3] = String.valueOf(v.getNroAsientosDisponibles());
            list[i][4] = v.getBus().getPatente();
        }
        return list;
    }

    public String[][] listPasajeros(LocalDate fecha, LocalTime hora, String patBus) {
        for (Viaje v : viajes) {
            if (v.getFecha().equals(fecha) && v.getHora().equals(hora) && v.getBus().getPatente().equals(patBus)) {
                return v.getListaPasajeros(); // Delega al método del objeto Viaje
            }
        }
        return new String[0][0];
    }

    // --- MÉTODOS DE BÚSQUEDA (FindXXXXX) [cite: 117, 118, 119, 120, 121, 669] ---

    public Cliente findCliente(IdPersona id) {
        for (Cliente c : clientes) {
            if (c.getIdPersona().equals(id)) return c;
        }
        return null;
    }

    public Bus findBus(String patente) {
        for (Bus b : buses) {
            if (b.getPatente().equalsIgnoreCase(patente)) return b;
        }
        return null;
    }

    public Pasajero findPasajero(IdPersona id) {
        for (Pasajero p : pasajeros) {
            if (p.getIdPersona().equals(id)) return p;
        }
        return null;
    }

    private Venta findVenta(String id, TipoDocumento tipo) {
        for (Venta v : ventas) {
            if (v.getIdDocumento().equals(id) && v.getTipo() == tipo) return v;
        }
        return null;
    }
}
