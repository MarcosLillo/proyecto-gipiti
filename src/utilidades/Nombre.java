package utilidades;//Quejas a Joaquin Castro

import modelo.Tratamiento;

public class Nombre {

    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Tratamiento tratamiento;

    //Con o sin constructor, supondre que si
    public Nombre( String nombres, String apellidoPaterno, String apellidoMaterno,  Tratamiento tratamiento) {

        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tratamiento = tratamiento;

    }
    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String toString() {
        return this.tratamiento + " " + this.nombres + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
    }

    public boolean equals(Object Otro) {

        //Modifique mi propio codigo por que no inclui esto
        if (this == Otro) return true;
        if (Otro == null || getClass() != Otro.getClass()) return false;
        //Osea la cosa basica

        Nombre persona = (Nombre) Otro;

        return this.nombres.equalsIgnoreCase(persona.nombres) && this.apellidoPaterno.equalsIgnoreCase(persona.apellidoPaterno) && this.apellidoMaterno.equalsIgnoreCase(persona.apellidoMaterno);
    }



}