/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingball;

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

    public Mover(DrawingSurface surface) {
        this.surface = surface;
        pDraw = new PDrawSwing(surface);

        location = new DVector(PTools.random(surface.width), PTools.random(surface.height));
        velocity = new DVector(PTools.random(-2, 10), PTools.random(-2, 10));
    }

    void update() {
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
