package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	
	private static Connection connection;
	
	// initialiser le charegement de la connection
	static {
		// charger le pilote JDBC avec la ethode forName
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// etablir la connexion
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_MVC_CAT", "root", "");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Connection getConnection() {
		return connection;
	}
	
	

}
