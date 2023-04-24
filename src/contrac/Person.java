package contrac;

public class Person {

	
	private int id;
	private String ad;
	private String soyad;
	private String tel;
	private String email;
	private String adres;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Person(String ad, String soyad, String tel, String email, String adres) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.tel = tel;
		this.email = email;
		this.adres = adres;
	}



	public Person(int id, String ad, String soyad, String tel, String email, String adres) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.tel = tel;
		this.email = email;
		this.adres = adres;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", tel=" + tel + ", email=" + email + ", adres="
				+ adres + "]";
	}
	
	
}
