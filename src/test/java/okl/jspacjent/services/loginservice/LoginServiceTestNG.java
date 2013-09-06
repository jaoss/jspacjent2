package okl.jspacjent.services.loginservice;

import okl.jspacjent.dao.hibernate.HibernateDAOTest;
import okl.jspacjent.model.Lekarz;
import okl.jspacjent.services.loginservice.exceptions.AccountLoginLimitReachedException;
import okl.jspacjent.services.loginservice.exceptions.AccountNotFoundException;
import okl.jspacjent.services.loginservice.exceptions.AccountRevokedException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** 
 * LoginService tests on data from fake database </br> 
 *   HSQL, from text file :  ./jspacjent2/src/test/resources/fake-database-hsql/jspacjent 
 */
public class LoginServiceTestNG extends HibernateDAOTest {  
    
  static Logger log = Logger.getLogger( LoginServiceTestNG.class.getName() );	
	
  private IAccount           account;
  private IAccountRepository accountRepository;
  private LoginService       service;
  	
  @BeforeMethod
  public void init() {     
	 accountRepository = this.getDao();     
	 service           = new LoginService(accountRepository);   
  } 
  
  @AfterMethod
  public void afterMethod() {
  }
  

  @BeforeClass
  public void beforeClass() {	  
	  beforeAssertions();
	  log.setLevel(Level.ALL);	  	    
	  /*
	  List lekarze  = getDao().getAllLekarz();
	  Iterator iter = lekarze.iterator(); 
	  Lekarz lekarz; 
	  while ( iter.hasNext() ) {   
	      lekarz = (Lekarz)iter.next();
	      log.info(lekarz);
	 }
	 */	 
  }

  @AfterClass
  public void afterClass() {
	  afterAssertions();
  }  
  
  @Test
  public void itShouldFindAccountWhenAccountIdAndPasswordMatches() {  
	 account = service.login("moss", "password");
	 assertTrue(account.isLoggedIn());
	 assertFalse(account.isRevoked());
	 log.info( ((Lekarz)account).toStringFull() ); 
     account = service.login("zi¹bek", "password");
     assertTrue(account.isLoggedIn());
     assertFalse(account.isRevoked());
     log.info( ((Lekarz)account).toStringFull() );
     account = service.login("góra", "password");
     assertTrue(account.isLoggedIn());
     assertFalse(account.isRevoked());
     log.info( ((Lekarz)account).toStringFull() );
  }
  
  @Test(expectedExceptions = AccountNotFoundException.class)
  public void ItShouldThrowExceptionIfAccountNotFound() {     
     account = service.login("schuchert", "password");
  }
  
  @Test 
  public void itShouldNotSetAccountLoggedInIfPasswordDoesNotMatch() {     
     account = service.login("moss", "word");     
     assertFalse(account.isLoggedIn());     
  }
  
  
  @Test
  public void itShouldSetAccountToRevokedAfterThreeFailedLoginAttempts() {    
     for (int i = 0; i < 3; i++) {
        account = service.login("moss", "word");
     }
     assertTrue(account.isRevoked());
     assertFalse(account.isLoggedIn());     
  } 
  
  @Test(expectedExceptions = AccountRevokedException.class)
  public void ItShouldNotBePossibleToLogIntoRevokedAccount() {
	for (int i = 0; i < 3; i++) {
	   account = service.login("moss", "word");
	}
	assertTrue(account.isRevoked());
	account = service.login(account, "password");	
  }
  
  @Test(expectedExceptions = AccountLoginLimitReachedException.class)
  public void itShouldNotAllowConcurrentLogins() {     
     service.login("moss", "password");
     assertTrue(account.isLoggedIn());
     service.login(account, "password");
  }  
   
  @Test
  public void itShouldNotRevokeSecondAccountAfterTwoFailedAttemptsFirstAccount() {        
     account = service.login("góra", "word");
     assertFalse(account.isLoggedIn());
     account = service.login("góra", "word");
     assertFalse(account.isLoggedIn());
     account = service.login("moss",  "password");
     assertTrue(account.isLoggedIn());     
  }  
  
}
