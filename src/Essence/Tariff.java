package Essence;

import java.util.Locale;
import java.util.Scanner;

public class Tariff {
    private int id;
    private String nameTariff;
    private double value;

    public Tariff() {
    }

    public Tariff(int id, String nameTariff, double value) {
        this.id = id;
        this.nameTariff = nameTariff;
        this.value = value;
    }


    public void addToDatabaseTariff() {
        String sql = "INSERT INTO tariff(nameTariff, value) VALUES('" + this.nameTariff + "', '" + this.value + "')";
        System.out.println(sql);
        Database.executeSQL(sql);      //Вызов метода "executeSQL"  для добавления тарифа в Базу Данных
    }

    public void updateTariffInDatabase() {
        String sql = String.format("UPDATE tariff SET nameTariff = '%s', value = '%s' where id = %d", this.nameTariff, this.value, id);
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
        this.value = scan.nextDouble();


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
        this.value = scan.nextDouble();

        updateTariffInDatabase();
        return this;
    }

    public void deleteTariff() {
        deleteFromDatabase();
    }

    public void show() {
        System.out.println("****");
        System.out.println("id: " + this.id);
        System.out.println("Name tariff: " + this.nameTariff);
        System.out.println("Value tariff: " + this.value);
    }

    public double getValue() {
        return value;
    }


}
