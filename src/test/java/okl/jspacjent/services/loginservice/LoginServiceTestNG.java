package okl.jspacjent.services.loginservice;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import okl.jspacjent.dao.hibernate.HibernateDAOTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class LoginServiceTestNG extends HibernateDAOTest {  
    
  private IAccount           account;
  private IAccountRepository accountRepository;
  private LoginService       service;
  	
  @BeforeMethod
  public void init() {
     account = mock(IAccount.class);
     accountRepository = mock(IAccountRepository.class);      
     when(accountRepository.find(anyString())).thenReturn(account);
     service = new LoginService(accountRepository);
  } 
  
  @AfterMethod
  public void afterMethod() {
  }
  

  @BeforeClass
  public void beforeClass() {
	  beforeAssertions();
  }

  @AfterClass
  public void afterClass() {
  }  

  private void willPasswordMatch(boolean value) {
     when(account.passwordMatches(anyString())).thenReturn(value);
  }

  @Test
  public void itShouldSetAccountToLoggedInWhenPasswordMatches() {
     willPasswordMatch(true);
     service.login("brett", "password");
     verify(account, times(1)).setLoggedIn(true);
  }
  
  /*
  @Test
  public void itShouldSetAccountToRevokedAfterThreeFailedLoginAttempts() {
     willPasswordMatch(false); 
     for (int i = 0; i < 3; i++) {
        service.login("brett", "password");
     }
     verify(account, times(1)).setRevoked(true);
     verify(account, times(1)).setLoggedIn(false);
  } 
  
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
