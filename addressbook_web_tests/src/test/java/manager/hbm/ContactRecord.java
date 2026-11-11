package manager.hbm;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "addressbook")

public class ContactRecord {
    @Id

    public int id;


    public String firstname;


    public String lastname;


    public String address;

    public String home;
    public String mobile;
    public String work;
    public String fax;

    public String email;
    public String email2;
    public String email3;





    public ContactRecord(){}


    public ContactRecord(int id, String firstname, String lastname, String address){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }



}
