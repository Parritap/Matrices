package Test.MatrizTest;

import model.Matriz;

public class TestMatrizFlecha {

    public static void main(String[] args) {

        Matriz matriz = new Matriz();

        int[][] matrix = matriz.generarMatrizFlecha(5);

        matriz.print(matrix);



    }

}
