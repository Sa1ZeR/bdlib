/*
 * Copyright (c) bdew, 2013 - 2014
 * https://github.com/bdew/bdlib
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.lib.network

import net.minecraft.item.{Item, ItemStack}
import net.minecraft.network.PacketBuffer

class ItemStackSerialize(var stack: ItemStack) extends Serializable {
  private def writeObject(p: PacketBuffer) {
    p.writeShort(Item.getIdFromItem(stack.getItem))
    p.writeByte(stack.stackSize)
    p.writeShort(stack.getItemDamage)
    if (stack.hasTagCompound)
      p.writeNBTTagCompoundToBuffer(stack.getTagCompound)
    else
      p.writeNBTTagCompoundToBuffer(null)
  }

  private def readObject(p: PacketBuffer) {
    val id = p.readShort()
    val sz = p.readByte()
    val dmg = p.readShort()
    stack = new ItemStack(Item.getItemById(id), sz, dmg)
    val obj = p.readNBTTagCompoundFromBuffer();
    if (obj != null)
      stack.setTagCompound(obj)
  }
}

object ItemStackSerialize {

  import scala.language.implicitConversions

  implicit def ser2content(v: ItemStackSerialize): ItemStack = v.stack
  implicit def content2ser(v: ItemStack): ItemStackSerialize = new ItemStackSerialize(v)
}

