public class Cliente extends idPersona {
    private String email;
    public Cliente(int idPersona, String nombreCompleto, String telefono, String email){
        super(idPersona, nombreCompleto, telefono);
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return super.toString() + ", Email: " + email;
    }
}
