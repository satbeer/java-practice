package com.exceptions;


// TranslatedExceptionDemo1.java
class TranslatedExceptionDemo1 {
  public static void main(String[] args) {
    try {
      Library.methodA(); // Line 9.
    } catch (Library.ExternalException e) {
      System.out.println(e.getMessage());
      // Send stack trace to standard output device, instead of
      // default standard error device.
      e.printStackTrace(System.out);
    }
  }
}


class Library {
  static void methodA() throws ExternalException {
    try {
      methodB();
    } catch (InternalException e) {
      System.out.println(e.getMessage());
      throw new ExternalException(); // Line 35.
    }
  }

  static class ExternalException extends Exception {
    ExternalException() {
      super("External Exception");
    }
  }

  private static void methodB() throws InternalException {
    throw new InternalException();
  }

  private static class InternalException extends Exception {
    InternalException() {
      super("Internal Exception");
    }
  }
}
