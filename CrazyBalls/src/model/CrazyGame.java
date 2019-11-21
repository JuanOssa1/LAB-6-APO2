package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import threads.movementThread;

public class CrazyGame {
	public static String SEARCHROUTE ="Charger//clans.dat";
	public static String FLATGAME = "games//juego.txt";
	private ArrayList<Pelota> balls;
	private ArrayList<Gamer> gamers;
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
	
	public ArrayList<Gamer> getGamers() {
		return gamers;
	}
	public void setGamers(ArrayList<Gamer> gamers) {
		this.gamers = gamers;
	}
	public CrazyGame() {
		balls = new ArrayList<Pelota>();
		gamers = new ArrayList<Gamer>();
		loadGame();
		startProgramLoadGamers();
	}
	public String loadGame() {	
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
	
	
	
	
	
	
	
	public String winners() {
		return null;
	}
	public int generateScore() {
		return 0;
	}
	public void addGamer(String name) {
		Gamer gamer = new Gamer(nivel, generateScore(),name);
		gamers.add(gamer);
	}
	public int generalBounces() {
		return 0;
	}
	
	
	
	
	
	
	
	//SERIALIZACION Y ORDENAMIENTO
	
	
	public void closeAndSavefileCreator()  {
		try {
			File fl = new File(SEARCHROUTE);
			ObjectOutputStream duct = new ObjectOutputStream(new FileOutputStream(fl));
			duct.writeObject(gamers);
			duct.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void startProgramLoadGamers(){
		File file = new File(SEARCHROUTE);
		ArrayList<Gamer> p;
		try {
			
				FileInputStream	fi = new FileInputStream(file);
				ObjectInputStream co = new ObjectInputStream(fi);
				p = (ArrayList<Gamer>)co.readObject();
				setGamers(p); 
				co.close();
			}
			
		
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public void sortGamersScore() {	
		for(int i = 0; i < gamers.size()-1; i++) {
			Gamer small = gamers.get(i);
			int wich = i;
			for(int j = i + 1; j < gamers.size(); j++) {
				if(gamers.get(j).getScore() < small.getScore()) {
					small = gamers.get(j);
					wich = j;
				}
				Gamer tmp = gamers.get(i);
				gamers.set(i, small);
				gamers.set(wich, tmp);
			}
		}
	}
	
}