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

    static float m_maxAge = 1000;

    float    m_age;
    float    m_colorR = 255, m_colorG = 255, m_colorB = 255;

    public Particle(PApplet pApplet, PVector size, PVector position, PVector velocity, PVector acceleration) {
        m_p            = pApplet;
        m_position     = position.get();
        m_velocity     = velocity.get();
        m_acceleration = acceleration.get();
        m_size         = size.get();
        m_age          = 0;
    }

    public void setAge (float age){
        m_age = age;
    }
    public float getAge (){
        return m_age;
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
                m_age > m_maxAge);
    }

    public void update() {
        m_position.add(m_velocity);
        m_velocity.setMag(m_velocity.mag() + m_acceleration.mag());
    }

    public void draw() {
        m_p.tint(m_colorR, m_colorG, m_colorB);
        m_p.vertex(m_position.x - m_size.x/2, m_position.y - m_size.y/2, 0, 0);
        m_p.vertex(m_position.x - m_size.x/2, m_position.y + m_size.y/2, m_size.y, 0);
        m_p.vertex(m_position.x + m_size.x/2, m_position.y + m_size.y/2, m_size.y, m_size.x);
        m_p.vertex(m_position.x + m_size.x/2, m_position.y - m_size.y/2, 0, m_size.x);
    }
}
