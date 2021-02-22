# Breakout API
BreakoutAPI is a Minecraft mod which allows developers to create new windows that run alongside Minecraft. All the windows run on the same OpenGL context, so all the game assets and data is shared between them. With this library, you can create external GUIs, maps, inventory reports and much more - you could even render a portion of your Minecraft world from a different perspective, or split in-game GUIs between physical screens. 

## Using BreakoutAPI in your mod
To get started using BreaakoutAPI, add the following to your **build.gradle**:
```groovy
def joml_version=1.9.25 
def cbchain_version=1.0.0 
def commons_collections_version=4.1 
def lwjgl_version=3.2.2 
def breakoutapi_version=1.0.0 

repositories { 
  mavenCentral() 
  maven { url "https://oss.sonatype.org/content/repositories/releases/" } 
  maven { url "https://raw.github.com/SpinyOwl/repo/releases" } 
  maven { url "https://minecraft.curseforge.com/api/maven"}
}

dependencies { 
  compile "org.joml:joml:$joml_version" 
  compile "org.liquidengine:cbchain:$cbchain_version" 
  compile "org.apache.commons:commons-collections4:$commons_collections_version"

  implementation "org.lwjgl:lwjgl-nanovg:$lwjgl_version"
  runtimeOnly "org.lwjgl:lwjgl-nanovg:$lwjgl_version:natives-windows"
  runtimeOnly "org.lwjgl:lwjgl-nanovg:$lwjgl_version:natives-linux"
  runtimeOnly "org.lwjgl:lwjgl-nanovg:$lwjgl_version:natives-macos" 

  implementation "org.lwjgl:lwjgl-yoga:$lwjgl_version" 
  runtimeOnly "org.lwjgl:lwjgl-yoga:$lwjgl_version:natives-windows" 
  runtimeOnly "org.lwjgl:lwjgl-yoga:$lwjgl_version:natives-linux" 
  runtimeOnly "org.lwjgl:lwjgl-yoga:$lwjgl_version:natives-macos" 

  modCompile "breakoutapi:breakoutapi:$breakoutapi_version"
}
```

Once you have added the necessary dependencies and reloaded gradle, you can create your own Breakout windows by extending the **AbstractBreakout** class:
```java
public class ExampleBreakout extends Breakout {

  public ExampleBreakout(Identifier identifier) {
    super(identifier, new BreakoutWindow("Example Breakout", 480, 720));
  }

  @Override
  public void render() {
    super.render();

    MinecraftClient client = MinecraftClient.getInstance();
    MatrixStack stack = new MatrixStack();

    client.getTextureManager().bindTexture(new Identifier("textures/block/azalea_leaves.png"));
    DrawableHelper.drawTexture(stack, 50, 250, 0, 0, 0, 180, 300, 32, 32);

    client.textRenderer.draw(stack, "Hello world!", 100 / 3f, 200 / 3f, 0);
  }
}
```

Once you have created the class, you can open and close the breakout using the methods provided in `BreakoutAPIClient`. The `identifier` is only used to keep track of an instance of a breakout, and it can be used to close or track it after creation.
```java
Identifier id = new Identifier("your_mod_id", "your_first_breakout");
BreakoutAPIClient.openBreakout(id, new ExampleBreakout(id));
```