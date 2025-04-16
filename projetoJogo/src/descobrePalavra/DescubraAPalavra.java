package descobrePalavra;

import poo.JogoDasPalavras;
import java.util.Random;
import java.util.Scanner;

public class DescubraAPalavra {
    public static void main(String[] args) {

//        String[] arrayPalavras = {"banana", "computador", "engenharia", "gato", "python"};
//        String palavraEscolhida = escolhendoPalavraAleatoriamente(arrayPalavras);
//        String palavraDesordenada = desordenandoPalavraEscolhida(palavraEscolhida);
//        System.out.println(palavraDesordenada);
//        descobrindoPalavra(palavraEscolhida);

        Scanner in = new Scanner(System.in);
        JogoDasPalavras jogo = new JogoDasPalavras();
        jogo.sortearPalavra();

        String palavraEmbaralhada = desordenandoPalavraEscolhida(jogo.getPalavraEscolhida());
        System.out.println("Você precisa adivinhar a palavra a seguir:");
        System.out.println(palavraEmbaralhada);

//        String entrada = jogo.setEntrada(); --> tentei fazer algo diferente
        String entrada = "";

        do {
            System.out.println("Digite seu palpite ou 'dica' ou 'sair': ");
            entrada = in.nextLine();
        } while(jogo.verificarResposta(entrada));

    }

//    public static String escolhendoPalavraAleatoriamente(String[] arrayPalavras) {
//        Random random = new Random();
//
//        return arrayPalavras[random.nextInt(arrayPalavras.length)];
//    }

    public static String desordenandoPalavraEscolhida(String palavraEscolhida) {
        Random random = new Random();
        char[] caracter;
        caracter = palavraEscolhida.toCharArray();
        for (int i = caracter.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            char aux = caracter[i];
            caracter[i] = caracter[index];
            caracter[index] = aux;

        }
        return new String(caracter);
    }

//    public static void descobrindoPalavra(String palavraEscolhida) {
//        Scanner in = new Scanner(System.in);
//        while(true) {
//            System.out.println("Digite seu palpite ou 'dica' ou 'sair': ");
//            String entrada = in.nextLine().toLowerCase();
//
//            char primeiraLetra = palavraEscolhida.charAt(0);
//            char ultimaLetra = palavraEscolhida.charAt(palavraEscolhida.length() - 1);
//
//            if(entrada.equals("dica")){
//                System.out.println("A palavra começa com '" + primeiraLetra + "' e termina com '" + ultimaLetra + "'.");
//            } else if(entrada.equals("sair")) {
//                System.out.println("Você desistiu :( ...");
//                break;
//            } else if (entrada.equals(palavraEscolhida)) {
//                System.out.println("Você ganhou!!");
//                break;
//            }
//        }
//    }
}
