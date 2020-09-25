package com.ykqfrost.test;

/**
 * @author ykq
 * @date 2020/9/9
 */
public class HashMapTest {

    public static void main(String[] args) {
//        System.out.println(tableSizeFor(9));
//        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        Integer c = Integer.valueOf(-129);
        Integer d = Integer.valueOf(-129);

        System.out.println("aa".hashCode());
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}
