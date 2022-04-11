package Test;
import exceptions.MatrixException;
import model.Matriz;


public class TestMatrizDiagonal {

    public static void main (String []args) throws MatrixException {
        Matriz matriz = new Matriz();

        int[][] myMatrix = matriz.generarMatrizTriangularSuperiorPares(4);

        matriz.print(myMatrix);

    }
}
