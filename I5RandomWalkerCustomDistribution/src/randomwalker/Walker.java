/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomwalker;

import java.awt.Color;
import simulation.PDrawSwing;
import simulation.PTools;

/**
 *
 * @author frank
 */
public class Walker {

    private PDrawSwing pDraw;
    private int x;
    private int y;

    public Walker(DrawingSurface surface) {
        pDraw = new PDrawSwing(surface);
        x = surface.width / 2;
        y = surface.height / 2;
    }

    public void display() {
        pDraw.setColor(Color.black);
        pDraw.point(x, y);
    }

    public void step() {
        double xstep;
        double ystep;
        double r = PTools.random(1.0);
        if (r < 0.01) {
            xstep = PTools.random(-100, 100);
            ystep = PTools.random(-100, 100);
        } else {
            xstep = PTools.random(3) - 1;
            ystep = PTools.random(3) - 1;
        }

        x += xstep;
        y += ystep;
    }
}
