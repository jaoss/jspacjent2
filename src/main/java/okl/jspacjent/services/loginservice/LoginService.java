package okl.jspacjent.services.loginservice;

import okl.jspacjent.services.loginservice.exceptions.AccountNotFoundException;
import okl.jspacjent.services.loginservice.states.AwaitingFirstLoginAttempt;

/**
 * By Brett L. Schuchert</br>
 * 
 * This example login service demonstrates : </br> 
 * Test Driven Development, Using the Mockito library </br>
   Refactoring to design patterns, Template Method Pattern, State Pattern </br>
   
   podstawowa funkcjonalno�� logowania do systemu - na razie nie wprowadzona do aplikacji
   aby unikn�� zb�dnej komplikacji przy obs�udze programu kt�ry jest tylko przyk�adem   
*/
public class LoginService extends LoginServiceContext {
	
   private final IAccountRepository accountRepository;
   
   public LoginService(IAccountRepository accountRepository ) {
	  super( new AwaitingFirstLoginAttempt() ); 
      this.accountRepository = accountRepository;
   }   
 
   /** logowanie na podstawie identyfikatora i has�a </br>
    *  zwracana jest instancja :IAccount z odpowiednimi warto�ciami loggedIn i revoked </br>
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
   
   /** logowanie na podstawie istniej�cej instancji :IAccount i has�a </br>
    *  zwracana jest wej�ciowa instancja :IAccount z odpowiednimi warto�ciami loggedIn lub revoked </br>
    *   logika metody delegowana jest do obiektu stanu */
   public IAccount login(IAccount account, String password) {		  
	  if (account == null) {
		 throw new AccountNotFoundException();
	  }
      getState().login(this, account, password);       
      return account;
   }	
}
