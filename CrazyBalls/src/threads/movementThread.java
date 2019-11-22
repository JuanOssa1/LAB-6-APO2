package threads;

import controller.ControllerWindow;
import model.Pelota;

public class movementThread extends Thread{
	private Pelota pelota;
	private ControllerWindow controller;
	public movementThread( ControllerWindow controller, Pelota pelota) { 
		this.controller = controller;
		this.pelota = pelota;
		setDaemon(true);
	}
	@Override
	public void run(){
		int i = 0; 
			while(true) { 
//				if(pelota != null) {
						//pelota.movement(); 
					pelota.movement();
					//pelota.playCrazyFrog();
					//controller.draw(/*i, 50*/); 
					
//				}
				try {
//					sleep(pelota.getEspera());
					sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
				}
				i+=1;
			}
			
		
	}

}
