package buncee;

import java.io.*;
import java.util.*;

public class AddNumbers {
	public static void main(String [] args) throws Exception
  {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for (int t = 0; t < n; t++) {
          int a = sc.nextInt();
          int b = sc.nextInt();
          System.out.println(a + b);
      }
  }
}
