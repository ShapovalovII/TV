package Essence;

import java.util.Scanner;

public class Main {
    public static void main(String agrs[]) {
        Database.getDatabase();
    Clients clients = new Clients();
    Client client = new Client();


    Scanner scan = new Scanner(System.in);
//        while (true) {
//            System.out.println("Select an action: ");
//            System.out.println(" **1** Create");
//            System.out.println(" **2** Update");
//            System.out.println(" **3** Delete");
//            System.out.println(" **4** Show");
//            System.out.println(" **0** Exit");
//            System.out.print("Number: ");
//            int number = scan.nextInt();
//            switch (number) {
//                case 1:
//                    clients.show();
//                    client.createClient();
//                    break;
//                case 2:
//                    clients.show();
//                    client = clients.getClient();
//                    client.updateClient();
//                    break;
//                case 3:
//                    clients.show();
//                    client = clients.getClient();
//                    client.deleteClient();
//                    break;
//                case 4:
//                    clients.show();
//                    break;
//                case 0:
//                    System.exit(0);
//                default:
//                    break;
//            }
//        }


    Tariff tariff = new Tariff();

        Tariffs tariffs = new Tariffs();
        tariffs.show();
        tariff.createTariff();
        tariff = tariffs.getTariff();
        tariff.updateTariff();




}

}
