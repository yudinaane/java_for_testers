package model;

public record ContactData(String id,
                          String firstname,
                          String lastname,
                          String address,
                          String photo
                          ) {
    //конструктор для создания пустого контакта, чтобы в тесте не указывать все параметры
    public ContactData() {
        this("","", "", "", "");

    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.address, this.photo);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, lastname,  this.address, this.photo);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.lastname,  this.address, this.photo);
    }

    public ContactData withFieldToHome(String firstname, String lastname,String address
                                       ) {
        return new ContactData(this.id, firstname, lastname,  address, this.photo);
    }
    }



