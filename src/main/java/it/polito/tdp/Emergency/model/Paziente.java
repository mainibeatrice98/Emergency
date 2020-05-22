package it.polito.tdp.Emergency.model;

import java.time.LocalTime;

/**
 * Rappresenta le informazioni su ciascun paziente nel sistema
 * @author Fulvio
 *
 */
public class Paziente implements Comparable<Paziente>{
	
	public enum CodiceColore {
		UNKNOWN, // non lo so ancora perché il paziente non ancora finito il triage
		WHITE,
		YELLOW,
		RED,
		BLACK,
	}
	
	private LocalTime oraArrivo ;
	private CodiceColore colore ;
	/**
	 * @param oraArrivo
	 * @param colore
	 */
	public Paziente(LocalTime oraArrivo, CodiceColore colore) {
		super();
		this.oraArrivo = oraArrivo;
		this.colore = colore;
	}
	public LocalTime getOraArrivo() {
		return oraArrivo;
	}

	public CodiceColore getColore() {
		return colore;
	}
	public void setColore(CodiceColore colore) {
		this.colore = colore;
	}
	@Override
	public int compareTo(Paziente other) {
		if(this.colore==other.colore) {
			return this.oraArrivo.compareTo(other.oraArrivo);
		} else if(this.colore==CodiceColore.RED) {
			return -1 ;
		} else if(other.colore==CodiceColore.RED) {
			return +1 ;
		} else if(this.colore==CodiceColore.YELLOW) {
			return -1 ;
		} else if(this.colore==CodiceColore.YELLOW) {
			return +1 ;
		}
		
		throw new RuntimeException("Comparator<Persona> failed") ;
	}
	
	
	
}
