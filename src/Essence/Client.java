package Essence;


public class Client {
    private int id;
    private String nameClient;
    private String surnameClient;
    private String lastnameClient;
    private String streetClient;
    private String numberStreetClient;
    private String flatClient;
    private String mobilePhoneClient;
    private String homePhoneClient;
    private String numberContractClient;            //Номер контракта
    private String dateContractClient;           //Дата контракта
    private String dateConnectedClient;        //Дата подключения

    private String fullName;
    private String fullAddress;

    public Client() {
    }


    public Client(int id, String nameClient, String surnameClient, String lastnameClient, String streetClient, String numberStreetClient,
                  String flatClient, String mobilePhoneClient, String homePhoneClient, String numberContractClient, String dateContractClient, String dateConnectedClient) {
        this.id = id;
        this.nameClient = nameClient;
        this.surnameClient = surnameClient;
        this.lastnameClient = lastnameClient;
        this.streetClient = streetClient;
        this.numberStreetClient = numberStreetClient;
        this.flatClient = flatClient;
        this.mobilePhoneClient = mobilePhoneClient;
        this.homePhoneClient = homePhoneClient;
        this.numberContractClient = numberContractClient;
        this.dateContractClient = dateContractClient;
        this.dateConnectedClient = dateConnectedClient;

        this.fullName = String.format("%s %s %s", surnameClient, nameClient, lastnameClient);
        this.fullAddress = String.format("%s %s %s", streetClient, numberContractClient, flatClient);

    }


    public Client(String nameClient, String surnameClient, String lastnameClient, String streetClient, String numberStreetClient,
                  String flatClient, String mobilePhoneClient, String homePhoneClient, String numberContractClient, String dateContractClient, String dateConnectedClient) {
        this.nameClient = nameClient;
        this.surnameClient = surnameClient;
        this.lastnameClient = lastnameClient;
        this.streetClient = streetClient;
        this.numberStreetClient = numberStreetClient;
        this.flatClient = flatClient;
        this.mobilePhoneClient = mobilePhoneClient;
        this.homePhoneClient = homePhoneClient;
        this.numberContractClient = numberContractClient;
        this.dateContractClient = dateContractClient;
        this.dateConnectedClient = dateConnectedClient;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return nameClient;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public String getLastNameClient() {
        return lastnameClient;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStreetClient() {
        return streetClient;
    }

    public String getNumberStreetClient() {
        return numberStreetClient;
    }

    public String getFlatClient() {
        return flatClient;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getMobilePhoneClient() {
        return mobilePhoneClient;
    }

    public String getHomePhoneClient() {
        return homePhoneClient;
    }

    public String getNumberContractClient() {
        return numberContractClient;
    }

    public String getDateContractClient() {
        return dateContractClient;
    }

    public String getDateConnectedClient() {
        return dateConnectedClient;
    }



    public void addToDatabaseClient() {
        String sql = String.format("INSERT INTO client(nameClient, surnameClient, lastnameClient, streetClient, numberStreetClient, flatClient, mobilePhoneClient, homePhoneClient, numberContractClient, dateContractClient, dateConnectedClient)" +
                        " VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",       //Использовать метод format из класса String, для сохранения Client
                this.nameClient, this.surnameClient, this.lastnameClient, this.streetClient, this.numberStreetClient, this.flatClient,  this.mobilePhoneClient, this.homePhoneClient, this.numberContractClient, this.dateContractClient, this.dateConnectedClient);
        System.out.println(sql);
        Database.executeSQL(sql);      //Вызов метода "executeSQL"  для добавления клиентов в Базу Данных
    }

    private void updateClientInDatabase() {
        String sql = String.format("UPDATE client SET nameClient = '%s', surnameClient = '%s', lastNameClient = '%s', " +
                        "streetClient = '%s', numberStreetClient = '%s', flatClient = '%s', mobilePhoneClient = '%s', homePhoneClient = '%s', numberContractClient = '%s', dateContractClient = '%s', dateConnectedClient = '%s' where id = %d",
                this.nameClient, this.surnameClient, this.lastnameClient, this.streetClient, this.flatClient, this.mobilePhoneClient, this.homePhoneClient, this.numberContractClient, this.dateContractClient, this.dateConnectedClient, id);
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
    }


    public void show() {
        System.out.println("****");
        System.out.println("id: " + this.id);
        System.out.println("Name Client: " + this.nameClient);
        System.out.println("Surname Client: " + this.surnameClient);
        System.out.println("Lastname Client: " + this.lastnameClient);
        System.out.println("Street: " + this.streetClient);
        System.out.println("Flat: " + this.flatClient);
        System.out.println("Phone: " + this.mobilePhoneClient);
        System.out.println("Lastphone: " + this.homePhoneClient);
        System.out.println("NumderCont: " + this.numberContractClient);
        System.out.println("DateCont: " + this.dateContractClient);
        System.out.println("DateConnect: " + this.dateConnectedClient);
    }
}