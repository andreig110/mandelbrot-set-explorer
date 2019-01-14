import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MJPanel extends JPanel {

    private static final int WIDTH = 640;  // panel width
    private static final int HEIGHT = 480;  // panel height
    private int[] pixels = new int[WIDTH * HEIGHT];
    private BufferedImage bufferedImage;

    private FractalGenerator fractalGenerator;

    public MJPanel() {
        bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        fractalGenerator = new FractalGenerator(pixels, WIDTH, HEIGHT);
        fractalGenerator.Generate(-0.75, 0, 3.5);
        bufferedImage.setRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null);
    }
}
