import java.util.Arrays;

public class Note {

    private String name;
    private int tone;

    public static String[] noteNames = {
            "C", "B#", "Dbb",
            "C#", "Db", "B##",
            "D", "C##", "Ebb",
            "D#", "Eb", "Fbb",
            "E", "D##", "Fb",
            "F", "E#", "Gbb",
            "F#", "E##", "Gb",
            "G", "F##", "Abb",
            "G#", "Ab",
            "A", "G##", "Bbb",
            "A#", "Bb", "Cbb",
            "B", "A##", "Cb"
    };

    public Note(String name) {
        this.name = name.toUpperCase();
        if (Arrays.asList(noteNames).contains(this.name)) {
            throw new IllegalArgumentException("Improper Note Name: '" + name + "'");
        }
        this.tone = Note.tone_from_name(this.name);
    }

    public Note(int tone) {
        this.tone = tone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
        if (Arrays.asList(noteNames).contains(this.name)) {
            throw new IllegalArgumentException("Improper Note Name: '" + name + "'");
        }
        this.tone = Note.tone_from_name(this.name);
    }

    public int getTone() {
        return tone;
    }

    public static int tone_from_name(String name) {

        int tone;
        name = name.toUpperCase();

        tone = switch (name) {
            case "C", "B#", "Dbb" -> 0;
            case "C#", "Db", "B##" -> 1;
            case "D", "C##", "Ebb" -> 2;
            case "D#", "Eb", "Fbb" -> 3;
            case "E", "D##", "Fb" -> 4;
            case "F", "E#", "Gbb" -> 5;
            case "F#", "E##", "Gb" -> 6;
            case "G", "F##", "Abb" -> 7;
            case "G#", "Ab" -> 8;
            case "A", "G##", "Bbb" -> 9;
            case "A#", "Bb", "Cbb" -> 10;
            case "B", "A##", "Cb" -> 11;
            default -> throw new IllegalArgumentException("Improper Note Name: '" + name + "'");
        };
        return tone;
    }
}