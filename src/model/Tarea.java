package model;

import java.util.Arrays;

import jdk.jshell.execution.Util;
import utils.Utils;


public class Tarea {

    public static void main(String[] args) {

        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};

        char[][] charMatrix = new char[3][9];

        //  int[][] newMatrix = recorrerMatriz(matrix, '-', '+');

        //  for (int[] e : newMatrix) {
        //      System.out.println(Arrays.toString(e));
        //  }

        //  //Se rota la matriz en sentido horario una sola vez.
        //  int[][] matrizRotada = rotarMatrizSentidoHorario(matrix);
        //  Utils.print(matrizRotada);

        //  //Se rota la matriz en sentido antihorario una sola vez.
        //  int[][] antiMatrizRotada = rotarMatrizSentidoAntiHorario(matrix);
        //  Utils.print(antiMatrizRotada);

        int[][] matrizRotada = rotarMatriz(matrix, 'a', 3);

        Utils.print(matrizRotada);

        llenarDeAstericos(charMatrix);
        Utils.print(charMatrix);

    }

    /**
     * Método que recorre una matriz aumentando o disminuyendo las columnas, existiendo 4 posibilidades
     * de recorrido para dicha matriz.
     * <p>
     * '+' y '+' : Recorrido normal
     * '+' y '-' : Recorrido en el que se aumentan las filas, pero se disminuyen las columnas.
     * '-' y '+' : Recorrido en el que se disminuyen las filas, pero se aumentan las columnas.
     * '+' y '+' : Recorrido en el que se disminuyen tanto filas como columnas.
     *
     * @param matriz             Matriz a recorrer.
     * @param instruccionFila    Char que indica cómo recorrer las filas, puede ser '+' o '-' únicamente.
     * @param instruccionColmuna Char que insdica cómo recorrer las columnas,  puede ser '+' o '-' únicamente.
     * @return Una matriz que guarda los elementos de @matriz a medida que se vaya haciendo el recorrido indicado.
     */
    public static int[][] recorrerMatriz(int[][] matriz, char instruccionFila, char instruccionColmuna) {
        //Hay dos posibilidades, que instFila y instCol sean iguales "+" ó "-"

        int[][] newMatrix = new int[matriz.length][matriz[0].length];

        if (instruccionFila == '+' && instruccionColmuna == '+') {
            //Recorremos normalmente

            for (int i = 0, f = 0; i < matriz.length; i++, f++) {
                for (int j = 0, c = 0; j < matriz.length; j++, c++) {
                    newMatrix[f][c] = matriz[i][j];
                }
            }
        }


        if (instruccionFila == '+' && instruccionColmuna == '-') {
            //Recorremos aumentando filas y disminuyendo columnas
            for (int i = 0, f = 0; i < matriz.length; i++, f++) {
                for (int j = matriz[i].length - 1, c = 0; j >= 0; j--, c++) {
                    newMatrix[f][c] = matriz[i][j];
                }
            }

        }


        if (instruccionFila == '-' && instruccionColmuna == '+') {
            //Recorremos aumentando filas y disminuyendo columnas
            for (int i = matriz.length - 1, f = 0; i >= 0; i--, f++) {
                for (int j = 0, c = 0; j < matriz[i].length; j++, c++) {
                    newMatrix[f][c] = matriz[i][j];
                }
            }
        }


        if (instruccionFila == '-' && instruccionColmuna == '-') {
            //Recorremos disminuyendo filas y columnas.
            for (int i = matriz.length - 1, f = 0; i >= 0; i--, f++) {
                for (int j = matriz[i].length - 1, c = 0; j >= 0; j--, c++) {
                    newMatrix[f][c] = matriz[i][j];
                }
            }
        }

        return newMatrix;
    }

    /**
     * Método que devuelve una matriz rotoada la cantidad de veces dispuesta en el argumento, como tambien en el sentido indicado.
     * Para rotar en sentido horario escribir 'h', para sentido antihorario escribir 'a'
     *
     * @param matrix             Matriz a rotar
     * @param sentido            Char que indica el sentido a rotar
     * @param cantidadRotaciones Cantidad de veces a rotar la matriz
     * @return Una matriz rotada con los parámetros indicados.
     */
    public static int[][] rotarMatriz(int[][] matrix, char sentido, int cantidadRotaciones) {

        if (cantidadRotaciones == 0)
            return matrix;

        if (sentido != 'h' && sentido != 'a') {
            System.out.println("El caracter 'sentido' ingresado no es ni 'h' ni 'a' \nSe devolverá la matriz sin rotar");
            return matrix;
        }


        int[][] newMatrix = matrix;
        // 'h' significa horario
        if (sentido == 'h') {
            for (int i = 0; i < cantidadRotaciones; i++) {
                newMatrix = rotarMatrizSentidoHorario(newMatrix);
            }
        }

        if (sentido == 'a') {
            for (int i = 0; i < cantidadRotaciones; i++) {
                newMatrix = rotarMatrizSentidoAntiHorario(newMatrix);
            }

        }
        return newMatrix;

    }

    /**
     * Método que rota una matriz en sentido horario una única vez.
     *
     * @param matrix Matriz a rotar
     * @return La matriz rotada.
     */
    public static int[][] rotarMatrizSentidoHorario(int[][] matrix) {
        Matriz matriz = new Matriz();

        if (!matriz.esRectangular(matrix))
            return matrix;

        int[][] newMatrix = new int[matrix[0].length][matrix.length];

        for (int j = 0, f = 0; j < matrix[0].length; j++, f++) {
            for (int i = matrix.length - 1, c = 0; i >= 0; i--, c++) {
                newMatrix[f][c] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * Método que rota una matriz en sentido antihorario una única vez.
     *
     * @param matrix matriz a rotar
     * @return Matriz rotada.
     */
    public static int[][] rotarMatrizSentidoAntiHorario(int[][] matrix) {
        Matriz matriz = new Matriz();

        if (!matriz.esRectangular(matrix))
            return matrix;

        int[][] newMatrix = new int[matrix[0].length][matrix.length];

        for (int j = matrix[0].length - 1, f = 0; j >= 0; j--, f++) {
            for (int i = 0, c = 0; i < matrix.length; i++, c++) {
                newMatrix[f][c] = matrix[i][j];
            }
        }
        return newMatrix;

    }


    public static void  llenarDeAstericos (char [][] matriz){

        if (esRegular(matriz) && (matriz[0].length %2 ==1)){ //La segunda parte de la condición evalúa que la cantidad de columnas sea impar.

            int esp = matriz[0].length/2; //cantidad de espacios.
            int cantPrint = 1; //Cantidad de astericos a imprimir.


            for (int i = 0; i < matriz.length ; i++, esp--, cantPrint+=2) {
                for (int j = esp, aux= cantPrint ; aux >0 && j< matriz[i].length; j++, aux--) {
                    matriz[i][j] = '*';
                }
            }

        }

    }

    private static boolean esRegular(char[][] matriz) {
        for (int i = 0; i < matriz.length-1; i++) {
            if (matriz[i].length != matriz[i+1].length)
                return false;
        }

        return true;













    }

}
