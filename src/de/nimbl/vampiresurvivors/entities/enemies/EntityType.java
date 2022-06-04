package de.nimbl.vampiresurvivors.entities.enemies;

public enum EntityType { //Should be EntityType

    PLAYER("ENT_PLAYER"),
    BAT("ENT_BAT"),

    GARLIC("ENT_GARLIC")

    ;

    private final String textID;

    EntityType(final String type){
        this.textID = type;
    }

    @Override
    public String toString() {
        return textID;
    }


}
