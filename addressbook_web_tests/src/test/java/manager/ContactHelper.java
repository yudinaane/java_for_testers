package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

    public ContactHelper (ApplicationManagar manager){
        super(manager);
    }

    public void createContact(ContactData contact) {
        initContactCreation(); //нажать add
        fillContactForm(contact); //заполнить форму
        submitContactCreation();
        returnToHomePage();
    }

    public void removeContact(ContactData contact) {
        selectContact(contact); //проставив чек-бокс
        deleteContact();//нажать кнопку удалить
        returnToHomePage();
    }

    public void openPageContact() {
        if (!manager.isElementPresent(By.name("Number of results"))) {
            click(By.linkText("add new"));
        }
    }

    public void initContactCreation() {
        click(By.xpath("//a[contains(text(),\'add new\')]"));

        }

     public void  submitContactCreation(){
         click (By.name("submit"));

        }

     public void  returnToHomePage(){
            click(By.linkText("home page"));
            //driver.switchTo().alert().accept();
    }

     private void fillContactForm(ContactData contact) {
        type (By.name("firstname"), contact.firstname());
        type (By.name("middlename"), contact.middlename());
        type (By.name("lastname"), contact.lastname());
        type (By.name("nickname"), contact.nickname());
        type (By.name("title"), contact.title());
        type (By.name("company"), contact.company());
        type (By.name("address"), contact.address());
        type (By.name("home"), contact.home());
        type (By.name("mobile"), contact.mobile());
        type (By.name("work"), contact.work());
        type (By.name("email"), contact.email());
        type (By.name("email2"), contact.email2());

     }



    private void selectContact(ContactData contact) {
       // click(By.cssSelector(String.format("input[value='%s']", contact.id())));
       click(By.xpath("//input[@type=\"checkbox\"]"));
    }

    private void deleteContact() {
        click(By.name("delete"));
    }

    public boolean isContactPreset() {
        openPageContact();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public int getCountContact() {
        return manager.driver.findElements(By.name("selected[]")).size(); //возвращает кол-во чек-боксов
    }

    public void removeAllContacts() {
        selectedAllContacts();
        removeSelectedContacts();
    }

    private void removeSelectedContacts() { click(By.name("delete"));
    }

    private void selectedAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public List<ContactData> getListContact() {

        //надо прочитать данные и построить список
        var contacts = new ArrayList<ContactData>(); //пустой список с контактами в который будем складывать группы
        //хотим получить со страницы список элементов с информацией о контактах:
        var tds = manager.driver.findElements(By.cssSelector("td.center"));        //список элементов группы
        for (var td : tds) {
            var firstName = td.getText();
            var lastName = td.getText();
            var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("//input[@type=\"checkbox\"]");
            contacts.add(new ContactData().withId(id).withLastname(lastName).withFirstname(firstName));
        }
        return contacts;
    }
}

