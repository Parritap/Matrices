package Test.MatrizTest;

import exceptions.MatrixException;
import model.Matriz;
import java.util.Arrays;

public class TestMultiplicacionMatrices {


    public static void main(String[] args) throws MatrixException {

        Matriz matriz = new Matriz();

        int arrayA[][] = {
                {5, 3, -4, -2},
                {8, -1, 0, -3},
        };

        int arrayB[][] = {
                {1, 4, 0},
                {-5, 3, 7},
                {0, -9, 5},
                {5, 1, 4}
        };
        System.out.println("A continuación la matríz A:");
        for (int[] element : arrayA
        ) {
            System.out.println(Arrays.toString(element));
        }
        System.out.println("\n");

        System.out.println("A continuación la matriz B:");
        for (int[] element : arrayB
        ) {
            System.out.println(Arrays.toString(element));
        }
        System.out.println("\n");


        int[][] producto = matriz.multiplicarMatrices(arrayA, arrayB);

        System.out.println("A continuación, la matriz producto entre A y B (o multiplicación entre A y B):");
        for (int[] element : producto
        ) {
            System.out.println(Arrays.toString(element));
        }

    }
}



