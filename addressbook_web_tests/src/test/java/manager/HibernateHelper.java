package manager;

import jakarta.persistence.FetchType;
import manager.hbm.ContactRecord;
import manager.hbm.GroupRecord;
import model.ContactData;
import model.GroupData;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.jpa.HibernatePersistenceConfiguration;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {
    private SessionFactory sessionFactory;
    public HibernateHelper (ApplicationManagar manager){
        super(manager);
        //создание фвбрик сессиий:
        sessionFactory = new Configuration()
                        .addAnnotatedClass(ContactRecord.class)
                        .addAnnotatedClass(GroupRecord.class)
                        .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=ConvertToNull")
                        .setProperty(AvailableSettings.USER,"root")
                        .setProperty(AvailableSettings.PASS,"")
                        .buildSessionFactory();
    }


    public List<GroupData> convertList(List<GroupRecord> records){
        List<GroupData> result = new ArrayList<>();
        for (var record : records){
            result.add(convert(record));
        }
        return result;

    }

    public List<ContactData> convertContactList(List<ContactRecord> records){
        List<ContactData> result = new ArrayList<>();
        for (var record : records){
            result.add(convert(record));
        }
        return result;

    }
    private static ContactData convert(ContactRecord record) {
        return new ContactData().withId("" + record.id)
                .withFirstname(record.firstname)
                .withLastname(record.lastname)
                .withAddress(record.address);
    }

    private static ContactRecord convert(ContactData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new ContactRecord(Integer.parseInt(id), data.firstname(), data.lastname(), data.address());
    }



    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(GroupData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    public List<GroupData> getGroupList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public long getGroupCount() {
                return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        });
    }

    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(groupData));
            session.getTransaction().commit();
        });
    }

    public List<ContactData> getContactsInGroup(GroupData group) {
        return sessionFactory.fromSession( session -> {
            return convertContactList(session.getReference(GroupRecord.class, group.id()).contacts);
        });

    }
}
