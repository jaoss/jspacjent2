package okl.jspacjent.services.loginservice.states;

import okl.jspacjent.services.loginservice.IAccount;
import okl.jspacjent.services.loginservice.LoginServiceContext;
import okl.jspacjent.services.loginservice.exceptions.AccountLoginLimitReachedException;
import okl.jspacjent.services.loginservice.exceptions.AccountRevokedException;

public abstract class LoginServiceState {
	
	protected int    failedAttempts;
	protected String previousAccountId = "";

	public void login(LoginServiceContext context, IAccount account, String password) {
		if (account.passwordMatches(password)) {
           if (account.isLoggedIn()) {
              throw new AccountLoginLimitReachedException();
           }   
           if (account.isRevoked()) {
              throw new AccountRevokedException();
           }   
           account.setLoggedIn(true);
           context.setState(new AwaitingFirstLoginAttempt());
	    } 
		else {
	       handleIncorrectPassword(context, account, password);
		}
	}

	public abstract void handleIncorrectPassword( 
			LoginServiceContext context, IAccount account, String password);

}
