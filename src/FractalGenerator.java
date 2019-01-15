/**
 * Created by andreig110 on 2017-12-03.
 */

public class FractalGenerator {

    private static final int WHITE = 0xffffffff;
    private static final int BLACK = 0xff000000;

    private int[] pixels;
    private final int W;  // image width
    private final int H;  // image height
    // Precalculated variables (for optimization)
    private final boolean W_less_H;
    private final double W_div_H;
    private final double H_div_W;

    public FractalGenerator(int[] pixels, int width, int height) {
        this.pixels = pixels;
        W = width;
        H = height;
        // Precomputation (for optimization)
        W_less_H = W < H;
        W_div_H = (double) W / H;
        H_div_W = (double) H / W;
    }

    public void Generate(double regionCenterX, double regionCenterY, double regionSize) {
        double regionWidth, regionHeight;
        if (W_less_H) {
            regionWidth = regionSize;
            regionHeight = regionWidth * H_div_W;
        }
        else {
            regionHeight = regionSize;
            regionWidth = regionHeight * W_div_H;
        }
            /* The size (width & height) of fractal region is regionSize:
             *      [regionCenterX-regionWidth/2,  regionCenterX+regionWidth/2)
             *      [regionCenterY+regionHeight/2, regionCenterY-regionHeight/2)
             * x:
             *    (left border)    x0  =  regionCenterX - regionWidth/2    (inclusive)
             *    (right border)   xn  =  regionCenterX + regionWidth/2    (exclusive)
             * y:
             *    (top border)     y0  =  regionCenterY + regionHeight/2    (inclusive)
             *    (bottom border)  yn  =  regionCenterY - regionHeight/2    (exclusive)
             */
        double x0 = regionCenterX - regionWidth/2;
        double y0 = regionCenterY - regionHeight/2;
        double delta = regionWidth / W;    //  regionWidth/W  =  regionHeight/H  (must be)

        // X and Y are indexes in pixels[]
        for (int X=0; X<W; X++)
            for (int Y=0; Y<H; Y++)
            {
                double xn = x0 + X*delta;
                double yn = y0 + Y*delta;
                double x = 0.0;
                double y = 0.0;
                int iteration = 0;
                final int MAX_ITERATION = 500;  //1000
                while ( (x*x + y*y < 4)  &&  (iteration < MAX_ITERATION) )
                {
                    double xtemp = x*x - y*y + xn;
                    y = 2*x*y + yn;
                    x = xtemp;
                    iteration++;
                }
                if (iteration < MAX_ITERATION)
                    pixels[X + Y*W] = WHITE;
                else
                    pixels[X + Y*W] = BLACK;
            }
    }

}
