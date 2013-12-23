/*
 * Copyright (c) bdew, 2013
 * https://github.com/bdew/bdlib
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://raw.github.com/bdew/bdlib/master/MMPL-1.0.txt
 */

package net.bdew.lib.gui

object Direction extends Enumeration {
  type Direction = Value
  val UP = Value("UP")
  val DOWN = Value("DOWN")
  val LEFT = Value("LEFT")
  val RIGHT = Value("RIGHT")
}
