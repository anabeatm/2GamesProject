package descobrePalavra;

import java.util.Random;
import java.util.Scanner;

public class DescubraAPalavra {
    public static void main(String[] args) {
        String[] arrayPalavras = {"banana", "computador", "engenharia", "gato", "python"};
        String palavraEscolhida = escolhendoPalavraAleatoriamente(arrayPalavras);
        String palavraDesordenada = desordenandoPalavraEscolhida(palavraEscolhida);
        System.out.println(palavraDesordenada);


    }

    public static String escolhendoPalavraAleatoriamente(String[] arrayPalavras) {
        Random random = new Random();
        String palavraEscolhidaIndex = arrayPalavras[random.nextInt(arrayPalavras.length)];

        return palavraEscolhidaIndex;
    }

    public static String desordenandoPalavraEscolhida(String palavraEscolhida) {
        Random random = new Random();
        char[] caracter = palavraEscolhida.toCharArray();
        for (int i = caracter.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            char aux = caracter[i];
            caracter[i] = caracter[index];
            caracter[index] = aux;

        }
        return new String(caracter);
    }

    public static String descobrindoPalavra(String palavraEscolhida, String palavraDesordenada) {
        Scanner in = new Scanner(System.in);
        while(true) {

        }
    }
}
