package metier;

import java.util.List;

public class TestMetier {

	public static void main(String[] args) {
		
		MetierImpl metier = new MetierImpl();
		
		List<Produit> produits = metier.getProduitsParMC("H");
		
		for(Produit produit : produits) {
			System.out.println(produit.getNomProduit());
		}
		
		
		
		

	}

}
