package argaaya.helloprocessing;

import java.util.LinkedList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PVector;

public class ParticleSystemManager {

    PApplet        m_p;
    LinkedList<ParticleSystem> m_pSys = new LinkedList<ParticleSystem>();

    public ParticleSystemManager (PApplet papplet){
        m_p = papplet;
    }

    public void addParticleSystem (ParticleSystem pSys){
        m_pSys.add(pSys);
    }

    public void update() {
        for (ParticleSystem P : m_pSys) {
            P.update();
        }
    }

    public void draw() {
        for (ParticleSystem P : m_pSys) {
            if (P.isDead()) {
                //TODO
            } else {
                P.draw();
            }
        }
    }
}





