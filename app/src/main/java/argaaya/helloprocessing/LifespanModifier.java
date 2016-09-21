package argaaya.helloprocessing;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Maria on 2016-09-17.
 */
public class LifespanModifier extends Modifier {

    float m_ageingRate;

    public LifespanModifier (float ageingRate){
        m_ageingRate = ageingRate;
    }

    public void apply (LinkedList<Particle> particles){

        for (Particle p : particles) {
            Random rnd = new Random();
            p.setAge(p.getAge() + m_ageingRate);
        }
    }
}
