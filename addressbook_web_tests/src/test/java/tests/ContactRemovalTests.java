package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase{

    @Test
    void canRemoveContact(){
        //if (!app.contacts().isContactPreset()) {
          // app.contacts().createContact(new ContactData().withId("").withFirstname(CommonFunctions.randomString(10))
                   //.withLastname(CommonFunctions.randomString(10)));
       // }
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData().withId("").withFirstname(CommonFunctions.randomString(10))
            .withLastname(CommonFunctions.randomString(10)));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
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
