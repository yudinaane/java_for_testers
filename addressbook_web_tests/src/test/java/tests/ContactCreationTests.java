package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;


public class ContactCreationTests extends TestBase {



  @Test
  public void canCreateContact() {
    app.contacts().openPageContact();
    app.contacts().createContact( new ContactData("first name", "middle name",
            "last name", "nick name", "Title", "Company",
            "Address", "homephone", "mobilephone", "workphone", "email1@mail.ru", "email2@mail.ru"));

    }



  @Test
  public void canCreateContactWithFieldToHome() {
    app.contacts().openPageContact();
    app.contacts().createContact(new ContactData().withFieldToHome("some firstname", "some lastname",
            "some address", "some home", "some email"));




  }







}
