package argaaya.helloprocessing;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;


public class App extends PApplet{

    ParticleSystemManager m_pMan;
    ParticleSystem        m_Dragged_pSys;
    ParticleSystem        m_smoke_pSys;
    Emitter               m_DraggedEmitter;
    Emitter               m_smokeEmitter;
    PVector               m_position = new PVector();
    PImage                m_image;
    PImage                m_smoke;
    PImage                m_smallsmoke;
    boolean               m_mouseDragged, m_mouseReleased;

    PVector               m_oldPosition = new PVector();
    PVector               m_newPosition = new PVector();

    public void settings () {fullScreen(P2D);}

    public void setup () {
        blendMode(ADD);
        orientation(LANDSCAPE);

        m_image = loadImage("basic_particle_100_100.png");
        m_smoke = loadImage("smoke2.png");
        m_smallsmoke = loadImage("smoke2_small.png");
        m_pMan  = ParticleSystemManager.getInstance();
        m_pMan.providePapplet(this);
    }

    @Override
    public void mouseDragged() {
        m_position.set(mouseX, mouseY);

        if (!m_mouseDragged){
            m_smoke_pSys = new ParticleSystem(this, m_smoke);
            m_pMan.addParticleSystem(m_smoke_pSys);
            m_smoke_pSys.addModifier(new AgeModifier(5));
            m_smoke_pSys.addModifier(new PerlinModifier(this, 0.02F));
            m_smoke_pSys.addModifier(new ColorModifier(this, color(255, 255, 255, 0), color(255, 255, 255, 25), color(255, 255, 255, 0), 0.1F));
            m_smokeEmitter = new ConstantEmitter(this, 1, m_position, new PVector(450,450), 2F, 3F);
            m_smoke_pSys.addEmitter(m_smokeEmitter);

            m_Dragged_pSys = new ParticleSystem(this, m_smallsmoke);
            m_pMan.addParticleSystem(m_Dragged_pSys);
            m_Dragged_pSys.addModifier(new AgeModifier(35));
            m_Dragged_pSys.addModifier(new DampingModifier(0.1F));
            m_Dragged_pSys.addModifier(new ColorModifier(this, color(255, 255, 255, 127), color(255, 51, 255, 127), color(51, 51, 255, 0), 0.5F));
            m_DraggedEmitter = new ConstantEmitter(this, 10, m_position, new PVector(150,150), 2F, 15F);
            m_Dragged_pSys.addEmitter(m_DraggedEmitter);
        }
        else {
            m_smokeEmitter.updatePosition(m_position);
            m_DraggedEmitter.updatePosition(m_position);
        }
        m_oldPosition.set(m_newPosition);
        m_newPosition.set(m_position);

        m_mouseDragged = true;
    }

    @Override
    public void mousePressed() {
        m_mouseDragged = false;
        m_mouseReleased = false;
    }

    @Override
    public void mouseReleased() {
        if (m_mouseDragged) {
            m_DraggedEmitter.kill();
            m_smokeEmitter.kill();
        }
        m_mouseReleased = true;
    }

    public void draw() {
        m_pMan.update();
        background(0,0,0);
        m_pMan.draw();
    }
}
