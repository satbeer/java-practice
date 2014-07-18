package com.exceptions;

class TranslatedExceptionDemo2 {
  public static void main(String[] args) {
    try {
      Library1.methodA(); // Line 9.
    } catch (Library1.ExternalException e) {
      System.out.println(e.getMessage());
      // Send stack trace to standard output device, instead of
      // default standard error device.
      e.printStackTrace(System.out);
    }
  }
}


class Library1 {
  static void methodA() throws ExternalException {
    try {
      methodB(); // Line 29.
    } catch (InternalException e) {
      System.out.println(e.getMessage());
      ExternalException ee = new ExternalException(e); // Line 35.
      throw ee;
    }
  }

  static class ExternalException extends Exception {
    ExternalException() {
      super("External Exception");
    }
    ExternalException(Throwable t){
      super(t);
    }
  }

  private static void methodB() throws InternalException {
    throw new InternalException(); // Line 51.
  }

  private static class InternalException extends Exception {
    InternalException() {
      super("Internal Exception");
    }
  }
}
