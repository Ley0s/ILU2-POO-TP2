package histoire;

import controleur.ControlAcheterProduit;
import controleur.ControlAfficherMarche;
import controleur.ControlAfficherVillage;
import controleur.ControlEmmenager;
import controleur.ControlLibererEtal;
import controleur.ControlPrendreEtal;
import controleur.ControlTrouverEtalVendeur;
import controleur.ControlVerifierIdentite;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class TestControleursDesCas {
	public static void main(String[] args) {

		
		Village village = new Village("le village des irr�ductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 6);
		Gaulois obelix = new Gaulois("Obelix", 12);

		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(
				village);

		// Cas 2 : Emmenager

		System.out.println("Cas 2 : Emmenager");
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterDruide("Panoramix", 10, 5, 7);
		controlEmmenager.ajouterGaulois("Asterix", 6);
		controlEmmenager.ajouterGaulois("Obelix", 12);
		String[] nomsVillageois = controlAfficherVillage.donnerNomsVillageois();
		System.out.println("Les villageois sont : ");
		for (String villageois : nomsVillageois) {
			System.out.println("- " + villageois);
		}
		
//		Sortie Console :
//		Cas 2 : Emmenager
//		Le druide Panoramix : « Bonjour, je suis le druide Panoramix et ma potion peut aller d'une force 5 � 7.»
//		Les villageois sont : 
//		- Abraracourcix
//		- le druide Panoramix
//		- Asterix
//		- Obelix

		// Cas 3 : Verifier Identification
		System.out.println("///////////////////////////////");
		System.out.println("Cas 3 : Verifier Identification");
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(
				village);
		boolean vendeur = controlVerifierIdentite.verifierIdentite("Panoramix");
		System.out.println("Panoramix est un villageois ? " + vendeur);
		vendeur = controlVerifierIdentite.verifierIdentite("Intrus");
		System.out.println("Intrus est un villageois ? " + vendeur);

//		Sortie Console :
		
//		Cas 3 : Verifier Identification
//		Panoramix est un villageois ? true
//		Intrus est un villageois ? false


		// Cas 4 : Prendre etal

		System.out.println("///////////////////////////////");
		System.out.println("Cas 4 : Prendre etal");
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(
				controlVerifierIdentite, village);
		int numeroEtal = controlPrendreEtal.prendreEtal("Obelix", "fleur", 5);
		System.out.println("Obelix a pris l'�tal n°" + numeroEtal);

//		Sortie Console :
//		Cas 4 : Prendre etal
//		Obelix a pris l'�tal n°1


		// Cas 5 : trouverEtalVendeur

		System.out.println("///////////////////////////////");
		System.out.println("Cas 5 : trouver etal vendeur");
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(
				village);
		Etal etalObelix = controlTrouverEtalVendeur
				.trouverEtalVendeur("Obelix");
		Etal etalIntrus = controlTrouverEtalVendeur
				.trouverEtalVendeur("Intrus");
		System.out.print("L'�tal d'Ob�lix");
		if (etalObelix != null) {
			System.out.println(" est trouv�");
		} else {
			System.out.println(" n'est pas trouv�");
		}
		System.out.print("L'�tal de Intrus");
		if (etalIntrus != null) {
			System.out.println(" est trouv�");
		} else {
			System.out.println(" n'est pas trouv�");
		}
		

//		Sortie Console :
//		Cas 5 : trouver etal vendeur
//		L'�tal d'Ob�lix est trouv�
//		L'�tal de Intrus n'est pas trouv�


		// Cas 6 : libererEtal

		System.out.println("///////////////////////////////");
		System.out.println("Cas 6 : Liberer etal");
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(
				controlTrouverEtalVendeur, village);
		String[] ventesObelix = controlLibererEtal.libererEtal("Obelix");
		System.out.println("Les ventes d'Obelix : ");
		System.out.println("[0] : un boolean indiquant si l'�tal est occup� ");
		System.out.println("[1] : nom du vendeur");
		System.out.println("[2] : produit vendu");
		System.out.println(
				"[3] : quantit� de produit à vendre au d�but du march�");
		System.out.println("[4] : quantit� de produit vendu");
		for (String string : ventesObelix) {
			System.out.println(string);
		}
		String[] ventesIntrus = controlLibererEtal.libererEtal("Intrus");
		System.out.println("Les ventes d'Intrus : " + ventesIntrus);
		

//		Sortie Console :
//		Cas 6 : Liberer etal
//		Les ventes d'Obelix : 
//		[0] : un boolean indiquant si l'�tal est occup�
//		[1] : nom du vendeur
//		[2] : produit vendu
//		[3] : quantit� de produit � vendre au début du march�
//		[4] : quantit� de produit vendu
//		true
//		Obelix
//		fleur
//		5
//		0
//		Les ventes d'Intrus : null

		// Cas 7 : Afficher marche

		System.out.println("///////////////////////////////");
		System.out.println("Cas 7 : Afficher Marche");
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(
				village);
		controlPrendreEtal.prendreEtal("Obelix", "menhirs", 3);
		controlPrendreEtal.prendreEtal("Asterix", "poissons", 10);
		String[] marche = controlAfficherMarche.donnerInfosMarche();
		for (String etal : marche) {
			System.out.println(etal);
		}
		

//		Sortie Console :
//		Cas 7 : Afficher Marche
//		Obelix
//		3
//		menhirs
//		Asterix
//		10
//		poissons

		// Cas 8 : Acheter produit

		System.out.println("///////////////////////////////");
		System.out.println("Cas 8 : Acheter Produit");
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(
				controlVerifierIdentite, controlTrouverEtalVendeur, village);
		System.out.println("Obelix a 3 menhir sur son etal");
		int nbProduitAcheter = controlAcheterProduit.acheterProduit("Obelix",
				2);
		System.out.println("Achat de " + nbProduitAcheter + " menhirs sur 2");
		nbProduitAcheter = controlAcheterProduit.acheterProduit("Obelix", 3);
		System.out.println("Achat de " + nbProduitAcheter + " menhirs sur 3");
		

//		Sortie Console :
//		Cas 8 : Acheter Produit
//		Obelix a 3 menhir sur son etal
//		Achat de 2 menhirs sur 2
//		Achat de 1 menhirs sur 3

	}

}
