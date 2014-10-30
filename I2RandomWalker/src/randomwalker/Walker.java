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
        int choice = PTools.random(4);
        if (choice == 0) {
            x++;
        } else if (choice == 1) {
            x--;
        } else if (choice == 2) {
            y++;
        } else {
            y--;
        }
    }
}
