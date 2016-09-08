package argaaya.helloprocessing;

import processing.core.PApplet;
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

    public Particle(PApplet pApplet, PVector size, PVector position, PVector velocity, PVector acceleration) {
        m_p            = pApplet;
        m_position     = position.get();
        m_velocity     = velocity.get();
        m_acceleration = acceleration.get();
        m_size         = size.get();
    }

    public boolean isDead () {
        if (m_position.x < 0 || m_position.x > m_p.width || m_position.y < 0 || m_position.y > m_p.height) {
            return false;
        } else {
            return false;
        }
    }

    public void update() {
        m_position.add(m_velocity);
        m_velocity.add(m_acceleration);

        /*
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
        }*/
    }

    public void draw() {
        m_p.ellipse(m_position.x, m_position.y, m_size.x, m_size.y);
    }
}
