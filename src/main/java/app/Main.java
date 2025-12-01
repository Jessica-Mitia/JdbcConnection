package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT id, nom FROM etudiant LIMIT 1";
        try (Connection conn = JdbcConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Connexion réussie !");

            if (rs.next()) {
                System.out.println("Exemple de etudiant dans la base : ");
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Nom : " + rs.getString("nom"));
            } else {
                System.out.println("La table etudiant est vide ou n'existe pas.");
            }

        } catch (SQLException e) {
            System.out.println("Erreur de connexion ou de requête :");
            e.printStackTrace();
        }
    }
}
