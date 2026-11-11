package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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
    public void createContact(ContactData contact, GroupData group) {
        initContactCreation(); //нажать add
        fillContactForm(contact); //заполнить форму
        selectGroup(group);       //6.4 выбрать группу из выпадающего списка
        submitContactCreation();
        returnToHomePage();
    }
   //6.4
    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id()); //находить на странице нужный элемент
    }

    public void removeContact(ContactData contact) {
        selectContact(contact); //проставив чек-бокс
        deleteContact();//нажать кнопку удалить
        returnToHomePage();
    }

// не надо
    //public void addContactInGroup(ContactData contact, GroupData group) {
       // selectContact(contact); //проставив чек-бокс
        //selectGroupInHomePage(group); //выбрать группу на главной
       // submitGroupCreation(); //нажать ADD TO
        //returnToHomePage();
   // }
 //6.5
    private void selectGroupInHomePage(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id()); //находить на странице нужный элемент
    }

    public void openPageContact() {
        if (!manager.isElementPresent(By.name("Number of results"))) {
            click(By.linkText("add new"));
        }
    }

    public void initContactCreation() {
        click(By.xpath("//a[contains(text(),\'add new\')]"));
       }


       //&&&&
    public void  submitContactCreation(){
         click (By.name("submit"));
    }

    public void  submitGroupCreation(){
        click (By.name("add"));
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
       //click(By.cssSelector(String.format("input[value='%s']", contact.id())));
       //click(By.xpath("//input[@type=\"checkbox\"]"));
        click(By.xpath(String.format("//input[@type=\"checkbox\"]", contact.id())));
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
        var tds = manager.driver.findElements(By.cssSelector("td.center") );
        for (var td : tds) {
            //var firstName = td.getText();
            var lastName = td.getText();
            //var checkbox = td.findElement(By.name("selected[]"));
            var checkbox = td.findElement(By.xpath("//input[@name='selected[]']"));
            var id = checkbox.getAttribute("//input[@type=\"checkbox\"]");
            contacts.add(new ContactData().withId(id).withLastname(lastName));
        }
        return contacts;
    }



    //удал1
    public void removeContactFromGroup(GroupData group, ContactData contact) {
        selectGroupRight(group);//выбрать группу
        selectContact(contact); //проставив чек-бокс
        removeContactFooter();//нажать кнопку Remove
        //returnToHomePage();
    }
    //удал2 (барвть группу правый верх угол)
    private void selectGroupRight(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id()); //находить на странице нужный элемент
    }



    //удал3
    private void removeContactFooter() {
        click(By.name("remove"));
    }

    //7.5
    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id=%s]/../../td[6]", contact.id()))).getText();
    }

    public String getEmail(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id=%s]/../../td[5]", contact.id()))).getText();
    }

    public String getAddress(ContactData contact) {
       return manager.driver.findElement(By.xpath(
                String.format("//input[@id=%s]/../../td[4]", contact.id()))).getText();
    }



    public String getAddressModify(ContactData contact){
        selectEdit();  //нажать ручку
        return getAddressOnEditPage(contact);             //получить адресс
    }


    public void  selectEdit(){
        click (By.xpath("//img[@title='Edit']"));
    }

    public String  getAddressOnEditPage(ContactData contact){
       // var addressValue = manager.driver.findElement(By.name("address"), contact.id());
//        return addressValue.getText();
        return manager.driver.findElement(By.name(
                String.format("address", contact.id()))).getText();



    }
}

