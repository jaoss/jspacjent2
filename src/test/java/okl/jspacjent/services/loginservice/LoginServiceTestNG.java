package okl.jspacjent.services.loginservice;

import java.io.IOException;

import okl.jspacjent.dao.hibernate.HibernateDAOTest;
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
 *   HSQL, from text file  ./jspacjent2/src/test/resources/fake-database-hsql/jspacjent 
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
  public void beforeClass() throws IOException {	  
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
	 log.info(account); 
     account = service.login("zi¹bek", "password");
     assertTrue(account.isLoggedIn());
     assertFalse(account.isRevoked());
     log.info(account);
     account = service.login("góra", "password");
     assertTrue(account.isLoggedIn());
     assertFalse(account.isRevoked());
     log.info(account);
  }
  
  @Test(expectedExceptions = AccountNotFoundException.class)
  public void ItShouldThrowExceptionIfAccountNotFound() {     
     account = service.login("schuchert", "password");
  }
  
  @Test 
  public void itShouldNotSetAccountLoggedInIfPasswordDoesNotMatch() {     
     account = service.login("moss", "word");     
     assertFalse(account.isLoggedIn());
     log.info(account);
  }
  
  
  @Test
  public void itShouldSetAccountToRevokedAfterThreeFailedLoginAttempts() {    
     for (int i = 0; i < 3; i++) {
        account = service.login("moss", "word");
     }
     assertTrue(account.isRevoked());
     assertFalse(account.isLoggedIn());
     log.info(account);
  } 
  
  @Test(expectedExceptions = AccountRevokedException.class)
  public void ItShouldNotBePossibleToLogIntoRevokedAccount() {
	for (int i = 0; i < 3; i++) {
	   account = service.login("moss", "word");
	}
	assertTrue(account.isRevoked());
	account = service.login(account, "password");
	log.info(account);
  }
  /*
  @Test
  public void itShouldNotSetAccountLoggedInIfPasswordDoesNotMatch() {
     willPasswordMatch(false);
     service.login("brett", "password");
     verify(account, never()).setLoggedIn(true);
  }
  
  @Test
  public void itShouldNotRevokeSecondAccountAfterTwoFailedAttemptsFirstAccount() {
     willPasswordMatch(false);

     IAccount secondAccount = mock(IAccount.class);
     when(secondAccount.passwordMatches(anyString())).thenReturn(false);
     when(accountRepository.find("schuchert")).thenReturn(secondAccount);

     service.login("brett",     "password");
     service.login("brett",     "password");
     service.login("schuchert", "password");

     verify(secondAccount, never()).setRevoked(true);
  }
  
  @Test(expectedExceptions = AccountLoginLimitReachedException.class)
  public void itShouldNotAllowConcurrentLogins() {
     willPasswordMatch(true);
     when(account.isLoggedIn()).thenReturn(true);
     service.login("brett", "password");
  }
  
  @Test(expectedExceptions = AccountNotFoundException.class)
  public void ItShouldThrowExceptionIfAccountNotFound() {
     when(accountRepository.find("schuchert")).thenReturn(null);
     service.login("schuchert", "password");
  }
  
  @Test(expectedExceptions = AccountRevokedException.class)
  public void ItShouldNotBePossibleToLogIntoRevokedAccount() {
     willPasswordMatch(true);
     when(account.isRevoked()).thenReturn(true);
     service.login("brett", "password");
  }
  */
}
