package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import threads.movementThread;

public class CrazyGame {
	public static String FLATGAME = "games//juego.txt";
	private ArrayList<Pelota> balls;
	private int nivel;
	public ArrayList<Pelota> getBalls() {
		return balls;
	}
	public void setBalls(ArrayList<Pelota> balls) {
		this.balls = balls;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public CrazyGame() {
		balls = new ArrayList<Pelota>();
		loadClub();
	}
	public String loadClub() {	
		String msg = "DATOS CARGADOS CON EXITO!!!";
		String radio = "";
		String posx = "";
		String posy = "";
		String espera = "";
		String direccion = "";
		String rebotes = "";
		String detenida = "";
		try {
			File	file = new File(FLATGAME);
			FileReader	frReader = new FileReader(file);
			BufferedReader	bufferRead = new BufferedReader(frReader);
			String saveString;
			int contador=0;
			while( (saveString = bufferRead.readLine()) != null){
					if(saveString.charAt(0) != '#') {
						if(contador==0){
							this.nivel=Integer.parseInt(saveString);
							contador++;
						}
						else{
							String[] parts = saveString.split(","); 
							 radio = parts[0]; 
							 posx = parts[1];
							 posy = parts[2];
							 espera = parts[3];
							 direccion = parts[4];
							 rebotes = parts[5];
							 detenida = parts[6]; 
							 createBall( radio,  posx,  posy,  espera,  direccion,  rebotes,  detenida );
						}
						
					} 		
			}	
			bufferRead.close();
			frReader.close();	
		}
		catch(Exception e){
			e.printStackTrace();
			}
		return msg;
		
	}
	public void createBall(String radio, String posx, String posy, String espera, String direccion, String rebotes, String detenida ) {
		//T abreviation of "Transformed"
		int radioT = Integer.parseInt(radio); 
		int posxT = Integer.parseInt(posx);
		int posyT = Integer.parseInt(posy);
		int esperaT = Integer.parseInt(espera);
		int rebotesT = Integer.parseInt(rebotes);
		boolean detenidaT = Boolean.parseBoolean(detenida);
		Pelota pelota = new Pelota(radioT,posxT,posyT,esperaT,direccion,rebotesT, detenidaT);
		balls.add(pelota);
	}
	
}