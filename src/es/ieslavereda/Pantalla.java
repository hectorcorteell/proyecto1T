package es.ieslavereda;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Pantalla {

    public static void mostrarMensaje(String texto){
        System.out.println(texto);
    }

    public static void mostrarError(String mensajeError){
        System.out.println(colorize("¡ERROR!", Attribute.TEXT_COLOR(255,0,0)));
        System.out.println(mensajeError);
    }
}
