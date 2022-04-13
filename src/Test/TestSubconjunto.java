package Test;

import model.Matriz;

import java.util.Arrays;

public class TestSubconjunto {

    public static void main(String[] args) {

        Matriz matriz = new Matriz();

        // Matriz A
        int[][] mA = new int[2][2];
        mA[0] = new int[]{1, 5};
        mA[1] = new int[]{2, 3};

        //Matriz lineal
        int [][] linearMatrix = new int [1][3];
        linearMatrix[0] = new int[]{1,5};

        //Matriz B
        int[][] mB = new int[4][4];
        mB[0] = new int[]{0, 0, 0, 0};
        mB[1] = new int[]{0, 1, 5, 0};
        mB[2] = new int[]{0, 2, 3, 0};
        mB[3] = new int[]{0, 0, 0, 0};


        //A prima
        int[][] matrizA_Prima = new int[2][2];
        matrizA_Prima[0] = new int[]{1, 4};
        matrizA_Prima[1] = new int[]{2, 3};

        //Matriz C
        int[][] mC = new int[3][3];
        mC[0] = new int[]{1, 1, 6};
        mC[1] = new int[]{2, 3, 9};
        mC[2] = new int[]{2, 1, 5};

    //   boolean bool = matriz.esMatrizSubconjunto(mA, mB);
    //   System.out.println("bool 1: " + bool);

    //   boolean bool2 = matriz.esMatrizSubconjunto(mA, matrizA_Prima);
    //   System.out.println("bool 2: " + bool2);

       boolean bool3 = matriz.esMatrizSubconjunto(linearMatrix, mC);
       System.out.println("bool 3:" + bool3);


        //  System.out.println("Es B mayor o igual en dimensiones a A?: " + matriz.esTamañoIgualMayor(B, A));

        //  System.out.println("Es B mayor o igual en dimensiones a A?: " + matriz.esTamañoIgualMayor(X, A));

        //  System.out.println("Es pettit  mayor o igual en dimensiones a A?: " + matriz.esTamañoIgualMayor(pettit, A));

        //  int element = 3;
        //  System.out.println("¿Existe el elemento " + element +" dentro de la matriz A?:  " + matriz.existeElemento(element, A));


        //System.out.println("La posicion del número " + 1 + " es:  " + Arrays.toString(matriz.buscarPosElemento(1, Aprima)));
        //System.out.println("La posicion del número " + 5 + " es:  " + Arrays.toString(matriz.buscarPosElemento(5, Aprima)));
        //System.out.println("La posicion del número " + 2 + " es:  " + Arrays.toString(matriz.buscarPosElemento(2, Aprima)));
        //System.out.println("La posicion del número " + 3 + " es:  " + Arrays.toString(matriz.buscarPosElemento(3, Aprima)));


    }
}
