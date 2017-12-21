package cos_tam;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private Repair naprawa;
	
	ArrayList<String> nazwa = new ArrayList<>();
	
	public DBConnection() {
		try{
			Class.forName(DRIVER);
			conn = DriverManager.getConnection("jdbc:mysql://192.168.1.3:3306/Serwis", "test", "password");
			st = conn.createStatement();
			
		}catch(Exception ex) {
			System.out.print("Error: " + ex);
		}
	}
	
	public ArrayList<String> getSerwisanci() {
		
		try {
			String query = "select * from Serwisanci";
			rs = st.executeQuery(query);
			while(rs.next()) {
				nazwa.add(rs.getString("Nazwa"));
			}
		}catch(Exception ex) {
			System.out.print("Error: " + ex);
		}
		return(nazwa);
	}
	
	public boolean sprawdzHaslo(String user, String password) {
		try{
			String query = "select * from Serwisanci WHERE Nazwa LIKE '" + user +"'";
			rs = st.executeQuery(query);
			rs.next();
			if( rs.getString("Haslo").equals(password) ) {
				return(true);
			}
		}catch(Exception ex) {
			System.out.print("Error: " + ex);
		}
		return(false);
	}
	
	public Repair getRepair(int id) {
		
		try{
			String query = "select * from naprawy WHERE id LIKE '" + id +"'";
			rs = st.executeQuery(query);
			rs.next();
			
			naprawa.setId(rs.getInt("id"));
			naprawa.setMarka(rs.getString("Marka"));
			naprawa.setModel(rs.getString("Model"));
			naprawa.setImei(rs.getInt("Imei"));
			naprawa.setKomentarz(rs.getString("Komentarz"));
			naprawa.setUsterka(rs.getString("Usterka"));
			
			System.out.print(naprawa.getModel());
			
		}catch(Exception ex) {
			System.out.print("Error: " + ex);
		}
		
		return(naprawa);
	}

}
