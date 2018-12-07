package Essence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Clients {
   private static ArrayList<Client> clients;

    public Clients() {
        clients = Database.loudClients();
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static ObservableList<Client> getClientsObservableList() {
        return FXCollections.observableArrayList(clients);
    }
}


