package Essence;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Tariffs {
    ArrayList<Tariff> tariffs;

    private double value;

    public Tariffs() {
        tariffs = Database.loudTariffs();
    }

    public void show() {
        System.out.println("All Tariffs: ");

        for (Tariff tariff : tariffs) {
            tariff.show();
        }
    }

    public Tariff getTariff(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Tariff search: ");
        scan.useLocale(Locale.US);
        System.out.print("Value: ");
        this.value = scan.nextDouble();


        for (Tariff tariff : tariffs) {
            if(tariff.getValue() == value){
                System.out.println("Tariff fount");
                return tariff;
            }
        }
        System.out.println("Tariff not fount");
        return null;

    }
}
