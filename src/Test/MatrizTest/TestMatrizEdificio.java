package Test.MatrizTest;

import exceptions.MatrixException;
import model.Matriz;

public class TestMatrizEdificio {

    public static void main(String[] args) throws MatrixException {

        Matriz matriz = new Matriz();

        char[][] matrix = matriz.generarMatrizEdificio(0,0 );

        matriz.print(matrix);




    }

}
