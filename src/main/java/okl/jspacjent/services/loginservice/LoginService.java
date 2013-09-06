package okl.jspacjent.services.loginservice;

import okl.jspacjent.services.loginservice.exceptions.AccountNotFoundException;
import okl.jspacjent.services.loginservice.states.AwaitingFirstLoginAttempt;

/**
 * By Brett L. Schuchert</br>
 * 
 * This example login service demonstrates : </br> 
 * Test Driven Development, Using the Mockito library </br>
   Refactoring to design patterns, Template Method Pattern, State Pattern </br>
*/
public class LoginService extends LoginServiceContext {
	
   private final IAccountRepository accountRepository;
   
   public LoginService(IAccountRepository accountRepository ) {
	  super( new AwaitingFirstLoginAttempt() ); 
      this.accountRepository = accountRepository;
   }   
 
   /** logowanie na podstawie identyfikatora i has³a </br>
    *  zwracana jest instancja :IAccount w odpowiednim stanie 
    *   - loggedIn lub revoked */
   public IAccount login(String accountId, String password) {	   
	  IAccount account = accountRepository.find(accountId);
	  if (account == null) {
		 throw new AccountNotFoundException();
	  }
      getState().login(this, account, password);      
      return account;
   }
   
   /** logowanie na podstawie istniej¹cej instancji :IAccount i has³a </br>
    *  zwracana jest wejœciowa instancja :IAccount w odpowiednim stanie 
    *   - loggedIn lub revoked */
   public IAccount login(IAccount account, String password) {		  
	  if (account == null) {
		 throw new AccountNotFoundException();
	  }
      getState().login(this, account, password);       
      return account;
   }	
}
