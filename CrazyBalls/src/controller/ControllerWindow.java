package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.CrazyGame;
import model.Pelota;
import threads.movementThread;
import threads.paintThread;


public class ControllerWindow implements Initializable{
	//public static String FLATGAME = "games//juego.txt";
	private CrazyGame crazyGame;
	@FXML
	private Pane border;
	private Canvas canvas;
	private GraphicsContext lienzo; 
	private Image img1;
	//private Pelota pelotica;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		crazyGame = new CrazyGame();
		
	}
	public void newGame() {
		try {
			canvas = new Canvas(1366, 768);
			lienzo = canvas.getGraphicsContext2D();
			border.getChildren().add(canvas); 
			String path = "pictures//playa.jpg";
			img1 = new Image(new File(path).toURI().toString());
			lienzo.drawImage(img1, 0, 0);
			arrancarHilos();
			new AnimationTimer() {
				public void handle(long now) {
					draw();
				}
			}.start();
		} catch(Exception e) {
			e.printStackTrace(); 
		} 
	}
	public void arrancarHilos() {
		for (int i = 0; i < crazyGame.getBalls().size(); i++) {
			new movementThread(this, crazyGame.getBalls().get(i)).start();
		}
	}	
	public void draw() { 
		lienzo.drawImage(img1, 0, 0);
		for (int i = 0; i < crazyGame.getBalls().size(); i++) {
			double positionX = crazyGame.getBalls().get(i).getPosX();
			double positionY = crazyGame.getBalls().get(i).getPosY(); 
			double width = crazyGame.getBalls().get(i).getRadio();
			lienzo.setFill(Color.AQUA);
			lienzo.fillOval(positionX, positionY, width, width); 
		}
	}
	
	public void stopBalls() {
		
	}
	public void showHalfOfFame() {
		
	}
	public void alertWinner() {
		
	}

}
