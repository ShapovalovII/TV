package Controller;

import Essence.Client;
import Essence.Clients;
import Essence.Database;
import Essence.Tariff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

import static Essence.Clients.getClientsObservableList;
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


    Clients clients;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database.getDatabase();

        clients = new Clients();

        fullName.setCellValueFactory(new PropertyValueFactory<Client, String>("fullName"));
        address.setCellValueFactory(new PropertyValueFactory<Client, String>("fullAddress"));
        mobilePhone.setCellValueFactory(new PropertyValueFactory<Client, String>("mobilePhone"));
        homePhone.setCellValueFactory(new PropertyValueFactory<Client, String>("homePhone"));

        clientsTable.setItems(getClientsObservableList());


        name.setCellValueFactory(new PropertyValueFactory<Tariff, String>("nameTariff"));
        price.setCellValueFactory(new PropertyValueFactory<Tariff, String>("price"));
        //dateAdd.setCellValueFactory(new PropertyValueFactory<Client, String>("fullName"));

        tariffsTable.setItems(getTariffsObservableList());
    }

//    @FXML
//    void searchClient(KeyEvent event) {
//        System.out.println("Search client with " + searchField.getText());
//    }

    @FXML
    void createClient(ActionEvent event) {
        System.out.println("Create client");
    }

    @FXML
    void createTariff(ActionEvent event) {
        System.out.println("Create tariff");
    }

//    @FXML
//    void openTariffDetails(MouseEvent event){
//        System.out.printf("Open tariff");
//    }

}
