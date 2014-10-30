/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ballmover;

import java.awt.Graphics2D;
import simulation.PDrawSwing;
import simulation.PTools;
import vectortypes.DVector;

/**
 *
 * @author frank
 */
public class Mover {

    private DrawingSurface surface;
    private PDrawSwing pDraw;
    DVector location;
    DVector velocity;
    DVector acceleration;
    double mass;

    public Mover(DrawingSurface surface) {
        this.surface = surface;
        pDraw = new PDrawSwing(surface);

        location = new DVector(400,50);
        velocity = new DVector(1, 0);
        acceleration = new DVector(0, 0);

        mass = 1;
    }

    void applyForce(DVector force) {
        DVector f = DVector.getDiv(force, mass);
        acceleration.add(f);
    }

    void update() {
        velocity.add(acceleration);
        location.add(velocity);
        acceleration.mult(0.0); // zero acceleration
    }

    void display() {
        pDraw.stroke(0);
        pDraw.strokeWeight(1);
        pDraw.fill(127);
        pDraw.ellipse(location.x, location.y, 16, 16);
    }
}
