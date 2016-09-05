package argaaya.helloprocessing;

import processing.core.PApplet;


public class App extends PApplet{

    ParticleSystemManager m_pMan;

    public void settings () {
        size (1000, 1000);
    }

    public void setup () {
        m_pMan = new ParticleSystemManager(this);
    }

    public void draw() {
        background(155, 58, 58);
        m_pMan.update();
        m_pMan.draw ();
    }
}
