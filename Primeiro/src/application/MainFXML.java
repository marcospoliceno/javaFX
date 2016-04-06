package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainFXML extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			 * Encontra o arquivo fxml com o nome HelloWord E cria o root que é
			 * o nome AnchorPane adicionado no SceneBuilder.
			 */
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("HelloWord.fxml"));
			// Cria a cena com base no root(AnchorPane)
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// Seta para o palco a cena
			primaryStage.setScene(scene);
			// Faz mostrar a tela.
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

// verificar index nao esta escrevendo a mensagem de erro e de ok!