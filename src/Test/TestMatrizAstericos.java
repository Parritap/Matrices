package Test;

import model.Matriz;

import java.util.Arrays;

public class TestMatrizAstericos {

    public static void main(String[] args) {

        Matriz matriz = new Matriz();

        char c = '\0';
        String str = "\0";

        char[] charArray = new char[3];
        char[][] charMatrix = new char[3][3];

        System.out.println(Arrays.toString(charArray));

        System.out.println('\0' == charArray[1]);

        System.out.println("Está la columna llena de vacios?: " +matriz.estaColumnaVacia(charMatrix, 1));


        int x = 5;
        int y = 2;

        System.out.println(x/y);



    }
}
