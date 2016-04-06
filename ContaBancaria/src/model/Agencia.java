package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Agencia {

	private IntegerProperty numero;
	private StringProperty nome;

	public Agencia() {
		numero = new SimpleIntegerProperty();
		nome = new SimpleStringProperty();
	}

	public Integer getNumero() {
		return numero.get();
	}

	public void setNumero(Integer numero) {
		this.numero.set(numero);
	}

	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public StringProperty getNomeProperty() {
		return nome;
	}

	public IntegerProperty getNumeroProperty() {
		return numero;
	}

}
