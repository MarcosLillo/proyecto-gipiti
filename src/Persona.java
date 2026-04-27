public class Persona {

        private IdPersona idPersona; //UML dice IdPersona = idPersona
        private String nombreCompleto;
        private String telefono;

        //Cambie el int por IdPersona
        public Persona(IdPersona idPersona, String nombreCompleto, String telefono){
            this.idPersona = idPersona;
            this.nombreCompleto = nombreCompleto;
            this.telefono = telefono;
        }

        //Cambie el int por IdPersona
        public IdPersona getIdPersona(){
            return idPersona;
        }
        public String getNombreCompleto() {
            return nombreCompleto;
        }
        public String getTelefono(){
            return telefono;
        }
        public void setNombreCompleto(String nombreCompleto){
            this.nombreCompleto = nombreCompleto;
        }
        public void setTelefono(String telefono){
            this.telefono = telefono;
        }

        @Override
        public String toString(){
            return "ID: " + idPersona + ", Nombre: " + nombreCompleto + ", Telefono: " + telefono;
        }

        @Override
        public boolean equals(Object obj){
            if (this == obj) return true;
            if (obj == null) return false; //Cambie el this por obj
            if (getClass() != obj.getClass()) return false;

            Persona persona = (Persona) obj;
            return this.idPersona.equals(persona.idPersona); //Modifique return this.idPersona == persona.idPersona; ya que era un objeto, no int
        }

}


