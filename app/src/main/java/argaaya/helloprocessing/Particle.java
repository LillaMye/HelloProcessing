package argaaya.helloprocessing;

import processing.core.PApplet;

/**
 * Created by Maria on 2016-08-31.
 */
public class Particle {

    ParticleSystemManager Parent;

    int[] position     = new int[2];
    float[] velocity     = new float[2];
    float[] acceleration = new float[2];
    int size;
    int color;
    int texture;
    int longevity;

    public Particle(ParticleSystemManager particleSystemManager, int StartPositionX, int StartPositionY, int Size, float VelocityX, float VelocityY, float AccelerationX, float AccelerationY /*, int Color, int Texture, int Longevity, int Velocity, int acceleration*/) {
        Parent          = particleSystemManager;
        position[0]     = StartPositionX;
        position[1]     = StartPositionY;
        velocity[0]     = VelocityX;
        velocity[1]     = VelocityY;
        acceleration[0] = AccelerationX;
        acceleration[1] = AccelerationY;
        size            = Size;
    }

    public void update() {
        position[0] += velocity[0];
        position[1] += velocity[1];
        if (velocity[0] < 15 && velocity[0] > -15) {
            velocity[0] += acceleration[0];
            velocity[1] += acceleration[1];
        }

        if ((position[0] - size/2 < 0            && velocity[0] < 0 ) ||
             position[0] + size/2 > Parent.width && velocity[0] > 0 )
        {
            velocity[0]     = -1 * velocity[0];
            acceleration[0] = -1 * acceleration[0];
        }
        if ((position[1] - size/2 < 0             && velocity[1] < 0) ||
            (position[1] + size/2 > Parent.height && velocity[1] > 0))
        {
            velocity[1]     = -1 * velocity[1];
            acceleration[1] = -1 * acceleration[1];
        }
    }

    public void draw() {
        Parent.ellipse(position[0], position[1], size, size);
    }
}
