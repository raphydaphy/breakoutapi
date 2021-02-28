package org.liquidengine.legui.style;

import org.joml.Vector4f;
import org.liquidengine.legui.component.optional.align.HorizontalAlign;
import org.liquidengine.legui.component.optional.align.VerticalAlign;
import org.liquidengine.legui.style.border.Border;
import org.liquidengine.legui.style.border.SimpleLineBorder;
import org.liquidengine.legui.style.color.ColorConstants;
import org.liquidengine.legui.style.flex.FlexStyle;
import org.liquidengine.legui.style.length.Length;
import org.liquidengine.legui.style.length.Unit;
import org.liquidengine.legui.style.shadow.Shadow;

import static org.liquidengine.legui.style.length.LengthType.pixel;

/**
 * The type Style.
 *
 * @author ShchAlexander.
 */
public class Style {

    private DisplayType display = DisplayType.MANUAL;
    private PositionType position = PositionType.ABSOLUTE;

    private FlexStyle flexStyle = new FlexStyle();
    private Background background = new Background();
    private Border border = new SimpleLineBorder(ColorConstants.gray(), 1);

    private Length borderTopLeftRadius;
    private Length borderTopRightRadius;
    private Length borderBottomRightRadius;
    private Length borderBottomLeftRadius;

    private Length width;
    private Length height;

    private Length minWidth;
    private Length minHeight;

    private Length maxWidth;
    private Length maxHeight;

    private Length paddingTop;
    private Length paddingBottom;
    private Length paddingRight;
    private Length paddingLeft;

    private Unit marginTop;
    private Unit marginBottom;
    private Unit marginRight;
    private Unit marginLeft;

    private Length top;
    private Length bottom;
    private Length right;
    private Length left;

    private Shadow shadow;

    /**
     * Stroke color. Used to render stroke if component is focused.
     */
    private Vector4f focusedStrokeColor = ColorConstants.lightBlue();

    // TEXT RELATED STYLE PROPERTIES.

    private String font;
    private Float fontSize;
    /**
     * Horizontal alignment. By default used {@link HorizontalAlign#CENTER}.
     */
    private HorizontalAlign horizontalAlign;
    /**
     * Vertical alignment.
     */
    private VerticalAlign verticalAlign;
    /**
     * Text color.
     */
    private Vector4f textColor;
    /**
     * Highlight color (used to highlight selection).
     */
    private Vector4f highlightColor;


    /**
     * Used to set border radius for all four corners. (PIXEL VERSION)
     *
     * @param radius radius to set. Sets border radius to all corners.
     */
    public Style setBorderRadius(float radius) {
        setBorderRadius(pixel(radius));
        return this;
    }


    /**
     * Used to set border radius for all four corners.
     *
     * @param radius radius to set. Sets border radius to all corners.
     */
    public Style setBorderRadius(Length radius) {
        borderTopLeftRadius = borderTopRightRadius =
                borderBottomRightRadius = borderBottomLeftRadius = radius;
        return this;
    }

    /**
     * Used to set border radius. (PIXEL VERSION)
     *
     * @param topLeftBottomRight top left and bottom right radius.
     * @param topRightBottomLeft top right and bottom left radius.
     */
    public Style setBorderRadius(float topLeftBottomRight, float topRightBottomLeft) {
        setBorderRadius(pixel(topLeftBottomRight), pixel(topRightBottomLeft));
        return this;
    }

    /**
     * Used to set border radius.
     *
     * @param topLeftBottomRight top left and bottom right radius.
     * @param topRightBottomLeft top right and bottom left radius.
     */
    public Style setBorderRadius(Length topLeftBottomRight, Length topRightBottomLeft) {
        borderTopLeftRadius = borderBottomRightRadius = topLeftBottomRight;
        borderTopRightRadius = borderBottomLeftRadius = topRightBottomLeft;
        return this;
    }

    /**
     * Used to set border radius. (PIXEL VERSION)
     *
     * @param topLeft            top left radius.
     * @param bottomRight        bottom right radius.
     * @param topRightBottomLeft top right and bottom left radius.
     */
    public Style setBorderRadius(float topLeft, float topRightBottomLeft, float bottomRight) {
        setBorderRadius(pixel(topLeft), pixel(topRightBottomLeft), pixel(bottomRight));
        return this;
    }

    /**
     * Used to set border radius.
     *
     * @param topLeft            top left radius.
     * @param bottomRight        bottom right radius.
     * @param topRightBottomLeft top right and bottom left radius.
     */
    public Style setBorderRadius(Length topLeft, Length topRightBottomLeft, Length bottomRight) {
        borderTopLeftRadius = topLeft;
        borderTopRightRadius = borderBottomLeftRadius = topRightBottomLeft;
        borderBottomRightRadius = bottomRight;
        return this;
    }

    /**
     * Used to set border radius. (PIXEL VERSION)
     *
     * @param topLeft     top left radius.
     * @param topRight    top right radius.
     * @param bottomRight bottom right radius.
     * @param bottomLeft  bottom left radius.
     */
    public Style setBorderRadius(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        setBorderRadius(pixel(topLeft), pixel(topRight), pixel(bottomRight), pixel(bottomLeft));
        return this;
    }

    /**
     * Used to set border radius.
     *
     * @param topLeft     top left radius.
     * @param topRight    top right radius.
     * @param bottomRight bottom right radius.
     * @param bottomLeft  bottom left radius.
     */
    public Style setBorderRadius(Length topLeft, Length topRight, Length bottomRight, Length bottomLeft) {
        borderTopLeftRadius = topLeft;
        borderTopRightRadius = topRight;
        borderBottomRightRadius = bottomRight;
        borderBottomLeftRadius = bottomLeft;
        return this;
    }

    /**
     * Returns top left border radius.
     *
     * @return top left border radius.
     */
    public Length getBorderTopLeftRadius() {
        return borderTopLeftRadius;
    }

    /**
     * Used to set top left border radius. (PIXEL VERSION)
     *
     * @param borderTopLeftRadius top left border radius.
     */
    public Style setBorderTopLeftRadius(float borderTopLeftRadius) {
        setBorderTopLeftRadius(pixel(borderTopLeftRadius));
        return this;
    }

    /**
     * Used to set top left border radius.
     *
     * @param borderTopLeftRadius top left border radius.
     */
    public Style setBorderTopLeftRadius(Length borderTopLeftRadius) {
        this.borderTopLeftRadius = borderTopLeftRadius;
        return this;
    }

    /**
     * Returns top right border radius.
     *
     * @return top right border radius.
     */
    public Length getBorderTopRightRadius() {
        return borderTopRightRadius;
    }

    /**
     * Used to set top right border radius. (PIXEL VERSION)
     *
     * @param borderTopRightRadius top right border radius.
     */
    public Style setBorderTopRightRadius(float borderTopRightRadius) {
        setBorderTopRightRadius(pixel(borderTopRightRadius));
        return this;
    }

    /**
     * Used to set top right border radius.
     *
     * @param borderTopRightRadius top right border radius.
     */
    public Style setBorderTopRightRadius(Length borderTopRightRadius) {
        this.borderTopRightRadius = borderTopRightRadius;
        return this;
    }

    /**
     * Returns bottom right border radius.
     *
     * @return bottom right border radius.
     */
    public Length getBorderBottomRightRadius() {
        return borderBottomRightRadius;
    }

    /**
     * Used to set bottom right border radius. (PIXEL VERSION)
     *
     * @param borderBottomRightRadius bottom right border radius.
     */
    public Style setBorderBottomRightRadius(float borderBottomRightRadius) {
        setBorderBottomRightRadius(pixel(borderBottomRightRadius));
        return this;
    }

    /**
     * Used to set bottom right border radius.
     *
     * @param borderBottomRightRadius bottom right border radius.
     */
    public Style setBorderBottomRightRadius(Length borderBottomRightRadius) {
        this.borderBottomRightRadius = borderBottomRightRadius;
        return this;
    }

    /**
     * Returns bottom left border radius.
     *
     * @return bottom left border radius.
     */
    public Length getBorderBottomLeftRadius() {
        return borderBottomLeftRadius;
    }

    /**
     * Used to set bottom left border radius. (PIXEL VERSION)
     *
     * @param borderBottomLeftRadius bottom left border radius.
     */
    public Style setBorderBottomLeftRadius(float borderBottomLeftRadius) {
        setBorderBottomLeftRadius(pixel(borderBottomLeftRadius));
        return this;
    }

    /**
     * Used to set bottom left border radius.
     *
     * @param borderBottomLeftRadius bottom left border radius.
     */
    public Style setBorderBottomLeftRadius(Length borderBottomLeftRadius) {
        this.borderBottomLeftRadius = borderBottomLeftRadius;
        return this;
    }

    /**
     * Returns width.
     *
     * @return width.
     */
    public Length getWidth() {
        return width;
    }

    /**
     * Used to set width. (PIXEL VERSION)
     *
     * @param width width to set.
     */
    public Style setWidth(float width) {
        setWidth(pixel(width));
        return this;
    }

    /**
     * Used to set width.
     *
     * @param width width to set.
     */
    public Style setWidth(Length width) {
        this.width = width;
        return this;
    }

    /**
     * Used to set height.
     *
     * @return height to set.
     */
    public Length getHeight() {
        return height;
    }

    public Style setHeight(float height) {
        setHeight(pixel(height));
        return this;
    }

    public Style setHeight(Length height) {
        this.height = height;
        return this;
    }

    public Length getMinWidth() {
        return minWidth;
    }

    public Style setMinWidth(float minWidth) {
        setMinWidth(pixel(minWidth));
        return this;
    }

    public Style setMinWidth(Length minWidth) {
        this.minWidth = minWidth;
        return this;
    }

    public Length getMinHeight() {
        return minHeight;
    }

    public Style setMinHeight(float minHeight) {
        setMinHeight(pixel(minHeight));
        return this;
    }

    public Style setMinHeight(Length minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    public Length getMaxWidth() {
        return maxWidth;
    }

    public Style setMaxWidth(float maxWidth) {
        setMaxWidth(pixel(maxWidth));
        return this;
    }

    public Style setMaxWidth(Length maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    public Length getMaxHeight() {
        return maxHeight;
    }

    public Style setMaxHeight(float maxHeight) {
        setMaxHeight(pixel(maxHeight));
        return this;
    }

    public Style setMaxHeight(Length maxHeight) {
        this.maxHeight = maxHeight;
        return this;
    }

    public Style setWidths(float width) {
        return this.setWidth(width).setMinWidth(width).setMaxWidth(width);
    }

    public Style setWidths(Length width) {
        return this.setWidth(width).setMinWidth(width).setMaxWidth(width);
    }

    public Style setHeights(float height) {
        return this.setHeight(height).setMinHeight(height).setMaxHeight(height);
    }

    public Style setHeights(Length height) {
        return this.setHeight(height).setMinHeight(height).setMaxHeight(height);
    }

    public Style setPadding(float padding) {
        this.setPadding(pixel(padding));
        return this;
    }

    public Style setPadding(Length padding) {
        paddingLeft = paddingRight =
                paddingTop = paddingBottom = padding;
        return this;
    }

    public Style setPadding(float topBottom, float leftRight) {
        this.setPadding(pixel(topBottom), pixel(leftRight));
        return this;
    }

    public Style setPadding(Length topBottom, Length leftRight) {
        paddingLeft = paddingRight = leftRight;
        paddingTop = paddingBottom = topBottom;
        return this;
    }

    public Style setPadding(float top, float right, float bottom, float left) {
        this.setPadding(pixel(top), pixel(right), pixel(bottom), pixel(left));
        return this;
    }

    public Style setPadding(Length top, Length right, Length bottom, Length left) {
        paddingTop = top;
        paddingRight = right;
        paddingBottom = bottom;
        paddingLeft = left;
        return this;
    }

    public Length getPaddingTop() {
        return paddingTop;
    }

    public Style setPaddingTop(Length paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }


    public Length getPaddingBottom() {
        return paddingBottom;
    }

    public Style setPaddingBottom(Length paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }


    public Length getPaddingRight() {
        return paddingRight;
    }

    public Style setPaddingRight(Length paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }


    public Length getPaddingLeft() {
        return paddingLeft;
    }

    public Style setPaddingLeft(Length paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public Style setMargin(float margin) {
        setMargin(pixel(margin));
        return this;
    }

    public Style setMargin(Unit margin) {
        marginLeft = marginRight = marginTop = marginBottom = margin;
        return this;
    }

    public Style setMargin(float topBottom, float leftRight) {
        setMargin(pixel(topBottom), pixel(leftRight));
        return this;
    }

    public Style setMargin(Unit topBottom, Unit leftRight) {
        marginLeft = marginRight = leftRight;
        marginTop = marginBottom = topBottom;
        return this;
    }

    public Style setMargin(float top, float right, float bottom, float left) {
        setMargin(pixel(top), pixel(right), pixel(bottom), pixel(left));
        return this;
    }

    public Style setMargin(Unit top, Unit right, Unit bottom, Unit left) {
        marginTop = top;
        marginRight = right;
        marginBottom = bottom;
        marginLeft = left;
        return this;
    }

    public Unit getMarginTop() {
        return marginTop;
    }

    public Style setMarginTop(Unit marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public Style setMarginTop(Float marginTop) {
        setMarginTop(pixel(marginTop));
        return this;
    }

    public Unit getMarginBottom() {
        return marginBottom;
    }

    public Style setMarginBottom(Unit marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public Style setMarginBottom(Float marginBottom) {
        setMarginBottom(pixel(marginBottom));
        return this;
    }

    public Unit getMarginRight() {
        return marginRight;
    }

    public Style setMarginRight(Unit marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    public Style setMarginRight(Float marginRight) {
        setMarginRight(pixel(marginRight));
        return this;
    }

    public Unit getMarginLeft() {
        return marginLeft;
    }

    public Style setMarginLeft(Unit marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public Style setMarginLeft(Float marginLeft) {
        setMarginLeft(pixel(marginLeft));
        return this;
    }

    /**
     * Returns top style.
     *
     * @return top style.
     */
    public Length getTop() {
        return top;
    }

    /**
     * Used tp set top style. (PIXEL VERSION)
     *
     * @param top top style.
     */
    public Style setTop(float top) {
        setTop(pixel(top));
        return this;
    }

    /**
     * Used tp set top style.
     *
     * @param top top style.
     */
    public Style setTop(Length top) {
        this.top = top;
        return this;
    }

    /**
     * Returns bottom style.
     *
     * @return bottom style.
     */
    public Length getBottom() {
        return bottom;
    }

    /**
     * Used tp set bottom style. (PIXEL VERSION)
     *
     * @param bottom bottom style.
     */
    public Style setBottom(float bottom) {
        setBottom(pixel(bottom));
        return this;
    }

    /**
     * Used tp set bottom style.
     *
     * @param bottom bottom style.
     */
    public Style setBottom(Length bottom) {
        this.bottom = bottom;
        return this;
    }

    /**
     * Returns right style.
     *
     * @return right style.
     */
    public Length getRight() {
        return right;
    }

    /**
     * Used tp set right style. (PIXEL VERSION)
     *
     * @param right right style.
     */
    public Style setRight(float right) {
        setRight(pixel(right));
        return this;
    }

    /**
     * Used tp set right style.
     *
     * @param right right style.
     */
    public Style setRight(Length right) {
        this.right = right;
        return this;
    }

    /**
     * Returns left style.
     *
     * @return left style.
     */
    public Length getLeft() {
        return left;
    }

    /**
     * Used tp set left style. (PIXEL VERSION)
     *
     * @param left left style.
     */
    public Style setLeft(float left) {
        setLeft(pixel(left));
        return this;
    }

    /**
     * Used tp set left style.
     *
     * @param left left style.
     */
    public Style setLeft(Length left) {
        this.left = left;
        return this;
    }

    /**
     * Returns display style.
     *
     * @return display style.
     */
    public DisplayType getDisplay() {
        return display;
    }

    /**
     * Used to set display type.
     *
     * @param display display to set.
     */
    public Style setDisplay(DisplayType display) {
        if (display == null) {
            this.display = DisplayType.MANUAL;
        }
        this.display = display;
        return this;
    }

    /**
     * Gets background.
     *
     * @return the background
     */
    public Background getBackground() {
        return background;
    }

    /**
     * Sets background.
     *
     * @param background the background
     */
    public Style setBackground(Background background) {
        if (background != null) {
            this.background = background;
        } else {
            this.background = new Background();
        }
        return this;
    }

    /**
     * Gets border.
     *
     * @return the border
     */
    public Border getBorder() {
        return border;
    }

    /**
     * Sets border.
     *
     * @param border the border
     */
    public Style setBorder(Border border) {
        this.border = border;
        return this;
    }

    /**
     * Gets font.
     *
     * @return the font
     */
    public String getFont() {
        return font;
    }

    /**
     * Sets font.
     *
     * @param font the font
     */
    public Style setFont(String font) {
        this.font = font;
        return this;
    }

    /**
     * Returns {@link Vector4f} focused stroke color vector where x,y,z,w mapped to r,g,b,a values. <ul> <li>vector.x - red.</li> <li>vector.y - green.</li>
     * <li>vector.z - blue.</li> <li>vector.a - alpha.</li> </ul>
     *
     * @return background color vector.
     */
    public Vector4f getFocusedStrokeColor() {
        return focusedStrokeColor;
    }

    /**
     * Used to set focused stroke color vector where x,y,z,w mapped to r,g,b,a values. <ul> <li>vector.x - red.</li> <li>vector.y - green.</li> <li>vector.z -
     * blue.</li> <li>vector.a - alpha.</li> </ul>
     *
     * @param focusedStrokeColor focused stroke color vector.
     */
    public Style setFocusedStrokeColor(Vector4f focusedStrokeColor) {
        this.focusedStrokeColor = focusedStrokeColor;
        return this;
    }

    /**
     * Used to set focused stroke color vector.
     *
     * @param r red value.
     * @param g green value.
     * @param b blue value.
     * @param a alpha value.
     */
    public Style setFocusedStrokeColor(float r, float g, float b, float a) {
        focusedStrokeColor.set(r, g, b, a);
        return this;
    }

    /**
     * Flex style object.
     *
     * @return flex style object.
     */
    public FlexStyle getFlexStyle() {
        return flexStyle;
    }

    /**
     * Returns position type or null.
     *
     * @return position type or null.
     */
    public PositionType getPosition() {
        return position;
    }

    /**
     * Used to set position style.
     *
     * @param position position type to set.
     */
    public Style setPosition(PositionType position) {
        if (position != null) {
            this.position = position;
        }
        return this;
    }

    /**
     * Used to set minimum width and height
     *
     * @param width  minimum width to set.
     * @param height minimum height to set.
     */
    public Style setMinimumSize(float width, float height) {
        setMinWidth(width);
        setMinHeight(height);
        return this;
    }

    /**
     * Used to set max width and height.
     *
     * @param width  max width to set.
     * @param height max height to set.
     */
    public Style setMaximumSize(float width, float height) {
        setMaxWidth(width);
        setMaxHeight(height);
        return this;
    }

    /**
     * Used to quickly set the size of the element
     *
     * @param width The width of the element
     * @param height The height of the element
     */
    public Style setSize(float width, float height) {
        return this.setWidth(width).setHeight(height);
    }

    public Shadow getShadow() {
        return shadow;
    }

    public Style setShadow(Shadow shadow) {
        this.shadow = shadow;
        return this;
    }

    public Float getFontSize() {
        return fontSize;
    }

    public Style setFontSize(Float fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * Returns horizontal alignment.
     *
     * @return horizontal alignment.
     */
    public HorizontalAlign getHorizontalAlign() {
        return horizontalAlign;
    }

    /**
     * Used to set horizontal alignment.
     *
     * @param horizontalAlign horizontal alignment.
     */
    public Style setHorizontalAlign(HorizontalAlign horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
        return this;
    }

    /**
     * Returns vertical alignment.
     *
     * @return vertical alignment.
     */
    public VerticalAlign getVerticalAlign() {
        return verticalAlign;
    }

    /**
     * Used to set vertical alignment.
     *
     * @param verticalAlign vertical alignment.
     */
    public Style setVerticalAlign(VerticalAlign verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
    }

    /**
     * Returns text color.
     *
     * @return text color.
     */
    public Vector4f getTextColor() {
        return textColor;
    }

    /**
     * Used to set text color.
     *
     * @param textColor text color.
     */
    public Style setTextColor(Vector4f textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * Used to set text color.
     *
     * @param r red component.
     * @param g green component.
     * @param b blue component.
     * @param a alpha component.
     */
    public Style setTextColor(float r, float g, float b, float a) {
        this.textColor = new Vector4f(r, g, b, a);
        return this;
    }

    /**
     * Returns highlight color.
     *
     * @return highlight color
     */
    public Vector4f getHighlightColor() {
        return highlightColor;
    }

    /**
     * Used to set highlight color.
     *
     * @param highlightColor highlight color.
     */
    public Style setHighlightColor(Vector4f highlightColor) {
        this.highlightColor = highlightColor;
        return this;
    }

    /**
     * Sets the position type to relative (necessary to use flex layouts)
     */
    public Style enableFlex() {
        return this.setPosition(PositionType.RELATIVE);
    }

    /**
     * Used to quickly configure the necessary properties to use flex layout
     *
     * @param width The width of the element
     * @param height The height of the element
     */
    public Style enableFlex(float width, float height) {
        return this.enableFlex().setSize(width, height).setMinimumSize(width, height).setMaximumSize(width, height);
    }

    /**
     * Used to quickly enable infinite flex growth in the specified direction
     *
     * @param direction The flex direction of the parent component
     */
    public Style enableFlexGrow(FlexStyle.FlexDirection direction) {
        this.enableFlex().getFlexStyle().setFlexGrow(1);
        if (direction == FlexStyle.FlexDirection.ROW || direction == FlexStyle.FlexDirection.ROW_REVERSE) {
            this.setMaxWidth(Float.MAX_VALUE);
        } else {
            this.setMaxHeight(Float.MAX_VALUE);
        }
        return this;
    }

    /**
     * Used to set highlight color.
     *
     * @param r red component.
     * @param g green component.
     * @param b blue component.
     * @param a alpha component.
     */
    public Style setHighlightColor(float r, float g, float b, float a) {
        this.highlightColor = new Vector4f(r, g, b, a);
        return this;
    }

    /**
     * Css display type.
     */
    public enum DisplayType {
        /**
         * Flex display means that it is parent for flex child.
         */
        FLEX,
        /**
         * Manual display type.
         */
        MANUAL,
        /**
         * None display means that component with such style will not be rendered and used during laying out.
         */
        NONE
    }

    /**
     * Css position type.
     */
    public enum PositionType {
        RELATIVE,
        ABSOLUTE
    }

}
