package argaaya.helloprocessing;

import java.util.LinkedList;
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

    public void addEmitter (Emitter emitter) {
        m_emitters.add(emitter);
    }

    public boolean isDead (){
        if (m_emitters.size() == 0 && m_particles.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void update () {
        for (Particle P : m_particles){
            if (P.isDead()){
                //TODO m_particles.removeFirstOccurrence(P);
            } else {
                P.update();
            }
        }
        for (Emitter E : m_emitters){
            if (E.isDead()){
               // TODO  m_emitters.removeFirstOccurrence(E);
            } else {
                E.update();
            }
        }
    }

    public void draw() {
        for (Particle P : m_particles){
            P.draw();
        }
    }
}
