package website.marcioheleno;

import java.util.Scanner;

public class AutomatoAB01 {

    public static void main(String[] args) {

        var sc = new Scanner(System.in);

        String letras = "AB";
        String digitos = "01";

        System.out.println("Digite uma cadeia válida contendo AB e pelo menos 0 ou 1:");
        final var cadeia = sc.nextLine();

        var estado = 1;

        if (cadeia.length() >= 3 ) {

            for (int i = 0; i < cadeia.length(); i++) {

                switch (estado) {

                    case 1:
                        if (letras.contains(cadeia.substring(i, i + 1))) {
                            estado = 2;
                            System.out.println(cadeia.substring(i, i + 1));
                            System.out.println("Vai para o estado " + estado);
                        } else if (digitos.contains(cadeia.substring(i, i + 1))) {
                            estado = 3;
                            System.out.println(cadeia.substring(i, i + 1));
                            System.out.println("Vai para o estado " + estado);
                        } else i = 99;
                        break;
                    case 2:
                        if (letras.contains(cadeia.substring(i, i + 1))) {
                            estado = 2;
                            System.out.println(cadeia.substring(i, i + 1));
                            System.out.println("Continua no estado " + estado);
                        } else if ( digitos.contains(cadeia.substring(i, i + 1))) {
                            estado = 3;
                            System.out.println(cadeia.substring(i, i + 1));
                            System.out.println("Continua no estado " + estado);
                        }
                        break;
                    case 3:
                        if (letras.contains(cadeia.substring(i, i + 1)) || digitos.contains(cadeia.substring(i, i + 1))) {
                            estado = 3;
                            System.out.println(cadeia.substring(i, i + 1));
                            System.out.println("Vai para o estado " + estado);
                        } else i = 99;
                        break;
                    default:
                        System.out.println("error !");
                }
            }
            System.out.println((estado == 3) ? "Cadeia reconhecida !!!" : "Cadeia não reconhecida !!!!");
        } else {
            System.out.println("Cadeia invalida a quantidade de caracteres deve ser de no minimo 3!");
        }
    }
}