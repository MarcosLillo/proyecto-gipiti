public class Pasajero extends Persona {
    private String nomContacto;
    private String fonoContacto;

    public Pasajero(int idPersona, String nombreCompleto, String telefono, String nomContacto, String fonoContacto){
        super(idPersona, nombreCompleto, telefono);
        this.nomContacto = nomContacto;
        this.fonoContacto = fonoContacto;
    }

    public String getNomContacto(){
        return nomContacto;
    }
    public void setNomContacto(String nomContacto){
        this.nomContacto = nomContacto;
    }

    public String getFonoContacto(){
        return fonoContacto;
    }
    public void setFonoContacto(String fonoContacto){
        this.fonoContacto = fonoContacto;
    }
}

