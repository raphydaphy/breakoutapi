# Breakout API
BreakoutAPI is a Minecraft mod which allows developers to create new windows that run alongside Minecraft. All the windows run on the same OpenGL context, so all the game assets and data is shared between them. With this library, you can create external GUIs, maps, inventory reports and much more - you could even render a portion of your Minecraft world from a different perspective, or split in-game GUIs between physical screens. 

## Using BreakoutAPI in your mod
To get started using BreaakoutAPI, you will need to create aa class which extends **AbstractBreakout**:
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