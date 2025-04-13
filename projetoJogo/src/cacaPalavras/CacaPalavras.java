package cacaPalavras;
import java.util.Random;
import java.util.Scanner;

public class CacaPalavras {
    public static void main(String[] args) {
        String[] arrayPalavras = {"banana", "computador", "engenharia", "gato", "python"};
        cacandoPalavra(arrayPalavras);

    }
    public static void cacandoPalavra(String[] arrayPalavras) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        String palavraEscolhidaIndex = arrayPalavras[random.nextInt(arrayPalavras.length)];

        while(true) {
            Tabuleiro(palavraEscolhidaIndex);

            System.out.println("Digite seu palpite ou 'dica' ou 'sair': ");
            String entrada = in.nextLine().toLowerCase();

            char primeiraLetra = palavraEscolhidaIndex.charAt(0);
            char ultimaLetra = palavraEscolhidaIndex.charAt(palavraEscolhidaIndex.length() - 1);

            if(entrada.equals("dica")){
                System.out.println("A palavra começa com '" + primeiraLetra + "' e termina com '" + ultimaLetra + "'.");
            } else if(entrada.equals("sair")) {
                System.out.println("Você desistiu :( ...");
                break;
            } else if (entrada.equals(palavraEscolhidaIndex)) {
                System.out.println("Você ganhou!!");
                break;
            }
        }

    }

    public static int[][] Tabuleiro(String palavraEscolhida) {
        Random random = new Random();
        int colunas = Math.max(palavraEscolhida.length(), 3);
        int[][] tabuleiro = new int[3][colunas];

        for(int i = 0; i < tabuleiro.length; i++) {
            for(int c = 0; c < tabuleiro[i].length; c++) {
                tabuleiro[i][c] = (char) ('a' + random.nextInt(26));
            }
        }

        int linha = random.nextInt(tabuleiro.length);
        int colunaMaxima = tabuleiro[0].length - palavraEscolhida.length();
        int coluna = random.nextInt(colunaMaxima + 1);
        // ^ aqui defini em que direção quero que esconda a palavra

        for (int i = 0; i < palavraEscolhida.length(); i++) {
            tabuleiro[linha][coluna + i] = palavraEscolhida.charAt(i);
        }

        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print("|");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print((char) tabuleiro[i][j] + " | ");
            }
            System.out.println();
        }

        return tabuleiro;
    }

}