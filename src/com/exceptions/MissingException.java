package com.exceptions;


/**
 * Do not throw exception objects from finally clauses; you risk losing other exception objects.
 * @author satbeer
 *
 */
class ExceptionA extends RuntimeException {
  ExceptionA() {
    super("Exception A");
  }
}


class ExceptionB extends RuntimeException {
  ExceptionB() {
    super("Exception B");
  }
}


class MissingException {
  public static void main(String[] args) {
   // try {
      methodA();
/*    } catch (ExceptionA e) {
      System.out.println(e.getMessage());
    } catch (ExceptionB e) {
      System.out.println(e.getMessage());
    }*/
  }

  static void methodA() throws ExceptionA, ExceptionB {
    try {
      methodB();
    } finally {
      throw new ExceptionA();
    }
  }

  static void methodB() throws ExceptionB {
    throw new ExceptionB();
  }
}
