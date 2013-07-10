package com.twoseasgames.viewport;

import static playn.core.PlayN.graphics;

import playn.core.Image;
import playn.core.ImageLayer;

public class ImageView {

    private ImageLayer layer;
    private Rect rect;
    private Section parent;
    private Rect realRect;
    private boolean posChanged; 
    private boolean sizeChanged; 
    
    public ImageView(Image image, Rect rect) {
        this.rect = rect;
        posChanged = false;
        sizeChanged = false;
        layer = graphics().createImageLayer(image);
    }
    
    public void setParent(Section parent) {
        this.parent = parent;
        realRect = parent.getRealRect(rect);
        posChanged = true;
        sizeChanged = true;
    }
    
    public void setCenterPosition(int x, int y) {
        rect.setX(x - rect.width() / 2);
        rect.setY(y - rect.height() / 2);
        realRect = parent.getRealRect(rect);
        posChanged = true;
    }
    
    public void setVisible(boolean visible) {
        layer.setVisible(visible);
    }
    
    public void setImage(Image image) {
    	layer.setImage(image);
    }

    public void paint() {
        if (sizeChanged == true) {
            layer.setSize(realRect.width(), realRect.height());
        }
        if (posChanged == true) {
            layer.setTranslation(realRect.x(), realRect.y());
        }
        posChanged = false;
        sizeChanged = false;
    }
}
