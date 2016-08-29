package argaaya.helloprocessing;

/**
 * Created by Maria on 2016-08-28.
 */
import processing.core.PApplet;

public class text extends PApplet {
    public void settings() {
        size(1000, 1000);
    }

    public void setup() { }

    public void draw() {
        if (mousePressed) {
            ellipse(mouseX, mouseY, 15, 15);
        }
    }
}