/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ballmover;

import java.awt.Color;
import simulation.DrawPanel;
import simulation.PDrawSwing;
import vectortypes.DVector;

/**
 *
 * @author frank
 */
public class DrawingSurface extends DrawPanel {

    private PDrawSwing pDraw;
    Mover[] movers = new Mover[20];

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);
        for (int i = 0; i < movers.length; i++) {
            movers[i] = new Mover(this);
        }
    }

    @Override
    public void draw() {
         pDraw.background(Color.white);

        for (int i = 0; i < movers.length; i++) {
            movers[i].update();
            movers[i].checkEdges();
            movers[i].display();
        }
    }
}
