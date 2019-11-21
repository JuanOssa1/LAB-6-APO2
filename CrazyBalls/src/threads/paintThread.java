package threads;

import controller.ControllerWindow;

public class paintThread extends Thread{
	private ControllerWindow control;
	public paintThread(ControllerWindow control) {
		this.control = control;
	}
	@Override
	public void run(){
		while(true) {
			control.addBalls();
		}
	}
}
