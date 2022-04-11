package Test;

import exceptions.MatrixException;
import model.Matriz;

public class TestElemetosConsecutivos {

    public static void main (String [] args){

        Matriz matriz = new Matriz();

        //Matriz A
        int[][]matrixA = new int [3][3];
        matrixA[0]= new int[]{0, 0, 1};
        matrixA[1]= new int[]{1, 1, 1};
        matrixA[2]= new int[]{1, 1, 1};

        //Matriz B
        int[][]matrixB = new int [3][ 3];
        matrixB[0]= new int[]{1, 1, 1};
        matrixB[1]= new int[]{1, 1, 0};
        matrixB[2]= new int[]{1, 1, 0};

        System.out.println("Matriz A: " +  matriz.verificarConsecutivos(matrixA, 0));
        System.out.println("Matriz B: " +  matriz.verificarConsecutivos(matrixB, 0));

       //System.out.println(matrixB [0][1]);
       //System.out.println(matrixB [1][1]);



    }
}
