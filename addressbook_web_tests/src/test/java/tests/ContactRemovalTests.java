package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase{

    @Test
    void canRemoveContact(){
        if (!app.contacts().isContactPreset()) {
           app.contacts().createContact(new ContactData().withFieldToHome("some firstname", "some lastname",
                    "some address", "some home", "some email"));
        }
        List<ContactData> oldContacts = app.contacts().getListContact();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        List<ContactData> newContacts = app.contacts().getListContact();
        Assertions.assertEquals(newContacts.size(),oldContacts.size()-1);
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
