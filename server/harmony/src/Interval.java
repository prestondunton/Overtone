public class Interval {

    public enum Quality {
        DIMINISHED("°"),
        MINOR("m"),
        MAJOR("M"),
        AUGMENTED("+"),
        PERFECT("P"),
        NATURAL("♮"),
        SHARP("#"),
        FLAT("b");

        private final String q;

        Quality(String q){
            this.q = q;
        }

        public String toString() {
            return this.q;
        }
    }

    public enum Distance {
        UNSION(1),
        THIRD(3),
        FIFTH(5),
        SEVENTH(7),
        NINTH(9),
        ELEVENTH(11),
        THIRTEENTH(13);

        private final int d;

        Distance(int d) {
            this.d = d;
        }

        public int value() {
            return this.d;
        }

        public String toString() {
            return String.valueOf(this.d);
        }
    }

    private Note low;
    private Note high;
    private Quality quality;
    private Distance distance;
    private int semitones;

    public Interval(Note low, Note high) {
        this.low = low;
        this.high = high;
        this.quality = quality(low,high);
        this.distance = distance(low,high);
        this.semitones = semitones(low, high);
    }

    public Interval(Note note, boolean up, Quality quality, Distance distance) {
        if(up){
            this.low = note;
            this.high = findNote(note,up,quality,distance);
        } else {
            this.low = findNote(note, up, quality, distance);
            this.high = note;
        }
        validateQualityDistance(quality,distance);
        this.quality = quality;
        this.distance = distance;
        this.semitones = semitones(this.low,this.high);
    }

    public Interval(Note note, boolean up, int semitones) {
        semitones = normalizeSemitones(semitones);
        if(up){
            this.low = note;
            this.high = findNote(note,up,quality,distance);
        } else {
            this.low = findNote(note, up,quality,distance);
            this.high = note;
        }
        this.quality = quality(this.low,this.high);
        this.distance = distance(this.low,this.high);
        this.semitones = semitones;
    }

    public Interval(Quality quality, Distance distance) {
        validateQualityDistance(quality,distance);
        this.quality = quality;
        this.distance = distance;
        this.semitones = semitones(quality, distance);
    }

    public Interval(int semitones) {
        semitones = normalizeSemitones(semitones);
        this.semitones = semitones;
    }

    public Note getLow() {
        return low;
    }

    public Note getHigh() {
        return high;
    }

    public Quality getQuality() {
        return quality;
    }

    public Distance getDistance() {
        return distance;
    }

    public int getSemitones() {
        return semitones;
    }

    public String toString() {
        return this.quality.toString() + this.distance.toString();
    }
    
    public static int normalizeSemitones(int semitones) {
        while(semitones < 0){
            semitones += 12;
        }
        return semitones % 12;
    }

    public static void validateQualityDistance(Quality quality, Distance distance) {

    }

    public static Note findNote(Note note, boolean up, Quality quality, Distance distance) {
        validateQualityDistance(quality,distance);
    }

    public static int findTone(Note note, boolean up, int semitones) {
        if(up){
            return normalizeSemitones(note.tone() + semitones);
        } else {
            return normalizeSemitones(note.tone() - semitones);
        }
    }

    public static int semitones(Note low, Note high) {
        return normalizeSemitones(high.tone() - low.tone());
    }
    
    public static int semitones(Quality quality, Distance distance) {
        validateQualityDistance(quality,distance);
        if(quality == Quality.DIMINISHED){
            return switch(distance){
                case THIRD -> 2;
                case FIFTH -> 6;
                case SEVENTH -> 9;
                default -> throw new IllegalArgumentException("Diminished interval undefined for distance: " + distance);
            };
        } else if(quality == Quality.MINOR){
            return switch(distance){
                case THIRD -> 3;
                case SEVENTH -> 10;
                default -> throw new IllegalArgumentException("Minor interval undefined for distance: " + distance);
            };
        } else if(quality == Quality.MAJOR){
            return switch(distance){
                case THIRD -> 4;
                case SEVENTH -> 11;
                default -> throw new IllegalArgumentException("Major interval undefined for distance: " + distance);
            };
        } else if(quality == Quality.AUGMENTED){
            return switch(distance){
                case UNSION -> 1;
                case THIRD -> 5;
                case FIFTH -> 8;
                case SEVENTH -> 0;
                default -> throw new IllegalArgumentException("Augmented interval undefined for distance: " + distance);
            };
        } else if(quality == Quality.PERFECT){
            return switch(distance){
                case UNSION -> 0;
                case FIFTH -> 7;

                default -> throw new IllegalArgumentException("Perfect interval undefined for distance: " + distance);
            };
        } else if(quality == Quality.NATURAL){
            return switch(distance){
                case FIFTH: 7;
                case NINTH -> 2;
                case ELEVENTH -> 5;
                case THIRTEENTH -> 9;
                default -> throw new IllegalArgumentException("Natural interval undefined for distance: " + distance);
            };
        } else if(quality == Quality.SHARP){
            return switch(distance){
                case FIFTH -> 8;
                case NINTH -> 3;
                case ELEVENTH -> 6;
                default -> throw new IllegalArgumentException("Natural interval undefined for distance: " + distance);
            };
        } else {  // Quality.FLAT
            return switch(distance){
                case THIRD -> 3;
                case NINTH -> 2;
                case ELEVENTH -> 5;
                case THIRTEENTH -> 9;
                default -> throw new IllegalArgumentException("Natural interval undefined for distance: " + distance);
            };
        }
    }
    
    public static Distance distance(Note low, Note high) {
        int distance = 1;
        char c = low.toString().charAt(0);
        char end = high.toString().charAt(0);
        while(c != end){
            distance += 1;
            c = increment_note(c);
        }
        return switch(distance){
            case 1 -> Distance.UNSION;
            case 2 -> Distance.NINTH;
            case 3 -> Distance.THIRD;
            case 4 -> Distance.ELEVENTH;
            case 5 -> Distance.FIFTH;
            case 6 -> Distance.THIRTEENTH;
            case 7 -> Distance.SEVENTH;
            default -> throw new RuntimeException("Unexpected distance created: " + distance);
        };
    }

    public static Quality quality(Note low, Note high) {

    }

    private static char increment_note(char c){
        if(c == 'G'){
            return 'A';
        } else {
            return (char)(c + 1);
        }
    }

}

    /*public static Distance intToDistance(int d) {
        if(d == 0){
            throw new IllegalArgumentException("Interval distance cannot be 0");
        }
        // Distance can only be 1,3,5,7,9,11,13
        distance = distance % 14;

        if(distance == 0 || distance == 2 || distance == 4 || distance == 6) {
            distance += 7;
        }
        if(distance == 8 || distance == 10 || distance == 12) {
            distance -= 7;
        }

        return distance;
    }*/