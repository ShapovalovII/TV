package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Essence.Client;
import Essence.Database;
import View.MainScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lastnameClient;

    @FXML
    private TextField numberStreetClient;

    @FXML
    private TextField dateConnectedClient;

    @FXML
    private TextField numberContractClient;

    @FXML
    private Button creatNewClientButton;

    @FXML
    private TextField surnameClient;

    @FXML
    private TextField mobilePhoneClient;

    @FXML
    private TextField flatClient;

    @FXML
    private TextField nameClient;

    @FXML
    private TextField homePhoneClient;

    @FXML
    private TextField streetClient;

    @FXML
    private TextField dateContractClient;

    @FXML
    void creatNewClient(ActionEvent event) throws Exception {

        Client client;

        String tempName = nameClient.getText();
        String tempSurname = surnameClient.getText();
        String tempLastname = lastnameClient.getText();
        String tempStreet = streetClient.getText();
        String tempNumderStreet = numberStreetClient.getText();
        String tempFlat = flatClient.getText();
        String tempMobilePhone = mobilePhoneClient.getText();
        String tempHomePhone = homePhoneClient.getText();
        String tempNumberContract = numberContractClient.getText();
        String tempDateContract = dateContractClient.getText();
        String tempDateConnected = dateConnectedClient.getText();


        if (nameClient.getLength() == 0 || surnameClient.getLength() == 0 || lastnameClient.getLength() == 0 ||
                streetClient.getLength() == 0 || numberStreetClient.getLength() == 0 || mobilePhoneClient.getLength() == 0 || homePhoneClient.getLength() == 0 ||
                numberContractClient.getLength() == 0 || dateContractClient.getLength() == 0 || dateConnectedClient.getLength() == 0) {


        } else if (nameClient.getText().equals("0") != true && surnameClient.getText().equals("0") != true && lastnameClient.getText().equals("0") != true &&
                streetClient.getText().equals("0") != true && numberStreetClient.getText().equals("0") != true && mobilePhoneClient.getText().equals("0") != true && homePhoneClient.getText().equals("0") != true &&
                numberContractClient.getText().equals("0") != true && dateContractClient.getText().equals("0") != true && dateConnectedClient.getText().equals("0") != true) {
            client = new Client(tempName, tempSurname, tempLastname, tempStreet, tempNumderStreet, tempFlat,  tempMobilePhone, tempHomePhone, tempNumberContract, tempDateContract, tempDateConnected);
            client.addToDatabaseClient();
            Stage stage = (Stage) creatNewClientButton.getScene().getWindow();
            stage.close();
            MainScreen mainScreen = new MainScreen();
            mainScreen.start(new Stage());
        }


    }

    @FXML
    void initialize() {

        Database.getDatabase();
    }


}
