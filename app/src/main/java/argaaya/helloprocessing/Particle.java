package argaaya.helloprocessing;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Maria on 2016-08-31.
 */
public class Particle {

    PApplet m_p;

    PVector m_position     = new PVector();
    PVector m_velocity     = new PVector();
    PVector m_acceleration = new PVector();
    PVector m_size         = new PVector();

    public Particle(PApplet pApplet, PVector size, PVector position, PVector velocity, PVector acceleration) {
        m_p            = pApplet;
        m_position     = position;
        m_velocity     = velocity;
        m_acceleration = acceleration;
        m_size         = size;
    }

    public void update() {
        m_position.add(m_velocity);
        m_velocity.add(m_acceleration);

        // change direction at border
        if ((m_position.x - m_size.x/2) < 0         && (m_velocity.x < 0 ) ||
             m_position.x + m_size.x/2  > m_p.width &&  m_velocity.x > 0 )
        {
            m_velocity.x = -1 * m_velocity.x;
        }
        if ((m_position.y - m_size.y/2) < 0          && (m_velocity.y < 0 ) ||
             m_position.y + m_size.y/2  > m_p.height &&  m_velocity.y > 0 )
        {
            m_velocity.y = -1 * m_velocity.y;
        }
    }

    public void draw() {
        m_p.ellipse(m_position.x, m_position.y, m_size.x, m_size.y);
    }
}
