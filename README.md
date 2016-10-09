#ProtectionPerms:
ProtectionPerms is a simple player protection and control plugin inspired by plugins like ModifyWorld or NoItem.  It's aim is to provide an easy, permissions-based way of preventing players from performing certain actions on your server, such as breaking blocks, damaging entities, or using items.

##Sponge Forum Post:
You can view the Sponge Forum post of ProtectionPerms [here](https://forums.spongepowered.org/t/wip-protectionperms-v0-1-0-a-simple-player-protection-control-plugin/10481)!

##Permssions:
At this time, ProtectionPerms is completely based off permissions.  Without a given permission, players will **not** be able to perform the action the permission specifies.  Currently, permissions come in three flavors:

###Block Permissions:

* `protectionperms.block.interact.<blockName>.primary` - Player can primary interact (left-click) on `blockName`.
Example: `protecitonPerms.block.interact.minecraft:stone.primary`

* `protectionperms.block.interact.<blockName>.secondary` - Player can secondary interact (right-click) on `blockName`. 
Example: `protecitonPerms.block.interact.minecraft:dirt.secondary`

* `protectionperms.block.break.<blockName>` - Player can break `blockName`. 
Example: `protectionperms.block.break.minecraft:stone`

* `protectionperms.block.place.<blockName>` - Player can place `blockName`. 
Example: `protectionperms.block.place.minecraft:stone`

###Entity Permissions:

* `protectionperms.entity.interact.<entityName>.primary` - Player can primary interact (left-click) on `enityName`.
Example: `protecitonPerms.entity.interact.minecraft:zombie.primary`

* `protectionperms.entity.interact.<entityName>.secondary` - Player can secondary interact (right-click) on `enityName`. 
Example: `protecitonPerms.entity.interact.minecraft:pig.secondary`

* `protectionperms.entity.tame.<entityName>` - Player can tame `enityName`. 
Example: `protecitonPerms.entity.tame.minecraft:wolf`

* `protectionperms.entity.breed.<entityName>` - Player can breed `enityName`. 
Example: `protecitonPerms.entity.breed.minecraft:cow`

* `protectionperms.entity.mount.<entityName>` - Player can mount `enityName`. 
Example: `protecitonPerms.entity.mount.minecraft:entityhorse`

* `protectionperms.entity.damage.<entityName>.deal` - Player can deal damage to `enityName`. 
Example: `protecitonPerms.entity.damage.minecraft:skeleton.deal`

###Item Permissions:

* `protectionperms.item.use.<itemName>.on.<name>.primary` - Player can primary use (left-click) with `itemName` on the block or entity `name`. 
Example: `protecitonPerms.item.use.minecraft:diamond_sword.on.minecraft:zombie`

* `protectionperms.item.use.<itemName>.on.<name>.secondary` - Player can secondary use (right-click) with `itemName` on the block or entity `name`. 
Example: `protecitonPerms.item.use.minecraft:iron_hoe.on.minecraft:grass`

When creating your permission nodes you may run into situations where you have conflicting permissions. For instance, you may not be able to place a block even though you have the place permission because you don't have the corresponding use permission for the block as an item, in this case pay attention to the message ProtectionPerms gives you when you try to execute an action, it should point you toward the permission node you need. :wink:
