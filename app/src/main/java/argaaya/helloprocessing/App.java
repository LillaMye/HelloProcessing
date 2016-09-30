package argaaya.helloprocessing;

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
        m_pMan  = ParticleSystemManager.getInstance();
        m_pMan.providePapplet(this);
    }

    @Override
    public void mouseDragged() {

    }

    @Override
    public void mousePressed() {
        m_position.set(mouseX, mouseY);

        m_pSys = new ParticleSystem(this, m_image);
        m_pMan.addParticleSystem(m_pSys);
        m_pSys.addModifier(new AgeModifier(10));
        m_pSys.addModifier(new DampingModifier(0.003F));
        m_pSys.addModifier(new PerlinModifier(this));
        m_pSys.addModifier(new ColorModifier(this, color(255,255,255,255), color(255,127,0,255),color(255,0,0,0), 0.7F));
        m_pSys.addEmitter(new AllAtOnceEmitter(this, 1000, m_position, 0.1F, 20F));
    }

    public void draw() {
        m_pMan.update();
        background(0,0,0);
        m_pMan.draw();
    }
}
