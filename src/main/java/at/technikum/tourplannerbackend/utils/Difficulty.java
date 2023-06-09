package at.technikum.tourplannerbackend.utils;

public enum Difficulty {

    SUPER_EASY("super easy"),
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    EXTREME("extreme");

    Difficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public final String difficulty;
}
