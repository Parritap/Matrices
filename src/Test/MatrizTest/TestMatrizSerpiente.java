package Test.MatrizTest;

import exceptions.MatrixException;
import model.Matriz;

public class TestMatrizSerpiente {
    public static void main(String[] args) throws MatrixException {

        Matriz matriz = new Matriz();

        int [][] matrix = matriz.generarMatrizSerpiente(4);

        matriz.print(matrix);

    }
}
