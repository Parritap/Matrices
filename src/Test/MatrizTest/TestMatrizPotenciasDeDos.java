package Test.MatrizTest;
import exceptions.MatrixException;
import model.Matriz;


public class TestMatrizPotenciasDeDos {

    public static void main (String []args) throws MatrixException {
        Matriz matriz = new Matriz();

        int[][] myMatrix = matriz.generarMatrizTriangularSupPotencia(4);

        matriz.print(myMatrix);

    }
}
