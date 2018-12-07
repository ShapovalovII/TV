package Controller;

import Essence.Client;
import Essence.Clients;
import Essence.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;

import static Essence.Clients.getClientsObservableList;

public class MainScreenController implements Initializable {

    @FXML
    private Tab Client;

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
    }

    @FXML
    void searchClients(KeyEvent event) {

    }

}
