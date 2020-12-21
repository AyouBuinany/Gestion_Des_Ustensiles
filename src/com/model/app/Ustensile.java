package com.model.app;

public abstract  class Ustensile {
private String year;
private int id;
	public Ustensile() {
		// TODO Auto-generated constructor stub
	}
	public Ustensile(int id ,String year) {
		this.year= year;
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id= id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year=year;
	}
	@Override
	public String toString() {
		return " id est : " + this.id + " year est : " + this.year;
	}
	public abstract double calculerSurface();
	public double calculerValeur(int anneeActuelle) {
		int year= Integer.parseInt(getYear());
        int age = (anneeActuelle - year);
        double valeur = 0;
        if (age > 50) {
            valeur = age - 50;
        }
        return valeur;
    }
}
