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

    public Mover(DrawingSurface surface, double m, double x, double y) {
        this.surface = surface;
        pDraw = new PDrawSwing(surface);

        mass = m;

        location = new DVector(x, y);
        velocity = new DVector(0, 0);
        acceleration = new DVector(0, 0);
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
        pDraw.strokeWeight(2);
        pDraw.fill(175);
        pDraw.ellipse(location.x, location.y, mass*16, mass*16);
    }

    void checkEdges() {
        if (location.x > surface.width) {
            location.x = 0;
        } else if (location.x < 0) {
            location.x = surface.width;
        }

        if (location.y > surface.height) {
            velocity.y *= -1;
            location.y = surface.height;
        }
    }
}
