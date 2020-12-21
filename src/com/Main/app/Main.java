package com.Main.app;

import java.util.Scanner;

import com.controllers.app.ControllerAssietteCarree;
import com.controllers.app.ControllerAssietteRonde;
import com.controllers.app.ControllerCuillere;
import com.model.app.AssietteCarree;
import com.model.app.AssietteRonde;
import com.model.app.Cuillere;
import com.model.app.Ustensile;

public class Main {

	private static final int CURRENT_YEAR = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ControllerAssietteCarree assCarre= new ControllerAssietteCarree();
			ControllerAssietteRonde assRonde = new   ControllerAssietteRonde();
			ControllerCuillere cl= new ControllerCuillere();
			Ustensile[] us = new Ustensile[10];
		        us[0] = new AssietteRonde(1,"1999", 8.4);
		        us[1] = new Cuillere(2,"1989", 7.3);
		        us[2] = new AssietteCarree(3,"1935", 5.6);
		        us[3] = new AssietteCarree(4,"2000", 7.5);
		        us[4] = new Cuillere(5,"1917", 8.8);
		        us[5] = new AssietteRonde(6,"1837", 5.4);
		        us[6] = new AssietteRonde(7,"2007", 3.5);
			Scanner input = new Scanner(System.in);
			String annee ="";
			double cote=0,rayon=0,longeur=0;int id=0,cuil=0,ronde=0,carre=0;
			
			System.out.println("Welcom");
			int gestionDB=0,gUstensile=0,choix=0;
			
			System.out.println(" Gestion base de donnee  : =>1 \n  Ustensile =>2 \n "); 
			choix =input.nextInt();
			 switch(choix) {
			 case 1 :
				
				 System.out.println(" Ustensite : \n  AssietteCaree =>1 \n AssietteRnde =>2 \n Cuillere =>3");
				 gestionDB =input.nextInt();
				 
				 break;
				 
			 case 2 :
				 System.out.println("gestion Ustensile : \n afficher nombre Cuilleres : =>1 \n afficherValeurTotale : => 2 \n afficherSurfaceAssiettes : => 3 ");
				 gUstensile =input.nextInt();
				 
				 switch(gUstensile) {
				 case 1:
					 afficherNbrCuilleres(us);
					 break;
				 case 2 :
					 afficherValeurTotale(us);
					 break;
				 case 3 :
					 afficherSurfaceAssiettes(us);
					 break;	

				 }
			 }
			 //Add tables
			
			 while(true) {
				 
			switch(gestionDB) {
			
					case  1:
						assCarre.AfficherAssietteCarree();
						System.out.println(" Ajouter  : =>1 \n Modifier =>2 \n ");
						carre=input.nextInt();
							break;
						case 2 :
							assRonde.AfficherAssietteRounde();
							System.out.println(" Ajouter  : =>1 \n Modifier =>2 \n ");
							ronde=input.nextInt();
							break;
							case 3: 
								cl.AfficherCuillere();
								System.out.println(" Ajouter  : =>1 \n Modifier =>2 \n ");
								cuil= input.nextInt();
								break;
			}
			
							//table carre
							switch(carre) {
							case 1:
								System.out.println("Entrer annee ");
								annee= input.next();
								System.out.println("Entrer cote");
								cote= input.nextDouble();
								if(assCarre.AddUpdateAssietteCarree(id, annee, cote, "Add")>0) {
									System.out.println(" add");
								}else {
									System.out.println("dont add");
								}
								break;
							case 2:
								if(assCarre.NumberRowAssietteCarree()>0) {
								assCarre.AfficherAssietteCarree();
								System.out.println("Entrer id : ");
								id= input.nextInt();
								System.out.println("Entrer annee ");
								annee= input.next();
								if(assCarre.AddUpdateAssietteCarree(id, annee, cote, "update")>0) {
									System.out.println(" update");
								}else {
									System.out.println("dont update");
								}
								}else {
									System.out.println("tableau vide ");
								}
								break;
							}
			
							//table ronde 
							switch(ronde) {
							case 1:
								assRonde= new ControllerAssietteRonde();
								System.out.println("Entrer annee ");
								annee= input.next();
								System.out.println("Entrer rayon");
								rayon= input.nextDouble();
								if(assRonde.AddUpdateAssietteRounde(id, annee, rayon, "Add")>0) {
									
									System.out.println(" add");
									assRonde.AfficherAssietteRounde();
								}else {
									System.out.println("dont add");
								}
								
								break;
							case 2:
								if(assRonde.NumberRowAssietteRounde()>0) {
								assRonde.AfficherAssietteRounde();
								System.out.println("Entrer id : ");
								id= input.nextInt();
								System.out.println("Entrer annee ");
								annee= input.next();
								if(assRonde.AddUpdateAssietteRounde(id, annee, rayon, "update")>0) {
									System.out.println(" update");
								}else {
									System.out.println("dont update");
								}
								}else {
									System.out.println("Table vide");
								}
								break;
							}
			
							// table cuillere
							switch(cuil) {
							case 1:
							System.out.println("Entrer annee ");
							annee= input.next();
							System.out.println("Entrer longeur ");
							longeur= input.nextDouble();
							if(cl.AddUpdateCuillere(id, annee, longeur, "Add")>0) {
								
								System.out.println(" add");
								cl.AfficherCuillere();
							}else {
								System.out.println("dont add");
							}
							break;
							case 2 :
								if(cl.NumberRowCuillere()>0) {
									cl.AfficherCuillere();
									System.out.println("Entrer id : ");
									id= input.nextInt();
									System.out.println("Entrer annee ");
									annee= input.next();
									System.out.println("Entrer cote");
									cote= input.nextDouble();
									if(cl.AddUpdateCuillere(id, annee, cote, "update")>0) {
										System.out.println(" update");
									}else {
										System.out.println("dont update");
									}
									}else {
										System.out.println("tableau vide ");
									}
								break;
							
							}
			 }
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
		
	//Nomber cuillere
	static  void afficherNbrCuilleres(Ustensile[] us) {
        int nbCuilleres = 0;
        for (int i = 0; i < us.length; i++) {
            if (us[i] instanceof Cuillere) {
                nbCuilleres++;
            }
        }
       System.out.println("Il y a " + nbCuilleres + " cuillères.");
    }
	//some de ustensile
	 static void afficherValeurTotale(Ustensile[] us) {
	        double somme = 0;
	        for (int i = 0; i < us.length; i++) {
	            somme = somme + us[i].calculerValeur(CURRENT_YEAR);
	        }
	       System.out.println("Valeur totale de la collection : " + somme);
	    }
	 //some Assiete
	 static void afficherSurfaceAssiettes(Ustensile[] us) {
	        double somme = 0;
	        for (int i = 0; i < us.length; i++) {
	            if (us[i] instanceof AssietteCarree || us[i] instanceof AssietteRonde ) {
	                somme = somme + us[i].calculerSurface();
	            }
	        }
	       System.out.println("Surface totale des assiettes : " + somme);
	    }

}
