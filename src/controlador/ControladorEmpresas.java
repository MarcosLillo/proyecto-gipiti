package controlador;

public class ControladorEmpresas {

    //Singleton
    private static ControladorEmpresas instance;

    private ControladorEmpresas() {
    }

    public static ControladorEmpresas getInstance() {
        if (instance == null) {
            instance = new ControladorEmpresas();
        }
        return instance;
    }

}
