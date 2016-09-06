package argaaya.helloprocessing;

import java.util.LinkedList;
import processing.core.PApplet;
import processing.core.PVector;

public class ParticleSystem {

    LinkedList<Particle> m_particles = new LinkedList<Particle>();
    PApplet    m_p;

    public ParticleSystem (PApplet pApplet){
        m_p            = pApplet;
    }

    public void create (PVector size, PVector position, PVector velocity, PVector acceleration){
        m_particles.add(new Particle(m_p, size, position, velocity, acceleration));
    }

    public void update () {
        for (Particle P : m_particles){
            P.update();
        }
    }

    public void draw() {
        for (Particle P : m_particles){
            P.draw();
        }
    }
}
