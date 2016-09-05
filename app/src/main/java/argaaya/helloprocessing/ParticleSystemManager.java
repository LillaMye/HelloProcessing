package argaaya.helloprocessing;

import processing.core.PApplet;

public class ParticleSystemManager {

    PApplet m_p;
    ParticleSystem m_pSys;

    public ParticleSystemManager (PApplet pApplet){       //TODO: naming
        m_p = pApplet;
        m_pSys = new ParticleSystem(m_p);
    }

    public void update() {
        m_pSys.update();

        if (m_p.mousePressed){
            m_pSys.create(m_p.mouseX, m_p.mouseY);
            m_p.mousePressed = false;
        }
    }

    public void draw() {
        m_pSys.draw ();
    }
}





