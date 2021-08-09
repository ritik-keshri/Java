import java.io.*;
import java.util.*;
import java.lang.*;
class Main{
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String:");
    String s = sc.next();
    StringBuffer sb = new StringBuffer(s);
    System.out.println("Enter location:");
    int pos = sc.nextInt();
    System.out.println("Enter new character:");
    char c = sc.nextChar();
    sb.insert(pos,c);
    System.out.println(sb.toString());
}
