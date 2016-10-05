package argaaya.helloprocessing;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import android.graphics.Color;

/**
 * Created by Maria on 2016-08-31.
 */
public class Particle {

    private PApplet m_p;

    private final PVector m_position     = new PVector();
    private final PVector m_velocity     = new PVector();
    private final PVector m_acceleration = new PVector();
    private final PVector m_size         = new PVector();

    static int m_maxAge = 1000;

    int m_age;
    int m_tint = 0xFFFFFFFF;

    public Particle(PApplet pApplet, PVector size, PVector position, PVector velocity) {
        m_p = pApplet;
        m_position.set(position);
        m_velocity.set(velocity);
        m_size.set(size);
        m_age = 0;
        m_acceleration.set(0,0);
    }

    public int getAge() {return m_age;};
    public int getMaxAge() {return m_maxAge;};
    public void updateAge (float change){
        m_age += change;
    }

    public PVector getPosition(){return m_position;}
    public PVector getVelocity(){ return m_velocity;};
    public void    setVelocity(PVector velocity){m_velocity.set(velocity);}
    public void    setAcceleration(PVector acceleration) {m_acceleration.set(acceleration);}
    public void    applyForce(PVector force){m_acceleration.add(force);}

    public void setTint (int color){
        m_tint = color;
    }

    public boolean isDead () {
        return (m_position.x < 0 || m_position.x > m_p.width ||
                m_position.y < 0 || m_position.y > m_p.height ||
                m_age > m_maxAge);
    }

    public void update() {
        m_position.add(m_velocity);
        m_velocity.add(m_acceleration);
        m_acceleration.set(0,0);
    }

    public void draw() {
        m_p.tint(m_tint);
        m_p.vertex(m_position.x - m_size.x/2, m_position.y - m_size.y/2, 0, 0);
        m_p.vertex(m_position.x - m_size.x/2, m_position.y + m_size.y/2, m_size.y, 0);
        m_p.vertex(m_position.x + m_size.x/2, m_position.y + m_size.y/2, m_size.y, m_size.x);
        m_p.vertex(m_position.x + m_size.x/2, m_position.y - m_size.y/2, 0, m_size.x);
    }
}
