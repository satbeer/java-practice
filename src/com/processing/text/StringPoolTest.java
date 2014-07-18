package com.processing.text;

public class StringPoolTest {
  
  public static void main(String[] args) {
    String a = "123";
    String b = "123";
    String f = "1234";
    String g = f.intern();
    String d = "1234";
    String i = a + "4";
    String c = new String (a);
    System.out.println ("a == b: " + (a == b));
    System.out.println ("a == c: " + (a == c));
    System.out.println(g==i);
  }

}
