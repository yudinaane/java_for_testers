package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void canRemoveAllContactsAtOnce(){
        if (app.contacts().getCountContact() ==0) {
            app.contacts().createContact(new ContactData().withFieldToHome("some firstname", "some lastname",
                    "some address", "some home", "some email"));
        }
        app.contacts().removeAllContacts(); //удаление всех групп
        Assertions.assertEquals(0, app.contacts().getCountContact());
    }
}
