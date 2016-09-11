package argaaya.helloprocessing;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

import processing.core.PApplet;

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

        ListIterator<ParticleSystem> pSysItr = m_pSys.listIterator();

        while (pSysItr.hasNext()){
            ParticleSystem curr_pSys = pSysItr.next();

            if (curr_pSys.isDead()){
                pSysItr.remove();
            } else{
                curr_pSys.update();
            }
        }
    }

    public void draw() {
        for (ParticleSystem P : m_pSys) {
            P.draw();
        }
    }
}





