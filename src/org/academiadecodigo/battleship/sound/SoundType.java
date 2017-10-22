package org.academiadecodigo.battleship.sound;

public enum SoundType {

    // find the right sounds, delete the rest
    // clean path for files in enum


    START("theme.wav"),
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
