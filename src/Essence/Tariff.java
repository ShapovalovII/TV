package Essence;

import java.util.Locale;
import java.util.Scanner;

import static Essence.Tariffs.deleteTariffFromGlobalList;

public class Tariff {
    private int id;
    private String nameTariff;
    private double price;

    Tariff() {}

    Tariff(int id, String nameTariff, double price) {
        this.id = id;
        this.nameTariff = nameTariff;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getNameTariff() {
        return nameTariff;
    }

    public double getPrice() {
        return price;
    }

    public void addToDatabaseTariff() {
        String sql = "INSERT INTO tariff(nameTariff, price) VALUES('" + this.nameTariff + "', '" + this.price + "')";
        System.out.println(sql);
        Database.executeSQL(sql);      //Вызов метода "executeSQL"  для добавления тарифа в Базу Данных
    }

    public void updateTariffInDatabase() {
        String sql = String.format("UPDATE tariff SET nameTariff = '%s', price = '%s' where id = %d", this.nameTariff, this.price, id);
        System.out.println(sql);
        Database.executeSQL(sql);
    }

    public void deleteFromDatabase() {
        String sql = String.format("DELETE FROM tariff WHERE id = %d", id);
        System.out.println(sql);
        Database.executeSQL(sql);
    }

    public Tariff createTariff() {
        System.out.println("Create new tariff: ");

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.print("Name: ");
        this.nameTariff = scan.nextLine();

        System.out.print("Value: ");
        this.price = scan.nextDouble();


        addToDatabaseTariff();
        return this;
    }

    public Tariff updateTariff() {
        System.out.println("Update tariff: ");

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.print("Name: ");
        this.nameTariff = scan.nextLine();

        System.out.print("Value: ");
        this.price = scan.nextDouble();

        updateTariffInDatabase();
        return this;
    }

    public void deleteTariff() {
        deleteFromDatabase();
        deleteTariffFromGlobalList(this.id);
    }

    public void show() {
        System.out.println("****");
        System.out.println("id: " + this.id);
        System.out.println("Name tariff: " + this.nameTariff);
        System.out.println("Value tariff: " + this.price);
    }
}
