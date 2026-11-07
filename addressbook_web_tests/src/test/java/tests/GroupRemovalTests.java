package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup () {
        if (app.hbm().getGroupCount() ==0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        //int groupCount = app.groups().getCount();
        var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());      //случайным образом выбираем какой-то элемент из oldGroups
        app.groups().removeGroup(oldGroups.get(index)); //удаляется именно эта группа
        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        //int newGroupCount=app.groups().getCount();
        Assertions.assertEquals(newGroups, expectedList);
    }

    @Test
    void canRemoveAllGroupsAtOnce(){
        if (app.hbm().getGroupCount() ==0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        app.groups().removeAllGroups(); //удаление всех групп
        Assertions.assertEquals(0, app.hbm().getGroupCount());
    }

}
