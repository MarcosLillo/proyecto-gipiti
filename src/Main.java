public class Main { //Testeo
    public static void main(String[] args) {

        //Objetos creados a partir de Nombre
        Nombre h1 = new Nombre(Tratamiento.SR, "a", "a", "a");
        Nombre h2 = new Nombre(Tratamiento.SRA, "a", "a", "a");

        //Sout (System.out.println("");) para verificar que te muestra el mensaje de toString
        System.out.println(h1.toString());
        System.out.println(h2.toString());


        //Compara el objeto h1 con h2, usando el metodo equals de la clase Nombre
        System.out.println(h1.equals(h2));



    }
}
