package vista;

import java.util.Scanner;

//Singleton
public class UISVP {

    //Lo que carateriza a un singleton
    private static UISVP instance;

    private Scanner sc;

    private UISVP() {
        Scanner sc = new Scanner(System.in);
    }

    //Esto asegura que se cree una instancia si no la hay, si la hay, que se mantenga igual osea que se reutilize, es caracteristico de los singleton
    public static UISVP getInstance() {
        if (instance == null) {
            instance = new UISVP();
        }
        return instance;
    }
}
