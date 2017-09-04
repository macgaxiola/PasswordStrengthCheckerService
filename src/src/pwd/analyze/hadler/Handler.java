package src.pwd.analyze.hadler;

import src.pwd.entity.Password;

/**
 * 
 * Abstract class for the handling of the Chain of Responsibility design pattern
 * @author Mac - mac.gaxiola@gmail.com
 *
 */
public abstract class Handler {

	protected Handler handler;
	
	public void nextHandler(Handler handler)
	{
		this.handler = handler;
	}
	
	public abstract void check(Password password);
}
