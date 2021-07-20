package TestWindowsDoc;

import java.awt.Window; import java.io.IOException;

/**
* A base class representing a window on the screen.
*/
class BaseWindow {
  public BaseWindow() {
  }

  /**
   * A simple method fo adding two values
   * @param a the first value.
   * @param b the second value.
   * @return the desired result.
   * @see MyWindow
   */
  public int method( int a, int b) {
    return a + b;
    }
  }

/**
* <p>A class that represents a windowed dialog on the screen.<br>
* A class representing a window on the screen.<br>
* For example (Example):
* <pre>
* Window win = new Window(parent);
* win.show();
* </pre>
*
* @author <font color="red">Artem Shevchenko</font>
* @version %I%, %G%
* @see TestWindowsDoc.BaseWindow
*/
public class MyWindow extends BaseWindow {

  /**
   * The constant value of this field is the largest value of type
   * {@code char}, {@code '\u005CuFFFF'}.
   *
   * @since 1.0.2
   */
  public static final char MAX_VALUE = '\uFFFF';

  /**
   * A main constructor of this class.
   * @param p1 the first value.
   * @param p2 the second value.
   */
  public MyWindow( int p1, String p2) {}

  /**
   * A simple file read method.
   * @param a the first value.
   * @param b the second value.
   * @return the desired result.
   * @exception IOException
   * if the index is not in the range <code>0</code>
   * to <code>length()-1</code>.
   * @see #method( int a, int b)
   */
  public int inputFile( int a, int b) throws IOException {
    return a + b;
    }
  }