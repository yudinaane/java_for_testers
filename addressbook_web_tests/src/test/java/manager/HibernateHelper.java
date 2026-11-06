package manager;

import jakarta.persistence.FetchType;
import manager.hbm.GroupRecord;
import model.GroupData;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceConfiguration;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {
    private SessionFactory sessionFactory;
    public HibernateHelper (ApplicationManagar manager){
        super(manager);
        //создание фвбрик сессиий:
        sessionFactory = new HibernatePersistenceConfiguration("Bookshop")
                        //.defaultToOneFetchType(FetchType.LAZY)
                        .managedClass(GroupRecord.class)
                        .jdbcUrl("jdbs:mysql://localhost/addressbook")
                        .jdbcCredentials("root", "")
                        .createEntityManagerFactory();
    }


    public List<GroupData> convertList(List<GroupRecord> records){
        List<GroupData> result = new ArrayList<>();
        for (var record : records){
            result.add(convert(record));
        }
        return result;

    }

    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    public List<GroupData> getGroupList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();


        }));

    }
}
