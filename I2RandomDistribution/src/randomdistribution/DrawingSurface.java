package randomdistribution;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import simulation.DrawPanel;
import simulation.PDrawSwing;
import simulation.PTools;

/**
 *
 * @author frank
 */
public class DrawingSurface extends DrawPanel {

    private PDrawSwing pDraw;
    private int[] randomCounts;

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);
        randomCounts = new int[10];
    }

    @Override
    public void draw() {
        pDraw.background(Color.white);

        int index = PTools.random(randomCounts.length);

        randomCounts[index]++;

        pDraw.stroke(0);
        pDraw.fill(175);

        int w = width / randomCounts.length;

        for (int x = 0; x < randomCounts.length; x++) {
            pDraw.rect(x * w, height - randomCounts[x], w - 1, randomCounts[x]);
        }
    }
}
