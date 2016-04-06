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
import model.Pessoa;
import view.componente.Alerta;

public class PessoaController {

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnNovo;

	@FXML
	private Button btnExcluir;

	@FXML
	private TextField tfCpf;

	@FXML
	private TextField tfNome;

	@FXML
	private Label lblMsg;

	@FXML
	private TableView<Pessoa> tblPessoa;

	@FXML
	private TableColumn<Pessoa, String> tbcCpf;

	@FXML
	private TableColumn<Pessoa, String> tbcNome;

	private ObservableList<Pessoa> PessoaList = FXCollections.observableArrayList();

	private Optional<Pessoa> Pessoa = Optional.empty();

	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		tbcCpf.setCellValueFactory(cellData -> cellData.getValue().getNumeroProperty());
		tblPessoa.setItems(PessoaList);

		tblPessoa.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> populaText(newValue));
	}

	@FXML
	private void onActionCancelar(ActionEvent event) {
		limparCampos();
	}

	@FXML
	private void onActionNovo(ActionEvent event) {
		// cria um local vazio
		this.Pessoa = Optional.empty();
		limparCampos();
	}

	@FXML
	private void limparCampos() {
		tfNome.setText("");
		tfCpf.setText("");
	}

	@FXML
	private void onActionSalvar(ActionEvent event) {
		boolean editar = this.Pessoa.isPresent();
		Pessoa Pessoa = this.Pessoa.orElse(new Pessoa());
		Pessoa.setNome(tfNome.getText());
		Pessoa.setNumero(String.valueOf(tfCpf.getText()));
		if (!editar) {
			PessoaList.add(Pessoa);
			lblMsg.setText("Salvo com sucesso!");
		}
	}

	private void populaText(Pessoa Pessoa) {
		this.Pessoa = Optional.ofNullable(Pessoa);
		if (this.Pessoa.isPresent()) {
			tfNome.setText(Pessoa.getNome());
			tfCpf.setText(Pessoa.getNumero().toString());
		}
		limparCampos();
	}

	@FXML
	private void onActionExcluir(ActionEvent event) {
		if (new Alerta().excluir()) {

			int posicaoTabela = tblPessoa.getSelectionModel().getSelectedIndex();

			// remove da tabela a linha selecionada
			tblPessoa.getItems().remove(posicaoTabela);
			lblMsg.setText("Registro Excluido com sucesso");
			lblMsg.getStyleClass().remove("msgSalvar");
			lblMsg.getStyleClass().add("msgExcluir");

		}

	}

}
