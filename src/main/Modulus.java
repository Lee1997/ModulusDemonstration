package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Modulus extends Application{
	
	public Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Title");
		
		StackPane root = new StackPane();	
		Canvas canvas = new Canvas(800, 600);	
		GraphicsContext g = canvas.getGraphicsContext2D();
		drawQuestion(g);
		
		TextField text = new TextField();
		text.setStyle("-fx-max-width: 300px;");
		StackPane.setAlignment(text, Pos.TOP_LEFT);
		text.setMargin(new Insets(10, 10, 10, 10));
		
		root.getChildren().addAll(canvas, text);
		
		
		window.setScene(new Scene(root));
		window.show();
		
		
	}
	
	public void drawQuestion(GraphicsContext g){
		Color background = Color.rgb(204, 221, 255);
		
		
		g.setFill(background);
		g.fillRect(0, 0, 800, 600);
		
		g.setFont(new Font("Verdana", 30));
		g.setFill(Color.BLACK);
		g.fillText("Test text", 50, 50);
		
		
		
	
	}
	
}
















