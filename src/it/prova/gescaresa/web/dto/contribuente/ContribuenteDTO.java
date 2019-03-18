package it.prova.gescaresa.web.dto.contribuente;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ContribuenteDTO {
	private long id;
	private String nome;
	private String cognome;
	private int eta;
	private String residenza;

	public ContribuenteDTO(long id, String nome, String cognome, int eta, String residenza) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
	}

	public ContribuenteDTO(String nome, String cognome, int eta, String residenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
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

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}
	
	public List<String> validate(){
		
		List<String> messagesList = new ArrayList<String>();
		
		if(StringUtils.isEmpty(nome) || StringUtils.isEmpty(cognome) || StringUtils.isEmpty(residenza) || StringUtils.isEmpty(eta + "")) {
			messagesList.add("E' necessario riempire tutti i campi!");
		}
		
		if(eta <= 0 || !StringUtils.isNumeric(eta + "")) { 
			messagesList.add("Eta' deve essere maggiore di 0!");
		}
		
		if(!nome.matches("[A-Za-z]+") || !cognome.matches("[A-Za-z]+")) {
			System.out.println(nome + " " + cognome);
			messagesList.add("I campi nome e cognome devono contenere solo caratteri alfabetici!");
		}
		return messagesList;
	}
}
