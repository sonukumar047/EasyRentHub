package ENTITY;

import java.time.LocalDate;
import java.util.Set;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Renter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50)	//this is for not null
	private String name;
	
	@Column(unique = true, length = 50, nullable = false)	//this is for making it unique
	private String username;
	
	@Column(nullable = false, length = 50)
	private String password;
	
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(name = "is_deleted", nullable = false)
	private int isDeleted;
	
	@OneToMany(mappedBy = "re",cascade = CascadeType.ALL)
	private Set<Property> propertySet;

	public Renter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Renter(String name, String username, String password, LocalDate dateOfBirth, Set<Property> propertySet) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.propertySet = propertySet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	 public void setPassword(String password) {
	        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	    }

	    public boolean verifyPassword(String password) {
	        return BCrypt.checkpw(password, this.password);
	    }

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Set<Property> getPropertySet() {
		return propertySet;
	}

	public void setPropertySet(Set<Property> propertySet) {
		this.propertySet = propertySet;
	}

	
	
}
