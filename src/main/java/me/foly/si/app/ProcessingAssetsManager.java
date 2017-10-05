package me.foly.si.app;

import me.foly.si.core.IAssetsManager;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class ProcessingAssetsManager implements IAssetsManager<PImage> {
    private PApplet applet;
    private HashMap<String, PImage> cache = new HashMap<>();

    public ProcessingAssetsManager(PApplet applet) {
        this.applet = applet;

        Path imagesPath = Paths.get(getClass().getResource("/images").getPath());
        try {
            Files
                    .walk(imagesPath)
                    .filter(path -> Files.isRegularFile(path))
                    .map(path -> path.getFileName().toString())
                    .forEach(imgSrc -> cache.put(imgSrc, applet.loadImage("images/" + imgSrc)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PImage getAsset(String imgSrc) {
        return cache.get(imgSrc);
    }
}
