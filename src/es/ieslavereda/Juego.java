package es.ieslavereda;

public class Juego {
    public static void main(String[] args) {

        //System.out.println(Entrada.obtenerFila());
        //System.out.println(Entrada.obtenerColumna());

        char[][] tableroJugador = new char[10][10];
        char[][] tableroPC = new char[10][10];

        inicializarTablero(tableroJugador);
        inicializarTablero(tableroPC);

        Pantalla.mostrarTablero(tableroJugador,tableroPC);
    }

    // Métodos a implementar
// Metodo que implementa el disparo del jugador

    //public static boolean disparoJugador (char[][] tableroDisparosJugador, char[][] tableroPC){}


// Metodo que implementa el disparo del PC

    //public static boolean disparoPC(char[][] tableroDisparosPC, char[][] tableroJugador){}


/* Este metodo inicializa cada tablero de la siguiente manera:

A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~

 0 1 2 3 4 5 6 7 8 9	*/

    public static void inicializarTablero(char[][] tablero){

        for (int col = 0; col < 10; col++)
            for (int fila = 0; fila < 10; fila++)
                tablero[fila][col] = '~';
    }



//Este metodo visualiza el tablero por pantalla

    public static void visualizarTablero(char[][] tablero,char[][] tablero2) {
        for (int col = 0; col < 10; col++) {
            for (int fila = 0; fila < 10; fila++)
                System.out.print(tablero[fila][col]);
        }
    }

//Este metodo borra la terminal

    public static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


// Este metodo suma todos los valores de un vector

    //public static int sumaCeldas(int[] unVector){}


//Este metodo coloca los barcos pasados como vector dentro del tablero del Jugador

    public static void colocarBarcosJugador(char[][] tablero, int[] barcos){}


//Este metodo coloca los barcos pasados como vector dentro del tablero del PC

    public static void colocarBarcosPC(char[][] tablero,int[] barcos){}


//Este metodo comprueba si hay algun barco en la zona del barco a colocar

    //public static boolean hayColision(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion){}


//Este metodo comprueba si el barco está en los límites del tablero

    //public static boolean cabeBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion){}

//Este metodo coloca un barco en una posicion si este cabe en tablero y no coincide ninguna posicion con otro barco en la zona

    //public static boolean colocarBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion,boolean jugador){}

}