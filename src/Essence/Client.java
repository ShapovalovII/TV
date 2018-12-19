package Essence;

import static Essence.Clients.deleteClientFromGlobalList;

public class Client {
    private int id;
    private String nameClient;
    private String surname;
    private String lastname;
    private String street;
    private String numberStreet;
    private String flat;
    private String mobilePhone;
    private String homePhone;
    private String numberContract;            //Номер контракта
    private String dateContract;           //Дата контракта
    private String dateConnected;        //Дата подключения

    private String fullName;
    private String fullAddress;


    public Client() {
    }


    public Client(int id, String nameClient, String surname, String lastname, String street, String numberStreet,
                  String flat, String mobilePhone, String homePhone, String numberContract, String dateContract, String dateConnected) {
        this.id = id;
        this.nameClient = nameClient;
        this.surname = surname;
        this.lastname = lastname;
        this.street = street;
        this.numberStreet = numberStreet;
        this.flat = flat;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.numberContract = numberContract;
        this.dateContract = dateContract;
        this.dateConnected = dateConnected;

        this.fullName = String.format("%s %s %s", surname, nameClient, lastname);
        this.fullAddress = String.format("%s %s %s", street, numberStreet, flat);

    }

    public Client(String nameClient, String surname, String lastname, String street, String numberStreet,
                  String flat, String mobilePhone, String homePhone, String numberContract, String dateContract, String dateConnected) {
        this.nameClient = nameClient;
        this.surname = surname;
        this.lastname = lastname;
        this.street = street;
        this.numberStreet = numberStreet;
        this.flat = flat;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.numberContract = numberContract;
        this.dateContract = dateContract;
        this.dateConnected = dateConnected;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return nameClient;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStreet() {
        return street;
    }

    public String getFlat() {
        return flat;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getNumberContract() {
        return numberContract;
    }

    public String getDateContract() {
        return dateContract;
    }

    public String getDateConnected() {
        return dateConnected;
    }



    public void addToDatabaseClient() {
        String sql = String.format("INSERT INTO client(nameClient, surname, lastname, street, numberStreet, flat, mobilePhone, homePhone, numberContract, dateContract, dateConnected)" +
                        " VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",       //Использовать метод format из класса String, для сохранения Client
                this.nameClient, this.surname, this.lastname, this.street, this.numberStreet, this.flat, this.mobilePhone, this.homePhone, this.numberContract, this.dateContract, this.dateConnected);
        System.out.println(sql);
        Database.executeSQL(sql);      //Вызов метода "executeSQL"  для добавления клиентов в Базу Данных
    }

    private void updateClientInDatabase() {
        String sql = String.format("UPDATE client SET nameClient = '%s', surname = '%s', lastname = '%s', " +
                        "street = '%s', numberStreet = '%s', flat = '%s', mobilePhone = '%s', homePhone = '%s', numberContract = '%s', dateContract = '%s', dateConnected = '%s' where id = %d",
                this.nameClient, this.surname, this.lastname, this.street, this.numberStreet, this.flat, this.mobilePhone, this.homePhone, this.numberContract, this.dateContract, this.dateConnected, id);
        System.out.println(sql);
        Database.executeSQL(sql);
    }

    private void deleteFromDatabase() {
        String sql = String.format("DELETE FROM client WHERE id = %d", id);
        System.out.println(sql);
        Database.executeSQL(sql);
    }

    public void deleteClient(){
        deleteFromDatabase();
        deleteClientFromGlobalList(this.id);
    }


    public void show() {
        System.out.println("****");
        System.out.println("id: " + this.id);
        System.out.println("Name Client: " + this.nameClient);
        System.out.println("Surname Client: " + this.surname);
        System.out.println("Lastname Client: " + this.lastname);
        System.out.println("Street: " + this.street);
        System.out.println("Flat: " + this.flat);
        System.out.println("Phone: " + this.mobilePhone);
        System.out.println("Lastphone: " + this.homePhone);
        System.out.println("NumderCont: " + this.numberContract);
        System.out.println("DateCont: " + this.dateContract);
        System.out.println("DateConnect: " + this.dateConnected);
    }
}