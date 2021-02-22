package org.liquidengine.legui.style;

import org.joml.Vector2f;
import org.joml.Vector4f;
import org.liquidengine.legui.icon.Icon;
import org.liquidengine.legui.style.color.ColorConstants;

/**
 * The type Background.
 *
 * @author ShchAlexander.
 */
public class Background {

    private Vector4f color = null;
    private Icon icon;
    private Vector2f position;
    private Vector2f size;


    /**
     * Returns {@link Vector4f} background color vector where x,y,z,w mapped to r,g,b,a values. <ul> <li>vector.x - red.</li> <li>vector.y - green.</li>
     * <li>vector.z - blue.</li> <li>vector.a - alpha.</li> </ul>
     *
     * @return background color vector.
     */
    public Vector4f getColor() {
        return color;
    }

    /**
     * Used to set background color vector where x,y,z,w mapped to r,g,b,a values. <ul> <li>vector.x - red.</li> <li>vector.y - green.</li> <li>vector.z -
     * blue.</li> <li>vector.a - alpha.</li> </ul>
     *
     * @param color background color vector.
     */
    public Background setColor(Vector4f color) {
        if (color != null) {
            this.color = color;
        } else {
            this.color = ColorConstants.transparent();
        }
        return this;
    }

    /**
     * Used to set background color vector.
     *
     * @param r red value.
     * @param g green value.
     * @param b blue value.
     * @param a alpha value.
     */
    public Background setColor(float r, float g, float b, float a) {
        color.set(r, g, b, a);
        return this;
    }

    /**
     * Gets icon.
     *
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Sets icon.
     *
     * @param icon the icon
     */
    public Background setIcon(Icon icon) {
        this.icon = icon;
        return this;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Vector2f getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public Background setPosition(Vector2f position) {
        this.position = position;
        return this;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public Vector2f getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public Background setSize(Vector2f size) {
        this.size = size;
        return this;
    }
}
