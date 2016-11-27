#ProtectionPerms:
ProtectionPerms is a simple player protection and control plugin inspired by plugins like ModifyWorld or NoItem.  It's aim is to provide an easy, permissions-based way of preventing players from performing certain actions on your server, such as breaking blocks, damaging entities, or using items.

##Sponge Forum Post:
You can view the Sponge Forum post of ProtectionPerms [here](https://forums.spongepowered.org/t/wip-protectionperms-v0-1-0-a-simple-player-protection-control-plugin/10481)!

##Permssions:
At this time, ProtectionPerms is completely based off permissions.  Without a given permission, players will **not** be able to perform the action the permission specifies.  Currently, permissions come in three flavors:

###Block Permissions:

* `protectionperms.block.interact.<blockID>.primary` - Player can primary interact (left-click) on `blockID`. 
  * Example: `protectionperms.block.interact.minecraft:stone.primary`

* `protectionperms.block.interact.<blockID>.secondary` - Player can secondary interact (right-click) on `blockID`. 
  * Example: `protectionperms.block.interact.minecraft:dirt.secondary`

* `protectionperms.block.break.<blockID>` - Player can break `blockID`. 
  * Example: `protectionperms.block.break.minecraft:stone`

* `protectionperms.block.place.<blockID>` - Player can place `blockID`. 
  * Example: `protectionperms.block.place.minecraft:stone`

###Entity Permissions:

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

###Item Permissions:

* `protectionperms.item.use.<itemID>` - Player can use (right-click) with `itemID` on themselves (Example: eating bread). 
  * Example: `protectionperms.item.use.minecraft:bread`

* `protectionperms.item.use.<itemID>.on.<ID>.primary` - Player can primary use (left-click) with `itemID` on the block or entity `ID`. 
  * Example: `protectionperms.item.use.minecraft:diamond_sword.on.minecraft:zombie`

* `protectionperms.item.use.<itemID>.on.<ID>.secondary` - Player can secondary use (right-click) with `itemID` on the block or entity `ID`. 
  * Example: `protectionperms.item.use.minecraft:iron_hoe.on.minecraft:grass`

* `protectionperms.item.drop.<itemID>` - Player can drop `itemID` on the ground. 
  * Example: `protectionperms.item.drop.minecraft:diamond_sworld`

When creating your permission nodes you may run into situations where you have conflicting permissions. For instance, you may not be able to place a block even though you have the place permission because you don't have the corresponding use permission for the block as an item, in this case pay attention to the message ProtectionPerms gives you when you try to execute an action, it should point you toward the permission node you need. :wink:
