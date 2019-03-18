package it.prova.gescaresa.web.dto.utente;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.gescaresa.model.Ruolo;

public class UtenteDTO {
	private long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Date dataRegistrazione;
	private Set<Ruolo> ruoli = new HashSet<>();

	public UtenteDTO(long id, String nome, String cognome, String username, String password, Date dataRegistrazione,
			Set<Ruolo> ruoli) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
		this.ruoli = ruoli;
	}

	public UtenteDTO(String nome, String cognome, String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public List<String> validate() {

		List<String> messagesList = new ArrayList<String>();

		if (StringUtils.isEmpty(nome) || StringUtils.isEmpty(cognome) || StringUtils.isEmpty(username)) {
			messagesList.add("E' necessario riempire tutti i campi!");
		}

		if (!nome.matches("[A-Za-z]+") || !cognome.matches("[A-Za-z]+")) {
			messagesList.add("I campi nome e cognome devono contenere solo caratteri alfabetici!");
		}
		return messagesList;
	}
}
