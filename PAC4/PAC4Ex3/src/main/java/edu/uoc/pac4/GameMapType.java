package edu.uoc.pac4;

public enum GameMapType {
    CITY, VALLEY, DESERT, FOREST, MOUNTAIN, OCEAN, PLAINS, ICE, VOLCANO, TEMPLE;

    @Override
    public String toString() {
        // Capitalize the first letter and make the rest lowercase
        String name = this.name().toLowerCase();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
