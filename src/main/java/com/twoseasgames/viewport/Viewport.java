package com.twoseasgames.viewport;

import static playn.core.PlayN.*;

public class Viewport extends Section {

    private int width;
    private int height;
    
    public Viewport(int width, int height) {
        super(new Rect(0, 0, width, height));
        this.width = width;
        this.height = height;
    }

    public Rect getRealRect(Rect rect) {
        return new Rect(
            rect.x() * graphics().width() / width,
            rect.y() * graphics().height() / height,
            rect.width() * graphics().width() / width,
            rect.height() * graphics().height() / height
        );
    }
    
}
