import java.util.Scanner;

public class Q015 {
    // Função recursiva que verifica se a entrada é composta apenas por vogais
    public static boolean vogal(String entrada, int index) {
        // Se o índice for igual ao comprimento da entrada, todos os caracteres foram verificados
        if (index == entrada.length()) {
            return true; // Retorna verdadeiro, indicando que a entrada é composta apenas por vogais
        }
        // Obtém o caractere atual em maiúsculas para facilitar a comparação
        char currentChar = Character.toUpperCase(entrada.charAt(index));
        // Verifica se o caractere atual não é uma letra ou não é uma vogal
        if (!Character.isLetter(currentChar) || (currentChar != 'A' && currentChar != 'E' && currentChar != 'I'
                && currentChar != 'O' && currentChar != 'U')) {
            return false; // Retorna falso se o caractere não for uma vogal
        }
        // Chama recursivamente a função para verificar o próximo caractere na entrada
        return vogal(entrada, index + 1);
    }

    // Função recursiva que verifica se a entrada é composta apenas por consoantes
    public static boolean consoante(String entrada, int index) {
        if (index == entrada.length()) {
            return true; // Se o índice for igual ao comprimento da entrada, todos os caracteres foram verificados
        }
        // Obtém o caractere atual em maiúsculas para facilitar a comparação
        char currentChar = Character.toUpperCase(entrada.charAt(index));
        // Verifica se o caractere atual não é uma letra ou é uma vogal
        if (!Character.isLetter(currentChar) || (currentChar == 'A' || currentChar == 'E' || currentChar == 'I'
                || currentChar == 'O' || currentChar == 'U')) {
            return false; // Retorna falso se o caractere não for uma consoante
        }
        // Chama recursivamente a função para verificar o próximo caractere na entrada
        return consoante(entrada, index + 1);
    }

    // Função recursiva que verifica se a entrada é um número inteiro
    public static boolean checkInteiro(String entrada, int index) {
        if (index == entrada.length()) {
            return true; // Se o índice for igual ao comprimento da entrada, todos os caracteres foram verificados
        }
        // Obtém o caractere atual
        char currentChar = entrada.charAt(index);
        // Verifica se o caractere atual não é um dígito
        if (!Character.isDigit(currentChar)) {
            return false; // Retorna falso se o caractere não for um dígito
        }
        // Chama recursivamente a função para verificar o próximo caractere na entrada
        return checkInteiro(entrada, index + 1);
    }

    // Função recursiva que verifica se a entrada é um número real
    public static boolean checkReal(String entrada, int index, boolean hasDot) {
        if (index == entrada.length()) {
            return hasDot; // Se o índice for igual ao comprimento da entrada, retorna se um ponto decimal foi encontrado
        }
        // Obtém o caractere atual
        char currentChar = entrada.charAt(index);
        // Verifica se o caractere atual não é um dígito
        if (!Character.isDigit(currentChar)) {
            // Se não for um dígito e não for um ponto decimal, retorna falso
            if (currentChar != '.' || hasDot) {
                return false;
            }
            // Se for um ponto decimal e ainda não tiver sido encontrado outro, marca que um foi encontrado
            return checkReal(entrada, index + 1, true);
        }
        // Chama recursivamente a função para verificar o próximo caractere na entrada
        return checkReal(entrada, index + 1, hasDot);
    }

    // Função recursiva que verifica se a entrada é a palavra "FIM"
    public static boolean endLine(String entrada, int index) {
        // Verifica se os próximos três caracteres formam a palavra "FIM"
        if (index + 2 >= entrada.length()) {
            return false; // Se não houver espaço suficiente para "FIM" na entrada, retorna falso
        }
        return entrada.charAt(index) == 'F' && entrada.charAt(index + 1) == 'I' && entrada.charAt(index + 2) == 'M';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada;
        entrada = sc.nextLine(); // Lê a primeira linha da entrada
        // Loop enquanto a entrada não for "FIM"
        while (!endLine(entrada, 0)) {
            // Verifica e imprime se a entrada é composta apenas por vogais
            System.out.print(vogal(entrada, 0) ? "SIM " : "NAO ");
            // Verifica e imprime se a entrada é composta apenas por consoantes
            System.out.print(consoante(entrada, 0) ? "SIM " : "NAO ");
            // Verifica e imprime se a entrada é um número inteiro
            System.out.print(checkInteiro(entrada, 0) ? "SIM " : "NAO ");
            // Verifica e imprime se a entrada é um número real
            System.out.println(checkReal(entrada, 0, false) ? "SIM " : "NAO ");
            // Lê a próxima linha de entrada
            entrada = sc.nextLine();
        }
        sc.close(); // Fecha o Scanner
    }
}
