package argaaya.helloprocessing;

import processing.core.PApplet;

public class ParticleSystem {

    Particle[] m_particles = new Particle[100];
    PApplet    m_p;
    int        m_nofParticles;

    public ParticleSystem (PApplet pApplet){
        m_p = pApplet;
        m_nofParticles = 0;
    }

    public void create (int x, int y){
        m_particles[m_nofParticles] = new Particle(m_p,x,y,50,2,2);
        m_nofParticles++;
    }

    public void update () {
        if (m_nofParticles > 0) {
            m_particles[0].update();
        }
    }

    public void draw() {
        if (m_nofParticles > 0) {
            m_particles[0].draw();
        }
    }
}
