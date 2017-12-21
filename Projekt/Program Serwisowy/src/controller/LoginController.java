package controller;
 
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import cos_tam.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable  {

	private ArrayList<String> nazwa;
	DBConnection connect = new DBConnection();
	
    @FXML
    private Button loginButton;

    @FXML
    private Button closeButton;

    @FXML
    private TextField passwordField;

    @FXML
    private ComboBox<String> usersField;
    
    @FXML
    private Label komunikat;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	nazwa = connect.getSerwisanci();
    	ObservableList<String> onazwa = FXCollections.observableArrayList(nazwa);

    	usersField.setItems(onazwa);
   		
    }
    
    @FXML
    private void closeAction(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    private void loginAction(ActionEvent event) {

    	String wybrany = usersField.getValue();
    	String password = passwordField.getText();
    	if ( connect.sprawdzHaslo(wybrany, password) ) {

			try {
				Parent parent = FXMLLoader.load(getClass().getResource("/view/MainPane.fxml"));
			
				Scene scene = new Scene(parent);
				Stage stage = new Stage();
		        stage.setTitle("Zajebisty program serwisowy");
				stage.setScene(scene);
				stage.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
    		komunikat.setText("Has³o nieprawid³owe");
    	}
    	
    }

}
