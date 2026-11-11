package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase{

    @Test
    void testPhones(){
        var contacts = app.hbm().getContactList();
        //добавить проверку на случай отстусвия контактов
        var contact = contacts.get(0);
        var phones = app.contacts().getPhones(contact); //получаем телефоны для контакта с заданным идентификатором
        //склеиваем телефоны из бд, пустые пропускаем:
        var expected = Stream.of(contact.home(), contact.mobile(), contact.work(),contact.fax())
                .filter(s -> s !=null && ! "".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, phones);

    }

    @Test
    void testEmail(){
        var contacts = app.hbm().getContactList();
        //добавить проверку на случай отстусвия контактов
        var contact = contacts.get(0);
        var emailes = app.contacts().getEmail(contact); //получаем телефоны для контакта с заданным идентификатором
        //склеиваем телефоны из бд, пустые пропускаем:
        var expected = Stream.of(contact.email(), contact.email2(), contact.email3())
                .filter(s -> s !=null && ! "".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, emailes);

    }

    @Test
    void testAddress(){
        var contacts = app.hbm().getContactList();
        //добавить проверку на случай отстусвия контактов
        var contact = contacts.get(0);
        var address = app.contacts().getAddress(contact); //получаем телефоны для контакта с заданным идентификатором
        //склеиваем телефоны из бд, пустые пропускаем:
        var expected = Stream.of(contact.address());
        Assertions.assertEquals(expected, address);

    }

}
