package Test;

import java.util.Arrays;

public class RandomTest {


    public static void main(String[] args) {

        int[][] matrix = new int[1][3];

        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], 1);
        }

        for (int i = 0; i < matrix.length ; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
