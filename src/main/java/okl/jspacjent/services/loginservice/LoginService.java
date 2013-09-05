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
 
   public IAccount login(String accountId, String password) {	
	   
	  IAccount account = accountRepository.find(accountId);
	  if (account == null) {
		 throw new AccountNotFoundException();
	  }
      getState().login(this, account, password);  
      
      return account;
   }
	
}
