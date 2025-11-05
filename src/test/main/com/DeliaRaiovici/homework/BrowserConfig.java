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
