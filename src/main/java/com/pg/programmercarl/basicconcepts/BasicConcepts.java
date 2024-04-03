package com.pg.programmercarl.basicconcepts;

import java.util.*;

/**
 * @author luojx
 * @date 2024/3/16 14:02
 */
public class BasicConcepts {
    public static class Address implements Cloneable {
        private String name;

        public Address(String name) {
            this.name = name;
        }

        @Override
        public Address clone() {
            try {
                return (Address) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    public static class Person implements Cloneable {
        Address address;

        public Person(Address address) {
            this.address = address;
        }

        @Override
        public Person clone() {
            try {
                Person clone = (Person) super.clone();
                // TODO: copy mutable state here, so the clone can't change the internals of the original
//                clone.address = this.address.clone();
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    /*
    浅拷贝：浅拷贝会在堆上创建一个新的对象（区别于引用拷贝的一点），
    不过，如果原对象内部的属性是引用类型的话，浅拷贝会直接复制内部对象的引用地址，也就是说拷贝对象和原对象共用同一个内部对象。
     */
    public static void main(String[] args) {
        Person p1 = new Person(new Address("HK"));
        Person p2 = p1.clone();
        System.out.println(p1.address.equals(p2.address));

//        0100 0000
//        0001 0000
        int n = 64;
        System.out.println(n >>> 2);
        System.out.println(n | (n >>> 2));
        n |= n >>> 2;
        System.out.println("n = " + n);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.forEach(item -> list.remove(item));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("1"))
                iterator.remove();
        }
        System.out.println("list = " + list);
    }
}
