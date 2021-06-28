package dao;

import java.sql.Connection;
import java.sql.DriverManager;

// quand la classe est chargé au mémoire le premier bloc exécuté est le bloc static
//Donc s'il y en a un object qui devais être crée une seule fois la meilleu moyen est de le créer dans le bloc static
// etape : charger le pilote jdbc
public class SingletonConnection {
    private static Connection connection;
    static {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/DB_CATAL", "root", "");
                } catch (Exception e) {
                    e.printStackTrace();
                }

           }

    public static Connection getConnection() {
        return connection;
    }
}
