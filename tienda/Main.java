package tienda;

import datos.DatabaseManager;
import productos.*;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.Map;

public class Main {
    private static final Map<String, ProductoFactory> FABRICAS = Map.of(
            "fisico", new ProductoFisicoFactory(),
            "digital", new ProductoDigitalFactory());

    static void registrar(String tipo, Map<String, String> datos) throws Exception {
        Producto p = FABRICAS.get(tipo).crearProducto(datos);
        DatabaseManager.getInstance().executeUpdate(String.format(Locale.US,
                "INSERT INTO producto VALUES (%d, '%s', %.2f, '%s')",
                p.getId(), p.getNombre(), p.getPrecio(), p.getDescripcion()));
    }

    public static void main(String[] args) throws Exception {
        DatabaseManager db = DatabaseManager.getInstance();
        db.executeUpdate("CREATE TABLE producto (id INT PRIMARY KEY, nombre VARCHAR(50), "
                + "precio DOUBLE, descripcion VARCHAR(100))");

        registrar("fisico", Map.of("id", "1", "nombre", "Laptop", "precio", "850",
                "peso", "2.5", "dimensiones", "35x24x2 cm"));
        registrar("digital", Map.of("id", "2", "nombre", "Libro Java", "precio", "15",
                "tamanoMB", "12.5", "formato", "PDF"));

        ResultSet rs = db.executeQuery("SELECT * FROM producto");
        while (rs.next())
            System.out.println(rs.getString("nombre") + " | $" + rs.getDouble("precio")
                    + " | " + rs.getString("descripcion"));

        System.out.println(db == DatabaseManager.getInstance());
        db.close();
    }
}