package Test.myStringTest;

import model.MyString;

import java.util.Arrays;

public class TestOrdenarVocalesPrimero {

    public static void main(String[] args) {

        MyString myString = new MyString();

        String str = "ensayo";
        char[] charArray = myString.ordenarSegunVocales(str);

        System.out.println(Arrays.toString(charArray));


    }

}
