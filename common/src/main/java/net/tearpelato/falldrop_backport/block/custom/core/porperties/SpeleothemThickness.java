package net.tearpelato.falldrop_backport.block.custom.core.porperties;

import net.minecraft.util.StringRepresentable;

public enum SpeleothemThickness implements StringRepresentable {
    TIP_MERGE("tip_merge"),
    TIP("tip"),
    FRUSTUM("frustum"),
    MIDDLE("middle"),
    BASE("base");

    private final String name;

    private SpeleothemThickness(final String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}
