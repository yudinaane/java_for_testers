package tests;

import manager.ApplicationManagar;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class TestBase {

    protected static ApplicationManagar app;

    @BeforeEach
    public void setUp() {
        if (app == null){
            app = new ApplicationManagar();
        }
        app.init(System.getProperty("browser", "firefox"));
    }

    public static String randomString (int n){
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char)('a' + rnd.nextInt(26));
        }
        return result;
    }

    public static String randomFile (String dir){
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }

}
