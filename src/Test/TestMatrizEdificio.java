package Test;

import exceptions.MatrixException;
import model.Matriz;

public class TestMatrizEdificio {

    public static void main(String[] args) throws MatrixException {

        Matriz matriz = new Matriz();

        char[][] matrix = matriz.generarMatrizEdificio(7, 5);

        matriz.print(matrix);

        matriz.llenarEspacioVacios(matrix);

        matriz.print(matrix);



    }

}
