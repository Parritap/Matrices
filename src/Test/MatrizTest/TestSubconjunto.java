package Test.MatrizTest;

import exceptions.MatrixException;
import model.Matriz;

public class TestSubconjunto {

    public static void main(String[] args) throws MatrixException {

        Matriz matriz = new Matriz();

        // Matriz A
        int[][] A = new int[2][2];
        A[0] = new int[]{1, 5};
        A[1] = new int[]{2, 3};


        //Matriz B
        int[][] B = new int[4][4];
        B[0] = new int[]{0, 0, 0, 0};
        B[1] = new int[]{0, 1, 5, 0};
        B[2] = new int[]{0, 2, 3, 0};
        B[3] = new int[]{0, 0, 0, 0};


        //A prima
        int[][] Ap = new int[2][2];
        Ap[0] = new int[]{3, 9};
        Ap[1] = new int[]{1, 5};

        //Matriz C
        int[][] C = new int[3][3];
        C[0] = new int[]{1, 1, 6};
        C[1] = new int[]{2, 3, 9};
        C[2] = new int[]{2, 1, 5};

        //matric Cp
        int[][] Cp = new int[3][1];
        Cp[0] = new int[]{6};
        Cp[1] = new int[]{9};
        Cp[2] = new int[]{5};

        //Matriz lineal
        int[][] linearMatrix = new int[1][3];
        linearMatrix[0] = new int[]{3, 9};

        System.out.println("-----Vamos a evaluar si las siguiente matrices son subconjuntos de la otra y si caben en orden estricto-----\n");
        System.out.println("Ap respecto de C:  " + matriz.esMatrizSubconjunto(Ap, C));
        System.out.println("A respecto de B:  " + matriz.esMatrizSubconjunto(A, B));
        System.out.println("linearMatrix respecto de C:  " + matriz.esMatrizSubconjunto(linearMatrix, C));
        System.out.println("C respecto de Ap:  " + matriz.esMatrizSubconjunto(C, Ap));


        int[] arreglo = {1, 1, 6};

        System.out.println(matriz.esMatrizSubconjunto(arreglo , C));




    }
}
