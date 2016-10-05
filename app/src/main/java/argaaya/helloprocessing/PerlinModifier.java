package argaaya.helloprocessing;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Created by Maria on 2016-09-29.
 */
public class PerlinModifier extends Modifier {

    PApplet m_p;

    public PerlinModifier (PApplet pApplet) {
      m_p = pApplet;
    }

    public void apply (LinkedList<Particle> particles){

        for (Particle p : particles){
            float t = (float)p.getAge() / (float)p.getMaxAge();
            float n = m_p.noise(p.getPosition().x, p.getPosition().y, t);

            p.applyForce(new PVector(-p.getVelocity().x * n/20F, -p.getVelocity().y*n/20F));
        }
    }


}
