package model;

import exceptions.MatrixException;

import java.util.Arrays;

public class Matriz {

    /**
     * Método que imprime una matriz 2x2 de enteros.
     */
    public void print(int matrix[][]) {
        for (int[] element : matrix
        ) {
            System.out.println(Arrays.toString(element));
        }
    }


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
     * @param fila    Fila a multiplicar con @columna.
     * @param columna Columna a multiplicar con @fila.
     * @param a       Arreglo A.
     * @param b       Arreglo B.
     * @return Número producto de la suma de los productos de elementos de igual orden (el cual está dado por la 'i' del ciclo for).
     */
    public int multiplicarFilaColumna(int fila, int columna, int[][] a, int[][] b) throws MatrixException {
        int producto = 0;
        int limite = a[0].length;//Esto indica la cantidad de veces que vamos a hacer una operación.
        if (a[0].length == b.length) {
            for (int i = 0; i < limite; i++) {
                producto += a[fila][i] * b[i][columna];
            }
        } else {
            throw new MatrixException("Las matrices no pueden ser multiplicadas");
        }
        return producto;
    }

    /**
     * Método que multiplica dos matrices dadas en el argumento.
     *
     * @param mA Matriz A.
     * @param mB Matriz B.
     * @return La multiplicación entre las matrices @mA y @mB.
     * @throws MatrixException Excepción lanzada en caso de no poder multiplicar las matrices dadas.
     */
    public int[][] multiplicarMatrices(int[][] mA, int[][] mB) throws MatrixException {
        Matriz matriz = new Matriz();

        if (!matriz.sePuedeMultiplicar(mA, mB)) {
            throw new MatrixException("La matrices no pueden ser multiplicadas");
        }

        int[][] producto = new int[mA.length][mB[0].length];


        for (int fila = 0; fila < producto.length; fila++) {
            for (int columna = 0; columna < producto[0].length; columna++) {
                int element = multiplicarFilaColumna(fila, columna, mA, mB);
                producto[fila][columna] = element;
            }
        }
        return producto;
    }


    /*----------------------------A continuación el PUNTO 2 del taller-------------------------------------------*/

    /**
     * Método que evalúa si una matriz es o no cuadrada.
     *
     * @param matriz Matriz a evaluar
     * @return True si la matriz es cuadrada.
     */
    public boolean esCuadrada(int[][] matriz) {

        int numFilas = matriz.length;

        for (int i = 0; i < numFilas; i++) {
            if (matriz[i].length != numFilas)
                return false;
        }
        return true;
    }

    /**
     * Método que verifica si la fila de orden @n de una matriz @a es igual a la columna de orden @n de una matriz @b. Esto es, poseen los mismos elementos.
     *
     * @param n Orden con el que se evalúa las matrices. Si n = 1, entonces se evalua la fila 1 de la matriz @a y la columna 1 de la matriz @b.
     * @param a Matriz A
     * @param b Matriz B
     * @return True si ambas, fila y columna, poseen el mismo número de elementos.
     * @throws MatrixException Excepción lanzada en caso de que la fila @n de la matriz @a y la columna @n de la matriz @b no tengan igual tamaño
     */
    public boolean sonFilaColumnaIguales(int n, int[][] a, int[][] b) throws MatrixException {
        //La fila y la columna en cuestión han de tener el mismo tamaño.
        if (a.length != b[n].length) {
            throw new MatrixException("La fila y la columna no tienen el mismo tamaño");
        }

        for (int i = 0; i < a.length; i++) {

            if (a[n][i] != b[i][n])
                return false;
        }
        return true;
    }


    /**
     * Método que verifica si una matriz dada es simétrica.
     *
     * @param matriz Matriz a evaluar
     * @return True si la matriz es, en efecto, simétrica.
     * @throws MatrixException Excepción lanzada en caso de que la matriz lanzada no sea cuadrada.
     */
    public boolean esSimetrica(int[][] matriz) throws MatrixException {

        try {
            for (int i = 0; i < matriz.length; i++) {
                if (!sonFilaColumnaIguales(i, matriz, matriz))
                    return false;
            }
        } catch (MatrixException exception) {
            System.out.println("Las matriz no es cuadrada. El programara retornará un 'False'");
            return false;
        }

        return true;
    }
    /*------------------------------------------PUNTO 3---------------------------------- */

    /**
     * Método que genera una matriz cuadrada de n @dimensiones.
     *
     * @param dimensiones Dimensiones de la matriz de tamaño @dimensiones*@dimensiones.
     * @return Matriz cuadrada llena de ceros.
     */
    public int[][] generarCuadrada(int dimensiones) throws MatrixException {

        int[][] matriz;
        try {
            verificarDimension(dimensiones);
        } catch (MatrixException ex) {
            System.out.println("Las dimensiones de una matriz cuadrada han de ser mayores que 1");
        }
        if (dimensiones == 1)
            throw new MatrixException("Una matriz cuadr ada tiene dimensiones mayores a 1");


        matriz = new int[dimensiones][dimensiones];
        return matriz;
    }

    /**
     * Método que verifica que la dimensión de una matriz sea  mayor que 1.
     *
     * @param dimension Dimensión a evaluar.
     * @throws MatrixException Excepción lanzada en caso de que la dimensión sea igual o menor que 0.
     */
    private void verificarDimension(int dimension) throws MatrixException {
        if (dimension < 0)
            throw new MatrixException("Las dimensiones de una matriz no pueden ser negativas");

        if (dimension == 0)
            throw new MatrixException("Una matriz no puede tener  dimensiones 0*n o n*0 o 0+0");

    }

    private void rellenarDiagonal(int[][] matriz, int num) {
        if (esCuadrada(matriz)) {
            for (int i = 0; i < matriz.length; i++) {
                matriz[i][i] = num;
            }
        }

    }


    /**
     * Método que crea una matriz de una dimensión de n dimensiones (mayores que 1)
     * y rellena todos los elementos superiores a la diagonal con las potencias de 2.
     *
     * @param dimension Dimensión con la cual se crea la matriz cuadrada.
     * @return Matriz triangular superior cuyos elementos
     * @throws MatrixException Excepción lanzada si la dimensión indicada en el argumento es menor que 2.
     */
    public int[][] generarMatrizTriangularSuperiorPares(int dimension) throws MatrixException {

        int[][] matriz = generarCuadrada(dimension);
        rellenarDiagonal(matriz, 1);

        int limite = dimension;

        for (int i = 0; i < dimension; i++) {
            limite += i;
        }

        for (int i = 0, j = 0, p = 0; i < dimension; j++) {

            if (i < j) {
                matriz[i][j] = (int) Math.pow(2, p);
                p++;
            }
            if (j == dimension - 1) {
                i++;
                j = 0;
            }
        }
        return matriz;
    }

    /*------------------------------------- PUNTO 4---------------------------------- */

    /**
     * Método que verifica si el número @num pasado en el argumento se repite en las posiciones no diagonales
     * inmediatamente contiguas.
     *
     * @param matriz Matriz a evaluar
     * @param num    Número buscado
     * @return True de cumplir la condición.
     */
    public boolean verificarConsecutivos(int[][] matriz, int num) {

        // f = fila.
        // c = columna.

        //Condición que verifica la condición de manera horizontal.
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length - 1; c++) {

                if (matriz[f][c] == num && matriz[f][c] == matriz[f][c + 1])
                    return true;
            }

        }

        //Condición que verifica la condición de manera vertical.
        for (int c = 0; c < matriz[0].length; c++) {
            for (int f = 0; f < matriz.length - 1; f++) {

                if (matriz[f][c] == num && matriz[f][c] == matriz[f + 1][c])
                    return true;

            }
        }
        return false;
    }

    /*------------------------------------- PUNTO 5---------------------------------- */

   public char[][] generarMatrizAsteriscos(int dimension) {

       char[][] matriz = new char[dimension][dimension];


       for (int c = 0; estaColumnaVacia(matriz, matriz[0].length/2 +1); c++) {
            int contador = c+1;

            //Ciclo que llena el arreglo de forma superior.
           for (int f=0, j=contador;  j>0; f++, j--) {
               matriz[f][c] = '*';
           }

           for (int f = matriz.length-1, j=contador; j>0 ; f--, j--) {

           }



       }

       return matriz;
   }


    public boolean estaColumnaVacia(char[][] matriz, int columna) {

           for (int i = 0; i < matriz.length; i++) {
               if (matriz[i][columna] != '\0'){
                   return false;
               }
           }
        return true;
    }

}

