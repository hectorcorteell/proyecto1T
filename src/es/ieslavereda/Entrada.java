package es.ieslavereda;

import java.util.Scanner;

public class Entrada {

    public static String obtenerTexto(String texto){

        Scanner sc = new Scanner(System.in);

        Pantalla.mostrarMensaje(texto);
        return sc.nextLine();

    }

    private static int obtenerEntero(String texto) {
        Scanner sc = new Scanner(System.in);
        Pantalla.mostrarMensaje(texto);
        do{
            if(!sc.hasNextInt()) {
                Pantalla.mostrarError("¡Debes introducir un entero!");
                sc.nextLine();
                Pantalla.mostrarMensaje(texto);
            }
        }while(!sc.hasNextInt());

        return sc.nextInt();

    }

    public static int obtenerEnteroBetween(int min, int max, String texto) {
        int numero;

        do {
            numero = obtenerEntero(texto);
            if (numero < min)
                Pantalla.mostrarError("El número debe ser mayor o igual que " + min+".");
            if (numero > max)
                Pantalla.mostrarError("El número debe ser menor o igual que " + max+".");
        }while (numero<min || numero>max);

        return numero;
    }

    private static char obtenerChar(String texto){
        Scanner sc = new Scanner(System.in);
        Pantalla.mostrarMensaje(texto);
        String entrada;

        do {
            entrada = sc.nextLine();
            if (entrada.length() > 1)
                Pantalla.mostrarError("Has introducido demasiados caracteres");
        }while(entrada.length()!=1);

        return entrada.charAt(0);
    }

    public static char obtenerChar(char minChar, char maxChar, String texto){
        char letra;
        letra = obtenerChar(texto);

        do {
            if (letra < minChar || letra > maxChar)
                Pantalla.mostrarError("Debes introducir una letra entre " + minChar + " y " + maxChar);
        }while(letra < minChar || letra > maxChar);

        return letra;
    }

    public static int obtenerFila(){
        return obtenerChar('A','J', "Introduce la fila [A-J]");
    }

    public static int obtenerColumna(){
        return obtenerEnteroBetween(0,9,"Introduce un número [0-9]");
    }
}
