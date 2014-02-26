package com.edxmod.electrodynamics.common.block;

import com.edxmod.electrodynamics.common.block.prefab.EDXMultiBlock;
import com.edxmod.electrodynamics.common.lib.EDXProps;
import com.edxmod.electrodynamics.common.tabs.EDXCreativeTab;
import com.edxmod.electrodynamics.common.util.UtilArray;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * @author Royalixor
 */
public class BlockLimestone extends EDXMultiBlock {

    private static final String[] limestoneTypes = new String[] { "limestone", "limestoneCobblestone", "limestoneBricks", "limestoneScorched", "limestoneScorcedBricks", "limestoneTiled" };
    private IIcon[] textures;

    public BlockLimestone() {
        super(Material.rock);
        setStepSound(Block.soundTypeStone);
        setCreativeTab(EDXCreativeTab.BLOCKS.get());
        setHardness(2.0F);
        setHarvestLevel("pickaxe", 1);
    }


    @Override
    public boolean useCustomRender() {
        return false;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        textures = new IIcon[limestoneTypes.length];
        for (int i = 0; i  < limestoneTypes.length; i++) {
            textures[i] = iconRegister.registerIcon(EDXProps.RESOURCE_PREFIX + "world/" + limestoneTypes[i]);
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta >= textures.length) {
            meta = 0;
        }
        return textures[meta];
    }

    @Override
    public int[] getSubtypes() {
        return UtilArray.getArrayIndexes(limestoneTypes.length);
    }

    @Override
    public String getNameForType(int type) {
        return limestoneTypes[type];
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }
}
