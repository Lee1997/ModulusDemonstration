package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Modulus extends Application{
	
	public Stage window;
	public GridPane grid;
	public HBox top;
	
	public TextField numerator;
	public Label operator;
	public TextField denominator;
	public Button submit;
	
	public GraphicsContext g, g2;
	
	public int numValue, denValue;
	
	public final int WIDTH = 1280, HEIGHT = 720;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Title");
		
		grid = new GridPane();
		
		top = new HBox();
		top.setPadding(new Insets(20, 20, 20, 200));
		top.setSpacing(50);
		
		//Creating top bar
		numerator = new TextField("10");
		operator = new Label("%");
		denominator = new TextField("3");
		submit = new Button("Submit!");
		
		//Styling top bar
		numerator.setPrefSize(250, 100);
		numerator.setStyle("-fx-font-size: 60;");
		
		operator.setStyle("-fx-font-size: 80;");
		
		denominator.setPrefSize(250, 100);
		denominator.setStyle("-fx-font-size: 60;");
		
		submit.setPrefSize(150, 125);
		submit.setStyle("-fx-font-size: 20");
		submit.setOnAction(e -> inputsRecieved());
		
		
		top.getChildren().addAll(numerator, operator, denominator, submit);
		
		StackPane main = new StackPane();
		Canvas canvas = new Canvas(WIDTH-20, HEIGHT-20);
		Canvas canvas2 = new Canvas(WIDTH, HEIGHT);	
		g = canvas.getGraphicsContext2D();
		g2 = canvas2.getGraphicsContext2D();
		
		//BackGround
		Color background = Color.rgb(204, 221, 255);
		g2.setFill(background);
		g2.fillRect(0, 0, WIDTH, 550);
		
		main.getChildren().addAll(canvas2, canvas);
		
		VBox completed = new VBox();
		completed.getChildren().addAll(top, main);
		window.setScene(new Scene(completed, WIDTH, HEIGHT));
		window.show();
		
		
	}
	
	public void inputsRecieved(){
		
		String numString = numerator.getText();
		String denString = denominator.getText();
			
		try{
			numValue = Integer.parseInt(numString);
			denValue = Integer.parseInt(denString);
			drawQuestion(g);
		}catch(NumberFormatException e){
			AlertBox.display("Field completion error", "You must fill out all fields correctly with numbers");
		}
		
		
	}
	
	public void drawQuestion(GraphicsContext g){
		
		int scale = 20, counter = 0;
		g.moveTo(100, 100);
		//Drawing circles
		int width = numValue;
		int height  = denValue * 4;
		
		g.setFill(Color.RED);
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				if(counter < numValue){
					g.fillOval(j*70, i*70, 50, 50);
					counter++;
				}
			}
		}
		
		
	
	}
	
}
















