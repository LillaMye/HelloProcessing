package argaaya.helloprocessing;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PVector;

public class ParticleSystemManager {

    PApplet        m_p;
    ParticleSystem m_pSys;
    Random         m_rnd = new Random();

    public ParticleSystemManager (PApplet papplet){
        m_p = papplet;
        m_pSys = new ParticleSystem(m_p);
    }

    public void update() {
        m_pSys.update();

        if (m_p.mousePressed){
            // hjäääälp
            PVector m_position     = new PVector(m_p.mouseX, m_p.mouseY);
            PVector m_size         = new PVector(30, 30);
            PVector m_velocity     = new PVector(m_rnd.nextInt(15)-7, m_rnd.nextInt(15)-7);
            PVector m_acceleration = new PVector(0, 0);

            m_pSys.create(m_size, m_position, m_velocity, m_acceleration);
            m_p.mousePressed = false;
        }
    }

    public void draw() {
        m_pSys.draw ();
    }
}





