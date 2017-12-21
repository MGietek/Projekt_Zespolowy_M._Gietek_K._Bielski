package cos_tam;

public class Repair {

	private int id;
	private String marka;
	private String model;
	private int imei;
	private String usterka;
	private String komentarz;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getImei() {
		return imei;
	}
	public void setImei(int imei) {
		this.imei = imei;
	}
	public String getUsterka() {
		return usterka;
	}
	public void setUsterka(String usterka) {
		this.usterka = usterka;
	}
	public String getKomentarz() {
		return komentarz;
	}
	public void setKomentarz(String komentarz) {
		this.komentarz = komentarz;
	}
	
	public Repair(int id, String marka, String model, int imei, String usterka, String komentarz) {
		this.id = id;
		this.marka = marka;
		this.model = model;
		this.imei = imei;
		this.usterka = usterka;
		this.komentarz = komentarz;
	}
	
}
