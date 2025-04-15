package poo;
import java.util.Random;

public class JogoDasPalavras {

    private String[] arrayPalavras;
    private String palavraEscolhida;
//    private String entrada;

    public JogoDasPalavras() {
        arrayPalavras = new String[]{"banana", "computador", "engenharia", "gato", "python"};
    }

    public String sortearPalavra() {
        String[] arrayPalavras = this.arrayPalavras;
        Random random = new Random();

        palavraEscolhida = arrayPalavras[random.nextInt(arrayPalavras.length)];

        return palavraEscolhida;
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
