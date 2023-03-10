package edu.westga.cs3151.the8puzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Entry point for application.
 * 
 * @author CS3151
 * @version Spring 2023
 */
public class EightPuzzleApplication extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/PuzzleGui.fxml"));
			Pane pane = loader.load();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("The 8-Puzzle");
			primaryStage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Entry point
	 * 
	 * @pre none
	 * @post none
	 * @param args not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
