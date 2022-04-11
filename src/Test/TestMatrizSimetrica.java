package Test;

import model.Matriz;
import exceptions.MatrixException;

import java.util.Arrays;

public class TestMatrizSimetrica {

    public static void main (String [] args) throws MatrixException {

        Matriz matriz = new Matriz();

        int[][]matrix = new int [3][3];
        matrix[0]= new int[]{1, 1, 5};
        matrix[1]= new int[]{1, 2, 3};
        matrix[2]= new int[]{5, 3, 4};

        int[][]matrix2 = new int [3][3];
        matrix2[0]= new int[]{1, 9, 5};
        matrix2[1]= new int[]{3, 2, 3};
        matrix2[2]= new int[]{5, 3, 4};

        //La matriz a continuación es una matriz asimétrica, además no es una matriz cuadrada.
        int[][]asimetric = new int [3][];
        asimetric[0]= new int[]{1, 1, 5};
        asimetric[1]= new int[]{1, 2, 3};
        asimetric[2]= new int[]{5, 3};

        //Bloque para la matriz -matrix-.
        System.out.println("A continuación la matriz 'matrix': ");
        for (int[] element: matrix
             ) {
            System.out.println(Arrays.toString(element));
        }
        System.out.print("¿Es la matriz 'matrix' simétrica?: ");
        System.out.println(matriz.esSimetrica(matrix) + "\n");




        //Bloque para la matriz -matrix2-.
        System.out.println("A continuación la matriz 'matrix2': ");
        for (int[] element: matrix2
        ) {
            System.out.println(Arrays.toString(element));
        }
        System.out.print("¿Es la matriz 'matrix2' simétrica?: ");
        System.out.println(matriz.esSimetrica(matrix2) + "\n");


        //Bloque para la matriz -asimetric-.
        System.out.println("A continuación la matriz 'asimetric': ");
        for (int[] element: asimetric
        ) {
            System.out.println(Arrays.toString(element));
        }
        System.out.print("¿Es la matriz 'asimetric' simétrica?: ");
        System.out.println(matriz.esSimetrica(asimetric));

    }

}
