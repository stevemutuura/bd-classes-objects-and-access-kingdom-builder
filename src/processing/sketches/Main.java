package processing.sketches;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    public static PApplet sketch;
    public PImage castleImage;
    public PImage starImage;
    public PImage mapImage;

    private static final int STAR_LENGTH = 15;

    private Castle castle1;
    private Castle castle2;
    private Castle castle3;

    public void settings() {
        castleImage = loadImage("castle.png");
        starImage = loadImage("CapitolStar.png");
        mapImage = loadImage("map.png");
        size(600, 600);
        sketch = this;
    }

    public void setup() {
        background(0);
        imageMode(CENTER);
        textAlign(CENTER);

        castle1 = new Castle("Camelot",
                34583,
                "555-9738",
                5034.6f,
                "bonanza-valley",
                true,
                300,
                200
                );

        castle2 = new Castle( "Nairobi",
                45372,
                "2844-79273",
                9837.7f,
                "Globe",
                false,
                200,
                300
        );

        castle3 = new Castle("Meru",
                34854,
                "748-3924",
                8349.6f,
                "Mt.Kenya",
                false,
                250,
                150
        );
    }

    public void draw() {
        image(mapImage, width / 2,height / 2, width, height);
        drawCastle(castle1);
        drawCastle(castle2);
        drawCastle(castle3);
        //call drawCastle for each castle here
    }


    public void drawCastle(Castle castle) {
        float width = (float) Math.sqrt(castle.getArea());
        image(castleImage, castle.getLatitude(), castle.getLongitude(), width, width);

        if (castle.isCapital()) {
            image(starImage, castle.getLatitude() + width / 2, castle.getLongitude() - width / 2, STAR_LENGTH, STAR_LENGTH);
        }

        if (dist(castle.getLatitude(), castle.getLongitude(), mouseX, mouseY) < width/2) {
            textSize(12);
            fill(0);
            text(castle.getName(), castle.getLatitude(), castle.getLongitude() + 50);
            text(castle.getPopulation(), castle.getLatitude(), castle.getLongitude() + 50 + STAR_LENGTH);
            text(castle.getLandmark(), castle.getLatitude(), castle.getLongitude() + 50  + 2 * STAR_LENGTH);
        }
    }

    public static void main(String... args) {
        PApplet.main("processing.sketches.Main");
    }
}
