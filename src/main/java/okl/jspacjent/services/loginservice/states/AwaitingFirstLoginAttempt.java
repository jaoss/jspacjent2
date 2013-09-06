package okl.jspacjent.services.loginservice.states;

import okl.jspacjent.services.loginservice.IAccount;
import okl.jspacjent.services.loginservice.LoginServiceContext;

public class AwaitingFirstLoginAttempt extends LoginServiceState {

	public AwaitingFirstLoginAttempt() {
	  super();	  
	}
	
	public AwaitingFirstLoginAttempt( String previousAccountId, int failedAttempts ) {
		super();	
	    this.previousAccountId = previousAccountId;
	    this.failedAttempts    = failedAttempts;		    
	}
	
	@Override
	public void handleIncorrectPassword(LoginServiceContext context, IAccount account, String password) {
	  context.setState(new AfterFirstFailedLoginAttempt(account.getId()));		
	}

}
