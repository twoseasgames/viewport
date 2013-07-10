package com.twoseasgames.viewport;

import static playn.core.PlayN.graphics;
import playn.core.GroupLayer;

public class Section {

    private Rect rect;
    private Section parent;
    private GroupLayer layer;
    
    protected Section(Rect rect) {
        this.rect = rect;
        layer = graphics().createGroupLayer();
    }    

    public void setParent(Section parent) {
        this.parent = parent;
    }
    
    public Rect getRealRect(Rect rect) {
        Rect realRect = new Rect(
            this.rect.x() + rect.x(),
            this.rect.y() + rect.y(),
            rect.width(),
            rect.height()
        ); 
        return parent.getRealRect(realRect);
    }

    public GroupLayer layer() {
        return layer;
    }
    
    public Section addSection(Rect rect) {
        Section section = new Section(rect);
    	layer.add(section.layer);
        section.setParent(this);
        return section;
    }

    public void addImageView(ImageView imageView) {
    	layer.add(imageView.layer());
    	imageView.setParent(this);
    }

}
