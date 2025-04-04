import jm.music.data.*;
import jm.util.*;

public class RandomRhythm {
    private Score score;
    private Part snarePart;
    private Phrase snarePhrase;

    public RandomRhythm(String scoreTitle) {
        this.score = new Score(scoreTitle);
        this.snarePart = new Part("Snare", 0, 9);
        this.snarePhrase = new Phrase(0.0);
        this.score.addPart(snarePart);
        this.snarePart.addPhrase(snarePhrase);
    }

    public void generateRandomNotes(int maxInterval) {
        snarePhrase.empty();
        for (int i = 0; i < 24; i++) {
            double rhythmValue = Math.random() * maxInterval;
            Note note = new Note(38, rhythmValue);
            snarePhrase.addNote(note);
        }
    }

    public void play() {
        Play.midi(score);
    }

    public static void main(String[] args) {
        RandomRhythm rr = new RandomRhythm("Random Rhythm");
        rr.generateRandomNotes(2);
        rr.play();
    }
}