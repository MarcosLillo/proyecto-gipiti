package utilidades;

import java.io.Serializable;

public interface IdPersona extends Serializable { //Segun el UML, era IdPersona, osea "I" mayuscula https://www.youtube.com/watch?v=oUMsNjCDT8I
    //maxi
    public String toString();

    public boolean equals(Object otro);

}
