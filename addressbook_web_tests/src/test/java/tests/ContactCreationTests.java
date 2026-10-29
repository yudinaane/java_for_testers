package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;


public class ContactCreationTests extends TestBase {

  @Test
  public void canCreateContact() {
    var contact = new ContactData()
            .withFirstname(randomString(10))
            .withLastname(randomString(10))
            .withPhoto(randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
  }











}
