package org.liquidengine.legui.style.font;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.liquidengine.legui.Legui;

/**
 * Created by ShchAlexander on 1/26/2017.
 */
public class FontRegistry {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Default entypo font.
     */
    public static final String ENTYPO = "entypo";
    /**
     * Default roboto-bold font.
     */
    public static final String ROBOTO_BOLD = "roboto-bold";
    /**
     * Default roboto-light font.
     */
    public static final String ROBOTO_LIGHT = "roboto-light";
    /**
     * Default roboto-regular font.
     */
    public static final String ROBOTO_REGULAR = "roboto-regular";
    /**
     * Default material-icons-regular font.
     */
    public static final String MATERIAL_ICONS_REGULAR = "MaterialIcons-Regular";
    /**
     * Default font-awesome-icons font.
     */
    public static final String FONT_AWESOME_ICONS = "FontAwesomeIcons";
    /**
     * Default material-design-icons font.
     */
    public static final String MATERIAL_DESIGN_ICONS = "materialdesignicons";
    /**
     * Font used by default. {@link #ROBOTO_BOLD}.
     */
    private static String defaultFont = ROBOTO_LIGHT;

    public static String getDefaultFont() {
        return defaultFont;
    }

    public static void setDefaultFont(String defaultFont) {
        FontRegistry.defaultFont = Objects.requireNonNull(defaultFont);
    }

    /**
     * Font register.
     */
    private static final Map<String, Font> fontRegister = new ConcurrentHashMap<>();

    static {
        registerFont(ENTYPO, new Identifier(Legui.ID, "fonts/entypo.ttf"));
        registerFont(ROBOTO_BOLD, new Identifier(Legui.ID, "fonts/roboto_bold.ttf"));
        registerFont(ROBOTO_LIGHT, new Identifier(Legui.ID, "fonts/roboto_light.ttf"));
        registerFont(ROBOTO_REGULAR, new Identifier(Legui.ID, "fonts/roboto_regular.ttf"));
        registerFont(MATERIAL_ICONS_REGULAR, new Identifier(Legui.ID, "fonts/material_icons_regular.ttf"));
        registerFont(FONT_AWESOME_ICONS, new Identifier(Legui.ID, "fonts/font_awesome.otf"));
        registerFont(MATERIAL_DESIGN_ICONS, new Identifier(Legui.ID, "fonts/material_design_icons.ttf"));
    }

    /**
     * Private constructor to avoid creation instances of utility class.
     */
    private FontRegistry() {
    }

    /**
     * Used to register fonts.
     *
     * @param name font name.
     * @param path font path.
     */
    public static void registerFont(final String name, final Identifier path) {
        try {
            Font font = new Font(path);
            fontRegister.put(name, font);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Returns map of fonts where key is font name and value is font.
     *
     * @return map of fonts where key is font name and value is font.
     */
    public static Map<String, Font> getFontRegister() {
        return new HashMap<>(fontRegister);
    }

    /**
     * Used to retrieve font by name
     *
     * @param name font name.
     *
     * @return font or null.
     */
    public static Font getFont(String name) {
        return fontRegister.get(name);
    }
}
