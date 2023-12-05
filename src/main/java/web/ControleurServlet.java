package web;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.IMetierCatalogue;
import metier.MetierImpl;
import metier.Produit;


@WebServlet("/produit")
public class ControleurServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IMetierCatalogue metier;
	
	@Override
	public void init() throws ServletException {
		metier = new MetierImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lire les données de la requete
		String mc = request.getParameter("motCle");
		// creer une instance du modele 
		ProduitModele mod = new ProduitModele();
		// stocker les données de la requete dans le modele 
		mod.setMotCle(mc);
		// recuperer le resultat : fait appel a la couche metier pour recuperer le resultat
		List<Produit> prods = metier.getProduitsParMC(mc);
		// stocker le resultat dans le modele
		mod.setProduits(prods);
		request.setAttribute("modele", mod);
		// maintenant c'est la vu qui doit afficher le resultat
		request.getRequestDispatcher("ProduitView.jsp").forward(request, response);
		
		
		
	}
	


}
