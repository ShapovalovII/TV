package Essence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Tariffs {
    private static ArrayList<Tariff> tariffs;

    public Tariffs() {
        tariffs = Database.loudTariffs();
    }

    public static ArrayList<Tariff> getTariffs() {
        return tariffs;
    }

    public static ObservableList<Tariff> getTariffsObservableList() {
        return FXCollections.observableArrayList(tariffs);
    }

}
