package argaaya.helloprocessing;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Maria on 2016-09-07.
 */
public class AllAtOnceEmitter extends Emitter {

    Random m_rnd = new Random();

    AllAtOnceEmitter (PApplet pApplet, ParticleSystem pSys, int nofParticles, PVector position, int minVelocity, int maxVelocity){

        for (int i = 0; i < nofParticles; i++){
            PVector velocity     = new PVector((m_rnd.nextInt(201)-100),(m_rnd.nextInt(201)-100));
            PVector size         = new PVector(15,15);
            PVector acceleration = new PVector(0,0);

            velocity.setMag(m_rnd.nextInt(1+maxVelocity-minVelocity) + minVelocity + m_rnd.nextFloat());
            pSys.addParticle(new Particle(pApplet, size, position, velocity, acceleration));
        }
    }

    public void update (){}

    public boolean isDead () { return true; }
}
