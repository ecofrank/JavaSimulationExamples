/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ballmover;

import java.awt.Color;
import simulation.DrawPanel;
import simulation.PDrawSwing;
import simulation.PTools;
import vectortypes.DVector;

/**
 *
 * @author frank
 */
public class DrawingSurface extends DrawPanel {

    private PDrawSwing pDraw;
    Mover[] movers;
    double g = 0.4;

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);

        movers = new Mover[10];

        for (int i = 0; i < movers.length; i++) {
            movers[i] = new Mover(this, PTools.random(0.1, 2), PTools.random(width), PTools.random(height));
        }
    }

    @Override
    public void draw() {
        pDraw.background(Color.white);


        for (int i = 0; i < movers.length; i++) {
            for (int j = 0; j < movers.length; j++) {
                if (i != j) {
                    DVector force = movers[j].attract(movers[i]);
                    movers[i].applyForce(force);
                }
            }
            movers[i].update();
            movers[i].display();
        }
    }
}
