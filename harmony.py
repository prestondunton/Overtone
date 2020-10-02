class Note:
    def __init__(self, name=None, tone=None):
        if name is not None and tone is not None:
            if

        elif name is not None:
            if type(name) == str:
                self.name = name.upper()
                self.tone = self.name_to_tone(self.name)
            else:
                raise TypeError()
        elif tone is not None:
            if type(tone) == int:
                self.tone = tone
            else:
                raise TypeError()
        else:
            raise ValueError("Either a note name or tone is required to construct a note.")

    def name_to_tone(name):
        if name == "C" or name == "B#" or name == "Dbb":
            tone = 0
        elif name == "C#" or name == "Db" or name == "B##":
            tone = 1
        elif name == "D" or name == "C##" or name == "Ebb":
            tone = 2
        elif name == "D#" or name == "Eb" or name == "Fbb":
            tone = 3
        elif name == "E" or name == "D##" or name == "Fb":
            tone = 4
        elif name == "F" or name == "E#" or name == "Gbb":
            tone = 5
        elif name == "F#" or name == "E##" or name == "Gb":
            tone = 6
        elif name == "G" or name == "F##" or name == "Abb":
            tone = 7
        elif name == "G#" or name == "Ab":
            tone = 8
        elif name == "A" or name == "G##" or name == "Bbb":
            tone = 9
        elif name == "A#" or name == "Bb" or name == "Cbb":
            tone = 10
        elif name == "B" or name == "A##" or name == "Cb":
            tone = 11
        else:
            raise ValueError('Improper Note Name: ""' + name + '"')
        return tone


class Interval:
    def __init__(self, low_note=None, high_note=None, distance=None, quality=None, semitones=None):

        # Needed conditions to construct an interval
        if low_note is not None and high_note is not None:
            semitones = high_note.tone - low_note.tone
            if semitones < 0:
                semitones += 12
            distance, quality = self.__semitones_to_distance_quality(semitones)
        elif low_note is not None and distance is not None and quality is not None:
            semitones = self.__distance_quality_to_semitones(distance, quality)
            high_note = self.__semitones_up(low_note)
        elif low_note is not None and semitones is not None:
            distance, quality = self.__semitones_to_distance_quality(semitones)
            high_note = self.__semitones_up(low_note)
        elif high_note is not None and distance is not None and quality is not None:
            semitones = self.__distance_quality_to_semitones(distance, quality)
            low_note = self.__semitones_down(high_note)
        elif high_note is not None and semitones is not None:
            distance, quality = self.__semitones_to_distance_quality(semitones)
            low_note = self.__semitones_down(high_note)
        elif distance is not None and quality is not None:
            semitones = self.__distance_quality_to_semitones(distance, quality)
        elif semitones is not None:
            distance, quality = self.__semitones_to_distance_quality(semitones)
        else:
            raise TypeError("Not enough information given to construct interval")

        self._low_note = low_note  # potentially None
        self._high_note = high_note # potentially None
        self._distance = distance
        self._quality = quality
        self._semitones = semitones

    def __distance_quality_to_semitones(self,distance,quality):

    def __semitones_to_distance_quality(self,semitones):

    def __semitones_up(self,low_note):

    def __semitones_down(self,high_note):
