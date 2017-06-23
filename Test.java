/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author mzepedeo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("FirstTest");
        flatten(new Object[]{});
        System.out.println("SecondTest");
        flatten(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println("ThirdTest");
        flatten(new Object[]{1, 2, 3, 4, new Object[]{5, 6, 7, 8}, 9, 10});
        System.out.println("FourthTest");
        flatten(new Object[]{1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10});
    }

    public static void flatten(Object[] array) {
        ArrayList<Object> list = flattenP(array);
        Integer[] flat = list.toArray(new Integer[list.size()]);
        for (Integer value : flat) {
            System.out.println(value);
        }

    }

    private static ArrayList<Object> flattenP(Object o) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(o);
        return list;
    }

    private static ArrayList<Object> flattenP(Object[] o) {
        ArrayList<Object> list = new ArrayList<Object>();
        if (o != null) {
            for (int i = 0; i < o.length; i++) {
                if (o[i] instanceof Integer) {
                    list.addAll(flattenP(o[i]));
                } else {
                    Object[] array = (Object[]) o[i];
                    list.addAll(flattenP(array));
                }
            }
        }

        return list;
    }

}
