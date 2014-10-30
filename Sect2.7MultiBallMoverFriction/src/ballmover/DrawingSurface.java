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
    Mover[] movers = new Mover[10];

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);
        for (int i = 0; i < movers.length; i++) {
            movers[i] = new Mover(this, PTools.random(0.1, 5), 0, 0);
        }
    }

    @Override
    public void draw() {
        pDraw.background(Color.white);


        // Every cycle for every mover apply forces and update
        for (int i = 0; i < movers.length; i++) {

            DVector wind = new DVector(0.001, 0.0); // wind force is 0.01 to the right
            DVector gravity = new DVector(0, 0.1 * movers[i].mass); // Scaling gravity by mass to be more accurate

            double c = 0.01;
            DVector friction = movers[i].velocity.clone();

            friction.mult(-1);
            try {
                friction.normalize();
                friction.mult(c);

                movers[i].applyForce(friction);
            } catch (ArithmeticException ex) {
                // Don't do anything
            }
            movers[i].applyForce(wind);
            movers[i].applyForce(gravity);

            movers[i].update();
            movers[i].display();
            movers[i].checkEdges();
        }
    }
}
