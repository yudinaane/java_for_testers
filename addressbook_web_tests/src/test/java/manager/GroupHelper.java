package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper (ApplicationManagar manager){
        super(manager);
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void removeGroup(GroupData group) {
        openGroupsPage();
        selectGroup(group);
        removeSelectedGroups();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData group, GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup(group);
        initGroupModification();
        //заполнить форму
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();

    }

    public void openGroupsPage() {
        if (! manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    //НЕ нужен после появления getCount public boolean isGroupPresent() {
        //openGroupsPage();
       // return manager.isElementPresent(By.name("selected[]"));
    //}


    private void submitGroupCreation() {
       click(By.name("submit"));
    }


    private void initGroupCreation() {
        click(By.name("new"));
    }



    private void removeSelectedGroups() {
        click(By.name("delete"));
    }



    private void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name ("group_header"), group.header());
        type(By.name ("group_footer"), group.footer());
    }



    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup(GroupData group) {

        click(By.cssSelector(String.format("input[value='%s']", group.id())));
    }

    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size(); //возвращает кол-во чек-боксов
    }

    public void removeAllGroups() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();

    }

    private void selectAllGroups() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public List<GroupData> getList() {
        openGroupsPage();
        var groups = new ArrayList<GroupData>(); //пустой список, в который будем складывать группы
        var spans = manager.driver.findElements(By.cssSelector("span.group"));        //список элементов группы
        for (var span : spans) {
            var name = span.getText();
            var checkbox = span.findElement(By.name ("selected[]"));
            var id = checkbox.getAttribute("value");
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
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

    private void selectContact(ContactData contact) {
        //click(By.cssSelector(String.format("input[value='%s']", contact.id())));
        //click(By.xpath("//input[@type=\"checkbox\"]"));
        click(By.xpath(String.format("//input[@type=\"checkbox\"]", contact.id())));
    }

    //удал3
    private void removeContactFooter() {
        click(By.name("remove"));
    }


}
