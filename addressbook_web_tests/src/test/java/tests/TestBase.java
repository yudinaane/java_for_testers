package tests;

import manager.ApplicationManagar;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected static ApplicationManagar app;

    @BeforeEach
    public void setUp() {
        if (app == null){
            app = new ApplicationManagar();
        }
        app.init();


    }

}
