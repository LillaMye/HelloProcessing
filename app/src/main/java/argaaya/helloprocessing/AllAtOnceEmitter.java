package argaaya.helloprocessing;

import java.util.LinkedList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Maria on 2016-09-07.
 */
public class AllAtOnceEmitter extends Emitter {

    static float PI = 3.14159265358979323846F;

    PApplet m_p            = new PApplet();
    Random  m_rnd          = new Random();
    PVector m_velocity     = new PVector();
    PVector m_size         = new PVector();
    PVector m_acceleration = new PVector();
    PVector m_position     = new PVector();
    boolean m_isDead       = false;
    int     m_nofParticles;
    int     m_minVelocity, m_maxVelocity;

    LinkedList<Particle> m_particles = new LinkedList<Particle>();

    AllAtOnceEmitter (PApplet pApplet, int nofParticles, PVector position, int minVelocity, int maxVelocity){
        m_p            = pApplet;
        m_nofParticles = nofParticles;
        m_position.set(position);
        m_minVelocity = minVelocity;
        m_maxVelocity = maxVelocity;

    }

    public LinkedList<Particle> update (){

        m_size.set(15,15);
        m_acceleration.set(0,0);

        for (int i = 0; i < m_nofParticles; i++){
            m_velocity.set(getRandomVelocity(m_minVelocity, m_maxVelocity));
            m_particles.add(new Particle(m_p, m_size, m_position, m_velocity, m_acceleration));
        }

        m_isDead = true;
        return m_particles;
    }

    public boolean isDead () { return m_isDead; }
}
