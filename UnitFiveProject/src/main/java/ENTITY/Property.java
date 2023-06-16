package ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Property_name", nullable = false, unique = true, length = 50)
	private String propertyName;

	@Column(name = "ESTD_year", nullable = false)
	int estd;

	@Column(name = "Rent_price", nullable = false)
	int rentPrice;

	@Column(name = "propert_location", nullable = false, length = 10)
	private String propertlocation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "property_Id")
	private Renter re;

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(String propertyName, int estd, int rentPrice, String propertlocation, Renter re) {
		super();
		this.propertyName = propertyName;
		this.estd = estd;
		this.rentPrice = rentPrice;
		this.propertlocation = propertlocation;
		this.re = re;
	}

	public int getId() {
		return id;
	}

	public void setEstd(int estd) {
		this.estd = estd;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public int getEstd() {
		return estd;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getPropertlocation() {
		return propertlocation;
	}

	public void setPropertlocation(String propertlocation) {
		this.propertlocation = propertlocation;
	}

	public Renter getRe() {
		return re;
	}

	public void setRe(Renter re) {
		this.re = re;
	}
	
	
	

}
