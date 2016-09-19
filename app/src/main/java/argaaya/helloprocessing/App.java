package argaaya.helloprocessing;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;


public class App extends PApplet{

    ParticleSystemManager m_pMan;
    ParticleSystem        m_pSys;
    LinkedList<Modifier>  m_modifiers = new LinkedList<Modifier>();
    AllAtOnceEmitter      m_emitter;
    PVector               m_position = new PVector();
    PImage                m_image;

    static int i;

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
        m_position.set(mouseX, mouseY);

        m_modifiers.clear();
        m_modifiers.add(new LifespanModifier(40+i));
        m_modifiers.add(new SpeedModifier(-0.03F));
        m_modifiers.add(new ColorModifier(0, 5 - i/50, 3.5F - i/50));
        m_emitter = new AllAtOnceEmitter(this, m_modifiers, m_image, 30, m_position, 0.1F, 5F);

        m_pSys = new ParticleSystem();
        m_pMan.addParticleSystem(m_pSys);
        m_pSys.addEmitter(m_emitter);
        m_pSys.addModifiers(m_modifiers);

        i += 1;
    }

    @Override
    public void mousePressed() {
        i = 0;
    }

    public void draw() {
        m_pMan.update();
        background(0,0,0);
        m_pMan.draw();
    }
}
