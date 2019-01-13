import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JButton button = new JButton("Show Fractal");
        //button.setBounds(170, 20, 140, 40);
        //frame.add(button);
        frame.add(new MJPanel());
        frame.setSize(480, 360);
        //frame.setLayout(null);
        frame.setVisible(true);
    }
}
