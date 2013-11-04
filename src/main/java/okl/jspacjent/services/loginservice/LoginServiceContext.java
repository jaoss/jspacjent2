package okl.jspacjent.services.loginservice;

import okl.jspacjent.services.loginservice.states.LoginServiceState;

public abstract class LoginServiceContext {
	
   protected LoginServiceState state;
   
   public LoginServiceContext() {
	   super(); 	     
   }
	 
   public LoginServiceContext(LoginServiceState state) {
	   this(); 
     this.state = state;
   }
 
   public void setState(LoginServiceState state) {
     this.state = state;
   }
 
   public LoginServiceState getState() {
     return state;
   }

}
