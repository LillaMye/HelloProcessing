package argaaya.helloprocessing;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Maria on 2016-10-01.
 */
public class ConstantEmitter extends Emitter {

    PApplet m_p;
    PVector m_size;
    float   m_minVelocity, m_maxVelocity;
    int     m_nofParticles;
    boolean m_isDead;

    LinkedList<Particle> m_particles = new LinkedList<Particle>();

    public ConstantEmitter(PApplet pApplet, int nofParticles, PVector position, PVector size, float minVelocity, float maxVelocity){
        m_p            = pApplet;
        m_minVelocity  = minVelocity;
        m_maxVelocity  = maxVelocity;
        m_nofParticles = nofParticles;
        m_size         = new PVector(size.x, size.y);
        m_position     = new PVector(position.x, position.y);
        m_isDead = false;
    }


    public LinkedList<Particle> update (){
        PVector velocity     = new PVector();
        m_particles.clear();

        for (int i = 0; i < m_nofParticles; i++) {
            velocity.set(getRandomVelocity(m_minVelocity, m_maxVelocity));
            m_particles.add(new Particle(m_p, m_size, m_position, velocity));
        }

        return m_particles;
    }

}
