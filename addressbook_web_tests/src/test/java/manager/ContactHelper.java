package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper {
    private final ApplicationManagar managar;

    public ContactHelper(ApplicationManagar managar) {
        this.managar = managar;
    }

    public void openPageContact() {
        if (!managar.isElementPresentContact(By.name("add new"))) {
            managar.driver.findElement(By.linkText("add new")).click();
        }

    }

    public void createContact(ContactData contact) {
        openPageContact();
        managar.driver.findElement(By.name("firstname")).click();
        managar.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        managar.driver.findElement(By.name("middlename")).click();
        managar.driver.findElement(By.name("middlename")).sendKeys(contact.middlename());
        managar.driver.findElement(By.name("lastname")).click();
        managar.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        managar.driver.findElement(By.name("nickname")).click();
        managar.driver.findElement(By.name("nickname")).sendKeys(contact.nickname());
        managar.driver.findElement(By.name("title")).click();
        managar.driver.findElement(By.name("title")).sendKeys(contact.title());
        managar.driver.findElement(By.name("company")).click();
        managar.driver.findElement(By.name("company")).sendKeys(contact.company());
        managar.driver.findElement(By.name("address")).click();
        managar.driver.findElement(By.name("address")).sendKeys(contact.address());
        managar.driver.findElement(By.name("home")).click();
        managar.driver.findElement(By.name("home")).sendKeys(contact.home());
        managar.driver.findElement(By.name("mobile")).click();
        managar.driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
        managar.driver.findElement(By.name("work")).click();
        managar.driver.findElement(By.name("work")).sendKeys(contact.work());
        managar.driver.findElement(By.name("email")).click();
        managar.driver.findElement(By.name("email")).sendKeys(contact.email());
        managar.driver.findElement(By.name("theform")).click();
        managar.driver.findElement(By.name("email2")).click();
        managar.driver.findElement(By.name("email2")).sendKeys(contact.email2());
        managar.driver.findElement(By.linkText("home")).click();
        //managar.driver.findElement(By.name("submit")).click();
        managar.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    }
}
