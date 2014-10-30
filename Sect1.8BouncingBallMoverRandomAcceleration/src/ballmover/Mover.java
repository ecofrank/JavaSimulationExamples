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
    double topspeed;

    public Mover(DrawingSurface surface) {
        this.surface = surface;
        pDraw = new PDrawSwing(surface);

        location = new DVector(PTools.random(surface.width), PTools.random(surface.height));
        velocity = new DVector(0, 0);
        acceleration = new DVector(-0.001, 0.01);
        topspeed = 10;
    }

    void update() {
        acceleration.set(PTools.random(-1.0, 1.0), PTools.random(-1.0, 1.0));
        velocity.add(acceleration);
        velocity.limit(topspeed);
        location.add(velocity);
    }

    void display() {
        pDraw.stroke(0);
        pDraw.fill(175);
        pDraw.ellipse(location.x, location.y, 16, 16);
    }

    void checkEdges() {
        if (location.x > surface.width) {
            location.x = 0;
        } else if (location.x < 0) {
            location.x = surface.width;
        }

        if (location.y > surface.height) {
            location.y = 0;
        } else if (location.y < 0) {
            location.y = surface.height;
        }
    }
}
