import model.GroupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class GroupCreationTests extends TestBase {


    @Test
    public void сanCreateGroup() {
        openGroupsPage();
        createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void сanCreateGroupWithEmptyName() {
        openGroupsPage();
        driver.findElement(By.linkText("groups")).click();
        createGroup(new GroupData());
    }

    @Test
    public void сanCreateGroupWithNameOnly() {
        openGroupsPage();
        var emptyGroup= new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        driver.findElement(By.linkText("groups")).click();
        createGroup(new GroupData().withName("some name"));
    }
}
