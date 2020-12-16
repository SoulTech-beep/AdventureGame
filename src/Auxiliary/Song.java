package Auxiliary;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;

public class Song {

    private Clip clip;

    public Song(String name) {
        makeSong(name);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void start() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void updateSong(String songLink) {
        makeSong(songLink);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }


    private void makeSong(String name){
        try {
            File file = new File("src/Sound/"+ name);
            URL url = file.toURI().toURL();
            AudioInputStream player = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(player);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

}
