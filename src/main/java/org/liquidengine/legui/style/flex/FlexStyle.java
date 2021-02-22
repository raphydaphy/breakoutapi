package org.liquidengine.legui.style.flex;

/**
 * CSS flex style analogue.
 */
public class FlexStyle {

    /**
     * Specifies the direction of the flexible items
     */
    private FlexDirection flexDirection;
    /**
     * Specifies the alignment between the items inside a flexible container when the items do not use all available space.
     */
    private JustifyContent justifyContent;
    /**
     * Specifies the alignment for items inside a flexible container.
     */
    private AlignItems alignItems;
    /**
     * Specifies whether the flexible items should wrap or not.
     */
    private FlexWrap flexWrap;
    /**
     * Specifies the alignment between the lines inside a flexible container when the items do not use all available space.
     */
    private AlignContent alignContent;
    /**
     * Specifies the alignment for selected items inside a flexible container.
     */
    private AlignSelf alignSelf;
    /**
     * A number specifying how much the item will grow relative to the rest of the flexible items.
     */
    private int flexGrow;
    /**
     * A number specifying how much the item will shrink relative to the rest of the flexible items.
     */
    private int flexShrink;
    /**
     * The length of the item. Legal values: a number in px.
     */
    private float flexBasis;

    public FlexStyle() {
        this.flexDirection = FlexDirection.ROW;
        this.justifyContent = JustifyContent.FLEX_START;
        this.alignItems = AlignItems.STRETCH;
        this.flexWrap = FlexWrap.NOWRAP;
        this.alignContent = AlignContent.STRETCH;
        this.alignSelf = AlignSelf.AUTO;
    }

    public FlexStyle setFlex(int flexGrow, int flexShrink, float flexBasis) {
        setFlexGrow(flexGrow);
        setFlexShrink(flexShrink);
        setFlexBasis(flexBasis);
        return this;
    }

    public FlexStyle setFlexFlow(FlexDirection flexDirection, FlexWrap flexWrap) {
        setFlexDirection(flexDirection);
        setFlexWrap(flexWrap);
        return this;
    }

    public AlignSelf getAlignSelf() {
        return alignSelf;
    }

    public FlexStyle setAlignSelf(AlignSelf alignSelf) {
        this.alignSelf = alignSelf;
        return this;
    }

    public int getFlexGrow() {
        return flexGrow;
    }

    public FlexStyle setFlexGrow(int flexGrow) {
        this.flexGrow = flexGrow;
        return this;
    }

    public int getFlexShrink() {
        return flexShrink;
    }

    public FlexStyle setFlexShrink(int flexShrink) {
        this.flexShrink = flexShrink;
        return this;
    }

    public float getFlexBasis() {
        return flexBasis;
    }

    public FlexStyle setFlexBasis(float flexBasis) {
        this.flexBasis = flexBasis;
        return this;
    }

    public FlexDirection getFlexDirection() {
        return flexDirection;
    }

    public FlexStyle setFlexDirection(FlexDirection flexDirection) {
        if (flexDirection != null) {
            this.flexDirection = flexDirection;
        }
        return this;
    }

    public JustifyContent getJustifyContent() {
        return justifyContent;
    }

    public FlexStyle setJustifyContent(JustifyContent justifyContent) {
        if (justifyContent != null) {
            this.justifyContent = justifyContent;
        }
        return this;
    }

    public AlignItems getAlignItems() {
        return alignItems;
    }

    public FlexStyle setAlignItems(AlignItems alignItems) {
        if (alignItems != null) {
            this.alignItems = alignItems;
        }
        return this;
    }

    public FlexWrap getFlexWrap() {
        return flexWrap;
    }

    public FlexStyle setFlexWrap(FlexWrap flexWrap) {
        if (flexWrap != null) {
            this.flexWrap = flexWrap;
        }
        return this;
    }

    public AlignContent getAlignContent() {
        return alignContent;
    }

    public FlexStyle setAlignContent(AlignContent alignContent) {
        if (alignContent != null) {
            this.alignContent = alignContent;
        }
        return this;
    }

    /**
     * Specifies the alignment for selected items inside a flexible container.
     */
    public enum AlignSelf {
        /**
         * Default. The element inherits its parent container's align-items property, or "stretch" if it has no parent container.
         */
        AUTO,
        /**
         * The element is positioned to fit the container.
         */
        STRETCH,
        /**
         * The element is positioned at the center of the container.
         */
        CENTER,
        /**
         * The element is positioned at the beginning of the container.
         */
        FLEX_START,
        /**
         * The element is positioned at the end of the container.
         */
        FLEX_END,
        /**
         * The element is positioned at the baseline of the container.
         */
        BASELINE,
        /**
         * Sets this property to its default value.
         */
        INITIAL,
        /**
         * Inherits this property from its parent element..
         */
        INHERIT
    }

    /**
     * Specifies the alignment between the lines inside a flexible container when the items do not use all available space.
     */
    public enum AlignContent {
        /**
         * Default value. Lines stretch to take up the remaining space.
         */
        STRETCH,
        /**
         * Lines are packed toward the center of the flex container.
         */
        CENTER,
        /**
         * Lines are packed toward the start of the flex container.
         */
        FLEX_START,
        /**
         * Lines are packed toward the end of the flex container.
         */
        FLEX_END,
        /**
         * Lines are evenly distributed in the flex container.
         */
        SPACE_BETWEEN,
        /**
         * Lines are evenly distributed in the flex container, with half-size spaces on either end.
         */
        SPACE_AROUND,
        /**
         * Sets this property to its default value.
         */
        INITIAL,
        /**
         * Inherits this property from its parent element..
         */
        INHERIT
    }

    /**
     * Specifies whether the flexible items should wrap or not.
     */
    public enum FlexWrap {
        /**
         * Default value. Specifies that the flexible items will not wrap.
         */
        NOWRAP,
        /**
         * Specifies that the flexible items will wrap if necessary.
         */
        WRAP,
        /**
         * Specifies that the flexible items will wrap, if necessary, in reverse order.
         */
        WRAP_REVERSE,
        INITIAL,
        INHERIT
    }

    /**
     * Specifies the alignment for items inside a flexible container.
     */
    public enum AlignItems {
        AUTO,
        /**
         * Default. Items are stretched to fit the container.
         */
        STRETCH,
        /**
         * Items are positioned at the center of the container.
         */
        CENTER,
        /**
         * Items are positioned at the beginning of the container.
         */
        FLEX_START,
        /**
         * Items are positioned at the end of the container.
         */
        FLEX_END,
        /**
         * Items are positioned at the baseline of the container.
         */
        BASELINE,
        /**
         * Sets this property to its default value.
         */
        INITIAL,
        /**
         * Inherits this property from its parent element..
         */
        INHERIT
    }

    /**
     * Specifies the alignment between the items inside a flexible container when the items do not use all available space.
     */
    public enum JustifyContent {
        /**
         * Default value. Items are positioned at the beginning of the container.
         */
        FLEX_START,
        /**
         * Items are positioned at the end of the container.
         */
        FLEX_END,
        /**
         * Items are positioned at the center of the container.
         */
        CENTER,
        /**
         * Items are positioned with space between the lines.
         */
        SPACE_BETWEEN,
        /**
         * Items are positioned with space before, between, and after the lines.
         */
        SPACE_AROUND,
        /**
         * Distribute items evenly. Items have equal space around them.
         */
        SPACE_EVENLY,
        /**
         * Sets this property to its default value.
         */
        INITIAL,
        /**
         * Inherits this property from its parent element..
         */
        INHERIT
    }

    /**
     * Specifies the direction of the flexible items
     */
    public enum FlexDirection {
        /**
         * Default value. The flexible items are displayed horizontally, as a row.
         */
        ROW,
        /**
         * Same as row, but in reverse order.
         */
        ROW_REVERSE,
        /**
         * The flexible items are displayed vertically, as a column.
         */
        COLUMN,
        /**
         * Same as column, but in reverse order.
         */
        COLUMN_REVERSE
    }
}