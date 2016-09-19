package argaaya.helloprocessing;

/**
 * Created by Maria on 2016-09-18.
 */
public class ColorModifier extends Modifier {

    float m_colorR = 255;
    float m_colorG = 255;
    float m_colorB = 255;

    float m_changeR;
    float m_changeG;
    float m_changeB;

    public ColorModifier (float changeR, float changeG, float changeB){
        m_changeR = changeR;
        m_changeG = changeG;
        m_changeB = changeB;
    }

    public void update (){
        for (Particle P : m_particles){
            P.setTint(m_colorR, m_colorG, m_colorB);
        }
        m_colorR -= m_changeR;
        m_colorB -= m_changeG;
        m_colorG -= m_changeB;
    }
}
