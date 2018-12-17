package Essence;

import java.util.Scanner;

import static Essence.Clients.deleteClientFromGlobalList;

public class Client {
    private int id;
    private String name;
    private String surname;
    private String lastName;
    private String street;
    private int flat;
    private String mobilePhone;
    private String homePhone;
    private int numberContract;            //Номер контракта
    private String dateContract;           //Дата контракта
    private String dateConnected;        //Дата подключения

    private String fullName;
    private String fullAddress;

    public Client() {
    }


    public Client(int id, String name, String surname, String lastName, String street,
                  int flat, String mobilePhone, String homePhone, int numberContract, String dateContract, String dateConnected) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastName = lastName;
        this.street = street;
        this.flat = flat;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.numberContract = numberContract;
        this.dateContract = dateContract;
        this.dateConnected = dateConnected;

        this.fullName = String.format("%s %s %s", surname, name, lastName);
        this.fullAddress = String.format("%s %s", street, String.valueOf(flat));

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStreet() {
        return street;
    }

    public int getFlat() {
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

    public int getNumberContract() {
        return numberContract;
    }

    public String getDateContract() {
        return dateContract;
    }

    public String getDateConnected() {
        return dateConnected;
    }



    private void addToDatabaseClient() {
        String sql = String.format("INSERT INTO client(name, surname, lastName, street, flat, mobilePhone, homePhone, numberContract, dateContract, dateConnected)" +
                        " VALUES('%s','%s','%s','%s','%d','%s','%s','%d','%s','%s')",       //Использовать метод format из класса String, для сохранения Client
                this.name, this.surname, this.lastName, this.street, this.flat, this.mobilePhone, this.homePhone, this.numberContract, this.dateContract, this.dateConnected);
        System.out.println(sql);
        Database.executeSQL(sql);      //Вызов метода "executeSQL"  для добавления клиентов в Базу Данных
    }

    private void updateClientInDatabase() {
        String sql = String.format("UPDATE client SET name = '%s', surname = '%s', lastName = '%s', " +
                        "street = '%s', flat = '%d', mobilePhone = '%s', homePhone = '%s', numberContract = '%d', dateContract = '%s', dateConnected = '%s' where id = %d",
                this.name, this.surname, this.lastName, this.street, this.flat, this.mobilePhone, this.homePhone, this.numberContract, this.dateContract, this.dateConnected, id);
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
        System.out.println("Name Client: " + this.name);
        System.out.println("Surname Client: " + this.surname);
        System.out.println("Lastname Client: " + this.lastName);
        System.out.println("Street: " + this.street);
        System.out.println("Flat: " + this.flat);
        System.out.println("Phone: " + this.mobilePhone);
        System.out.println("Lastphone: " + this.homePhone);
        System.out.println("NumderCont: " + this.numberContract);
        System.out.println("DateCont: " + this.dateContract);
        System.out.println("DateConnect: " + this.dateConnected);
    }
}