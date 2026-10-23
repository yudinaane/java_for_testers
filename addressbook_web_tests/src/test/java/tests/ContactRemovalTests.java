package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase{

    @Test
    void canRemoveContact(){
        if (!app.contacts().isContactPreset()) {
           app.contacts().createContact(new ContactData().withId("").withFirstname(randomString(10))
                   .withLastname(randomString(10)));
        }
        var oldContacts = app.contacts().getListContact();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getListContact();
        var expectedListContact = new ArrayList<>(oldContacts);
        expectedListContact.remove(index);
        Assertions.assertEquals(newContacts,expectedListContact);
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
