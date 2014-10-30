/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ballmover;

import simulation.PDrawSwing;
import simulation.PTools;
import vectortypes.DVector;

/**
 *
 * @author frank
 */
public class Attractor {

    private DrawingSurface surface;
    private PDrawSwing pDraw;
    double mass;
    DVector location;
    double G;
    boolean dragging = false;
    boolean rollover = false;
    DVector dragOffset;

    public Attractor(DrawingSurface surface) {
        this.surface = surface;
        pDraw = new PDrawSwing(surface);

        location = new DVector(surface.width / 2, surface.height / 2);
        mass = 20;
        G = 1;
        dragOffset = new DVector(0.0, 0.0);
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

    void display() {
        pDraw.strokeWeight(4);
        pDraw.stroke(0);
        if (dragging) {
            pDraw.fill(50);
        } else if (rollover) {
            pDraw.fill(100);
        } else {
            pDraw.fill(175, 200);
        }
        pDraw.ellipse(location.x, location.y, mass * 2, mass * 2);
    }
    
    void drag() {
        if (dragging) {
            location.x = surface.mouseX+dragOffset.x;
            location.y = surface.mouseY+dragOffset.y;
        }
    }
}
