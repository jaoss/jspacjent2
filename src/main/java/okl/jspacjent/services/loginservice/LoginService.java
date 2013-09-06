package okl.jspacjent.services.loginservice;

import okl.jspacjent.services.loginservice.exceptions.AccountNotFoundException;
import okl.jspacjent.services.loginservice.states.AwaitingFirstLoginAttempt;

/**
 * By Brett L. Schuchert</br>
 * 
 * This example login service demonstrates : </br> 
 * Test Driven Development, Using the Mockito library </br>
   Refactoring to design patterns, Template Method Pattern, State Pattern </br>
   
   podstawowa funkcjonalnoœæ logowania do systemu - na razie nie wprowadzona do aplikacji
   aby unikn¹æ zbêdnej komplikacji przy obs³udze programu który jest tylko przyk³adem   
*/
public class LoginService extends LoginServiceContext {
	
   private final IAccountRepository accountRepository;
   
   public LoginService(IAccountRepository accountRepository ) {
	  super( new AwaitingFirstLoginAttempt() ); 
      this.accountRepository = accountRepository;
   }   
 
   /** logowanie na podstawie identyfikatora i has³a </br>
    *  zwracana jest instancja :IAccount z odpowiednimi wartoœciami loggedIn i revoked </br>
    *   
    *   logika metody delegowana jest do obiektu stanu, a stany mamy na razie trzy : </br>
    *   AwaitingFirstLoginAttempt, 
    *   AfterFirstFailedLoginAttempt,
    *   AfterSecondFailedLoginAttempt */
   public IAccount login(String accountId, String password) {	   
	  IAccount account = accountRepository.find(accountId);
	  if (account == null) {
		 throw new AccountNotFoundException();
	  }
      getState().login(this, account, password);      
      return account;
   }
   
   /** logowanie na podstawie istniej¹cej instancji :IAccount i has³a </br>
    *  zwracana jest wejœciowa instancja :IAccount z odpowiednimi wartoœciami loggedIn lub revoked </br>
    *   logika metody delegowana jest do obiektu stanu */
   public IAccount login(IAccount account, String password) {		  
	  if (account == null) {
		 throw new AccountNotFoundException();
	  }
      getState().login(this, account, password);       
      return account;
   }	
}
