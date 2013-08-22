package okl.jspacjent.model;
// Generated 2006-12-05 16:02:43 by Hibernate Tools 3.2.0.beta8

import java.util.HashSet;
import java.util.Set;

/**
 * Kasach generated by hbm2java 
 */
public class Kasach implements java.io.Serializable {

  // Fields    

  private long   idKasa;
  private String opis;
  private String uwagi;
  private Set    pacjents = new HashSet(0);

  // Constructors

  /** default constructor */
  public Kasach() {
  }

  /** minimal constructor */
  public Kasach(long idKasa, String opis) {
    this.idKasa = idKasa;
    this.opis = opis;
  }
  
  /** constructor */  
  public Kasach(long idKasa, String opis, String uwagi ) {
    this.idKasa = idKasa;
    this.opis = opis;
    this.uwagi = uwagi;    
  }
  
  /** full constructor */  
  public Kasach(long idKasa, String opis, String uwagi, Set pacjents) {
    this.idKasa = idKasa;
    this.opis = opis;
    this.uwagi = uwagi;
    this.pacjents = pacjents;
  }
  
  // Property accessors
  public long getIdKasa() {
    return this.idKasa;
  }

  public void setIdKasa(long idKasa) {
    this.idKasa = idKasa;
  }
  public String getOpis() {
    return this.opis;
  }

  public void setOpis(String opis) {
    this.opis = opis;
  }
  public String getUwagi() {
    return this.uwagi;
  }

  public void setUwagi(String uwagi) {
    this.uwagi = uwagi;
  }
  
  public Set getPacjents() {
    return this.pacjents;
  }

  public void setPacjents(Set pacjents) {
    this.pacjents = pacjents;
  }

  /** */
  public boolean equals(Object other) {
    if ((this == other))
      return true;
    if ((other == null))
      return false;
    if ( !( other instanceof Kasach ) )
      return false;    
    Kasach castOther = (Kasach) other;
    // Wystarczy por�wna� identyfikator
    return  ( ( this.getIdKasa() == castOther.getIdKasa() ) );
  }
  
  /** */
  public String toString() {
    String tmp = "";
    //tmp += ( new Long( this.getIdKasa() ) ).toString()+ " , " ;
    tmp += this.getOpis()  + "  " ;
    tmp += this.getUwagi() + "  " ;
    return tmp;
  }

}
