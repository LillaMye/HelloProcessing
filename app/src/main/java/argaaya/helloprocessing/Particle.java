package argaaya.helloprocessing;

import processing.core.PApplet;

/**
 * Created by Maria on 2016-08-31.
 */
public class Particle {

    PApplet Parent = null;

    public Particle(ParticleManager particleManager) {
        Parent = particleManager;
    }

    public void draw(float X, float Y, int size) {
        Parent.ellipse(X, Y, size, size);
    }

}
