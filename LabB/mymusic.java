package eecs1021;

import jm.JMC;
import jm.music.data.*;
import jm.util.Play;
import jm.constants.*;

public class mymusic {
    public static void main(String[] args) {
        // Play the melody using Play.midi() for each note as eighth notes
        Play.midi(new Note(Pitches.C4, RhythmValues.EIGHTH_NOTE)); // C4
        Play.midi(new Note(Pitches.C4, RhythmValues.EIGHTH_NOTE)); // C4
        Play.midi(new Note(Pitches.G4, RhythmValues.EIGHTH_NOTE)); // G4
        Play.midi(new Note(Pitches.G4, RhythmValues.EIGHTH_NOTE)); // G4
        Play.midi(new Note(Pitches.A4, RhythmValues.EIGHTH_NOTE)); // A4
        Play.midi(new Note(Pitches.A4, RhythmValues.EIGHTH_NOTE)); // A4
        Play.midi(new Note(Pitches.G4, RhythmValues.EIGHTH_NOTE)); // G4

        Play.midi(new Note(Pitches.F4, RhythmValues.EIGHTH_NOTE)); // F4
        Play.midi(new Note(Pitches.F4, RhythmValues.EIGHTH_NOTE)); // F4
        Play.midi(new Note(Pitches.E4, RhythmValues.EIGHTH_NOTE)); // E4
        Play.midi(new Note(Pitches.E4, RhythmValues.EIGHTH_NOTE)); // E4
        Play.midi(new Note(Pitches.D4, RhythmValues.EIGHTH_NOTE)); // D4
        Play.midi(new Note(Pitches.D4, RhythmValues.EIGHTH_NOTE)); // D4
        Play.midi(new Note(Pitches.C4, RhythmValues.EIGHTH_NOTE)); // C4

        Play.midi(new Note(Pitches.G4, RhythmValues.EIGHTH_NOTE)); // G4
        Play.midi(new Note(Pitches.G4, RhythmValues.EIGHTH_NOTE)); // G4
        Play.midi(new Note(Pitches.F4, RhythmValues.EIGHTH_NOTE)); // F4
        Play.midi(new Note(Pitches.F4, RhythmValues.EIGHTH_NOTE)); // F4
        Play.midi(new Note(Pitches.E4, RhythmValues.EIGHTH_NOTE)); // E4
        Play.midi(new Note(Pitches.E4, RhythmValues.EIGHTH_NOTE)); // E4
        Play.midi(new Note(Pitches.D4, RhythmValues.EIGHTH_NOTE)); // D4
    }
}
