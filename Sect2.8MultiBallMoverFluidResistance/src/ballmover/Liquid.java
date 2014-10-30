/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ballmover;

import simulation.PDrawSwing;
import vectortypes.DVector;

/**
 *
 * @author frank
 */
public class Liquid {

    private DrawingSurface surface;
    private PDrawSwing pDraw;
    double x, y, w, h;
    double c;

    public Liquid(DrawingSurface surface, double x_, double y_, double w_, double h_, double c_) {
        this.surface = surface;
        pDraw = new PDrawSwing(surface);

        x = x_;
        y = y_;
        w = w_;
        h = h_;
        c = c_;
    }

    boolean contains(Mover m) {
        DVector l = m.location;
        return l.x > x && l.x < x + w && l.y > y && l.y < y + h;
    }

    DVector drag(Mover m) {
        double speed = m.velocity.getMag();
        double dragMagnitude = c * speed * speed;

        DVector dragForce = m.velocity.clone();
        dragForce.mult(-1);

        dragForce.normalize();
        dragForce.mult(dragMagnitude);
        return dragForce;
    }

    void display() {
        pDraw.noStroke();
        pDraw.fill(175);
        pDraw.rect(x, y, w, h);
    }
}
