package _Chapter5._5_12_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
  public static void main(String[] args) {
    // read class name from command line args or user input
    String name;
    if (args.length > 0) {
      name = args[0];
    } else {
      var in = new Scanner(System.in);
      System.out.println("Enter class name (e.g. java.util.Date): ");
      name = in.next();
    }

    try {
      // print class name and superclass name (if != Object)
      var cl = Class.forName(name);
      var supercl = cl.getSuperclass();
      var modifiers = Modifier.toString(cl.getModifiers());
      if (modifiers.length() > 0) {
        System.out.print(modifiers + " ");
      }
      System.out.print("class " + name);
      if (supercl != null && supercl != Object.class) {
        System.out.print(" extends " + supercl.getName());
      }
      System.out.println("\n{\n");
      printConstructors(cl);
      System.out.println();
      printMethods(cl);
      System.out.println();
      printFields(cl);
      System.out.println("}");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.exit(0);
  }

  private static void printFields(Class<?> cl) {
    var fields = cl.getDeclaredFields();

    for (var f : fields) {
      var type = f.getType();
      var name = f.getName();
      System.out.print("    ");
      var modifiers = Modifier.toString(f.getModifiers());
      if (modifiers.length() > 0) {
        System.out.print(modifiers + " ");
      }
      System.out.println(type.getName() + " " + name + ";");
    }
  }

  private static void printMethods(Class<?> cl) {
    var methods = cl.getDeclaredMethods();

    for (var m : methods) {
      var retType = m.getReturnType();
      var name = m.getName();

      System.out.print("    ");
      // print modifiers, return type and method name
      var modifiers = Modifier.toString(m.getModifiers());
      if (modifiers.length() > 0) {
        System.out.print(modifiers + " ");
      }
      System.out.print(retType.getName() + " " + name + "(");

      // print parameter types
      var paraTypes = m.getParameterTypes();
      for (int j = 0; j < paraTypes.length; j++) {
        if (j > 0) {
          System.out.print(", ");
        }
        System.out.print(paraTypes[j].getName());
      }
      System.out.println(");");
    }
  }

  private static void printConstructors(Class<?> cl) {
    var constructors = cl.getDeclaredConstructors();

    for (var c : constructors) {
      var name = c.getName();
      System.out.print("    ");
      var modifiers = Modifier.toString(c.getModifiers());
      if (modifiers.length() > 0) {
        System.out.print(modifiers + " ");
      }
      System.out.print(name + "(");

      // print parameter types
      var paraTypes = c.getParameterTypes();
      for (int j = 0; j < paraTypes.length; j++) {
        if (j > 0) {
          System.out.print(", ");
        }
        System.out.print(paraTypes[j].getName());
      }
      System.out.println(");");
    }
  }
}
