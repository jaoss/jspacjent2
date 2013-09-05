package okl.jspacjent.services.loginservice.states;

import okl.jspacjent.services.loginservice.IAccount;
import okl.jspacjent.services.loginservice.LoginServiceContext;

public class AfterFirstFailedLoginAttempt extends LoginServiceState {	
	
	public AfterFirstFailedLoginAttempt(String previousAccountId) {
	   this.previousAccountId = previousAccountId;
	   this.failedAttempts    = 1;
	}

	@Override
	public void handleIncorrectPassword(LoginServiceContext context, IAccount account,	String password) {
		if (previousAccountId.equals(account.getId())) {
            context.setState(new AfterSecondFailedLoginAttempt(account.getId()));
		}   
        else {
            previousAccountId = account.getId();
        }    
	}

}
