/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomgaussian;

import java.util.Random;
import simulation.DrawPanel;
import simulation.PDrawSwing;

/**
 *
 * @author frank
 */
public class DrawingSurface extends DrawPanel {

    private PDrawSwing pDraw;
    Random generator;

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);

        generator = new Random();
    }

    @Override
    public void draw() {
        double num = generator.nextGaussian();

        double sd = 60;
        double mean = 320;

        double x = sd * num + mean;
        
        pDraw.noStroke();
        pDraw.fill(200,100);
        pDraw.ellipse(x,180,16,16);

    }
}
