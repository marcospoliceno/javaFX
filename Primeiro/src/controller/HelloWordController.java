package controller;

import java.util.Optional;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloWordController {

	@FXML
	private TextField tfNome;

	@FXML
	private Button btmSalvar;

	@FXML
	private Label lblmsgsalvar;

	@FXML
	private Button btmExcluir;
	@FXML
	private TableView<String> tblnomes;
	@FXML
	private TableColumn<String, String> colnome;

	// Sera Executado logo appÛs o arquivo xml ser carregado
	// È a primeira coisa a ser executado depois de carregaar o xml.
	@FXML
	private void initialize() {
		// Seta o responsavel por fabricar os valores da coluna.
		colnome.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue()));
	}

	@FXML
	void excluir(ActionEvent event) {
		Alert alerta = new Alert(AlertType.CONFIRMATION, "Deseja realmente excluir?", ButtonType.CANCEL, ButtonType.OK);

		// Desativando o comportamento padr√£o.
		Button okButton = (Button) alerta.getDialogPane().lookupButton(ButtonType.OK);
		okButton.setDefaultButton(false);

		// Optional do Java 8 executa o show e fica aguardando o click do
		// bot√£o.
		final Optional<ButtonType> result = alerta.showAndWait();
		// Se o click foi no ok executa os comandos abaixo
		if (result.get() == ButtonType.OK) {
			// Pega a linha selecionada
			int posicaoTabela = tblnomes.getSelectionModel().getSelectedIndex();
			// remove da tabela a linha selecionada
			tblnomes.getItems().remove(posicaoTabela);
			lblmsgsalvar.setText("Registro Excluido com sucesso");
			lblmsgsalvar.getStyleClass().remove("msgSalvar");
			lblmsgsalvar.getStyleClass().add("msgExcluir");
		}
	}

	@FXML
	void salvar(ActionEvent event) {
		// Pega o valor digitado no textField
		String nome = tfNome.getText();
		String msg = "Salvo com sucesso o cadastro: ";
		// Seta no label a mensagem de salvo com sucesso
		lblmsgsalvar.setText(msg + nome);
		lblmsgsalvar.getStyleClass().remove("msgExcluir");
		lblmsgsalvar.getStyleClass().add("msgSalvar");
		// Seta cada um dos nomes para dentro da tabela
		tblnomes.getItems().add(nome);
	}

}
