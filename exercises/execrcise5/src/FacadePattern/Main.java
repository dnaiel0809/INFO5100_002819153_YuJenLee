package FacadePattern;
//Step 1
interface AudioPlayer {
    void play(String audio);
}
//Step 2
class MP3Player implements AudioPlayer {
    @Override
    public void play(String audio) {
        System.out.println("Playing MP3 audio: " + audio);
    }
}

class WAVPlayer implements AudioPlayer {
    @Override
    public void play(String audio) {
        System.out.println("Playing WAV audio: " + audio);
    }
}
//Step 3
class AudioPlayerFacade {
    private AudioPlayer mp3Player;
    private AudioPlayer wavPlayer;

    public AudioPlayerFacade() {
        mp3Player = new MP3Player();
        wavPlayer = new WAVPlayer();
    }

    public void playMP3(String audio) {
        mp3Player.play(audio);
    }

    public void playWAV(String audio) {
        wavPlayer.play(audio);
    }
}

//Step 4
public class Main {
    public static void main(String[] args) {

        AudioPlayerFacade audioPlayerFacade = new AudioPlayerFacade();

        audioPlayerFacade.playMP3("Song.mp3");
        audioPlayerFacade.playWAV("SoundEffect.wav");
    }
}