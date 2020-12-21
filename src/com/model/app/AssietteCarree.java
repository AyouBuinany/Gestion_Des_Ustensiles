package com.model.app;

public class AssietteCarree extends Ustensile {
	
	private double cote;
	public AssietteCarree() {
		// TODO Auto-generated constructor stub
	}
	public AssietteCarree(int id ,String year, double cote) {
		super(id,year);
		this.cote=cote;
	}
//get set
	public double getCote() {
		return this.cote;
	}
	public void setCote(double cote) {
		this.cote= cote;
	}
	@Override
	public String toString() {
		return super.toString() + " le cote est : " + this.cote;
	}
	   public double calculerSurface() {
	        return (getCote() * getCote());
	    }
	   public double calculerValeur(int anneeActuelle) {
	        double valeur = 5 * super.calculerValeur(anneeActuelle);
	        return valeur;
	    }
}
