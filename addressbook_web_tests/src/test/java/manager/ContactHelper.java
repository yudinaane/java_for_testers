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

        type (By.name("lastname"), contact.lastname());

        type (By.name("address"), contact.address());
        attach (By.name("photo"), contact.photo());

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
