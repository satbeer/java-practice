package com.processing.text;

// Hexadecimal to Decimal
class HexDec {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("usage: java HexDec hex-character-sequence");
      return;
    }
    // Convert argument from hexadecimal to decimal
    int dec = 0;
    String s = args[0];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i); // Extract character
      // If character is an uppercase letter, convert character to
      // lowercase
      if (Character.isUpperCase(c)) c = Character.toLowerCase(c);
      if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f')) {
        System.err.println("invalid character detected");
        return;
      }
      dec <<= 4;
      if (c <= '9')
        dec += (c - '0');
      else
        dec += (c - 'a' + 10);
    }
    System.out.println("decimal equivalent = " + dec);
  }
}
