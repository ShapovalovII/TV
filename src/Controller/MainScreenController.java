package Controller;


import Essence.Client;
import Essence.Clients;
import Essence.Database;
import Essence.Tariff;

import Essence.*;

import View.NewClient;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
    private TableView<Tariff> tariffsTable;

    @FXML
    private TableColumn<Tariff, String> name;

    @FXML
    private TableColumn<Tariff, String> price;

    @FXML
    private TableColumn<Tariff, String> dateAdd;

    @FXML
    private Button createClientButton;


    Clients clients;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database.getDatabase();

        clients = new Clients();

        fullName.setCellValueFactory(new PropertyValueFactory<Client, String>("fullName"));
        address.setCellValueFactory(new PropertyValueFactory<Client, String>("fullAddress"));
        mobilePhone.setCellValueFactory(new PropertyValueFactory<Client, String>("mobilePhoneClient"));
        homePhone.setCellValueFactory(new PropertyValueFactory<Client, String>("homePhoneClient"));

        clientsTable.setItems(getClientsObservableList());


        name.setCellValueFactory(new PropertyValueFactory<Tariff, String>("nameTariff"));
        price.setCellValueFactory(new PropertyValueFactory<Tariff, String>("price"));
        //dateAdd.setCellValueFactory(new PropertyValueFactory<Client, String>("fullName"));

       try {
           tariffsTable.setItems(getTariffsObservableList());
       }catch (NullPointerException e){
           System.out.println("Tariff is missing");
       }
    }


    @FXML
    void searchClient(KeyEvent event) {
        System.out.println("Search client with " + searchField.getText());
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
    void createClient(ActionEvent event) throws Exception {
        Stage stage = (Stage) createClientButton.getScene().getWindow();
        stage.close();
        NewClient newClient = new NewClient();
        newClient.start(new Stage());

    }

    @FXML
    void createTariff(ActionEvent event) {
        System.out.println("Create tariff");
    }

    @FXML
    void openTariffDetails(MouseEvent event){
        System.out.printf("Open tariff");
    }

}
