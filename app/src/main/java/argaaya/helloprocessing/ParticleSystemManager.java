package argaaya.helloprocessing;

/**
 * Created by Maria on 2016-08-28.
 */
import processing.core.PApplet;

public class ParticleSystemManager extends PApplet {

    ParticleSystem pSys;

    public void settings () {
        size (1000, 1000);
    }

    public void setup () {
        pSys = new ParticleSystem(this);
        pSys.setup();
    }

    public void draw() {
        background(155, 58, 58);
        pSys.update();
        pSys.draw ();
    }
}





