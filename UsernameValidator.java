
import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username;
        boolean isValid;

        do {
            System.out.print("Introduceți un username: ");
            username = scanner.nextLine();
            isValid = true;

            // Verificare spații
            if (username.contains(" ")) {
                System.out.println("Eroare: Username-ul nu trebuie să conțină spații.");
                isValid = false;
                continue; // Sărim celelalte verificări
            }

            // Verificare lungime
            if (username.length() < 5 || username.length() > 12) {
                System.out.println("Eroare: Username-ul trebuie să aibă între 6 și 12 caractere.");
                isValid = false;
            }

            // Verificare cifre
            boolean hasDigit = false;
            for (int i = 0; i < username.length(); i++) {
                if (Character.isDigit(username.charAt(i))) {
                    hasDigit = true;
                    break;
                }
            }

            if (!hasDigit) {
                System.out.println("Eroare: Username-ul trebuie să conțină cel puțin o cifră.");
                isValid = false;
            }

        } while (!isValid);

        System.out.println("Username acceptat: " + username);
    }
}
