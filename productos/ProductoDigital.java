package productos;

public class ProductoDigital extends Producto {
    private final double tamanoMB;
    private final String formato;

    public ProductoDigital(int id, String nombre, double precio, double tamanoMB, String formato) {
        super(id, nombre, precio);
        this.tamanoMB = tamanoMB;
        this.formato = formato;
    }

    @Override
    public String getDescripcion() {
        return "Tamaño: " + tamanoMB + " MB, formato: " + formato;
    }
}