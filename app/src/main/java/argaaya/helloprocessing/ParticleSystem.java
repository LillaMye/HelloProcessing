package argaaya.helloprocessing;

import processing.core.PApplet;

/**
 * Created by Maria on 2016-09-04.
 */
public class ParticleSystem {

    Particle[]             p = new Particle[100];
    ParticleSystemManager  Parent;
    int                    i, currentParticle = 0;

    public ParticleSystem (ParticleSystemManager particleSystemManager){
        Parent = particleSystemManager;
    }

    public void settings () {
    }

    public void setup() {
        p[currentParticle] = new Particle(Parent, 50, 500, 50, 1, 1, 1, 1);
        currentParticle++;
    }

    public void update () {
        for (i = 0; i < currentParticle; i++){
            p[i].update ();
        }
    }
    public void draw() {
        if (Parent.mousePressed){
            p[currentParticle] = new Particle(Parent, Parent.mouseX, Parent.mouseY, 10, (float)0.1, (float)0.1, (float)0.1, (float)0.1);
            currentParticle++;
            Parent.mousePressed = false;
        }

        for (i = 0; i < currentParticle; i++){
            p[i].draw ();
        }
    }
}
