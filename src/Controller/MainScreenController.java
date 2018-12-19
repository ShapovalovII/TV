package Controller;

import Essence.*;
import View.NewClient;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static Essence.Clients.getClientsObservableList;
import static Essence.Clients.getSimilarClientsByFullName;
import static Essence.Tariffs.getTariffsObservableList;

public class MainScreenController implements Initializable {

    @FXML
    private Tab Client;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Client> clientsTable;

    @FXML
    private TableColumn<Client, String> fullName;

    @FXML
    private TableColumn<Client, String> address;

    @FXML
    private TableColumn<Client, String> mobilePhone;

    @FXML
    private TableColumn<Client, String> homePhone;

    @FXML
    private Tab Tariff;

    @FXML
    private Button createClientButton;

    @FXML
    private TableView<Tariff> tariffsTable;

    @FXML
    private TableColumn<Tariff, String> name;

    @FXML
    private TableColumn<Tariff, String> price;

    @FXML
    private TableColumn<Tariff, String> dateAdd;


    Clients clients;
    Tariffs tariffs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database.getDatabase();

        clients = new Clients();
        tariffs = new Tariffs();

        /* initialize client table */
        fullName.setCellValueFactory(new PropertyValueFactory<Client, String>("fullName"));
        address.setCellValueFactory(new PropertyValueFactory<Client, String>("fullAddress"));
        mobilePhone.setCellValueFactory(new PropertyValueFactory<Client, String>("mobilePhone"));
        homePhone.setCellValueFactory(new PropertyValueFactory<Client, String>("homePhone"));

        /* initialize tariff table */
        name.setCellValueFactory(new PropertyValueFactory<Tariff, String>("nameTariff"));
        price.setCellValueFactory(new PropertyValueFactory<Tariff, String>("price"));
        dateAdd.setCellValueFactory(new PropertyValueFactory<Tariff, String>("price"));

        /* set data in to tariff & client table */
        updateClientsTable(getClientsObservableList());
        updateTariffsTable(getTariffsObservableList());
    }


    @FXML
    void searchClients(KeyEvent event) {
        try {
        clientsTable.setItems(getSimilarClientsByFullName(searchField.getText()));
        } catch (NullPointerException e) {
            System.out.printf("Not found clients in database");
        }
    }

    @FXML
    void createClient(ActionEvent event) {
        try {
            NewClient newClient = new NewClient();
           newClient.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) createClientButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void createTariff(ActionEvent event) {
        System.out.println("Create tariff");
    }

    private void updateClientsTable(ObservableList clientList) {
        try {
            clientsTable.setItems(clientList);
        } catch (NullPointerException e) {
            System.out.printf("Not found clients in database");
        }
    }

    private void updateTariffsTable(ObservableList tariffList) {
        try {
            tariffsTable.setItems(tariffList);
        } catch (NullPointerException e) {
            System.out.printf("Not found tariff in database");
        }
    }
}
