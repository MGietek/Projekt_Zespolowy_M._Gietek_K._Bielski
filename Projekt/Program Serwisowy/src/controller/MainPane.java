package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainPane {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button dodajKlienta;

    @FXML
    private Button dodajNaprawe;

    @FXML
    private Button wyszukajNaprawe;

    @FXML
    private TextField szybkieWyszukiwanie;
    
    @FXML
    private Button szukaj;

    @FXML
    void initialize() {
        
    }
    
    @FXML
    void search(ActionEvent event) {
    	try {
			File file = new File("tmp.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(szybkieWyszukiwanie.getText());
			output.close();
		} catch (FileNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/ViewRepair.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
	        stage.setTitle("Naprawa nr " + szybkieWyszukiwanie.getText());
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
