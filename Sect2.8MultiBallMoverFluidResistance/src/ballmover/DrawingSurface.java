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
    Liquid liquid;
    Mover[] movers = new Mover[10];

    @Override
    public void setup() {
        pDraw = new PDrawSwing(this);
        for (int i = 0; i < movers.length; i++) {
            movers[i] = new Mover(this, PTools.random(0.5, 3), 40+i*70, 0);
        }
        liquid =  new Liquid(this,0,height/2,width,height/2,0.1);
    }

    @Override
    public void draw() {
        pDraw.background(Color.white);

        liquid.display();

        // Every cycle for every mover apply forces and update
        for (int i = 0; i < movers.length; i++) {
            
            if (liquid.contains(movers[i])) {
                DVector dragForce = liquid.drag(movers[i]);
                movers[i].applyForce(dragForce);
            }
         
            DVector gravity = new DVector(0,0.1*movers[i].mass);
            movers[i].applyForce(gravity);
            
            movers[i].update();
            movers[i].display();
            movers[i].checkEdges();
        }
    }
}
