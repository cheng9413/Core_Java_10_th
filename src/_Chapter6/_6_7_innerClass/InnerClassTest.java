package _Chapter6._6_7_innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {
  public static void main(String[] args) {
    var clock = new TalkingClock(1000, true);
    clock.start();

    // keep program running until user selects "OK"
    JOptionPane.showMessageDialog(null, "Quit program?");
    System.exit(0);
  }
}

/** A clock that prints the time in regular intervals */
class TalkingClock {
  private int interval;
  private boolean beep;

  /**
   * Construct a talking clock
   *
   * @param interval between messages (in milliseconds)
   * @param beep true if the clock should beep
   */
  public TalkingClock(int interval, boolean beep) {
    this.interval = interval;
    this.beep = beep;
  }

  /** Starts the clock */
  public void start() {
    var listener = new TimePrinter();
    var t = new Timer(interval, listener);
    t.start();
  }

  public class TimePrinter implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("At the tone, the time is " + new Date());
      if (beep) {
        Toolkit.getDefaultToolkit().beep();
      }
    }
  }
}
