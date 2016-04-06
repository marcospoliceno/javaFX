package controller;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Agencia;
import view.componente.Alerta;

public class AgenciaController {

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnNovo;

	@FXML
	private TextField tfNumero;

	@FXML
	private Button btnExcluir;

	@FXML
	private TextField tfNome;

	@FXML
	private Label lblMsgSalvar;

	@FXML
	private TableView<Agencia> tblAgencia;

	@FXML
	private TableColumn<Agencia, Number> tbcNumero;

	@FXML
	private TableColumn<Agencia, String> tbcNome;

	private ObservableList<Agencia> agenciaList = FXCollections.observableArrayList();

	private Optional<Agencia> agencia = Optional.empty();

	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		tbcNumero.setCellValueFactory(c -> c.getValue().getNumeroProperty());
		tblAgencia.setItems(agenciaList);

		tblAgencia.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> populaText(newValue));
	}

	@FXML
	private void onActionCancelar(ActionEvent event) {
		limparCampos();
	}

	@FXML
	private void onActionNovo(ActionEvent event) {
		// cria um local vazio
		this.agencia = Optional.empty();
		limparCampos();
	}

	@FXML
	private void limparCampos() {
		tfNome.setText("");
		tfNumero.setText("");
	}

	@FXML
	private void onActionSalvar(ActionEvent event) {
		boolean editar = this.agencia.isPresent();
		Agencia agencia = this.agencia.orElse(new Agencia());
		agencia.setNome(tfNome.getText());
		agencia.setNumero(Integer.valueOf(tfNumero.getText()));
		if (!editar) {
			agenciaList.add(agencia);
			lblMsgSalvar.setText("Salvo com sucesso!");
		}
	}

	private void populaText(Agencia agencia) {
		this.agencia = Optional.ofNullable(agencia);
		if (this.agencia.isPresent()) {
			tfNome.setText(agencia.getNome());
			tfNumero.setText(agencia.getNumero().toString());
		}
		limparCampos();
	}

	@FXML
	private void onActionExcluir(ActionEvent event) {
		if (new Alerta().excluir()) {

			int posicaoTabela = tblAgencia.getSelectionModel().getSelectedIndex();

			// remove da tabela a linha selecionada
			tblAgencia.getItems().remove(posicaoTabela);
			lblMsgSalvar.setText("Registro Excluido com sucesso");
			lblMsgSalvar.getStyleClass().remove("msgSalvar");
			lblMsgSalvar.getStyleClass().add("msgExcluir");

		}

	}

}
