package Essence;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    private static final String NAME = "database.db";
    private static final String DB_PATH = "C:/ЧП-Світогляд/db/" + NAME;
    private static final String URL = "jdbc:sqlite:" + DB_PATH;


    private static Statement statement = null;
    private static Connection connection = null;
    private static ResultSet result = null;

    public static Statement getStatement() {     //Возвращаем statement(для использования в следующих действиях)'обнуляем'
        return statement;
    }

    public static ResultSet getResultSet() {     //Возвращаем result(для использования в следующих действиях)'обнуляем'
        return result;
    }


    public static void getDatabase() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL);
                statement = connection.createStatement();           //Метод createStatement, через connection создаёт statement
                System.out.println("Connection with database created.");
                createDatabase();                                //Создание таблиц будет происходит параллельно запуску базы данных
            } catch (SQLException e) {
                System.out.println("Cant connect to database. \nError: " + e.getMessage());
            }
        }
    }

    public static void createDatabase() {
        String createClientSQL = "CREATE TABLE IF NOT EXISTS client (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	nameClient text NOT NULL,\n"
                + "	surnameClient text NOT NULL,\n"
                + "	lastnameClient text NOT NULL,\n"
                + " street text NOT NULL,\n"
                + " flat int NOT NULL,\n"
                + " phone text NOT NULL,\n"
                + " lastphone text NOT NULL,\n"
                + " numberCont int NOT NULL,\n"
                + " dateCont text NOT NULL,\n"
                + " dateConnect text NOT NULL\n"
                + ");";

        String createTariffSQL = "CREATE TABLE IF NOT EXISTS tariff (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	nameTariff text NOT NULL,\n"
                + "	value REAL NOT NULL\n"
                + ");";

        try {
            statement.execute(createClientSQL);     //Метод execute используется, когда операторы SQL возвращают более одного набора данных,
            statement.execute(createTariffSQL);     // более одного счетчика обновлений или и то, и другое.
        } catch (SQLException e) {
            System.out.println("Cant create database.\nError: " + e.getMessage());
        }
    }

    public static void executeSQL(String sql) {   //Создание строки sql(sql-скрипт) для многоразового использования.Для передачи данных в Базу
        getDatabase();
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Cant execute sql script.\nScript: " + sql + "\nError: " + e.getMessage());
        }
    }

    public static ArrayList<Client> loudClients() {
        String sql = "SELECT * FROM client;";                //Загрузить ВСЁ касаемо клиента

        getDatabase();
        ArrayList<Client> clients = new ArrayList<>();

        try {
            result = statement.executeQuery(sql);           //Метод executeQuery через statement создаёт result
            /* Метод executeQuery необходим для запросов, результатом которых является один единственный набор значений, таких как запросов SELECT. */

            while (result.next()) {
                int id = result.getInt("id");                        // Через result проходим по всем элементам
                String nameClient = result.getString("nameClient");
                String surnameClient = result.getString("surnameClient");
                String lastnameClient = result.getString("lastnameClient");
                String street = result.getString("street");
                int flat = result.getInt("flat");
                String phone = result.getString("phone");
                String lastphone = result.getString("lastphone");
                int numberCont = result.getInt("numberCont");
                String dateCont = result.getString("dateCont");
                String dateConnect = result.getString("dateConnect");

                Client client = new Client(id, nameClient, surnameClient, lastnameClient, street, flat, phone, lastphone, numberCont, dateCont, dateConnect);

                clients.add(client);                //В список клиентов ДОБАВИТЬ клиента
            }
        } catch (Exception e) {
            System.out.println("Cant loud data from database.\nError: " + e.getMessage());
        }

        return clients;
    }


    public static ArrayList<Tariff> loudTariffs() {
        String sql = "SELECT * FROM tariff;";              //Загрузить ВСЁ касаемо тарифа

        getDatabase();
        ArrayList<Tariff> tariffs = new ArrayList<>();

        try {
            result = statement.executeQuery(sql);       //Метод executeQuery через statement создаёт result
            /* Метод executeQuery необходим для запросов, результатом которых является один единственный набор значений, таких как запросов SELECT. */

            while (result.next()) {
                int id = result.getInt("id");                   // Через result проходим по всем элементам
                String nameTariff = result.getString("nameTariff");

                double value = result.getDouble("value");

                Tariff tariff = new Tariff(id, nameTariff, value);

                tariffs.add(tariff);                           //В список тарифов ДОБАВИТЬ тариф
            }
        } catch (Exception e) {
            System.out.println("Cant loud data from database.\nError: " + e.getMessage());
        }

        return tariffs;
    }
}


