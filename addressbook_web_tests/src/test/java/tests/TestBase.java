package tests;

import manager.ApplicationManagar;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    protected static ApplicationManagar app;

    @BeforeEach
    public void setUp() throws IOException {
        var properties = new Properties();
        properties.load(new FileReader(System.getProperty("target","local.properties")));
        if (app == null) {
            app = new ApplicationManagar();
        }
        app.init(System.getProperty("browser", "firefox"), properties);
    }

}
