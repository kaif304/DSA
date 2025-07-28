package oops.wrapperclasses;

import java.util.ArrayList;

public class IntegerWrapping {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
        /*
        if I want to use int value inside ArrayLists, I can't use it,
        because array list itself work as an object so, it can work with objects only.

        So if I convert this int value into an object then I can use it with ArrayList,
        ArrayList can now store int values but, in the form of objects.

        see the conversion and use below
        */

        Integer aInObjectForm = a; // this is called autoboxing
        int b = aInObjectForm; // this is called unboxing

        ArrayList<Integer> list = new ArrayList<>();
        list.add(aInObjectForm);
        System.out.println(list);
    }
}
