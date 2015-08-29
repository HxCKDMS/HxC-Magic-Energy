package HxCKDMS.HxCMagicEnergy.Client.Renderer.TileEntitySpecialRenderer;

import HxCKDMS.HxCMagicEnergy.Lib.References;
import HxCKDMS.HxCMagicEnergy.TileEntities.TileEntityMagicRune;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TESRMagicRune extends TileEntitySpecialRenderer {
    private final ResourceLocation textureMagicRune = new ResourceLocation(References.MOD_ID + ":textures/blocks/MagicRune.png");

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTick) {
        renderTileEntityAt((TileEntityMagicRune) tileEntity, x, y, z, partialTick);
    }

    public void renderTileEntityAt(TileEntityMagicRune tileEntity, double x, double y, double z, float partialTick) {
        GL11.glPushMatrix();
        {
            GL11.glTranslated(x, y, z);
            Tessellator tessellator = Tessellator.instance;

            if (tileEntity.isMaster) {
                this.bindTexture(textureMagicRune);

                double min = -1;
                double max = 2;
                double minY = 0;
                double maxY = 1;
                tessellator.startDrawingQuads();
                drawRune(tessellator, min, max, minY, maxY);
                tessellator.draw();
            } else if(!tileEntity.isSlave) {
                this.bindTexture(textureMagicRune);

                double min = 0;
                double max = 1;
                double minY = 0;
                double maxY = 1;
                tessellator.startDrawingQuads();
                drawRune(tessellator, min, max, minY, maxY);
                tessellator.draw();
            }
        }
        GL11.glPopMatrix();
    }

    public void drawRune(Tessellator tessellator, double min, double max, double minY, double maxY) {
        tessellator.addVertexWithUV(min, maxY, max, 0, 0);
        tessellator.addVertexWithUV(max, maxY, max, 0, 1);
        tessellator.addVertexWithUV(max, maxY, min, 1, 1);
        tessellator.addVertexWithUV(min, maxY, min, 1, 0);

        tessellator.addVertexWithUV(max, minY, max, 0, 0);
        tessellator.addVertexWithUV(min, minY, max, 0, 1);
        tessellator.addVertexWithUV(min, minY, min, 1, 1);
        tessellator.addVertexWithUV(max, minY, min, 1, 0);

        tessellator.addVertexWithUV(min, minY, max, 0, 0);
        tessellator.addVertexWithUV(min, maxY, max, 0, 1);
        tessellator.addVertexWithUV(min, maxY, min, 1, 1);
        tessellator.addVertexWithUV(min, minY, min, 1, 0);

        tessellator.addVertexWithUV(max, minY, min, 0, 0);
        tessellator.addVertexWithUV(max, maxY, min, 0, 1);
        tessellator.addVertexWithUV(max, maxY, max, 1, 1);
        tessellator.addVertexWithUV(max, minY, max, 1, 0);

        tessellator.addVertexWithUV(min, minY, min, 0, 0);
        tessellator.addVertexWithUV(min, maxY, min, 0, 1);
        tessellator.addVertexWithUV(max, maxY, min, 1, 1);
        tessellator.addVertexWithUV(max, minY, min, 1, 0);

        tessellator.addVertexWithUV(min, minY, max, 0, 0);
        tessellator.addVertexWithUV(max, minY, max, 0, 1);
        tessellator.addVertexWithUV(max, maxY, max, 1, 1);
        tessellator.addVertexWithUV(min, maxY, max, 1, 0);
    }
}
