package org.liquidengine.legui.cursor;

import net.minecraft.util.Identifier;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Cursor {

    private final Identifier id;

    public Cursor(Identifier id) {
        this.id = id;
    }

    public abstract long createHandle();

    public Identifier getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cursor that = (Cursor) o;
        return new EqualsBuilder().appendSuper(super.equals(o)).append(this.id, that.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(this.id).toHashCode();
    }
}
