package com.model.app;

public class Cuillere extends Ustensile {
private double longeur;
	public Cuillere() {
		// TODO Auto-generated constructor stub
	}
	public Cuillere(int id,String year,double longeur) {
		super(id,year);
		this.longeur=longeur;
	}
	// get set 
	public double getLongeur() {
		return longeur;
	}
	public void setLongeur(double longeur) {
		this.longeur= longeur;
	}
	@Override
	public String toString() {
		return super.toString() + " la longeur est : " + this.longeur; 
	}
	@Override
	public double calculerSurface() {
		// TODO Auto-generated method stub
		return 0;
	}

}
