package argaaya.helloprocessing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class ParticleSystem {

    LinkedList<Particle> m_particles = new LinkedList<Particle>();
    LinkedList<Emitter>  m_emitters  = new LinkedList<Emitter>();
    LinkedList<Modifier> m_modifiers = new LinkedList<Modifier>();

    PApplet m_p;
    PImage  m_image;

    public ParticleSystem (PApplet pApplet, PImage image){
        m_p     = pApplet;
        m_image = image;
    }

    public void addModifier(Modifier modifier){
        m_modifiers.add(modifier);
    }

    public void addEmitter (Emitter emitter) {
        m_emitters.add(emitter);
    }

    public boolean isDead (){
        return (m_emitters.size() == 0 && m_particles.size() == 0);
    }

    public void update () {

        ListIterator<Emitter> emitterItr = m_emitters.listIterator();
        while (emitterItr.hasNext()){
            Emitter currEmitter = emitterItr.next();

            m_particles.addAll(currEmitter.update());

            if (currEmitter.isDead()){
                emitterItr.remove();
            }
        }

        for (Modifier m : m_modifiers){
            m.apply(m_particles);
        }

        ListIterator<Particle> particleItr = m_particles.listIterator();
        while(particleItr.hasNext()){
            Particle currParticle = particleItr.next();

            if (currParticle.isDead()){
                particleItr.remove();
            } else {
                currParticle.update();
            }
        }
    }

    public void draw() {
        m_p.beginShape(m_p.QUADS);
        m_p.texture(m_image);

        for (Particle P : m_particles){
            P.draw();
        }
        m_p.endShape();
    }
}
