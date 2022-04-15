package Test.MatrizTest;

import exceptions.MatrixException;
import model.Matriz;

public class TestMatrizAstericos {

    public static void main(String[] args) throws MatrixException {

        Matriz matriz = new Matriz();

        char[][]  matrizAsteriscos = matriz.generarMatrizAsteriscos(1);

        matriz.print(matrizAsteriscos);

    }
}
