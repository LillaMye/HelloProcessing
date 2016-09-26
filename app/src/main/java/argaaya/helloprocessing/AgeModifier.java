package argaaya.helloprocessing;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Maria on 2016-09-17.
 */
public class AgeModifier extends Modifier {

    float m_ageingRate;

    public AgeModifier(float ageingRate){
        m_ageingRate = ageingRate;
    }

    public void apply (LinkedList<Particle> particles){

        for (Particle p : particles) {
            p.updateAge(m_ageingRate);
        }
    }
}
