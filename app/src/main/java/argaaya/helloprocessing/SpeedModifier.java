package argaaya.helloprocessing;

/**
 * Created by Maria on 2016-09-17.
 */
public class SpeedModifier extends Modifier {

    float m_speed;

    public SpeedModifier (float change){
        m_speed = change;
    }

    public void update (){
        for (Particle m : m_particles){
            m.updateSpeed (m_speed);
        }
    }
}
