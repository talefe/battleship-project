package org.academiadecodigo.battleship.sound;

public enum SoundType {
    START("theme2.wav"),
    HIT("hit.wav"),
    MISS("miss.wav"),
    DESTROYED("destroyed.wav"),
    END("end.wav");

    private String path;

    SoundType(String path) {
        this.path = "/resources/" + path;
    }

    public String getPath() {
        return path;
    }

}
