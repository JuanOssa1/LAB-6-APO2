package model;

public class Pelota {
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
	
	public int movement() {
		try {
			if(detenida != false) {
				if(direction.equals(IZQUIERDA)) {
					posX += MOVE;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return posX;
	}
	public int bounce() {
		return 0;
	}
	
	
}