package cacaPalavras;
import java.util.Random;
import java.util.Scanner;
import poo.JogoDasPalavras;

public class CacaPalavras {
    public static void main(String[] args) {
//        String[] arrayPalavras = {"banana", "computador", "engenharia", "gato", "python"};
//        cacandoPalavra(arrayPalavras);
        Random random = new Random();
        cacandoPalavra();
    }
    public static void cacandoPalavra() {
        Random random = new Random();

        JogoDasPalavras jogo = new JogoDasPalavras();
        Scanner in = new Scanner(System.in);
        String palavraEscolhida = jogo.sortearPalavra();
        String entrada = "";
//        String palavraEscolhidaIndex = arrayPalavras[random.nextInt(arrayPalavras.length)];
        char[][] tabuleiro = Criandotabuleiro(palavraEscolhida, random);
        imprimindoTabuleiro(tabuleiro, palavraEscolhida, random);

        do {
            System.out.println("Digite seu palpite ou 'dica' ou 'sair': ");
            entrada = in.nextLine();
        } while(jogo.verificarResposta(entrada));

//        while(true) {
//            tabuleiro(palavraEscolhida);
//
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
    }

    public static char[][] Criandotabuleiro(String palavraEscolhida, Random random) {
        int tamanho = 10;
//        int colunas = Math.max(palavraEscolhida.length(), 3);

        int linhas = 10;
        int colunas = Math.max(10, palavraEscolhida.length() + 1);
        char[][] tabuleiro = new char[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int c = 0; c < colunas; c++) {
                tabuleiro[i][c] = (char) (97 + random.nextInt(25));
            }
        }
        return tabuleiro;
    }

    public static void imprimindoTabuleiro(char[][] tabuleiro, String palavraEscolhida, Random random) {
        int tamanhoPalavraEscolhida = palavraEscolhida.length();
        int linha = random.nextInt(10);
        int coluna = random.nextInt(tabuleiro[0].length - tamanhoPalavraEscolhida);


        for (int i = 0; i < tamanhoPalavraEscolhida; i++) {
            tabuleiro[linha][coluna + i] = palavraEscolhida.charAt(i);
        }

        for (int i = 0; i < tabuleiro.length; i++) {
//            System.out.print("|");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print((char) tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}