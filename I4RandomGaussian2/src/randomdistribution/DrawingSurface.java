package randomdistribution;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.util.Random;
import simulation.DrawPanel;
import simulation.PDrawSwing;
import simulation.PTools;

/**
 *
 * @author frank
 */
public class DrawingSurface extends DrawPanel {

    private PDrawSwing pDraw;
    private Random generator;
    private int[] randomCounts;

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);

        generator = new Random();
        randomCounts = new int[100];
    }

    @Override
    public void draw() {
        pDraw.background(Color.white);
        double num = generator.nextGaussian();  // number between 0 and 1

        double sd = 10.0;
        double mean = randomCounts.length / 2.0;

        int index = (int) (sd * num + mean);

        if (index >= 0 && index < randomCounts.length) {

            randomCounts[index]++;

            pDraw.stroke(0);
            pDraw.fill(175);

            int w = width / randomCounts.length;

            for (int x = 0; x < randomCounts.length; x++) {
                pDraw.rect(x * w, height - randomCounts[x], w - 1, randomCounts[x]);
            }
        }
    }
}
