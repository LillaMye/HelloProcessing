package argaaya.helloprocessing;

import java.util.LinkedList;
import java.util.Random;

import processing.core.PVector;

/**
 * Created by Maria on 2016-09-07.
 */
public class Emitter {

    public boolean isDead () {
        return true;
    }

    public LinkedList<Particle> update () {return null;}

    public PVector getRandomVelocity (int minVelocity, int maxVelocity) {
        PVector velocity = new PVector();
        Random  rnd      = new Random();
        float   PI       = 3.14159265358979323846F;

        velocity.set   (rnd.nextInt(1+maxVelocity-minVelocity) + minVelocity + rnd.nextFloat(), 0, 0);
        velocity.rotate(rnd.nextFloat() * 2 * PI);

        return velocity;
    }
}
