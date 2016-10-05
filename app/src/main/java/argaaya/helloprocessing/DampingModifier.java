package argaaya.helloprocessing;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Maria on 2016-09-17.
 */
public class DampingModifier extends Modifier {

    float m_damping;

    public DampingModifier(float damping){
        m_damping = damping;
    }

    public void apply (LinkedList<Particle> particles){
        for (Particle p : particles){
            PVector acceleration = new PVector(-p.getVelocity().x * m_damping,
                                               -p.getVelocity().y * m_damping);
            p.setAcceleration (acceleration);
        }
    }
}
