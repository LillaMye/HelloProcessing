package argaaya.helloprocessing;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Created by Maria on 2016-08-31.
 */
public class Particle {

    private PApplet m_p;

    private final PVector m_position;
    private final PVector m_velocity;
    private final PVector m_acceleration;
    private final PVector m_size;

    PImage   m_image;
    int      m_lifespan;
    float    m_colorR = 255, m_colorG = 255, m_colorB = 255;

    public Particle(PApplet pApplet, PImage image, PVector size, PVector position, PVector velocity, PVector acceleration) {
        m_p            = pApplet;
        m_position     = position.get();
        m_velocity     = velocity.get();
        m_acceleration = acceleration.get();
        m_size         = size.get();
        m_lifespan     = 10000;

        m_image = image;     //TODO
    }

    public void setLifespan (int lifespan){
        m_lifespan = lifespan;
    }

    public void updateSpeed (float change){

        m_velocity.setMag(m_velocity.mag()+ change);
    }

    public void setTint (float r, float g, float b){
        m_colorR = r;
        m_colorG = g;
        m_colorB = b;
    }

    public boolean isDead () {
        return (m_position.x < 0 || m_position.x > m_p.width ||
                m_position.y < 0 || m_position.y > m_p.height ||
                m_lifespan < 0);
    }

    public void update() {
        m_position.add(m_velocity);
        m_velocity.setMag(m_velocity.mag() + m_acceleration.mag());
        m_lifespan--;
    }

    public void draw() {
        m_p.texture(m_image);
        m_p.tint(m_colorR, m_colorG, m_colorB);
        m_p.vertex(m_position.x - m_size.x/2, m_position.y - m_size.y/2, 0, 0);
        m_p.vertex(m_position.x - m_size.x/2, m_position.y + m_size.y/2, m_image.height, 0);
        m_p.vertex(m_position.x + m_size.x/2, m_position.y + m_size.y/2, m_image.height, m_image.width);
        m_p.vertex(m_position.x + m_size.x/2, m_position.y - m_size.y/2, 0, m_image.width);
    }
}
