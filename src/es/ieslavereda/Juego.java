package es.ieslavereda;

public class Juego {
    public static void main(String[] args) {

        //System.out.println(Entrada.obtenerFila());
        //System.out.println(Entrada.obtenerColumna());

        Pantalla.mostrarMenu();
        String nombre = Entrada.obtenerTexto("Nombre:");

        borrarPantalla();

        //arrays
        char[][] tableroJugador = new char[10][10];
        char[][] tableroPC = new char[10][10];
        int[] numeros = new int[10];
        int[] barcos = new int[4];

        //coordenadas
        int fila;
        int columna;

        rellenarNums(numeros);
        inicializarTablero(tableroJugador);
        inicializarTablero(tableroPC);

        Pantalla.mostrarTableros(numeros,tableroJugador,tableroPC);

        colocarBarcosJugador(tableroJugador, barcos, numeros, tableroPC);

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

    public static void rellenarNums(int[] numeros){
        for(int i=0;i<numeros.length;i++){
            numeros[i]=i;
        }
    }

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

    public static void colocarBarcosJugador(char[][] tableroJugador, int[] barcos, int[] numeros, char[][] tableroPC){
        String coordenada;
        int orientacion;
        int contador=0;
        boolean validado=false;
        int longitud = barcos.length - contador;

        char fila;
        char columna;
        int filaInt;
        int columnaInt;
        boolean cabe=false;

        do{
            System.out.println();
            coordenada = Entrada.obtenerTexto("Vamos a colocar el barco de " + (barcos.length - contador) + " celdas [A-J][0-9] ");
            if(coordenada.length() < 2){
                Pantalla.mostrarError("La coordenada debe comprenderse de dos caracteres [LETRA][número]");
            }else{
                fila=coordenada.charAt(0);
                columna=coordenada.charAt(1);
                validado=Entrada.validarCoordenada('A','J',fila, columna, coordenada);
                if (validado) {
                    contador++;
                    orientacion = Entrada.obtenerEnteroBetween(0,1,"Orientación [0-Horizontal  |  1-Vertical]");
                    System.out.println("________________________________");
                    filaInt=convertirFilaInt(fila);
                    columnaInt=convertirColumnaInt(columna);
                    cabe = cabeBarco(tableroJugador, longitud, fila, columna, orientacion);
                    if (cabe && orientacion==0){
                        for (int i=0;i<longitud;i++){
                            tableroJugador[filaInt][columnaInt+i]= 'B';
                        }
                        longitud = barcos.length - contador;
                        Pantalla.mostrarTableros(numeros,tableroJugador,tableroPC);
                        borrarPantalla();
                        cabe=false;
                    }else if (cabe && orientacion==1){
                        cabe=false;
                        for (int i=0;i<longitud;i++){
                            tableroJugador[filaInt+i][columnaInt]= 'B';
                        }
                        longitud = barcos.length - contador;
                        Pantalla.mostrarTableros(numeros,tableroJugador,tableroPC);
                        borrarPantalla();
                        cabe=false;
                    }
                }
            }
        }while(contador<=4);
    }

    //Este metodo devuelve la fila en int

    public static int convertirFilaInt(char fila){
        switch (fila){
            case 'A':return 0;
            case 'B':return 1;
            case 'C':return 2;
            case 'D':return 3;
            case 'E':return 4;
            case 'F':return 5;
            case 'G':return 6;
            case 'H':return 7;
            case 'I':return 8;
            case 'J':return 9;
            default:return 0;
        }

    }

    public static int convertirColumnaInt(char columna){
        switch (columna){
            case '0':return 0;
            case '1':return 1;
            case '2':return 2;
            case '3':return 3;
            case '4':return 4;
            case '5':return 5;
            case '6':return 6;
            case '7':return 7;
            case '8':return 8;
            case '9':return 9;
            default:return 0;
        }
    }

//Este metodo coloca los barcos pasados como vector dentro del tablero del PC

    public static void colocarBarcosPC(char[][] tablero,int[] barcos){}


//Este metodo comprueba si hay algun barco en la zona del barco a colocar

    public static boolean hayColision(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion){
        return false;
    }


//Este metodo comprueba si el barco está en los límites del tablero

    public static boolean cabeBarco(char[][] tablero, int longitudBarco, int filaInt, int columnaInt, int orientacion){
        if (orientacion == 0) {
            if (longitudBarco<10-columnaInt){
                Pantalla.mostrarError("El barco NO cabe");
                return false;
            }
        }
        if (orientacion == 1) {
            if (longitudBarco<tablero.length-filaInt){
                Pantalla.mostrarError("El barco NO cabe");
                return false;
            }
        }

        return true;
    }

//Este metodo coloca un barco en una posicion si este cabe en tablero y no coincide ninguna posicion con otro barco en la zona

    //public static boolean colocarBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion,boolean jugador){}

}