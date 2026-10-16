package tests;

import manager.ApplicationManagar;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {

    @Test
    public void сanCreateGroup() {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
        int newGroupCount=app.groups().getCount();
        Assertions.assertEquals(groupCount+1, newGroupCount);
    }

    @Test
    public void сanCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void сanCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));
    }

    @Test
    public void сanCreateMultipleGroup() {
        int n=5;

        int groupCount = app.groups().getCount();

        for (int i = 0; i < n; i++){
            app.groups().createGroup(new GroupData(randomString(i*10), "group header", "group footer"));
        }

        int newGroupCount=app.groups().getCount();
        Assertions.assertEquals(groupCount+n, newGroupCount);
    }
}
