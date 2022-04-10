package model;

import exceptions.MatrixException;

public class Matriz {

    /*----------------------------A continuación el PUNTO 1 del taller-------------------------------------------*/

    /**
     * Método que verifica que una matriz dada sea rectangular, esto es,
     * el número de columnas por cada fila ha de mantenerse constante.
     *
     * @param matriz Matriz a evaluar
     * @return true si la matriz es rectangular
     */
    public boolean esRectangular(int[][] matriz) {
        boolean condicion = true;
        for (int i = 0; i < matriz.length - 1; i++) {

            if (matriz[i].length != matriz[i + 1].length) {
                condicion = false;
                break;
            }
        }
        return condicion;
    }

    /**
     * Método que verifica si es posible multiplicar dos matrices. El método verifica si
     * las matrices dadas cumplen dos condiciones:
     * 1) Ambas matrices han de ser rectangulares
     * 2) El número de filas de la matriz @a debe ser el mismo que el número de columnas de la matriz @b.
     *
     * @param a Matriz a
     * @param b Matriz b
     * @return True si es posible multiplicar las matrices dadas.
     */
    public boolean sePuedeMultiplicar(int[][] a, int[][] b) {
        return (esRectangular(a) && esRectangular(b) && a[0].length == b.length);
    }


    /**
     * Método que multiplica la @fila de una matriz A con la @columna de una matriz B.
     *
     * @param fila Fila a multiplicar con @columna.
     * @param columna Columna a multiplicar con @fila.
     * @param a Arreglo A.
     * @param b Arreglo B.
     * @return Número producto de la suma de los productos de elementos de igual orden (el cual está dado por la 'i' del ciclo for).
     */
    public int multiplicarFilaColumna(int fila, int columna,int[][] a, int[][] b) throws MatrixException {
        int producto=0;
        int limite = a[0].length;//Esto indica la cantidad de veces que vamos a hacer una operación.
        if (a[0].length == b.length) {
            for (int i = 0; i < limite; i++) {
                producto += a[fila][i] * b[i][columna];
            }
        }

        else{
            throw new MatrixException("Las matrices no pueden ser multiplicadas");
        }
        return producto;
    }

    /**
     * Método que multiplica dos matrices dadas en el argumento.
     * @param mA Matriz A.
     * @param mB Matriz B.
     * @return La multiplicación entre las matrices @mA y @mB.
     * @throws MatrixException Excepción lanzada en caso de no poder multiplicar las matrices dadas.
     */
    public int[][] multiplicarMatrices (int[][]mA, int [][]mB) throws MatrixException {
        Matriz matriz = new Matriz();

        if (!matriz.sePuedeMultiplicar(mA, mB)){
            throw new MatrixException("La matrices no pueden ser multiplicadas");
        }

        int[][] producto = new int[mA.length][mB[0].length];


        for (int fila = 0; fila < producto.length; fila++) {
            for (int columna = 0; columna <producto[0].length ; columna++) {
                int element = multiplicarFilaColumna(fila, columna, mA, mB);
                producto[fila][columna] = element;
            }
        }
        return producto;
    }


    /*----------------------------A continuación el PUNTO 2 del taller-------------------------------------------*/

    /**
     * Método que evalúa si una matriz es o no cuadrada.
     * @param matriz Matriz a evaluar
     * @return True si la matriz es cuadrada.
     */
    public boolean esCuadrada (int[][]matriz){

        int numFilas = matriz.length;

        for (int i = 0; i < numFilas; i++) {
            if (matriz[i].length != numFilas)
                return false;
        }
        return true;
    }

    /**
     * Método que verifica si la fila de orden @n de una matriz @a es igual a la columna de orden @n de una matriz @b. Esto es, poseen los mismos elementos.
     * @param n Orden con el que se evalúa las matrices. Si n = 1, entonces se evalua la fila 1 de la matriz @a y la columna 1 de la matriz @b.
     * @param a Matriz A
     * @param b Matriz B
     * @return True si ambas, fila y columna, poseen el mismo número de elementos.
     * @throws MatrixException Excepción lanzada en caso de que la fila @n de la matriz @a y la columna @n de la matriz @b no tengan igual tamaño
     */
    public boolean sonFilaColumnaIguales (int n, int[][] a, int[][] b )throws MatrixException {
        //La fila y la columna en cuestión han de tener el mismo tamaño.
        if (a.length != b[n].length){
            throw new MatrixException("La fila y la columna no tienen el mismo tamaño");
        }

        for (int i = 0; i < a.length; i++) {

            if (a[n][i] != b[i][n])
                return false;
        }
        return true;
    }

    public boolean esSimetrica (int [][] matriz) throws MatrixException {

        if(esCuadrada(matriz)) {

            for (int i = 0; i < matriz.length; i++) {
                if(!sonFilaColumnaIguales(i, matriz, matriz))
                    return false;
            }
        }


        else{
            throw new MatrixException("Las matriz -" + matriz + "- no es cuadrada.");
        }

        return true;
    }


}
