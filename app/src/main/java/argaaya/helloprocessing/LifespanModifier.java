package argaaya.helloprocessing;

import java.util.Random;

/**
 * Created by Maria on 2016-09-17.
 */
public class LifespanModifier extends Modifier {

    int     m_lifespan;
    boolean m_isUpdated = false;

    public LifespanModifier (int lifespan){
      m_lifespan = lifespan;
    }

    public void update (){
        if (!m_isUpdated) {
            for (Particle P : m_particles) {
                Random rnd = new Random();
                P.setLifespan(m_lifespan + rnd.nextInt(m_lifespan / 5));
                m_isUpdated = true;
            }
        }
    }
}
