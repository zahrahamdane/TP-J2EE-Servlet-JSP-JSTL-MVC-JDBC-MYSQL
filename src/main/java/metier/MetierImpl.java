package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetierCatalogue{

	@Override
	public List<Produit> getProduitsParMC(String MC) {

		List<Produit> produits = new ArrayList<Produit>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Produits WHERE nom_produit LIKE ?;");
			ps.setString(1, "%"+ MC +"%");
			ResultSet  rs = ps.executeQuery();
			
			while(rs.next()) {
				Produit produit = new Produit();
				produit.setIdProduit(rs.getLong("ID_PRODUIT"));
				produit.setNomProduit(rs.getString("NOM_PRODUIT"));
				produit.setPrix(rs.getDouble("PRIX"));
				
				produits.add(produit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public void addProduit(Produit produit) {
		// TODO Auto-generated method stub
		
	}

}
