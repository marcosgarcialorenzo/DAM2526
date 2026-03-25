package Programacion.Curso2526.M.M1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class IngredienteDAO {
    private final Connection con;

    public IngredienteDAO(Connection con) {
        this.con = con;
    }

    public HashMap<Integer, Ingrediente> cargarCatalogo() throws SQLException {
        HashMap<Integer, Ingrediente> catalogo = new HashMap<>();
        String sql = "SELECT ID, NOMBRE, PRECIO FROM INGREDIENTES";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                double precio = rs.getDouble("PRECIO");
                catalogo.put(id, new Ingrediente(nombre, precio));
            }
        }
        return catalogo;
    }
}