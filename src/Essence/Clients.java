package Essence;
import java.util.ArrayList;
import java.util.Scanner;

public class Clients {
    ArrayList<Client> clients;


    private String name;
    private String surname;



    public Clients() {
        clients = Database.loudClients();
    }


    public void show() {
        System.out.println("All Clients: ");

        for (Client client : clients) {
            client.show();
        }
    }

    public Client getClient(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Client search: ");

        System.out.print("Name: ");
        this.name = scan.nextLine();
        System.out.print("Surname: ");
        this.surname = scan.nextLine();

        for (Client client : clients) {
            if(client.getNameClient().equals(name) && client.getSurnameClient().equals(surname)){
                System.out.println("Client fount");
                return client;
            }
        }
        System.out.println("Client not fount");
        return null;
    }


}


