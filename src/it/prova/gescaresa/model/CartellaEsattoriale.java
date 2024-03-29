package it.prova.gescaresa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartellaEsattoriale implements Serializable {

	private static final long serialVersionUID = 6848359105769176105L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String denominazione;
	private String descrizione;
	private int importo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contribuente_id", nullable = false)
	private Contribuente contribuente;

	public CartellaEsattoriale() {
	}

	public CartellaEsattoriale(String denominazione, String descrizione, int importo) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
	}

	public CartellaEsattoriale(String denominazione, String descrizione) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
	}
	
	public CartellaEsattoriale(String denominazione, String descrizione, int importo, Contribuente contribuente) {
		super();
		this.denominazione = denominazione;
		this.descrizione = descrizione;
		this.importo = importo;
		this.contribuente = contribuente;
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

}
