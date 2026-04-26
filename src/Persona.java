public class Persona {

        private int idPersona;
        private String nombreCompleto;
        private String telefono;

        public Persona(int idPersona, String nombreCompleto, String telefono){
            this.idPersona = idPersona;
            this.nombreCompleto = nombreCompleto;
            this.telefono = telefono;
        }

        public int getIdPersona(){
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
            if (this == null) return false;
            if (getClass() != obj.getClass()) return false;

            Persona persona = (Persona) obj;
            return this.idPersona == persona.idPersona;
        }

    }


