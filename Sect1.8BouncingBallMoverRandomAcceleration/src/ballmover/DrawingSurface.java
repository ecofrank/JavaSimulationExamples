/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ballmover;

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
    Mover mover;    

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);
        mover = new Mover(this);
    }

    @Override
    public void draw() {
       // pDraw.background(Color.white);

        mover.update();
        mover.checkEdges();
        mover.display();
    }
}
