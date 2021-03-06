package argaaya.helloprocessing;

import java.util.LinkedList;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Maria on 2016-09-07.
 */
public class Emitter {

    PApplet m_p;
    boolean m_isDead = false;
    PVector m_position;

    public boolean isDead () { return m_isDead; }

    public void kill(){m_isDead = true;}

    public LinkedList<Particle> update () {return null;}

    public PVector getRandomVelocity (float minVelocity, float maxVelocity) {
        PVector velocity = new PVector();
        Random  rnd      = new Random();
        float   PI       = 3.14159265358979323846F;

        velocity.set   (rnd.nextFloat() * (maxVelocity-minVelocity) + minVelocity, 0, 0);
        velocity.rotate(rnd.nextFloat() * 2 * PI);

        return velocity;
    }

    public void updatePosition(PVector position){
        m_position.set(position);
    }
    public PVector getPosition(){return m_position;}

}
