package de.nimbl.vampiresurvivors.items;

public abstract class Item {

    private String label;

    public Item() {
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }


}