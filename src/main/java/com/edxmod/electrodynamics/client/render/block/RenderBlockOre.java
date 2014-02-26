package com.edxmod.electrodynamics.client.render.block;

import com.edxmod.electrodynamics.client.render.BetterRenderer;
import com.edxmod.electrodynamics.common.block.BlockOre;
import com.edxmod.electrodynamics.common.util.RenderHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * @author Royalixor
 */
public class RenderBlockOre extends BetterRenderer {

    public static int renderID;

    static {
        renderID = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public int getRenderId() {
        return renderID;
    }

    @Override
    public void renderInventoryBlock(RenderBlocks renderer, Block block, int meta) {
        GL11.glPushMatrix();

        GL11.glRotated(180, 1, 0, 0);

        RenderHelper.instance.renderAllSides(renderer, block, Blocks.stone.getIcon(0, 0));
        RenderHelper.instance.renderAllSides(renderer, block, ((BlockOre) block).iconOverlays[meta]);

        GL11.glPopMatrix();
    }

    @Override
    public void renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, RenderBlocks renderer) {
        RenderHelper.instance.forceGraphics(true);
        RenderHelper.instance.forceLighting(0);

        renderer.renderStandardBlock(block, x, y, z);

        RenderHelper.instance.resetLighting();
        RenderHelper.instance.resetGraphics();
    }
}
