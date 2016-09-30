package argaaya.helloprocessing;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Created by Maria on 2016-09-07.
 */
public class AllAtOnceEmitter extends Emitter {

    PVector m_position;
    int     m_nofParticles;
    float   m_minVelocity, m_maxVelocity;

    LinkedList<Particle> m_particles = new LinkedList<Particle>();

    AllAtOnceEmitter (PApplet pApplet, int nofParticles, PVector position, float minVelocity, float maxVelocity){
        m_p            = pApplet;
        m_nofParticles = nofParticles;
        m_minVelocity  = minVelocity;
        m_maxVelocity  = maxVelocity;
        m_position     = new PVector(position.x, position.y);
    }

    public LinkedList<Particle> update (){

        PVector size         = new PVector(15, 15);
        PVector acceleration = new PVector(0, 0);
        PVector velocity     = new PVector();

        for (int i = 0; i < m_nofParticles; i++) {
            velocity.set(getRandomVelocity(m_minVelocity, m_maxVelocity));
            m_particles.add(new Particle(m_p, size, m_position, velocity, acceleration));
        }

        m_isDead = true;
        return m_particles;
    }

    public boolean isDead () { return m_isDead; }
}
