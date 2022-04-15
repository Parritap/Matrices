package model;

import exceptions.MatrixException;

import java.util.Arrays;
import java.util.Scanner;

public class Matriz {

    /**
     * Método que imprime una matriz de enteros.
     */
    public void print(int matrix[][]) {
        for (int[] element : matrix
        ) {
            System.out.println(Arrays.toString(element));
        }
    }

    /**
     * Método que imprime una matriz de caracteres.
     */
    public void print(char matrix[][]) {
        for (char[] element : matrix
        ) {
            System.out.println(Arrays.toString(element));
        }
    }

    public void printColum(int colum, int[][] matrix ){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][colum]);
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


    /**
     * Método que genera una matriz cuadra de asteriscos y espacios de la dimensión indicada en el argumento.
     * El patron generado es el siguiente:
     * [*, *, *, *, *]
     * [ , *, *, *,  ]
     * [ ,  , *,  ,  ]
     * [ , *, *, *,  ]
     * [*, *, *, *, *]
     *
     * @param dimension Dimensión de la matriz en cuestión. Ha de ser mayor que 0.
     * @return Una matriz de caracteres con las características indicadas.
     * @throws MatrixException Excepción lanzada en caso de que la dimensión indicada en el argumento sea igual o menor que 0.
     */
    public char[][] generarMatrizAsteriscos(int dimension) throws MatrixException {

        if (dimension <= 0)
            throw new MatrixException("La dimensión de la matriz no puede ser igual o menor que 0.");

        char[][] matriz = new char[dimension][dimension];


        for (int c = 0; estaColumnaVacia(matriz, matriz[0].length / 2); c++) {
            int contador = c + 1;

            //Ciclo que llena el arreglo desde la esquina superior izquierda.
            for (int f = 0, j = contador; j > 0; f++, j--) {
                matriz[f][c] = '*';
            }

            //Ciclo que llena el arreglo desde la esquina inferior izquierda.
            for (int f = matriz.length - 1, j = contador; j > 0; f--, j--) {
                matriz[f][c] = '*';
            }
        }

        reflejarMatriz(matriz);

        return matriz;
    }


    /**
     * Método que verifica si cierta columna de una matriz completamente vacía
     *
     * @param matriz  Matriz a inspeccionar.
     * @param columna Columna a inspeccionar.
     * @return False si al menos de los caracteres de la @columna es diferente de [null] o [vacio] o '' o '\0'. (Todo lo anterior es igual).
     */
    public boolean estaColumnaVacia(char[][] matriz, int columna) {

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][columna] != '\0') {
                return false;
            }
        }
        return true;
    }


    /**
     * Método que refleja la mitad derecha de una matriz respecto de su mitad izquierda. Esto es, copia la mitad izquierda de la matriz
     * para luego copiarla en la mitad derecha de la misma.
     * Si la matriz es de orden impar, entonces se ignora la fila que divide a la matriz justo por la mitad. De ser de orden par, esto no sucede.
     *
     * @param matriz Matriz a modificar.
     */
    public void reflejarMatriz(char[][] matriz) {

        int aux = matriz[0].length / 2;

        for (int i = 0, j = matriz.length - 1; aux > 0; i++, j--, aux--) {

            for (int k = 0; k < matriz.length; k++) {
                matriz[k][j] = matriz[k][i];
            }
        }
    }


    /*------------------------------------- PUNTO 6---------------------------------- */


    /**
     * Método que genera una matriz de nxn dimensiones, luego se llena de números (y estos de forma creciente) de manera que se sigue un patrón
     * en forma de serpiente en el que se imprime por columnas, id est, en vez de continuar la cuenta (una vez se terminase de llenar toda una columna)
     * en el principio de la siguiente columna, se salta de columna sin cambiar la fila, luego se llena de abajo hacia arriba,
     * y cuando se vuelva a saltar de columna, se llena de arriba hacia abajo (simulando el movimiento que hace una serpiente).
     * <p>
     * Exempli Gratia:
     * <p>
     * [1, 8, 9,  16]
     * [2, 7, 10, 15]
     * [3, 6, 11, 14]
     * [4, 5, 12, 13]
     *
     * @param dimension
     * @return
     * @throws MatrixException
     */
    public int[][] generarMatrizSerpiente(int dimension) throws MatrixException {

        int[][] matriz = generarCuadrada(dimension);
        int num = 1;
        int cLimit = matriz[0].length;

        for (int c = 0; c < cLimit; ) {

            for (int f = 0; f < matriz.length && c < cLimit; f++, num++) {
                matriz[f][c] = num;

                if (f == matriz.length - 1)
                    c++;
            }

            for (int f = matriz.length - 1; f >= 0 && c < cLimit; f--, num++) {
                matriz[f][c] = num;

                if (f == 0)
                    c++;
            }
        }
        return matriz;
    }


    /*------------------------------------- PUNTO 7---------------------------------- */

    /**
     * Método que genera una matriz de las dimensiones indicadas en el argumento, de manera que se sigue un patrón
     * como el siguinte:
     * <p>
     * [-, -, -, -, -]
     * [-, 1, 2, 3, -]
     * [-, -, -, -, -]
     * [-, 4, 5, 6, -]
     * [-, -, -, -, -]
     *
     * @param numFilas    Cantidad de filas
     * @param numColumnas Cantidad de columna
     * @return Matriz de las características indicadas.
     * @throws MatrixException Excepción lanzada si las dimensiones indicadas son menores que 1.
     */
    public char[][] generarMatrizEdificio(int numFilas, int numColumnas) throws MatrixException {

        verificarDimension(numFilas);
        verificarDimension(numColumnas);

        char[][] matriz = new char[numColumnas][numFilas];

        //Ciclo que rellena del carácter cuadrado ('\254') la primera y última columna.
        for (int i = 0, j = matriz[0].length - 1, k = 0; k < matriz.length; k++) {
            matriz[k][i] = '-';
            matriz[k][j] = '-';
        }

        //Ciclo que rellena las filas pares.

        for (int i = 0; i < matriz.length; i += 2) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = '-';
            }
        }

        int contador = 49;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == '\0') {
                    matriz[i][j] = (char) contador;
                    contador++;
                }
            }
        }
        return matriz;
    }

    /**
     * Método que indica mediante un print la cantidad de vacios que posee una matriz.
     * Luego, se da la opción de que el usuario llene un espacio vacio oprimiendo una letra.
     */
    public void llenarEspacioVacios(char[][] matriz) {

        int cantidadVacios = 0;
        StringBuilder indicadorVacios = new StringBuilder();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == '\0') {
                    cantidadVacios++;
                    indicadorVacios.append("Vacío # " + cantidadVacios + " en la fila [" + i + "] y la  columna [" + j + "]");
                }
            }
        }

        Scanner s = new Scanner(System.in);

        System.out.println("¿Desea cambiar alguno de los espacios en blanco indicado con los números (o caracteres)?\n" +
                "Si desea cambiar alguno presione 'y', de lo contrario escriba cualquier otra tecla o pulse [ENTER].");

        String option = s.nextLine();

        if (option == "y" || option == "Y") {

            System.out.print("Presione el caracter del espacio que desea cambiar: ");
            String option2 = s.nextLine();

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {

                    if (matriz[i][j] == option2.charAt(0)) ;
                    {
                        System.out.print("Presiona el caracter por el que desea cambiar el espacio");
                        String nuevoChar = s.nextLine();
                        matriz[i][j] = nuevoChar.charAt(0);
                        System.out.println("El espacio ha sido cambiado");
                    }
                }
            }

        }


    }

    /*------------------------------------- PUNTO 8---------------------------------- */


    /**
     * Método que verifica que el tamaño de la matriz B sea igual o mayor que el tamao de la subMatriz.
     *
     * @param superMatriz  Matriz que deberá tener el mayor tamaño; si no, el mismo que la subMatriz
     * @param subMatriz Matriz que debe tener las menores dimensiones.
     * @return True si el tamaño de la matriz B es mayor que le matriz A.
     */
    public boolean esTamanioIgualMayor(int[][] superMatriz, int[][] subMatriz) {


        //Recordar que el ancho es la cantidad de columnas, por tanto, matriz[i].length
        int anchoA = subMatriz[0].length;
        int anchoB = superMatriz[0].length;

        //Recordar que el alto es la cantidad de filas, por tanto, matriz.length
        int altoA = subMatriz.length;
        int altoB = superMatriz.length;

        //EL tamaño de B no puede ser bajo caso menor que el de A en ninguna de sus dimensiones.
        if (altoB >= altoA && anchoB >= anchoA)
            return true;

        return false;
    }


    /**
     * Método que indica si @subMatriz es subconjunto de @superMatriz en el orden estricto en la que existe @subMatriz.
     * @param subMatriz Matriz que se verifica que esté contenida dentro de @superMatriz
     * @param superMatriz Matriz que se verifica que contenga a @subMatriz.
     * @return True si @subMatriz está contenida dentro de @superMatriz en orden estricto.
     */
    public boolean esMatrizSubconjunto(int[][] subMatriz, int[][] superMatriz) throws MatrixException {
        //Buscamos saber si la matriz subMatriz es subconjunto de la matriz superMatriz.

        //Si el tamaño de superMatriz es menor que el de subMatriz, entonces subMatriz no es subconjunto de superMatriz.
        if (!esTamanioIgualMayor(superMatriz, subMatriz))
            return false;

        // Si el primer elemento de subMatriz no existe dentro de superMatriz, entonces subMatriz no es subconjunto de superMatriz.
        if (!existeElemento(subMatriz[0][0], superMatriz))
            return false;

        for (int y = 0; y < superMatriz.length; y++) {
            for (int x = 0; x < superMatriz[y].length; x++) {
                if (superMatriz[y][x] == subMatriz[0][0]) {

                    if (esPosibleExtraerDesdePos(x, y, superMatriz, subMatriz)) {

                        int[][] subMatrizPrima = copiarMatrizSegunCoordernadas(x, y, superMatriz, subMatriz);

                        if (sonIguales(subMatrizPrima, subMatriz))
                            return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Método que indica si un arreglo es subconjunto de una @superMatriz en el orden estricto en la que existe @subMatriz.
     * @param arreglo arreglo que se verifica que esté contenido dentro de @superMatriz
     * @param superMatriz Matriz que se verifica que contenga a @subMatriz.
     * @return True si @subMatriz está contenida dentro de @superMatriz en orden estricto.
     */
    public boolean esMatrizSubconjunto(int[] arreglo, int[][] superMatriz) throws MatrixException {
        //Buscamos saber si el arreglo es subconjunto de la matriz superMatriz.
        
        //convertimos el arreglo en una matriz (porque soy muy perezoso y no quiero rehacer codigo);
        int [][] subMatriz = convertirAMatriz(arreglo);
        

        //Si el tamaño de superMatriz es menor que el de subMatriz, entonces subMatriz no es subconjunto de superMatriz.
        if (!esTamanioIgualMayor(superMatriz, subMatriz))
            return false;

        // Si el primer elemento de subMatriz no existe dentro de superMatriz, entonces subMatriz no es subconjunto de superMatriz.
        if (!existeElemento(subMatriz[0][0], superMatriz))
            return false;

        for (int y = 0; y < superMatriz.length; y++) {
            for (int x = 0; x < superMatriz[y].length; x++) {
                if (superMatriz[y][x] == subMatriz[0][0]) {

                    if (esPosibleExtraerDesdePos(x, y, superMatriz, subMatriz)) {

                        int[][] subMatrizPrima = copiarMatrizSegunCoordernadas(x, y, superMatriz, subMatriz);

                        if (sonIguales(subMatrizPrima, subMatriz))
                            return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Método que me dice si es posible extraer una matriz nueva del mismo tamaño de @subMatriz a partir de @superMatriz
     * desde las coordenadas indicadas en el argumento.
     *
     * @param x           Número que representa la posición de la columna.
     * @param y           Número que representa la posición de la fila.
     * @param superMatriz Matriz a inspeccionar que deberá ser de igual o mayor tamaño que @subMatriz.
     * @param subMatriz   Matriz que se espera quepa dentro de @superMatriz desde las coordenadas [y][x].
     * @return True si @subMatriz cabe dentro de @superMatriz desde la posición [y][x] de @superMatriz.
     */
    public boolean esPosibleExtraerDesdePos(int x, int y, int[][] superMatriz, int[][] subMatriz) {

        int deltaX = superMatriz[0].length - x;
        int deltaY = superMatriz.length - y;

        if (deltaX >= subMatriz[0].length && deltaY >= subMatriz.length)
            return true;

        return false;
    }


    /**
     * Método que extrae una matriz de otra desde las coordenadas dadas (incluyentes). La matriz a retornar tiene las mismas dimensiones
     * que @subMatriz (y solo para tal obtención de dimensiones existe @subMatriz). Luego se llena la nueva matriz con los elementos de @superMatriz.
     * Id est. Si las coordenadas son x=1, y=1, entonces se ignoran la fila 0 y la columna 0, y se rellena la matriz a retornar con los valores restantes
     * de @superMatriz mientras se puedan llenar la nueva matriz.
     *
     *
     * @param coordenada_x Posición columna desde la cual empezar a copiar.
     * @param coordenada_y Posición fila desde la cual espezar a copiar.
     * @param superMatriz Matriz a la que se le copiarán sus elementos.
     * @param subMatriz Matriz referencia que solo sirve para dar las dimensiones a la nueva matriz que se retornará.
     * @return Nueva matriz llena de los elementos de @superMatriz dadas las condiciones listadas.
     * @throws MatrixException Si alguna de las dimensiones de @subMatriz es mayor que las de @superMatriz, entonces esto significa que no se puede copiar.
     */
    public int[][] copiarMatrizSegunCoordernadas(int coordenada_x, int coordenada_y, int[][] superMatriz, int[][] subMatriz) throws MatrixException {

        if (subMatriz.length > superMatriz.length || subMatriz[0].length > superMatriz[0].length)
             throw new MatrixException ("La superMatriz tiene alguna dimensión mayor que la subMatriz");

        int[][] nuevaMatriz = new int[subMatriz.length][subMatriz[0].length];


        //Llenamos el nuevo arreglo C a partir de los elementos de B, llenándolo únicamente desde la posición/coordernadas del
        // primer elemento de A dentro de B.
        for (int i = 0, y = coordenada_y; i < nuevaMatriz.length; i++, y++) {
            for (int j = 0, x = coordenada_x; j < nuevaMatriz[i].length; j++, x++) {
                nuevaMatriz[i][j] = superMatriz[y][x];
            }
        }

        return nuevaMatriz;
    }



    /**
     * Método que retorna si existe al menos un elemento @e dentro de la @matriz.
     *
     * @param e      Elemento a buscar.
     * @param matriz Matriz a inspeccionar.
     * @return True si @e existe dentro de @matriz. De lo contario, retorna False.
     */
    public boolean existeElemento(int e, int[][] matriz) {

        //ciclo para buscar elemento el elemento @e dentro de @matriz.
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                if (matriz[f][c] == e)
                    return true;
            }
        }
        return false;
    }



    /**
     * Método que retorna un arreglo con la primera posición del @elemento dentro de una @matriz.
     *
     * @param elemento Elemento a bucar dentro de @matriz.
     * @param matriz   Matriz a inspeccionar.
     * @return Posición en la que se encuentra @elemento dentro de @matriz. De no existir @elemento dentro de la matriz, el método retornará la posición {-1,-1}.
     */
    public int[] buscarPosElemento(int elemento, int[][] matriz) {

        int[] coordenadas = new int[2];
        boolean posEncontrada = false;

        int limHor = matriz[0].length - 1;
        int limVer = matriz.length - 1;

        //ciclo para buscar elemento el elemento @elemento dentro de @matriz.
        for (int f = 0; f < matriz.length && !posEncontrada; f++) {          //f para filas
            for (int c = 0; c < matriz[f].length && !posEncontrada; c++) {   //c para columnas
                if (matriz[f][c] == elemento) {
                    coordenadas = new int[]{f, c};
                    posEncontrada = true;
                }

                //Esta condición se ejecuta si el elemento no existe dentro de la matriz.
                if (f == limVer && c == limHor && !posEncontrada) {
                    coordenadas = new int[]{-1, -1};
                }
            }
        }
        return coordenadas;
    }


    /**
     * Método que verifica si dos matrices son iguales.
     * Esto se hace comparando los elementos que posean dentro de las mismas posiciones.
     *
     * @return True si son iguales. False de lo contrario.
     */
    public boolean sonIguales(int[][] matrizA, int[][] matrizB) {

        if (matrizA.length == matrizB.length) {

            for (int i = 0; i < matrizA.length; i++) {

                if (matrizA[i].length != matrizB[i].length)
                    return false;

                for (int j = 0; j < matrizA[i].length; j++) {
                    if (matrizA[i][j] != matrizB[i][j])
                        return false;
                }

                return true;
            }
        }
        return false;
    }

    /**
     * Método que convierte un arreglo en una matriz de una columna y n filas.
     * @param arreglo Arreglo a convertir.
     * @return Una matriz a partir del @arreglo.
     */
    public int[][] convertirAMatriz (int[] arreglo){
        
        int[][] matrix = new int[arreglo.length][1];

        for (int fila = 0; fila < arreglo.length; fila++) {
            matrix [fila][0] = arreglo [fila];
        }
        
        return matrix;
    }


    /*----------------------------- PUNTO 10.2 (hay dos puntos 10 en el taller)---------------------------------- */

    /**
     * Método que crea un arreglo de la siguiente manera:
     *
     * [1, 1, 0, 0, 0]
     * [1, 1, 1, 1, 0]
     * [1, 1, 1, 1, 1]
     * [1, 1, 1, 1, 0]
     * [1, 1, 0, 0, 0]
     *
     * @param dimension Dimensión utilizada para crear una matriz cuadrada en la que luego se imprime como se
     *                  vio anteriormente. Si la dimensión es par, se le suma una unidad para volverla impar,
     *                  tal y cómo lo pide el ejericio.
     * @return Una matriz con las características pedidas.
     */
    public int [][] generarMatrizFlecha (int dimension){

        int dim = dimension;

        if ((dim % 2) == 0){
            dim ++;
        }

        int [][] matrix = new int [dim][dim];

        int bound = 0; //"Boundaries".

        for (int i = 0; i < dim - 2 ; i+=2, bound++) {
            for (int j = i; j < i+2; j++) {

                for (int k = 0 + bound; k < dim - bound; k++) {
                    matrix [k][j] = 1;
                }
            }
        }

        matrix [dim/2][dim-1] =1;
        
        return matrix;
    }

}


