package _Chapter5._5_4_abstractClasses;

public abstract class Person {

  public abstract String getDescription();
  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
