package argaaya.helloprocessing;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;


public class App extends PApplet{

    ParticleSystemManager m_pMan;
    ParticleSystem        m_Released_pSys;
    ParticleSystem        m_Dragged_pSys;
    ParticleSystem        m_smoke_pSys;
    Emitter               m_DraggedEmitter;
    Emitter               m_smokeEmitter;
    PVector               m_position = new PVector();
    PImage                m_image;
    PImage                m_smoke;
    boolean               m_mouseDragged;

    public void settings () {
        fullScreen(P2D);
    }

    public void setup () {
        blendMode(ADD);
        m_image = loadImage("basic_particle_100_100.png");
        m_smoke = loadImage("smoke1_512.jpg");
        m_pMan  = ParticleSystemManager.getInstance();
        m_pMan.providePapplet(this);
    }

    @Override
    public void mouseDragged() {
        m_position.set(mouseX, mouseY);

        if (!m_mouseDragged){
/*            m_smoke_pSys = new ParticleSystem(this, m_smoke);
            m_pMan.addParticleSystem(m_smoke_pSys);
            m_smoke_pSys.addModifier(new AgeModifier(20));
            m_smokeEmitter = new ConstantEmitter(this, 1, m_position, new PVector(512,512), 1F, 10F);
            m_smoke_pSys.addEmitter(m_smokeEmitter);*/

            m_Dragged_pSys = new ParticleSystem(this, m_image);
            m_pMan.addParticleSystem(m_Dragged_pSys);
            m_Dragged_pSys.addModifier(new AgeModifier(20));
            m_Dragged_pSys.addModifier(new DampingModifier(0.1F));
            m_Dragged_pSys.addModifier(new ColorModifier(this, color(255, 127, 0, 200), color(255, 50, 0, 100), color(255, 0, 0, 0), 0.5F));
            m_DraggedEmitter = new ConstantEmitter(this, 50, m_position, new PVector(100,100), 2F, 15F);
            m_Dragged_pSys.addEmitter(m_DraggedEmitter);
        }
        else {
//            m_smokeEmitter.updatePosition(m_position);
            m_DraggedEmitter.updatePosition(m_position);
        }

        m_mouseDragged = true;

    }

    @Override
    public void mousePressed() {
        m_mouseDragged = false;
    }

    @Override
    public void mouseReleased() {
        m_position.set(mouseX, mouseY);

        if (!m_mouseDragged) {
            m_Released_pSys = new ParticleSystem(this, m_image);
            m_pMan.addParticleSystem(m_Released_pSys);
            m_Released_pSys.addModifier(new AgeModifier(20));
            m_Released_pSys.addModifier(new DampingModifier(0.1F));
            m_Released_pSys.addModifier(new ColorModifier(this, color(255, 255, 255, 255), color(127, 255, 0, 255), color(127, 127, 0, 0), 0.7F));
            m_Released_pSys.addEmitter(new AllAtOnceEmitter(this, 100, m_position, 0.1F, 15F));
        } else {
            m_DraggedEmitter.kill();
  //          m_smokeEmitter.kill();
        }
    }

    public void draw() {
        m_pMan.update();
        background(0,0,0);
        m_pMan.draw();
    }
}
