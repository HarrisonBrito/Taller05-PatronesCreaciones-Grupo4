package productos;

import java.util.Map;

public class ProductoFisicoFactory extends ProductoFactory {
    @Override
    public Producto crearProducto(Map<String, String> datos) {
        return new ProductoFisico(Integer.parseInt(datos.get("id")), datos.get("nombre"),
                Double.parseDouble(datos.get("precio")), Double.parseDouble(datos.get("peso")),
                datos.get("dimensiones"));
    }
}