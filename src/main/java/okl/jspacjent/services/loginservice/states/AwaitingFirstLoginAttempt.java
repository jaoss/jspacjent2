package okl.jspacjent.services.loginservice.states;

import okl.jspacjent.services.loginservice.IAccount;
import okl.jspacjent.services.loginservice.LoginServiceContext;

public class AwaitingFirstLoginAttempt extends LoginServiceState {

	public AwaitingFirstLoginAttempt() {
	  super();	  
	}
	
	@Override
	public void handleIncorrectPassword(LoginServiceContext context, IAccount account, String password) {
	  context.setState(new AfterFirstFailedLoginAttempt(account.getId()));		
	}

}
