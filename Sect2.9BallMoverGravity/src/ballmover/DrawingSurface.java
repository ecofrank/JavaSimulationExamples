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
    Mover m;
    Attractor a;

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);

        m = new Mover(this);
        a = new Attractor(this);
    }

    @Override
    public void draw() {
        pDraw.background(Color.white);

        DVector force = a.attract(m);
        
        m.applyForce(force);

        m.update();
        a.display();
        m.display();
    }
}
