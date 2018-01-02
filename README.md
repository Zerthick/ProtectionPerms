# ProtectionPerms:
ProtectionPerms is a simple player protection and control plugin inspired by plugins like ModifyWorld or NoItem.  It's aim is to provide an easy, permissions-based way of preventing players from performing certain actions on your server, such as breaking blocks, damaging entities, or using items.

## Permssions:
At this time, ProtectionPerms is completely based off permissions.  Without a given permission, players will **not** be able to perform the action the permission specifies.  Currently, permissions come in three flavors:

### Block Permissions:

* `protectionperms.block.interact.<blockID>.primary` - Player can primary interact (left-click) on `blockID`. 
  * Example: `protectionperms.block.interact.minecraft:stone.primary`

* `protectionperms.block.interact.<blockID>.secondary` - Player can secondary interact (right-click) on `blockID`. 
  * Example: `protectionperms.block.interact.minecraft:dirt.secondary`

* `protectionperms.block.break.<blockID>` - Player can break `blockID`. 
  * Example: `protectionperms.block.break.minecraft:stone`

* `protectionperms.block.place.<blockID>` - Player can place `blockID`. 
  * Example: `protectionperms.block.place.minecraft:stone`

### Entity Permissions:

* `protectionperms.entity.interact.<entityID>.primary` - Player can primary interact (left-click) on `enityName`.
  * Example: `protectionperms.entity.interact.minecraft:zombie.primary`

* `protectionperms.entity.interact.<entityID>.secondary` - Player can secondary interact (right-click) on `enityName`. 
  * Example: `protectionperms.entity.interact.minecraft:pig.secondary`

* `protectionperms.entity.tame.<entityID>` - Player can tame `enityName`. 
  * Example: `protectionperms.entity.tame.minecraft:wolf`

* `protectionperms.entity.breed.<entityID>` - Player can breed `enityName`. 
  * Example: `protectionperms.entity.breed.minecraft:cow`

* `protectionperms.entity.mount.<entityID>` - Player can mount `enityName`. 
  * Example: `protectionperms.entity.mount.minecraft:entityhorse`

* `protectionperms.entity.damage.<entityID>.deal` - Player can deal damage to `enityName`. 
  * Example: `protectionperms.entity.damage.minecraft:skeleton.deal`
  
* `protectionperms.entity.hook.<entityID>` - Player can hook `enityName` with a fishing pole. 
  * Example: `protectionperms.entity.hook.minecraft:sheep`

### Item Permissions:

* `protectionperms.item.use.<itemID>.on.self` - Player can use (right-click) with `itemID` on themselves (Example: eating bread). 
  * Example: `protectionperms.item.use.minecraft:bread.on.self`

* `protectionperms.item.use.<itemID>.on.<ID>.primary` - Player can primary use (left-click) with `itemID` on the block or entity `ID`. 
  * Example: `protectionperms.item.use.minecraft:diamond_sword.on.minecraft:zombie`

* `protectionperms.item.use.<itemID>.on.<ID>.secondary` - Player can secondary use (right-click) with `itemID` on the block or entity `ID`. 
  * Example: `protectionperms.item.use.minecraft:iron_hoe.on.minecraft:grass`

* `protectionperms.item.equip.<itemID>` - Player can equip `itemID` to an armor slot. 
  * Example: `protectionperms.item.equip.minecraft:iron_chestplate`

* `protectionperms.item.drop.<itemID>.dispense` - Player can drop `itemID` on the ground. 
  * Example: `protectionperms.item.drop.minecraft:diamond_sword.dispense`

* `protectionperms.item.drop.<itemID>.death` - Player will drop `itemID` on death. 
  * Example: `protectionperms.item.drop.minecraft:diamond.death`

* `protectionperms.item.craft.<itemID>` - Player can craft `itemID`. 
  * Example: `protectionperms.item.craft.minecraft:torch`
  
* `protectionperms.item.smelt.<itemID>` - Player can smelt `itemID` in a furance. 
  * Example: `protectionperms.item.smelt.minecraft:iron_ore`

* `protectionperms.item.fuel.<itemID>` - Player can us `itemID` as fuel in a furance. 
  * Example: `protectionperms.item.fuel.minecraft:coal`

#### A Note on BlockStates:
Whenever a permission requires a blockID you can optionally include `BlockState` information. For example if I wanted to give the player permission to break Andesite but not regular stone I could give them the permission `protectionperms.block.break.minecraft:stone[variant=andesite]`. Giving the player the `protectionperms.block.break.minecraft:stone` permission still allows them to break all variants of stone as normal.

When creating your permission nodes you may run into situations where you have conflicting permissions. For instance, you may not be able to place a block even though you have the place permission because you don't have the corresponding use permission for the block as an item, in this case pay attention to the message ProtectionPerms gives you when you try to execute an action, it should point you toward the permission node you need. :wink:

## Support Me
I will **never** charge money for the use of my plugins, however they do require a significant amount of work to maintain and update. If you'd like to show your support and buy me a cup of tea sometime (I don't drink that horrid coffee stuff :P) you can do so [here](https://www.paypal.me/zerthick)
