import jm.JMC;
import jm.music.data.*;
import jm.util.*;
import jm.util.View;

public class RandomMelody {
    private Score score;
    private Part snarePart;
    private Phrase snarePhrase;
    private double[] randomRhythms;

    public RandomMelody(String scoreTitle) {
        this.score = new Score(scoreTitle);
        this.snarePart = new Part("Snare", 0, 9);
        this.snarePhrase = new Phrase(0.0);
        this.randomRhythms = new double[24];
        this.score.addPart(snarePart);
        this.snarePart.addPhrase(snarePhrase);
    }

    public void generateRandomNotes(int maxInterval) {
        snarePhrase.empty();
        for (int i = 0; i < 24; i++) {
            double rhythmValue = Math.random() * maxInterval;
            randomRhythms[i] = rhythmValue;
            Note note = new Note(38, rhythmValue);
            snarePhrase.addNote(note);
        }
    }

    public void addASong(int instrument, int[] pitchArray) {
        if (pitchArray.length != 24) {
            System.out.println("Pitch array must have 24 notes");
            return;
        }
        Part instrumentPart = new Part("Instrument", instrument, 0);
        Phrase melodyPhrase = new Phrase(0.0);
        melodyPhrase.addNoteList(pitchArray, randomRhythms);
        instrumentPart.addPhrase(melodyPhrase);
        score.addPart(instrumentPart);
    }

    public void play() {
        Play.midi(score);
    }

    public void save() {
        Write.midi(score, score.getTitle() + ".mid");
    }

    public void clear() {
        this.score = new Score(score.getTitle());
        this.snarePart = new Part("Snare", 0, 9);
        this.snarePhrase = new Phrase(0.0);
        this.randomRhythms = new double[24];
        this.score.addPart(snarePart);
        this.snarePart.addPhrase(snarePhrase);
    }

    public void displayNotation() {
        View.notate(score);
    }

    public static void main(String[] args) {
        RandomMelody rm = new RandomMelody("My Melody");
        rm.generateRandomNotes(2);

        int[] pitchArray = {
                JMC.C5, JMC.C5, JMC.G5, JMC.G5, JMC.A5, JMC.A5, JMC.G5,
                JMC.F5, JMC.F5, JMC.E5, JMC.E5, JMC.D5, JMC.D5, JMC.C5,
                JMC.G5, JMC.G5, JMC.F5, JMC.F5, JMC.E5, JMC.E5, JMC.D5,
                JMC.G5, JMC.G5, JMC.F5
        };

        rm.addASong(JMC.PIANO, pitchArray);
        rm.play();
        rm.save();
        rm.displayNotation();
        rm.clear();
        rm.play();
    }
}
