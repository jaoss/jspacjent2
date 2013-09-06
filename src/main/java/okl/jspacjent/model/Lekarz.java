package okl.jspacjent.model;
// Generated 2006-12-05 16:02:43 by Hibernate Tools 3.2.0.beta8

import java.util.HashSet;
import java.util.Set;

import okl.jspacjent.services.loginservice.IAccount;
import okl.jspacjent.utility.Md5HashCode;

/**
 * Lekarz 
 */
public class Lekarz implements java.io.Serializable, IAccount {

  // Fields  
  private static final long serialVersionUID = 1L;
  // in database	
  private long   idLekarz;
  private String imie;
  private String nazwisko = "?";
  private String uwagi;
  private String email;
  private String password;
  
  private Set    przyjecies = new HashSet(0);

  // to login service
  private boolean loggedIn;
  private boolean revoked;
  
  // Constructors

  /** default constructor */
  public Lekarz() {
	super();
  }

  /** minimal constructor */
  public Lekarz(long idLekarz, String nazwisko) {
	super();
    this.idLekarz = idLekarz;
    this.nazwisko = nazwisko;
  }
  
  /** constructor */
  public Lekarz(long idLekarz, String imie, String nazwisko,
                String uwagi, Set przyjecies) {
	super();  
    this.idLekarz   = idLekarz;
    this.imie       = imie;
    this.nazwisko   = nazwisko;
    this.uwagi      = uwagi;
    this.przyjecies = przyjecies;
  }
  
  /** full constructor */
   public Lekarz(long idLekarz, String imie, String nazwisko, String uwagi,
		         String email, String password, Set przyjecies, 
		         boolean loggedIn, boolean revoked) {
	super();
	this.idLekarz = idLekarz;
	this.imie = imie;
	this.nazwisko = nazwisko;
	this.uwagi = uwagi;
	this.email = email;
	this.password = password;
	this.przyjecies = przyjecies;
	this.loggedIn = loggedIn;
	this.revoked = revoked;
  }

  // Property accessors
  public long getIdLekarz() {
    return this.idLekarz;
  }

  public void setIdLekarz(long idLekarz) {
    this.idLekarz = idLekarz;
  }
  
  public String getImie() {
    return this.imie;
  }

  public void setImie(String imie) {
    this.imie = imie;
  }
  public String getNazwisko() {
    return this.nazwisko;
  }

  public void setNazwisko(String nazwisko) {
    this.nazwisko = nazwisko;
  }
  
  public String getUwagi() {
    return this.uwagi;
  }

  public void setUwagi(String uwagi) {
    this.uwagi = uwagi;
  }
  
  public String getPassword() {
		return password;
  }
	
  public void setPassword(String password) {
		this.password = password;
  }
	
  public String getEmail() {
		return email;
  } 
	
  public void setEmail(String email) {
		this.email = email;
  }
	
  public Set getPrzyjecies() {
    return this.przyjecies;
  }

  public void setPrzyjecies(Set przyjecies) {
    this.przyjecies = przyjecies;
  }
  
  /** */
  public boolean equals(Object other) {
    if ((this == other))
      return true;
    if ((other == null))
      return false;
    if ( !( other instanceof Lekarz ) )
      return false;        
    Lekarz castOther = (Lekarz) other;
    // Wystarczy porównaæ identyfikator
    return ( ( this.getIdLekarz() == castOther.getIdLekarz() ) );
  }
  
  /** */
  public String toString() {
    String tmp = "";
    //tmp += (new Long(this.getIdLekarz())).toString() + " , " ;
    tmp += this.getNazwisko() + " " ;    
    tmp += this.getImie()     + "   " ;    
    tmp += this.getUwagi()    + " log in: " ;
    tmp += this.isLoggedIn()  + " revoked: " ;
    tmp += this.isRevoked()   + "";
    return tmp; 
  }
  
    // to implement IAccount

	@Override
	public void setLoggedIn(boolean value) {		
		this.loggedIn = value;
	}
	
	@Override
	public boolean isLoggedIn() {		
		return this.loggedIn;
	}
	
	@Override
	public void setRevoked(boolean value) {		
		this.revoked = value;
	}
	
	@Override
	public boolean isRevoked() {		
		return this.revoked;
	}
	
	/**  tutaj nazwisko jest identyfikatorem dla IAccount </br>
		 ... znaj¹c oczywiœcie wszystkie ograniczenia dla tego za³o¿enia */	
	@Override	
	public String getId() {		
		return this.getNazwisko();
	}
	
	/** porównuje has³a po zakodowaniu MD5 - tak s¹ przechowywane w bazie -
	 *  jako namiastka, pierwszy stopieñ zabezpieczenia */
	@Override
	public boolean passwordMatches(String candidate) { 
		String md5password = Md5HashCode.getMd5HashCode(candidate);
		return this.getPassword().equals(md5password);		
	}	

}
