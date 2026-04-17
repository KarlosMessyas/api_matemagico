package br.com.matemagico.domain.enums;

public enum AutismLevel {
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3);

    private final int level;

    AutismLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
