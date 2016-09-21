package argaaya.helloprocessing;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;


public class App extends PApplet{

    ParticleSystemManager m_pMan;
    ParticleSystem        m_pSys;
    PVector               m_position = new PVector();
    PImage                m_image;

    public void settings () {
        fullScreen(P2D);
    }

    public void setup () {
        blendMode(ADD);
        m_image = loadImage("particle_wo_surroundings_small.png");
        m_pMan  = new ParticleSystemManager(this);
    }

    @Override
    public void mouseDragged() {

    }

    @Override
    public void mousePressed() {
        m_position.set(mouseX, mouseY);

        m_pSys = new ParticleSystem(this, m_image);
        m_pMan.addParticleSystem(m_pSys);

        m_pSys.addModifier(new LifespanModifier(10));
        m_pSys.addModifier(new SpeedModifier(-0.03F));
        m_pSys.addModifier(new ColorModifier(0, 5, 3.5F, 5));
        m_pSys.addEmitter(new AllAtOnceEmitter(this, 100, m_position, 0.1F, 5F));
    }

    public void draw() {
        m_pMan.update();
        background(0,0,0);
        m_pMan.draw();
    }
}
