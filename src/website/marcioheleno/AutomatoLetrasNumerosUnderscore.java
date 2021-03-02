package website.marcioheleno;

import java.sql.SQLOutput;

public class AutomatoLetrasNumerosUnderscore {

    public static void main(String[] args) {

        String letras = "ABCDEFGHIJKLMNOPQRSTUVXYWZabcdefghijklmnopqrstuvxywz";
        String digitos = "0123456789";
        String underscore = "_";

        String fitaEntrada = "A1_11_11_B_";

        int estado = 1;

        for (int i = 0; i < fitaEntrada.length(); i++) {

            switch (estado) {

                case 1 :
                    if (letras.contains(fitaEntrada.substring(i, i+1))){
                        estado = 2;
                        System.out.println(fitaEntrada.substring(i, i+1));
                        System.out.println("Vai para o estado " + estado);
                    }
                    else i=99;
                    break;

                case 2 :
                    if (letras.contains(fitaEntrada.substring(i, i+1)) || digitos.contains(fitaEntrada.substring(i, i+1))){
                        estado = 2;
                        System.out.println(fitaEntrada.substring(i, i+1));
                        System.out.println("Continua no estado " + estado);
                    }
                    else if (underscore.contains(fitaEntrada.substring(i, i+1))) {
                        estado=3;
                        System.out.println(fitaEntrada.substring(i, i+1));
                        System.out.println("Continua no estado " + estado);
                    }
                    else {
                        i=99;
                        estado=99;
                    }
                    break;

                case 3 :
                    if (letras.contains(fitaEntrada.substring(i, i+1)) || digitos.contains(fitaEntrada.substring(i, i+1))){
                        estado = 2;
                        System.out.println(fitaEntrada.substring(i, i+1));
                        System.out.println("Vai para o estado " + estado);
                    }
                    else i=99;
                    break;

                default:
                    System.out.println("error !");
            }
        }

        System.out.println((estado == 2) ? "Cadeia reconhecida !!!" : "Cadeia com error !!!!");
    }
}
