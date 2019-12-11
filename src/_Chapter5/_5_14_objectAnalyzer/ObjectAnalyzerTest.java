package _Chapter5._5_14_objectAnalyzer;

import java.util.ArrayList;

public class ObjectAnalyzerTest {
  public static void main(String[] args) {
    var squares = new ArrayList<Integer>();
    for (int i = 1; i <= 5; i++) {
      squares.add(i * i);
    }
    System.out.println(new ObjectAnalyzer().toString(squares));
  }
}
