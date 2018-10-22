package Essence;

import java.util.Scanner;

public class Client {
    private int id;
    private String nameClient;
    private String surnameClient;
    private String lastnameClient;
    private String street;
    private int flat;
    private String phone;
    private String lastphone;
    private int numberCont;            //Номер контракта
    private String dateCont;           //Дата контракта
    private String dateConnect;        //Дата подключения

    public Client() {
    }


    public Client(int id, String nameClient, String surnameClient, String lastnameClient, String street,
                  int flat, String phone, String lastphone, int numberCont, String dateCont, String dateConnect) {
        this.id = id;
        this.nameClient = nameClient;
        this.surnameClient = surnameClient;
        this.lastnameClient = lastnameClient;
        this.street = street;
        this.flat = flat;
        this.phone = phone;
        this.lastphone = lastphone;
        this.numberCont = numberCont;
        this.dateCont = dateCont;
        this.dateConnect = dateConnect;
    }


    private void addToDatabaseClient() {
        String sql = String.format("INSERT INTO client(nameClient, surnameClient, lastnameClient, street, flat, phone, lastphone, numberCont, dateCont, dateConnect)" +
                        " VALUES('%s','%s','%s','%s','%d','%s','%s','%d','%s','%s')",       //Использовать метод format из класса String, для сохранения Client
                this.nameClient, this.surnameClient, this.lastnameClient, this.street, this.flat, this.phone, this.lastphone, this.numberCont, this.dateCont, this.dateConnect);
        System.out.println(sql);
        Database.executeSQL(sql);      //Вызов метода "executeSQL"  для добавления клиентов в Базу Данных
    }

    private void updateClientInDatabase() {
        String sql = String.format("UPDATE client SET nameClient = '%s', surnameClient = '%s', lastnameClient = '%s', " +
                                "street = '%s', flat = '%d', phone = '%s', lastphone = '%s', numberCont = '%d', dateCont = '%s', dateConnect = '%s' where id = %d",
                        this.nameClient, this.surnameClient, this.lastnameClient, this.street, this.flat, this.phone, this.lastphone, this.numberCont, this.dateCont, this.dateConnect, id);
        System.out.println(sql);
        Database.executeSQL(sql);
    }

    private void deleteFromDatabase() {
        String sql = String.format("DELETE FROM client WHERE id = %d", id);
        System.out.println(sql);
        Database.executeSQL(sql);
    }

    public Client createClient() {
        System.out.println("Create new client: ");
        Scanner scan = new Scanner(System.in);

        System.out.print("Name: ");
        this.nameClient = scan.nextLine();

        System.out.print("Surname: ");
        this.surnameClient = scan.nextLine();

        System.out.print("Lastname: ");
        this.lastnameClient = scan.nextLine();

        System.out.print("Street: ");
        this.street = scan.nextLine();

        System.out.print("Flat: ");
        this.flat = scan.nextInt();

        scan.nextLine();      //Метод scan.nextInt не использует последний символ новой строки вашего ввода, и, таким образом, эта строка используется в следующем вызове  scan.nextLine();

        System.out.print("Phone: ");
        this.phone = scan.nextLine();

        System.out.print("Lastphone: ");
        this.lastphone = scan.nextLine();

        System.out.print("NumderCont: ");
        this.numberCont = scan.nextInt();

        scan.nextLine();

        System.out.print("DateCont: ");
        this.dateCont = scan.nextLine();

        System.out.print("DateConnect: ");
        this.dateConnect = scan.nextLine();

        addToDatabaseClient();
        return this;
    }

    public Client updateClient() {
        System.out.println("Update client: ");
        Scanner scan = new Scanner(System.in);

        System.out.print("Name: ");
        this.nameClient = scan.nextLine();

        System.out.print("Surname: ");
        this.surnameClient = scan.nextLine();

        System.out.print("Lastname: ");
        this.lastnameClient = scan.nextLine();

        System.out.print("Street: ");
        this.street = scan.nextLine();

        System.out.print("Flat: ");
        this.flat = scan.nextInt();

        scan.nextLine();      //Метод scan.nextInt не использует последний символ новой строки вашего ввода, и, таким образом, эта строка используется в следующем вызове  scan.nextLine();

        System.out.print("Phone: ");
        this.phone = scan.nextLine();

        System.out.print("Lastphone: ");
        this.lastphone = scan.nextLine();

        System.out.print("NumderCont: ");
        this.numberCont = scan.nextInt();

        scan.nextLine();

        System.out.print("DateCont: ");
        this.dateCont = scan.nextLine();

        System.out.print("DateConnect: ");
        this.dateConnect = scan.nextLine();

        updateClientInDatabase();
        return this;
    }

    public void deleteClient(){
        deleteFromDatabase();
    }


    public void show() {
        System.out.println("****");
        System.out.println("id: " + this.id);
        System.out.println("Name Client: " + this.nameClient);
        System.out.println("Surname Client: " + this.surnameClient);
        System.out.println("Lastname Client: " + this.lastnameClient);
        System.out.println("Street: " + this.street);
        System.out.println("Flat: " + this.flat);
        System.out.println("Phone: " + this.phone);
        System.out.println("Lastphone: " + this.lastphone);
        System.out.println("NumderCont: " + this.numberCont);
        System.out.println("DateCont: " + this.dateCont);
        System.out.println("DateConnect: " + this.dateConnect);
    }

    public String getSurnameClient(){
        return this.surnameClient;
    }

    public String getNameClient() {
        return nameClient;
    }
}