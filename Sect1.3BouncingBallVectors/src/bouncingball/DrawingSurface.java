/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingball;

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
    DVector location;
    DVector velocity;

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);
        location = new DVector(100, 100);
        velocity = new DVector(2.5, 5);
    }

    @Override
    public void draw() {
        pDraw.background(Color.white);

        location.add(velocity);

        if ((location.x > width) || (location.x < 0)) {
            velocity.x = velocity.x * -1;
        }

        if ((location.y > height) || (location.y < 0)) {
            velocity.y = velocity.y * -1;
        }

        pDraw.stroke(0);
        pDraw.fill(175);
        pDraw.ellipse(location.x, location.y, 16, 16);
    }
}
