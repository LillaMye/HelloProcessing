package argaaya.helloprocessing;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Created by Maria on 2016-09-07.
 */
public class AllAtOnceEmitter extends Emitter {

    PApplet m_p;
    PVector m_position;
    int     m_nofParticles;
    float   m_minVelocity, m_maxVelocity;
    boolean m_isDead = false;

    LinkedList<Particle> m_particles = new LinkedList<Particle>();
    LinkedList<Modifier> m_modifiers = new LinkedList<Modifier>();

    PImage m_image;

    AllAtOnceEmitter (PApplet pApplet, LinkedList<Modifier> modifiers, PImage image, int nofParticles, PVector position, float minVelocity, float maxVelocity){
        m_p            = pApplet;
        m_nofParticles = nofParticles;
        m_minVelocity  = minVelocity;
        m_maxVelocity  = maxVelocity;
        m_position     = new PVector(position.x, position.y);
        m_image        = image;

        m_modifiers.addAll(modifiers);
    }

    public LinkedList<Particle> update (){

        if (m_isDead){
            return new LinkedList<Particle>();
        }

        PVector size         = new PVector(18, 18);
        PVector acceleration = new PVector(0.02F, 0.02F);
        PVector velocity     = new PVector();

        for (int i = 0; i < m_nofParticles; i++) {
            velocity.set(getRandomVelocity(m_minVelocity, m_maxVelocity));
            m_particles.add(new Particle(m_p, m_image, size, m_position, velocity, acceleration));
        }

        for (Modifier m : m_modifiers){
            m.addParticles(m_particles);
        }

        m_isDead = true;
        return m_particles;
    }

    public boolean isDead () { return m_isDead; }
}
