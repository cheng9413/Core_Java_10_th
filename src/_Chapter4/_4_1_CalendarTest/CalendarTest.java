package _Chapter4._4_1_CalendarTest;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarTest {
  public static void main(String[] args) {
    var date = LocalDate.now();
    var month = date.getMonthValue();
    var today = date.getDayOfMonth();

    date = date.minusDays(today - 1); // Set to start of month
    var weekday = date.getDayOfWeek();
    var value = weekday.getValue(); // 1 = Monday, ...7 = Sunday

    System.out.println("Mon Tue Wed Thu Fri Sat Sun");
    for (int i = 1; i < value; i++) {
    System.out.print("    ");
    }
    while (date.getMonthValue() == month) {
      System.out.printf("%3d", date.getDayOfMonth());
      if (date.getDayOfMonth() == today) {
        System.out.print("*");
      } else {
        System.out.print(" ");
      }
      date = date.plusDays(1);
      if (date.getDayOfWeek().getValue() == 1) {
        System.out.println();
      }
    }
    if (date.getDayOfWeek().getValue() != 1) {
      System.out.println();
    }
  }
}
