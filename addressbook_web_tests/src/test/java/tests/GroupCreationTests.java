import manager.ApplicationManagar;
import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {


    @Test
    public void сanCreateGroup() {
        app.openGroupsPage();
        app.createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void сanCreateGroupWithEmptyName() {
        app.openGroupsPage();
        ApplicationManagar.driver.findElement(By.linkText("groups")).click();
        app.createGroup(new GroupData());
    }

    @Test
    public void сanCreateGroupWithNameOnly() {
        app.openGroupsPage();
        var emptyGroup= new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        ApplicationManagar.driver.findElement(By.linkText("groups")).click();
        app.createGroup(new GroupData().withName("some name"));
    }
}
