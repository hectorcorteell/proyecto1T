package es.ieslavereda;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Pantalla {

    public static void mostrarMensaje(String texto) {
        System.out.println(texto);
    }

    public static void mostrarError(String mensajeError) {
        System.out.println(colorize("¡ERROR!", Attribute.TEXT_COLOR(255, 0, 0)));
        System.out.println(mensajeError);
    }

    public static void mostrarTablero(char[][] tableroJugador, char[][] tableroPC) {
        for (int fil = 0; fil < tableroJugador.length; fil++) {

            for (int col = 0; col < tableroJugador[fil].length; col++)
                System.out.print(tableroJugador[fil][col] + " ");

            System.out.print("       ");

            for (int col = 0; col < 10; col++)
                System.out.print(tableroPC[col][col] + " ");

            System.out.println();


        }


    }

    public static void mostrarMenu(){
        System.out.println(
                "====================== \n" +
                "   HUNDIR LA FLOTA \n" +
                " V1.0 Héctor Cortell\n" +
                "======================");
    }

}
