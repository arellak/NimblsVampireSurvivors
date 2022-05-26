package de.nimbl.vampiresurvivors.items;

public enum WeaponType {
    PENIS("ITEM_PENIS"),
    ;

    private final String textID;

    WeaponType(String type) {
        this.textID = type;
    }

    @Override
    public String toString() {
        return this.textID;
    }
}
