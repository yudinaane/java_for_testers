package tests;

import manager.ApplicationManagar;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {

    @Test
    public void сanCreateGroup() {
        app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void сanCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void сanCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));
    }
}
