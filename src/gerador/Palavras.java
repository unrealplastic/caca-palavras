package gerador;
import java.util.Random;

public class Palavras {

    public static void main(String[] args) {
        int numLinhas = 10;
        int numColunas = 10;
        
        String[] palavras = {"JAVA", "ALGORITMO", "MATRIZ", "CODIGO"};
        char[][] matriz = new char[numLinhas][numColunas];
        
        Random random = new Random();
        
        preencherMatriz(matriz);
        
        for (String palavra : palavras) {
            boolean palavraInserida = false;
            
            while (!palavraInserida) {
                int linhaInicial = random.nextInt(numLinhas);
                int colunaInicial = random.nextInt(numColunas);
                int posicao = random.nextInt(2); // 0 = horizontal, 1 = vertical
                if (verificarPosicao(linhaInicial, colunaInicial, palavra.length(), posicao, numLinhas, numColunas)) {
                    inserirPalavra(matriz, linhaInicial, colunaInicial, palavra, posicao);
                    palavraInserida = true;
                }
            }
        }
        
        imprimirMatriz(matriz);
    }

    public static void preencherMatriz(char[][] matriz) {
        Random random = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (char) ('A' + random.nextInt(26)); // Letras de A a Z
            }
        }
    }

    public static boolean verificarPosicao(int linha, int coluna, int tamanhoPalavra, int posicao, int numLinhas, int numColunas) {
        switch (posicao) {
            case 0: // horizontal
                return coluna + tamanhoPalavra <= numColunas;

            case 1: // vertical
                return linha + tamanhoPalavra <= numLinhas;

            default:
                return false;
        }
    }

    public static void inserirPalavra(char[][] matriz, int linha, int coluna, String palavra, int posicao) {
        int tamanhoPalavra = palavra.length();

        for (int i = 0; i < tamanhoPalavra; i++) {
            switch (posicao) {
                case 0: // horizontal
                    matriz[linha][coluna + i] = palavra.charAt(i);
                    break;

                case 1: // vertical
                    matriz[linha + i][coluna] = palavra.charAt(i);
                    break;
            }
        }
    }

    public static void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}