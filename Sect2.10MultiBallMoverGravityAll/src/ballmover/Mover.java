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
    double G;

    public Mover(DrawingSurface surface,double m, double x, double y) {
        this.surface = surface;
        pDraw = new PDrawSwing(surface);

        mass = m;
         G = 1;

        location = new DVector(x,y);
        velocity = new DVector(1, 0);
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
        pDraw.strokeWeight(1);
        pDraw.fill(127);
        pDraw.ellipse(location.x, location.y, 16, 16);
    }
    
    DVector attract(Mover m) {
        DVector force = DVector.getDiff(location, m.location);
        double d = force.getMag();
        d = PTools.constrain(d, 5.0, 25.0);

        force.normalize();
        double strength = (G * mass * m.mass) / (d * d);
        force.mult(strength);
        return force;
    }
}
