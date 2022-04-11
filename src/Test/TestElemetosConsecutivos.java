package Test;

import exceptions.MatrixException;
import model.Matriz;

public class TestElemetosConsecutivos {

    public static void main (String [] args){

        Matriz matriz = new Matriz();

        int[][]matrix = new int [3][3];
        matrix[0]= new int[]{1, 4, 5};
        matrix[1]= new int[]{9, 2, 3};
        matrix[2]= new int[]{5, 4, 4};

        System.out.println(matriz.verificarConsecutivos(matrix, 1));


    }
}
