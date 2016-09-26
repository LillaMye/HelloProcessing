package argaaya.helloprocessing;

import android.graphics.Color;
import android.provider.CalendarContract;

import java.util.LinkedList;

import processing.core.PApplet;

/**
 * Created by Maria on 2016-09-18.
 */
public class ColorModifier extends Modifier {

    int     m_first;
    int     m_mid;
    int     m_last;
    float   m_midT;
    PApplet m_p;

    public ColorModifier (PApplet pApplet, int first, int mid, int last, float midT){
        m_p     = pApplet;
        m_first = first;
        m_mid   = mid;
        m_last  = last;
        m_midT  = midT;
    }

    public void apply (LinkedList<Particle> particles){
        int c;
        for (Particle p : particles){
            float t = (float)p.getAge() / (float)p.getMaxAge();
            if (t<m_midT) {
                c = m_p.lerpColor(m_first, m_mid, t/m_midT);
            } else {
                c = m_p.lerpColor(m_mid, m_last, (t - m_midT)/(1 - m_midT));
            }

            p.setTint(c);
        }
    }
}
