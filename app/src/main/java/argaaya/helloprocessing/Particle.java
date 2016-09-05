package argaaya.helloprocessing;

import processing.core.PApplet;

/**
 * Created by Maria on 2016-08-31.
 */
public class Particle {

    PApplet m_p;

    int[] position       = new int[2];
    float[] velocity     = new float[2];
    int size;

    public Particle(PApplet pApplet, int StartPositionX, int StartPositionY, int Size, float VelocityX, float VelocityY /*, int Color, int Texture, int Longevity, int Velocity, int acceleration*/) {
        m_p = pApplet;
        position[0]     = StartPositionX;
        position[1]     = StartPositionY;
        velocity[0]     = VelocityX;
        velocity[1]     = VelocityY;
        size            = Size;
    }

    public void update() {
        position[0] += velocity[0];
        position[1] += velocity[1];

        if ((position[0] - size/2 < 0            && velocity[0] < 0 ) ||
             position[0] + size/2 > m_p.width && velocity[0] > 0 )
        {
            velocity[0]     = -1 * velocity[0];
        }
        if ((position[1] - size/2 < 0             && velocity[1] < 0) ||
            (position[1] + size/2 > m_p.height && velocity[1] > 0))
        {
            velocity[1]     = -1 * velocity[1];
        }
    }

    public void draw() {
        m_p.ellipse(position[0], position[1], size, size);
    }
}
