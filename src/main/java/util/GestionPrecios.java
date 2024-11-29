package util;

import com.videoclub.videoclub.enums.TipoPelicula;

public class GestionPrecios {

    private static final double PRECIO_UNITARIO = 3.0;

    public static double calcularPrecio(TipoPelicula tipoPelicula, int diasAlquiler) {
        switch (tipoPelicula) {

            case NUEVO_LANZAMIENTO:
                return diasAlquiler * PRECIO_UNITARIO;

            case NORMAL:
                return diasAlquiler <= 3 ? diasAlquiler * PRECIO_UNITARIO : (3 * PRECIO_UNITARIO) + ((diasAlquiler - 3) * PRECIO_UNITARIO * 1.5);

            case VIEJA:
                return diasAlquiler <= 5 ? diasAlquiler * PRECIO_UNITARIO : (5 * PRECIO_UNITARIO) + ((diasAlquiler - 5) * PRECIO_UNITARIO * 1.2);

            default:
                throw new IllegalArgumentException("Tipo de película no soportado");
        }
    }
}
