package it.prova.gescaresa.web.dto.cartellaesattoriale;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import it.prova.gescaresa.model.Contribuente;

public class CartellaEsattorialeDTO {
	private long id;
	private String denominazione;
	private String descrizione;
	private int importo;
	private Contribuente contribuente;

	public CartellaEsattorialeDTO(long id, String denominazione, String descrizione, int importo,
			Contribuente contribuente) {
		this.id = id;
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
		this.contribuente = contribuente;
	}

	public CartellaEsattorialeDTO(String denominazione, String descrizione, int importo, Contribuente contribuente) {
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
		this.contribuente = contribuente;
	}

	public CartellaEsattorialeDTO(String denominazione, String descrizione, int importo) {
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getImporto() {
		return importo;
	}

	public void setImporto(int importo) {
		this.importo = importo;
	}

	public Contribuente getContribuente() {
		return contribuente;
	}

	public void setContribuente(Contribuente contribuente) {
		this.contribuente = contribuente;
	}

	public List<String> validate() {

		List<String> messagesList = new ArrayList<String>();

		if (StringUtils.isEmpty(denominazione) || StringUtils.isEmpty(descrizione)
				|| StringUtils.isEmpty(importo + "")) {
			messagesList.add("E' necessario riempire tutti i campi!");
		}

		if (importo < 0 || !StringUtils.isNumeric(importo + "")) {
			messagesList.add("Importo deve essere un numero positivo!");
		}

		return messagesList;
	}
}
