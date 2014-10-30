/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomwalker;

import simulation.DrawPanel;

/**
 *
 * @author frank
 */
public class DrawingSurface extends DrawPanel {

    Walker w;

    @Override
    public void setup() {
        w = new Walker(this);
    }

    @Override
    public void draw() {
        w.step();
        w.display();
    }
}
