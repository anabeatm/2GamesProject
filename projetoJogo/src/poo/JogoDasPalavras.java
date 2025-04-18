package poo;
import java.util.Random;
import java.util.Scanner;

public class JogoDasPalavras {

    private String[] arrayPalavras;
    private String palavraEscolhida;

    public JogoDasPalavras() { // -> construtor
        arrayPalavras = new String[]{"banana", "computador", "engenharia", "gato", "python"};

        sortearPalavra();
    }
    // utilizando o metodo sortearPalavra() no construtor, pois isso fará com que o sorteo aconteça sem
    // a necessidade de chamar o metodo nas outras classses

    public void sortearPalavra() {
        String[] arrayPalavras = this.arrayPalavras; // -> referenciar alguma coisa da classe|metodo
        Random random = new Random();

        palavraEscolhida = arrayPalavras[random.nextInt(arrayPalavras.length)];
    }

    public String getPalavraEscolhida() {
        return palavraEscolhida;
    }


    public String darDica() {
        char primeiraLetra = palavraEscolhida.charAt(0);
        char ultimaLetra = palavraEscolhida.charAt(palavraEscolhida.length() - 1);

        return "A palavra começa com '" + primeiraLetra + "' e termina com '" + ultimaLetra + "'.";
    }

    public boolean verificarResposta(String entrada) {
        if (entrada.equals("dica")) {
            System.out.println(this.darDica());
            return true;
        } else if (entrada.equals("sair")) {
            System.out.println("Você desistiu :( ...");
            return false;
        } else if (entrada.equals(this.palavraEscolhida)) {
            System.out.println("Você ganhou!!");
            return false;
        } else {
            System.out.println("Tente novamente!");
            return true;
        }
    }
}
