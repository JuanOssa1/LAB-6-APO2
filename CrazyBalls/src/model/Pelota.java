package model;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Pelota {
	private MediaPlayer mediaPlayer;
	private int radio;
	private int posX;
	private int posY;
	private int espera;
	private String direction;
	private int rebotes;
	private boolean detenida;
	public static final double MOVE = 2.5;
	public static final String IZQUIERDA = "IZQUIERDA"; 
	public static final String DERECHA = "DERECHA";
	public static final String ARRIBA = "ARRIBA";
	public static final String ABAJO = "ABAJO";
	public Pelota(int radio, int posX, int posY, int espera, String direction, int rebotes, boolean detenida) {
		super();
		this.radio = radio;
		this.posX = posX;
		this.posY = posY;
		this.espera = espera;
		this.direction = direction;
		this.rebotes = rebotes;
		this.detenida = detenida;
	}
	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getEspera() {
		return espera;
	}

	public void setEspera(int espera) {
		this.espera = espera;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	} 

	public int getRebotes() { 
		return rebotes;
	}

	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}

	public boolean isDetenida() {
		return detenida;
	}

	public void setDetenida(boolean detenida) {
		this.detenida = detenida;
	}
	
	public void movement() {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		if(direction.equals(IZQUIERDA)) {
			posX += 12;
		} else if(direction.equals(DERECHA)) {
			posX += -12;
		} else if(direction.equals(ARRIBA)) {
			posY += 12;
		} else {
			posY += -12;
		}
		 if(posX <= (0 + radio) || 
                 posX >= (0+radio)){

         	posX = -posX;

         }
*/
		
		if(direction.equals(IZQUIERDA)) {
			posX += 12;
		} else if(direction.equals(DERECHA)) {
			posX += -12;
		} else if(direction.equals(ARRIBA)) {
			posY += 12;
		} else {
			posY += -12;
		}
		
	}
	public int bounce() {
		return 0;
	}
	public void playCrazyFrog() {
		
		String path = "pictures//amigosTraiganCerveza.mp3";
		Media media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setVolume(0.5);
		mediaPlayer.play();
		
		
	}
	
}