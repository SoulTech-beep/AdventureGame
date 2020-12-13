import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Song {

    private Clip clip;

    public Song(String name) {
        try {
            URL url = getClass().getResource(name);
            AudioInputStream player = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(player);
        } catch (Exception e) {
            System.out.println("Exeception " + e);
        }
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

}
