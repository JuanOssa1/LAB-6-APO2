package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

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
	private BorderPane border;
	private Canvas canvas;
	private GraphicsContext lienzo; 
	private Image img1;
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
			movementThread mt = new movementThread(this);
			mt.start();
			//addBalls();
	
		} catch(Exception e) {
			e.printStackTrace(); 
		}
	}
	
	
	public void draw(double x, double y) {
		lienzo.drawImage(img1, 0, 0);
		lienzo.setFill(Color.BLUE);
		lienzo.fillOval(x, y, 30, 30);
//		movementThread move = new movementThread(crazyGame.getBalls().get(i));
//		paintThread paint = new paintThread(this);
//		move.start();
//		paint.start();	
	}
	public void addBalls() {
		for (int i = 0; i < crazyGame.getBalls().size(); i++) {
			double positionX = crazyGame.getBalls().get(i).getPosX();
			double positionY = crazyGame.getBalls().get(i).getPosY();
			double width = crazyGame.getBalls().get(i).getRadio();
			lienzo.setFill(Color.AQUA);
			lienzo.fillOval(positionX, positionY, width, width); 
		}
		
	}

}
