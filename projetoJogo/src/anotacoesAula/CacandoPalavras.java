package anotacoesAula;

import java.util.Random;
import java.util.Scanner;

public class CacandoPalavras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String palavras[] = {"djavan", "anitta", "ludmilla"};

        int tamanhoPalavras = 0;

        int tamanho = 10;

        char tabuleiro[][] = new char[tamanho][tamanho];
        //                            linhas / colunas

        String palavraSelecionada = selecionandoPalavra(palavras, random);
//        System.out.println(palavraSelecionada);
        tabuleiro = criandoTabuleiro(tabuleiro, tamanho, random);

        // imprimirTabuleiro(tabuleiro, tamanho);
        // se só precisa imprimir, então só chama o metodo

        tamanhoPalavras = palavraSelecionada.length();
        int linha = random.nextInt(tamanho);
        int coluna = random.nextInt(tamanho - tamanhoPalavras);

        for (int i = 0; i < tamanhoPalavras; i++) {
            tabuleiro[linha][coluna + i] = palavraSelecionada.charAt(i);
        }

        System.out.println("Há um(a) cantor(a) nesse tabuleiro! Você consegue encontrar?");
        imprimirTabuleiro(tabuleiro, tamanho);

        Boolean acertou = false;

        while (!acertou) {
            System.out.println("Informe o nome do(a) cantor(a) [Digite 'dica' para receber uma dica ou '0' para parar: ");
            String resposta = scanner.nextLine();
            if (resposta.equals("0")) {
                System.out.println("Que pena! :(");
                break;
            }
            if (resposta.equals("dica")) {
                System.out.println("A primeira palavra é " + palavraSelecionada.charAt(0));
                continue;
            }

            if (resposta.equals(palavraSelecionada)) {
                System.out.println("Você acertou!!");
                acertou = true;
            } else {
                System.out.println("Tente novamente!");
            }

        }
    }

    public static String selecionandoPalavra(String[] palavras, Random random) {
        return palavras[random.nextInt(palavras.length)];
    }

    public static char[][] criandoTabuleiro(char[][] tabuleiro, int tamanho, Random random) {
        for(int x = 0; x < tamanho; x++) {

            for(int y = 0; y < tamanho; y++) {
                // dois for, pois precisa percorrer as linhas e colunas
                // tabuleiro[x][y] = (char) 97; todas as cedulas da matriz teriam 'a'

                tabuleiro[x][y] = (char) (97 + random.nextInt(25));
                // preencher de 'a' a 'z'; 97 pois
                // é o 'a' na tabela ASCII e mais 25, pois são as letras do alfabeto
            }
        }
        return  tabuleiro;
    }

    public static void imprimirTabuleiro(char[][] tabuleiro, int tamanho) {
        // void, pois não precisa de return

        for (int x = 0; x < tamanho; x++) {
            // linha

            for (int y = 0; y < tamanho; y++) {
                // coluna
                System.out.print(tabuleiro[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}

