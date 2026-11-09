package productos;

import java.util.Map;

public abstract class ProductoFactory {
    public abstract Producto crearProducto(Map<String, String> datos);
}