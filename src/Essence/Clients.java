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

    public static ObservableList<Client> getSimilarClientsByFullName(String fullName) {
        ArrayList<Client> tempList = new ArrayList<>();

        for (Client client : clients) {
            if (client.getFullName().contains(fullName)) {
                tempList.add(client);
            }
        }

        return FXCollections.observableArrayList(tempList);
    }

    public static void deleteClientFromGlobalList(int id) {
        for (int index = 0; index < clients.size(); index++) {
            if (clients.get(index).getId() == id) {
                clients.remove(index);
            }
        }
    }
}


