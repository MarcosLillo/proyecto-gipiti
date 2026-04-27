public class Rut {

    private int numero;
    private char dv;

    /*Como el constructor es privado, es necesario un of, pero no es la razon principal, la principal es para
    verificar los datos ingresados, osea rut y el digito verificador, por verificar significa ingresar numeros
    que no sean negativos o que simplemente no tengan sentido
    */
    private Rut(int numero, char dv) {

        this.numero = numero;
        this.dv = dv;

    }

    public int getNumero() {

        return numero;

    }

    public char getDv() {

        return dv;

    }

    //Modificado por J.C y GPT, son las 02:36 de la mañana, luego lo veo a detalle, el metodo de verificacion es demasiado dificil webon que mrd
    public Rut of(int numero, char dv) {

        // 🔹 Validación 1: número positivo
        if (numero <= 0) {
            throw new IllegalArgumentException("El número de RUT debe ser positivo");
        }

        // 🔹 Validación 2: DV válido (0-9 o K)
        dv = Character.toUpperCase(dv);
        if (!((dv >= '0' && dv <= '9') || dv == 'K')) {
            throw new IllegalArgumentException("Dígito verificador inválido");
        }

        // 🔹 (Opcional) Validación real del RUT
        if (!validarRut(numero, dv)) {
            throw new IllegalArgumentException("RUT no válido");
        }

        return new Rut(numero, dv);
    }

    //Validacion de un rut Chileno
    private static boolean validarRut(int numero, char dv) {

        int suma = 0;
        int multiplo = 2;

        while (numero > 0) {
            int digito = numero % 10;
            suma += digito * multiplo;
            numero /= 10;

            multiplo++;
            if (multiplo > 7) {
                multiplo = 2;
            }
        }

        int resto = 11 - (suma % 11);

        char dvCalculado;

        if (resto == 11) {
            dvCalculado = '0';
        } else if (resto == 10) {
            dvCalculado = 'K';
        } else {
            dvCalculado = (char) (resto + '0');
        }

        return dvCalculado == dv;

    }

}