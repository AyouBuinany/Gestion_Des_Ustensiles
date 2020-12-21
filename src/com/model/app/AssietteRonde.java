package com.model.app;

public class AssietteRonde extends Ustensile {
	private double rayon;
	public AssietteRonde() {
		// TODO Auto-generated constructor stub
	}
	public AssietteRonde(int id,String year, double rayon) {
		super(id,year);
		this.rayon= rayon;
	}
	//get set
	public double getRayon() {
		return rayon;
	}
	public void setRayon(double rayon) {
		this.rayon= rayon;
	}
@Override
public String toString() {
	return super.toString() + " le rayon est : " + this.rayon;
}
public double calculerSurface() {
    return (3.14 * getRayon() * getRayon());
}
}
