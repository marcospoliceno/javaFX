package view.componente;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class Alerta {

	public boolean excluir() {
		Alert alerta = new Alert(AlertType.CONFIRMATION, "Deseja realmente excluir?", ButtonType.CANCEL, ButtonType.OK);

		// Desativando o comportamento padrão.
		Button okButton = (Button) alerta.getDialogPane().lookupButton(ButtonType.OK);
		okButton.setDefaultButton(false);
		// Optional do Java 8 executa o show e fica aguardando o click do botão.
		final Optional<ButtonType> result = alerta.showAndWait();
		// Se o click foi no ok executa os comandos abaixo
		return (result.get() == ButtonType.OK);

	}
}
