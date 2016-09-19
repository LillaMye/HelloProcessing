package argaaya.helloprocessing;

import java.util.LinkedList;

/**
 * Created by Maria on 2016-09-17.
 */
public class Modifier {

    LinkedList<Particle> m_particles = new LinkedList<Particle>();

    public void addParticles(LinkedList<Particle> particles){
        m_particles.addAll(particles);
    }

    public void update (){}
}
