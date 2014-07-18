package com.processing.text;

// Country search
import java.io.*;

class CS {
  static String[] countries = {"Argentina", "Australia", "Bolivia", "Brazil", "Canada", "Chile", "China", "Denmark",
      "Egypt", "England", "France", "India", "Iran", "Ireland", "Iraq", "Israel", "Japan", "Jordan", "Pakistan",
      "Russia", "Scotland", "South Africa", "Sweden", "Syria", "United States"};

  public static void main(String[] args) {
    int i;
    if (args.length != 1) {
      System.err.println("usage: java CS country-name");
      return;
    }
    String country = args[0];
    // First search attempt using == operator
    for (i = 0; i < countries.length; i++)
      if (country == countries[i]) {
        System.out.println(country + " found");
        break;
      }
    if (i == countries.length) System.out.println(country + " not found");
    // Intern country string
    country = country.intern();
    // Second search attempt using == operator
    for (i = 0; i < countries.length; i++)
      if (country == countries[i]) {
        System.out.println(country + " found");
        break;
      }
    if (i == countries.length) System.out.println(country + " not found");
  }
}
