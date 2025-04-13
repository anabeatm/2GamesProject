package anotacoesAula;
import java.util.Random;
import java.util.Scanner;

public class JogoDescoberta {

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao jogo!");

        String palavras[] = {"computador", "mouse", "monitor"};
        Random random = new Random();
        //   Classe | objeto   | construtor
        // new - operador - salva na memória um espaço

        String palavraSelecionada =
                palavras[random.nextInt(palavras.length)];
        //               objeto | metodo | tamanho do vetor palavras(int)

        String palavraEmbaralhada = embaralhar(palavraSelecionada);

        System.out.println("Qual a palavra: " + palavraEmbaralhada +"?");

        int tentativas = 0;
        Boolean acertou = false;

        Scanner scanner = new Scanner(System.in);
        while(!acertou) { // enqt true pois ! mudou o valor de acertou

            System.out.println("Informe a palavra, 'dica' para receber uma dica ou '0' para parar: ");
            String resposta = scanner.nextLine();
            if(resposta.equals("0")) {
                System.out.println("Você é um covarde! Desistiu com " + tentativas + " tentativas.");
                break;
            }

            if(resposta.equals("dica")) {
                System.out.println("A primeira letra é " + palavraSelecionada.charAt(0));
                System.out.println("E a última letra é " + palavraSelecionada.charAt(palavraEmbaralhada.length() - 1));
                continue;
            }

            if(resposta.equals(palavraSelecionada)) {
                tentativas++;
                System.out.println("Você acertou com " + tentativas + " tentativas.");
                acertou = true;

            } else {
                tentativas++;
            }
        }

    }

    private static String embaralhar(String palavra) {
//                                   | parâmetro
// static - permite utilizar o metodo, sem criar uma instância
// private - qualificador de acesso - só pode acessar ele com a Classe JogoDescoberta

        char[] palavraArray = palavra.toCharArray();
        Random random = new Random(); // irá precisar dele todas as vezes que o for iterar

        for(int i = 0; i < palavraArray.length; i++) {
//              i - variável de controle; é int; enqt for menor que meu vetor; ela é incrementada;

            int indiceAleatorio = random.nextInt(palavraArray.length);
            //palavraArray[new Random().nextInt(palavra.length() - 1)];

            char temp = palavraArray[i];
            palavraArray[i] = palavraArray[indiceAleatorio];
            palavraArray[indiceAleatorio] = temp;
        }
        return new String(palavraArray);
//                 construtor - passando um vetor de char retornando uma string
    }
}
