
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

public class BrowserConfig {
    private BrowserType browser;
    private String version;
    private boolean isHeadless;

    // Constructor principal
    public BrowserConfig(BrowserType browser, String version, boolean isHeadless) {
        this.browser = browser;
        this.version = version;
        this.isHeadless = isHeadless;
    }

    // Constructor cu browser și version
    public BrowserConfig(BrowserType browser, String version) {
        this(browser, version, false);
    }

    // Constructor cu doar browser
    public BrowserConfig(BrowserType browser) {
        this(browser, "latest", false);
    }

    // Metodă statică Factory
    public static BrowserConfig createDefaultChromeConfig() {
        return new BrowserConfig(BrowserType.CHROME, "latest", true);
    }

    // Metodă de afișare
    public void afiseazaConfig() {
        System.out.println("Browser: " + browser + ", Version: " + version + ", Headless: " + isHeadless);
    }
}
public enum BrowserType {
    CHROME,
    FIREFOX,
    EDGE
}
public class TestConfigRunner {
    public static void main(String[] args) {
        // Instanță folosind constructorul cu toți parametrii
        BrowserConfig config1 = new BrowserConfig(BrowserType.FIREFOX, "120.0", true);
        config1.afiseazaConfig();

        // Instanță folosind constructorul cu browser și version
        BrowserConfig config2 = new BrowserConfig(BrowserType.EDGE, "119.0");
        config2.afiseazaConfig();

        // Instanță folosind constructorul cu doar browser
        BrowserConfig config3 = new BrowserConfig(BrowserType.CHROME);
        config3.afiseazaConfig();

        // Instanță folosind metoda statică createDefaultChromeConfig()
        BrowserConfig config4 = BrowserConfig.createDefaultChromeConfig();
        config4.afiseazaConfig();
    }
}
