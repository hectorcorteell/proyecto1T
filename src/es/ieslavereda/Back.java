package es.ieslavereda;

public class Back {
    public static void inicializarTablero(char[][] tablero) {
        for (int col = 0; col <= 10; col++)
            for (int fila = 0; fila <= 10; fila++)
                tablero[fila][col] = '~';

    }


}
