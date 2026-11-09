package productos;

public class ProductoFisico extends Producto {
    private final double peso;
    private final String dimensiones;

    public ProductoFisico(int id, String nombre, double precio, double peso, String dimensiones) {
        super(id, nombre, precio);
        this.peso = peso;
        this.dimensiones = dimensiones;
    }

    @Override
    public String getDescripcion() {
        return "Peso: " + peso + " kg, dimensiones: " + dimensiones;
    }
}