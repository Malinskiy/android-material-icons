package com.malinskiy.materialicons.sample;

/**
 * A dummy item representing a piece of content.
 */
public class Icon {
    public String id;
    public String content;

    public Icon(String id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
