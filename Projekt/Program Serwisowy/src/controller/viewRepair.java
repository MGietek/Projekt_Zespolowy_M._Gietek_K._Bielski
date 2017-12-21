package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cos_tam.DBConnection;
import cos_tam.Repair;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class viewRepair {
	
	private Repair repair;
	DBConnection connect = new DBConnection();
			
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nr_naprawy;

    @FXML
    private TextField klient;

    @FXML
    private TextField model;

    @FXML
    private TextField imei;

    @FXML
    private TextField usterka;

    @FXML
    private TextField komentarz;

    @FXML
    void initialize() {
    	File file = new File("tmp.txt");
		BufferedReader input;
		try {
			
			input = new BufferedReader(new FileReader(file));
			repair.setId(Integer.parseInt(input.readLine()));
			input.close();
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		repair = connect.getRepair(repair.getId());
    	
		nr_naprawy.setText(Integer.toString(repair.getId()));
		model.setText(repair.getMarka() + " " + repair.getModel());
		imei.setText(Integer.toString(repair.getImei()));
		komentarz.setText(repair.getKomentarz());
		usterka.setText(repair.getUsterka());
		
		}
    }
}
    
