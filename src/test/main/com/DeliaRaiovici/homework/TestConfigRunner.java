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
