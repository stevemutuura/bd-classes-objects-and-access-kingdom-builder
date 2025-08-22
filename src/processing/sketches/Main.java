package processing.sketches;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    public static PApplet sketch;
    public PImage castleImage;
    public PImage starImage;
    public PImage mapImage;

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

        castle1 = new Castle("Castle A", 1000, "12345",
                2500.5f, "Great Hall", true,
                40.7128f, 174.0060f);

        castle2 = new Castle("Castle B", 500, "67890",
                5500.0f, "Royal Gardens", false,
                234.0522f, 318.2437f);

        castle3 = new Castle("Castle C", 750, "54321",
                3000.0f, "Ancient Ruins", false,
                150.1234f, 200.5678f);
    }

    public void draw() {
        image(mapImage, width / 2,height / 2, width, height);

        drawCastle(castle1);
        drawCastle(castle2);
        drawCastle(castle3);
    }

    public void drawCastle(Castle castle) {
        float sideLength = (float) Math.sqrt(castle.getArea());
        image(castleImage, castle.getLatitude(), castle.getLongitude(), sideLength, sideLength);

        if (castle.isCapital()) {
            image(starImage, castle.getLatitude(), castle.getLongitude() - sideLength / 2,
                     sideLength / 4, sideLength / 4);
        }

        if (dist(castle.getLatitude(), castle.getLongitude(), mouseX, mouseY) < sideLength / 2) {
            textSize(14);
            fill(0);
            text(castle.getName(), castle.getLatitude(), castle.getLongitude() - sideLength / 2 - 10);
            text("Population: " + castle.getPopulation(), castle.getLatitude(), castle.getLongitude() + 10);
            text("Zipcode: " + castle.getZipcode(), castle.getLatitude(), castle.getLongitude() + 30);
            text("Area: " + castle.getArea() + " sq. units", castle.getLatitude(), castle.getLongitude() + 50);
            text("Landmark: " + castle.getLandmark(), castle.getLatitude(), castle.getLongitude() + 70);
            text("Coordinates: (" + castle.getLatitude() + ", " + castle.getLongitude() + ")",
                 castle.getLatitude(), castle.getLongitude() + 90);
            text("Capital: " + (castle.isCapital() ? "Yes" : "No"),
                 castle.getLatitude(), castle.getLongitude() + 110);
        }
    }

    public static void main(String... args) {
        PApplet.main("processing.sketches.Main");
    }
}
