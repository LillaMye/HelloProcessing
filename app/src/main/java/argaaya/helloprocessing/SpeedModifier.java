package argaaya.helloprocessing;

import java.util.LinkedList;

/**
 * Created by Maria on 2016-09-17.
 */
public class SpeedModifier extends Modifier {

    float m_speed;

    public SpeedModifier (float change){
        m_speed = change;
    }

    public void apply (LinkedList<Particle> particles){
        for (Particle m : particles){
            m.updateSpeed (m_speed);
        }
    }
}
