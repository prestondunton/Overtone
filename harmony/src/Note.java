public enum Note {
    A("A"), ASHARP("A#"), ADOUBLESHARP("A##"), AFLAT("Ab"), ADOUBLEFLAT("Abb"),
    B("B"), BSHARP("B#"), BDOUBLESHARP("B##"), BFLAT("Bb"), BDOUBLEFLAT("Bbb"),
    C("C"), CSHARP("C#"), CDOUBLESHARP("C##"), CFLAT("Cb"), CDOUBLEFLAT("Cbb"),
    D("D"), DSHARP("D#"), DDOUBLESHARP("D##"), DFLAT("Db"), DDOUBLEFLAT("Dbb"),
    E("E"), ESHARP("E#"), EDOUBLESHARP("E##"), EFLAT("Eb"), EDOUBLEFLAT("Ebb"),
    F("F"), FSHARP("F#"), FDOUBLESHARP("F##"), FFLAT("Fb"), FDOUBLEFLAT("Fbb"),
    G("G"), GSHARP("G#"), GDOUBLESHARP("G##"), GFLAT("Gb"), GDOUBLEFLAT("Gbb");

    private final String note_name;

    Note(String s) {
        note_name = s;
    }

    public int tone() {
        return switch (note_name) {
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
            default -> throw new IllegalArgumentException("Improper Note Name: '" + note_name + "'");
        };
    }

    public String toString() {
        return note_name;
    }
}