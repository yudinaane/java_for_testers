package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.CommonFunctions;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;




public class ContactCreationTests extends TestBase {

  public static List<ContactData> contactProvider() throws IOException {
    var result = new ArrayList<ContactData>();
    //for (var firstName : List.of("","first name")){
         //for (var lastName : List.of("","last name")){
            //for (var mobilephone : List.of("", "mobilephone")) {
                //for (var email1 : List.of("", "email1@mail.ru")) {
                    //result.add(new ContactData().withFirstname(firstName).withLastname(lastName)
                            //.withMobile(mobilephone));
               // }
            //}
         //}
    //}

    //for (int i = 0; i < 15; i++){
     // result.add(new ContactData()
              //.withFirstname(CommonFunctions.randomString(i*10))
              //.withLastname(CommonFunctions.randomString(i*10))
              //.withMobile(CommonFunctions.randomString(i*10)));
   // }
      var json = Files.readString(Paths.get("contacts.json"));
      ObjectMapper mapper = new ObjectMapper();
      var value = mapper.readValue(json, new TypeReference<List<ContactData>>() {});
      result.addAll(value);
      return result;


  }
    public static List<ContactData> singleRandomContact() {
        return List.of(new ContactData()
                .withFirstname(CommonFunctions.randomString(10))
                .withLastname(CommonFunctions.randomString(10))
                .withAddress(CommonFunctions.randomString(10)));

    }



  @ParameterizedTest
  @MethodSource("singleRandomContact")
  public void сanCreateContacts(ContactData contact) {
      var oldContacts = app.hbm().getContactList();
      app.contacts().createContact(contact);
      var newContacts = app.hbm().getContactList();
      Comparator<ContactData> compareByIdContact = (o1, o2) -> {
          return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
      };

      newContacts.sort(compareByIdContact);
      var maxId = newContacts.get(newContacts.size() - 1).id();

      var expectedList = new ArrayList<>(oldContacts);
      expectedList.add(contact.withId(maxId));
      expectedList.sort(compareByIdContact);
    //Assertions.assertEquals(contactCount + 1, newContactCount);
      Assertions.assertEquals(newContacts, expectedList);
  }

  @Test
  public void canCreateContactWithFieldToHome() {
      app.contacts().createContact(new ContactData().withFieldToHome("some firstname", "some lastname",
              "some address", "some home", "some email"));
  }

  @Test
  void canCreateContact() {
      var contact = new ContactData()
                  .withFirstname(CommonFunctions.randomString(10))
                  .withLastname(CommonFunctions.randomString(20));
                  //withPhoto(randomFile("src/test/resources/images"))
      app.contacts().createContact(contact);
      }

    @Test
    void canCreateContactInGroup() {

       var contact = new ContactData()
               .withFirstname(CommonFunctions.randomString(10))
               .withLastname(CommonFunctions.randomString(20))
               .withMobile(CommonFunctions.randomString(20));

        if (app.hbm().getGroupCount() == 0) {
           app.hbm().createGroup(new GroupData("", "group_name", "group_header", "group_footer"));
       }

        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);  //получить список контактов, входящих в группу
       app.contacts().createContact(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
       Assertions.assertEquals(oldRelated.size()+1, newRelated.size());
    }






}
