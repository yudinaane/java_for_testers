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
                          String email2) {
    //конструктор для создания пустого контакта, чтобы в тесте не указывать все параметры
    public ContactData() {
        this("", "", "", "", "", "",
                "", "", "", "", "", "", "");

    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, this.mobile, this.work, this.email, this.email2);
    }
    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, this.mobile, this.work, this.email, this.email2);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.title,
                this.company, this.address, this.home, this.mobile, this.work, this.email, this.email2);
    }


    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, address, this.home, this.mobile, this.work, this.email, this.email2);
    }

    public ContactData withEmail(String email) {
        return null;
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title,
                this.company, this.address, this.home, mobile, this.work, this.email, this.email2);
    }

    public ContactData withFieldToHome(String firstname, String lastname,
                                       String address, String home, String email) {
        return new ContactData(this.id, firstname, this.middlename, lastname, this.nickname, this.title,
                this.company, address, home, this.mobile, this.work, email, this.email2);
    }

    public ContactData withRandom(String lastname, String home, String mobile, String email) {
        return new ContactData(this.id, firstname, this.middlename, lastname, this.nickname, this.title,
                this.company, address, home, mobile, this.work, email, this.email2);
    }


}

