package _Chapter5._5_14_objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
  private ArrayList<Object> visited = new ArrayList<>();

  public String toString(Object obj) {
    if (obj == null) {
      return null;
    }
    if (visited.contains(obj)) {
      return "...";
    }
    visited.add(obj);
    var cl = obj.getClass();
    if (cl == String.class) {
      return (String) obj;
    }
    if (cl.isArray()) {
      var r = new StringBuilder(cl.getComponentType() + "[]{");
      for (int i = 0; i < Array.getLength(obj); i++) {
        if (i > 0) {
          r.append(",");
        }
        var val = Array.get(obj, i);
        if (cl.getComponentType().isPrimitive()) {
          r.append(val);
        } else {
          r.append(toString(val));
        }
      }
      return r + "}";
    }

    var r = new StringBuilder(cl.getName());
    // inspect the fields of this class and all superclass
    do {
      r.append("[");
      var fields = cl.getDeclaredFields();
      AccessibleObject.setAccessible(fields, true);
      // get the names and values of all fields
      for (var f : fields) {
        if (!Modifier.isStatic(f.getModifiers())) {
          if (!r.toString().endsWith("[")) {
            r.append(",");
          }
          r.append(f.getName()).append("=");
          try {
            var t = f.getType();
            var val = f.get(obj);
            if (t.isPrimitive()) {
              r.append(val);
            } else {
              r.append(toString(val));
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
      r.append("]");
      cl = cl.getSuperclass();
    } while (cl != null);

    return r.toString();
  }
}
