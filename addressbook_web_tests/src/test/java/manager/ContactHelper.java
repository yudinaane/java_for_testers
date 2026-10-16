package manager;

import model.ContactData;
import org.openqa.selenium.By;


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

    public void removeContact() {
        selectContact(); //проставив чек-бокс
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



    private void selectContact() {
        click(By.xpath("//input[@type=\"checkbox\"]"));
    }

    private void deleteContact() {
        click(By.name("delete"));
    }

    public boolean isContactPreset() {
        openPageContact();
        return manager.isElementPresent(By.name("selected[]"));
    }
}
