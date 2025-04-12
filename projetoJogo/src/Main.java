import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] tabuleiro = new int[3][3];
        for(int i = 0; i < tabuleiro.length; i++) {
            for(int c = 0; c < tabuleiro[i].length; c++) {
                tabuleiro[i][c] = (char) ('a' + random.nextInt(26));
            }
        }

    }
}