package processing.sketches;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    public static PApplet sketch;
    public PImage castleImage;
    public PImage starImage;
    public PImage mapImage;

    public void settings() {
        castleImage = loadImage("castle.png");
        starImage = loadImage("CapitolStar.png");
        mapImage = loadImage("map.png");
        size(600, 600);
        imageMode(CENTER);
        textAlign(CENTER);
        sketch = this;
    }

    public void setup() {
        background(0);
    }

    public void draw() {
        image(mapImage, 0,0, width, height);

        //call drawCastle for each castle here
    }

//  Uncomment when ready to draw castles
//    public void drawCastle(Castle castle) {
//
//    }

    public static void main(String... args) {
        PApplet.main("processing.sketches.Main");
    }
}
