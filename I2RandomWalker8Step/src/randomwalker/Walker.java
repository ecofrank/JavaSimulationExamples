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
        int stepx = PTools.random(3) - 1; // gives random step {-1,0,1} for x
        int stepy = PTools.random(3) - 1; // for y

        x += stepx;
        y += stepy;
    }
}
