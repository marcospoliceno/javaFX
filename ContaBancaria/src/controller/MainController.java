package controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainController {

	@FXML
	private BorderPane panelPrincipal;

	@FXML
	private Menu menuCadastro;

	@FXML
	private MenuItem menuItemAgencia;

	@FXML
	private MenuItem menuItemPessoa;

	@FXML
	public void onActionMenuFechar(ActionEvent event) {
		panelPrincipal.setCenter(null);
	}

	@FXML
	public void onActionAgencia(ActionEvent e) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(Main.PATH_VIEW + "Agencia.fxml"));
		try {
			AnchorPane agenciaView = (AnchorPane) loader.load();
			panelPrincipal.setCenter(agenciaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	public void onActionPessoa(ActionEvent Event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(Main.PATH_VIEW + "Pessoa.fxml"));
		try {
			AnchorPane PessoaView = (AnchorPane) loader.load();
			panelPrincipal.setCenter(PessoaView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
