import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita a string ao usuário
        System.out.print("Digite uma string para inverter: ");
        String input = scanner.nextLine();

        // Converte a string para um array de caracteres e inverte
        String invertida = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            invertida += input.charAt(i);
        }

        // Exibe a string invertida
        System.out.println("String invertida: " + invertida);

        scanner.close();
    }
}
