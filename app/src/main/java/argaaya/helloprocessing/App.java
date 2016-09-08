package argaaya.helloprocessing;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PVector;


public class App extends PApplet{

    ParticleSystemManager m_pMan;
    ParticleSystem        m_pSys;
    AllAtOnceEmitter      m_emitter;
    Random                m_rnd          = new Random();
    PVector               m_position     = new PVector();
    PVector               m_size         = new PVector();
    PVector               m_velocity     = new PVector();
    PVector               m_acceleration = new PVector();

    public void settings () {
        fullScreen();
    }

    public void setup () {
        m_pMan = new ParticleSystemManager(this);
    }

    public void draw() {
        m_pMan.update();

        if (mousePressed){
            m_position.set(mouseX, mouseY);

            m_pSys    = new ParticleSystem(this);
            m_emitter = new AllAtOnceEmitter(this, m_pSys, 200, m_position, 2, 8);

            m_pSys.addEmitter(m_emitter);
            m_pMan.addParticleSystem(m_pSys);

            mousePressed = false;
        }

        background(0, 0x33, 0);
        m_pMan.draw();
    }
}
