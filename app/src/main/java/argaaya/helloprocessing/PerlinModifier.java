package argaaya.helloprocessing;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Maria on 2016-09-29.
 */
public class PerlinModifier extends Modifier {

    PApplet m_p;
    float   m_damping;

    public PerlinModifier (PApplet pApplet, float damping) {
      m_p       = pApplet;
      m_damping = damping;
    }

    public void apply (LinkedList<Particle> particles){

        for (Particle p : particles){
            float t = (float)p.getAge() / (float)p.getMaxAge();
            float n = m_p.noise(p.getPosition().x, p.getPosition().y, t);

            p.applyForce(new PVector(p.getVelocity().x * n * m_damping, p.getVelocity().y * n * m_damping));
        }
    }


}
