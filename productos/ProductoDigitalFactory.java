package productos;

import java.util.Map;

public class ProductoDigitalFactory extends ProductoFactory {
    @Override
    public Producto crearProducto(Map<String, String> datos) {
        return new ProductoDigital(Integer.parseInt(datos.get("id")), datos.get("nombre"),
                Double.parseDouble(datos.get("precio")), Double.parseDouble(datos.get("tamanoMB")),
                datos.get("formato"));
    }
}