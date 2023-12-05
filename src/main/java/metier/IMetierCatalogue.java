package metier;

import java.util.List;

public interface IMetierCatalogue {
	
	public List<Produit> getProduitsParMC(String MC);
	public void addProduit(Produit produit);

}
