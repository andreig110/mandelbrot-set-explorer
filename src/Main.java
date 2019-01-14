import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Create and set up the window.
        JFrame frame = new JFrame("Mandelbrot Set Explorer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new MJPanel());

        // Display the window.
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
