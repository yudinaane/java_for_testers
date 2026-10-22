package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;


public class ContactCreationTests extends TestBase {

  public static List<ContactData> contactProvider() {
    var result = new ArrayList<ContactData>();
    for (var firstName : List.of("","first name")){
         for (var lastName : List.of("","last name")){
            for (var mobilephone : List.of("", "mobilephone")) {
                for (var email1 : List.of("", "email1@mail.ru")) {
                    result.add(new ContactData().withFirstname(firstName).withLastname(lastName)
                            .withMobile(mobilephone).withEmail(email1));
                }
            }
         }
    }

    for (int i = 0; i < 5; i++){
      result.add(new ContactData()
              .withFirstname(randomString(i*10))
              .withLastname(randomString(i*10))
              .withMobile(randomString(i*10))
              .withEmail(randomString(i*10)));
    }
    return result;

  }

  @ParameterizedTest
  @MethodSource("contactProvider")
  public void сanCreateMultipleContacts(ContactData contact) {
    int contactCount = app.contacts().getCountContact();
    app.contacts().createContact(contact);
    int newContactCount=app.contacts().getCountContact();
    Assertions.assertEquals(contactCount + 1, newContactCount);
  }





  @Test
  public void canCreateContactWithFieldToHome() {
    app.contacts().createContact (new ContactData().withFieldToHome("some firstname", "some lastname",
            "some address", "some home", "some email"));




  }







}
