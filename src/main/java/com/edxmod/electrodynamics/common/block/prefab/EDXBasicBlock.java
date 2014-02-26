package com.edxmod.electrodynamics.common.block.prefab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

/**
 * @author Royalixor
 */
public abstract class EDXBasicBlock extends Block {

    public EDXBasicBlock(Material material) {
        super(material);
    }

    public EDXBasicBlock(Material material, float hardness, float resistance) {
        this(material);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    @SideOnly(Side.CLIENT)
    public abstract boolean useCustomRender();

    @SideOnly(Side.CLIENT)
    public abstract void registerBlockIcons(IIconRegister iconRegister);

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.stone.getIcon(0, 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isOpaqueCube() {
        return !this.useCustomRender();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean renderAsNormalBlock() {
        return !this.useCustomRender();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderType() {
        return this.useCustomRender() ? -1 : 1;
    }

}
