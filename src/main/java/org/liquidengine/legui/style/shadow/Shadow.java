package org.liquidengine.legui.style.shadow;

import org.joml.Vector4f;
import org.liquidengine.legui.style.color.ColorConstants;

/**
 * Created by ShchAlexander on 10.05.2018.
 */
public class Shadow {

    private float hOffset;
    private float vOffset;
    private float blur;
    private float spread;
    private Vector4f color = ColorConstants.transparent();

    public Shadow() {
    }

    public Shadow(float hOffset, float vOffset, float blur, float spread, Vector4f color) {
        this.hOffset = hOffset;
        this.vOffset = vOffset;
        this.blur = blur;
        this.spread = spread;
        this.color = color;
    }

    public float gethOffset() {
        return hOffset;
    }

    public Shadow sethOffset(float hOffset) {
        this.hOffset = hOffset;
        return this;
    }

    public float getvOffset() {
        return vOffset;
    }

    public Shadow setvOffset(float vOffset) {
        this.vOffset = vOffset;
        return this;
    }

    public float getBlur() {
        return blur;
    }

    public Shadow setBlur(float blur) {
        if (blur > 0) {
            this.blur = blur;
        }
        return this;
    }

    public float getSpread() {
        return spread;
    }

    public Shadow setSpread(float spread) {
        this.spread = spread;
        return this;
    }

    public Vector4f getColor() {
        return color;
    }

    public Shadow setColor(Vector4f color) {
        this.color = color;
        return this;
    }
}
