public class TEst {

    public static void main(String[] args) {
        Note my_note = Note.EDOUBLESHARP;
        Note[] chord = {Note.C,Note.E,Note.G,Note.B};

        for(Note note : Note.values()){
            System.out.println(note + " " + note.tone());
        }

        System.out.println(my_note);
        System.out.println(chord);

        for(int i = 0; i < 15; i++)
            System.out.println(i % 14);
    }

}
