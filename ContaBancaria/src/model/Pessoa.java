package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {
	private StringProperty Cpf;
	private StringProperty Nome;

	public Pessoa() {
		Cpf = new SimpleStringProperty();
		Nome = new SimpleStringProperty();
	}

	public String getNumero() {
		return Cpf.get();
	}

	public void setNumero(String Cpf) {
		this.Cpf.set(Cpf);
	}

	public String getNome() {
		return Nome.get();
	}

	public void setNome(String Nome) {
		this.Nome.set(Nome);
	}

	public StringProperty getNomeProperty() {
		return Nome;
	}

	public StringProperty getNumeroProperty() {
		return Cpf;
	}

}
