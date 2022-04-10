package Test;

import model.Matriz;
import exceptions.MatrixException;

import java.util.Arrays;

public class TestMatrizSimetrica {

    public static void main (String [] args){

        Matriz matriz = new Matriz();

        int[][]matrix = new int [3][3];

        matrix[0]= new int[]{1, 1, 5};
        matrix[1]= new int[]{1, 2, 3};
        matrix[2]= new int[]{5, 3, 4};

        System.out.println("A continuación la matriz 'matrix': ");
        for (int[] element: matrix
             ) {
            System.out.println(Arrays.toString(element));
        }
        System.out.print("¿Es la matriz 'matrix' simétrica?: ");
        System.out.println(matriz.esSimetrica(matrix));

    }

}
