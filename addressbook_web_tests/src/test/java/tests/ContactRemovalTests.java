package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase{

    @Test
    void canRemoveContact(){
        if (!app.contacts().isContactPreset()) {
           app.contacts().createContact(new ContactData().withFieldToHome("some firstname", "some lastname",
                    "some address", "some home", "some email"));
        }
        app.contacts().removeContact();
    }
}
