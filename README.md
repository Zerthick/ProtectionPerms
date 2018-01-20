# ProtectionPerms
ProtectionPerms is a simple player protection and control plugin inspired by plugins like ModifyWorld or NoItem.  It's aim is to provide an easy, permissions-based way of preventing players from performing certain actions on your server, such as breaking blocks, damaging entities, or using items.

## Permissions
At this time, ProtectionPerms is completely based off permissions.  Without a given permission, players will **not** be able to perform the action the permission specifies (unless the inversion flag is set as described below).  Currently, permissions come in three flavors:

### Block Permissions
#### Primary Interaction
* `protectionperms.block.interact.<blockID>.primary` - Player can primary interact (left-click) on `blockID`. 
  * Example: `protectionperms.block.interact.minecraft:stone.primary`
#### Secondary Interaction
* `protectionperms.block.interact.<blockID>.secondary` - Player can secondary interact (right-click) on `blockID`. 
  * Example: `protectionperms.block.interact.minecraft:dirt.secondary`
#### Breaking
* `protectionperms.block.break.<blockID>` - Player can break `blockID`. 
  * Example: `protectionperms.block.break.minecraft:stone`
#### Placing
* `protectionperms.block.place.<blockID>` - Player can place `blockID`. 
  * Example: `protectionperms.block.place.minecraft:stone`

### Entity Permissions
#### Primary Interaction
* `protectionperms.entity.interact.<entityID>.primary` - Player can primary interact (left-click) on `enityName`.
  * Example: `protectionperms.entity.interact.minecraft:zombie.primary`
#### Secondary Interaction
* `protectionperms.entity.interact.<entityID>.secondary` - Player can secondary interact (right-click) on `enityName`. 
  * Example: `protectionperms.entity.interact.minecraft:pig.secondary`
#### Taming
* `protectionperms.entity.tame.<entityID>` - Player can tame `enityName`. 
  * Example: `protectionperms.entity.tame.minecraft:wolf`
#### Breeding
* Currently preventing entities from breeding is not functioning, in the meantime you can use the item interact event permissions to prevent players from right-clicking on entites with the item that makes them breed
#### Mounting
* `protectionperms.entity.mount.<entityID>` - Player can mount `enityName`. 
  * Example: `protectionperms.entity.mount.minecraft:entityhorse`
#### Dealing Damage
* `protectionperms.entity.damage.<entityID>.deal` - Player can deal damage to `enityName`. 
  * Example: `protectionperms.entity.damage.minecraft:skeleton.deal`
#### Hook (Fishing)  
* `protectionperms.entity.hook.<entityID>` - Player can hook `enityName` with a fishing pole. 
  * Example: `protectionperms.entity.hook.minecraft:sheep`

### Item Permissions
#### General Usage
* `protectionperms.item.use.<itemID>` - Player can use `itemID` (Example: casting a fishing rod)
  * Example: `protectionperms.item.use.minecraft:fishing_rod`
#### Usage on Self
* `protectionperms.item.use.<itemID>.on.self` - Player can use (right-click) with `itemID` on themselves (Example: eating bread). 
  * Example: `protectionperms.item.use.minecraft:bread.on.self`
#### Primary Usage on Subject
* `protectionperms.item.use.<itemID>.on.<ID>.primary` - Player can primary use (left-click) with `itemID` on the block or entity `ID`. 
  * Example: `protectionperms.item.use.minecraft:diamond_sword.on.minecraft:zombie`
#### Secondary Usage on Subject
* `protectionperms.item.use.<itemID>.on.<ID>.secondary` - Player can secondary use (right-click) with `itemID` on the block or entity `ID`. 
  * Example: `protectionperms.item.use.minecraft:iron_hoe.on.minecraft:grass`
#### Equipping
* `protectionperms.item.equip.<itemID>` - Player can equip `itemID` to an armor slot. 
  * Example: `protectionperms.item.equip.minecraft:iron_chestplate`
#### Picking Up
* `protectionperms.item.pickup.<itemID>` - Player can pickup `itemID` from the ground. 
  * Example: `protectionperms.item.pickup.minecraft:diamond`
#### Dropping
* Not Recommended. See issue [#13](https://github.com/Zerthick/ProtectionPerms/issues/13)
* `protectionperms.item.drop.<itemID>.dispense` - Player can drop `itemID` on the ground. 
  * Example: `protectionperms.item.drop.minecraft:diamond_sword.dispense`
#### Drop on Death
* Not Recommended. See issue [#13](https://github.com/Zerthick/ProtectionPerms/issues/13)
* `protectionperms.item.drop.<itemID>.death` - Player can drop `itemID` on death. 
  * Example: `protectionperms.item.drop.minecraft:diamond.death`
#### Crafting
* `protectionperms.item.craft.<itemID>` - Player can craft `itemID`. 
  * Example: `protectionperms.item.craft.minecraft:torch`
#### Smelting
* `protectionperms.item.smelt.<itemID>` - Player can smelt `itemID` in a furance. 
  * Example: `protectionperms.item.smelt.minecraft:iron_ore`
#### Use as Fuel
* `protectionperms.item.fuel.<itemID>` - Player can use `itemID` as fuel in a furance. 
  * Example: `protectionperms.item.fuel.minecraft:coal`

### A Note on BlockStates
Whenever a permission requires a blockID you can optionally include `BlockState` information. For example if I wanted to give the player permission to break Andesite but not regular stone I could give them the permission `protectionperms.block.break.minecraft:stone[variant=andesite]`. Giving the player the `protectionperms.block.break.minecraft:stone` permission still allows them to break all variants of stone as normal.

### Conflicts
When creating your permission nodes you may run into situations where you have conflicting permissions. For instance, you may not be able to place a block even though you have the place permission because you don't have the corresponding use permission for the block as an item, in this case pay attention to the message ProtectionPerms gives you when you try to execute an action, it should point you toward the permission node you need. :wink:

## Inverting Permissions
ProtectionPerms runs in "whitelist" mode, where players cannot perform any actions that have not been granted to them. You can change this behavior by changing the mode in the config file at `~/config/ProtectionPerms.conf`.

**Whitelist mode prevents players from performing any action unless the according permission node is granted to them.**

**Blacklist mode allows players to perform all actions, unless the according permission node is granted.**

### Default Config
```
# ProtectionPerms

# The mode the plugin runs in.
# Whitelist mode prevents players from performing any action unless the according permission node is granted to them.
# Blacklist mode allows players to perform all actions, unless the according permission node is granted.
# Values: whitelist or blacklist
# Default: whitelist
mode = whitelist
```
## Migrating to v1.4.0
ProtectionPerms v1.4.0 changed the configuration file, and it must be migrated. The easiest way to do this is to delete the current configuration file.

See [above](#default-config) for the default configuration file for v1.4.0.

If you set `invert=true` in the current config, change the mode to `blacklist` in the new config. (`mode = blacklist`)

If you never made any changes to the old config file, just delete the old config file. ProtectionPerms will generate a new one for you.

If you have any questions, feel free to open an issue.

## Support Me
I will **never** charge money for the use of my plugins, however they do require a significant amount of work to maintain and update. If you'd like to show your support and buy me a cup of tea sometime (I don't drink that horrid coffee stuff :P) you can do so [here](https://www.paypal.me/zerthick)
