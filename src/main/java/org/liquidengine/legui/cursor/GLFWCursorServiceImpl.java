package org.liquidengine.legui.cursor;

import net.minecraft.util.Identifier;
import org.liquidengine.legui.system.context.Context;
import org.lwjgl.glfw.GLFW;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GLFWCursorServiceImpl implements CursorService {
    private Map<Cursor, Long> cursors = new ConcurrentHashMap<>();

    @Override
    public void setCursor(Cursor cursor, Context context) {
        if (cursor == null) {
            resetCursor(context);
            return;
        }
        GLFW.glfwSetCursor(context.getGlfwWindow(), cursors.computeIfAbsent(cursor, (c) -> c.createHandle()));
    }

    @Override
    public void resetCursor(Context context) {
        GLFW.glfwSetCursor(context.getGlfwWindow(), 0);
    }
}
