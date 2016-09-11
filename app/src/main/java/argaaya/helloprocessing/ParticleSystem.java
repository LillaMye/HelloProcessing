package argaaya.helloprocessing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import processing.core.PApplet;
import processing.core.PVector;

public class ParticleSystem {

    LinkedList<Particle> m_particles = new LinkedList<Particle>();
    LinkedList<Emitter>  m_emitters  = new LinkedList<Emitter>();
    PApplet    m_p;

    public ParticleSystem (PApplet pApplet){
        m_p = pApplet;
    }

    public void addParticle(Particle particle){
        m_particles.add(particle);
    }

    public void addParticleList(LinkedList<Particle> particles){
        m_particles.addAll(particles);
    }

    public void addEmitter (Emitter emitter) {
        m_emitters.add(emitter);
    }

    public boolean isDead (){
        return (m_emitters.size() == 0 && m_particles.size() == 0);
    }

    public void update () {

        ListIterator<Particle> particleItr = m_particles.listIterator();

        while(particleItr.hasNext()){
            Particle currParticle = particleItr.next();

            if (currParticle.isDead()){
                particleItr.remove();
            } else {
                currParticle.update();
            }
        }

        ListIterator<Emitter> emitterItr = m_emitters.listIterator();

        while (emitterItr.hasNext()){
            Emitter currEmitter = emitterItr.next();

            if (currEmitter.isDead()){
                emitterItr.remove();
            } else{
                m_particles.addAll(currEmitter.update());
            }
        }
    }

    public void draw() {
        for (Particle P : m_particles){
            P.draw();
        }
    }
}
