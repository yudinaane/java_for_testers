package model;

public record ContactData(String id, String firstname,
                          String middlename,
                          String lastname,
                          String nickname,
                          String title,
                          String company,
                          String address,
                          String home,
                          String mobile,
                          String work,
                          String email,
                          String email2, String fax, String email3) {
    //конструктор для создания пустого контакта, чтобы в тесте не указывать все параметры
    public ContactData() {
        this("", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "");

    }

    public ContactData(String id, String firstname, String lastname, String address) {
        this(id, firstname, "", lastname, "", "",
                "", address, "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, this.mobile, this.work, this.email, this.email2, this.fax, this.email3);
    }
    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, this.mobile, this.work, this.email, this.email2,  this.fax, this.email3);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.title,
                this.company, this.address, this.home, this.mobile, this.work, this.email, this.email2,  this.fax, this.email3);
    }


    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, address, this.home, this.mobile, this.work, this.email, this.email2,  this.fax, this.email3);
    }

   // public ContactData withEmail(String email) {       return null;    }



    public ContactData withFieldToHome(String firstname, String lastname,
                                       String address, String home, String email) {
        return new ContactData(this.id, firstname, this.middlename, lastname, this.nickname, this.title,
                this.company, address, home, this.mobile, this.work, email, this.email2,  this.fax, this.email3);
    }

    public ContactData withRandom(String lastname, String home, String mobile, String email) {
        return new ContactData(this.id, firstname, this.middlename, lastname, this.nickname, this.title,
                this.company, address, home, mobile, this.work, email, this.email2,  this.fax, this.email3);
    }

    public ContactData withHbm(String id, String firstname, String lastname, String address) {
        return new ContactData(id, firstname, this.middlename, lastname, this.nickname, this.title,
                this.company, address, home, mobile, this.work, email, this.email2,  this.fax, this.email3);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, home, this.mobile, this.work, this.email, this.email2,  this.fax, this.email3);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, this.mobile, work, this.email, this.email2,  this.fax, this.email3);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, mobile, this.work, this.email, this.email2,  this.fax, this.email3);
    }
    public ContactData withFax(String fax) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, mobile, this.work, this.email, this.email2,  fax, this.email3);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, mobile, this.work, email, this.email2,  this.fax, this.email3);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, mobile, this.work, this.email, email2,  this.fax, this.email3);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, mobile, this.work, this.email, this.email2,  this.fax, email3);
    }




}

