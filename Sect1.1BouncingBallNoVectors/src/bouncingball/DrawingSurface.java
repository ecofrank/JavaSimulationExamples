/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingball;

import java.awt.Color;
import simulation.DrawPanel;
import simulation.PDrawSwing;

/**
 *
 * @author frank
 */
public class DrawingSurface extends DrawPanel {

    private PDrawSwing pDraw;
    double x = 100;
    double y = 100;
    double xspeed = 1;
    double yspeed = 3.3;

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);
        pDraw.background(Color.white);
    }

    @Override
    public void draw() {
        pDraw.background(Color.white);

        x = x + xspeed;
        y = y + yspeed;

        if ((x > width) || (x < 0)) {
            xspeed = xspeed * -1;
        }

        if ((y > height) || (y < 0)) {
            yspeed = yspeed * -1;
        }

        pDraw.stroke(0);
        pDraw.fill(175);
        pDraw.ellipse(x, y, 16, 16);

    }
}
