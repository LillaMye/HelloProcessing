package argaaya.helloprocessing;

/**
 * Created by Maria on 2016-08-28.
 */
import processing.core.PApplet;

public class ParticleManager extends PApplet {

    Particle  p;
    int       Lasting;
    int       x, y;
    int       vx, vy;
    int       size;

    public ParticleManager() {
        p = new Particle (this);
    }

    public void settings () {
        size (1000, 1000);
    }

    public void setup() {}

    public void draw() {
        background(155, 58, 58);
        if (mousePressed) {
            x     = mouseX;
            y     = mouseY;
            vx    = 8;
            vy    = 2;
            size  = 50;
        }

        if (x - size/2 < 0 || x + size/2 > width)
        {
            vx = -1 * vx;
            if      (vx > 0 && vx <= 10)  {vx += 2;}
            else if (vx > 10 )            {vx = 4;}
            else if (vx < 0 && vx >= -10) {vx -= 2;}
            else if (vx < -10)            {vx = -3;}
        }
        if (y - size/2 < 0 || y + size/2 > height)
        {
            vy = -1 * vy;
            if      (vy > 0 && vy <= 10)  {vy += 2;}
            else if (vy > 10 )            {vy = 3;}
            else if (vy < 0 && vy >= -10) {vy -= 2;}
            else if (vy < -10)            {vy = -4;}
        }

        x += vx;
        y += vy;
        p.draw (x, y, size);
    }
}