package de.janschuri.SurvivalDebugStick;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.*;
import org.bukkit.block.data.type.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class BlockClickListener implements Listener {

    boolean processingClickEvent = false;
    int blockStateIndex = 0;
    private final Main plugin;

    public BlockClickListener(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null
                && event.getPlayer().getItemInHand().getItemMeta() != null
                && event.getPlayer().getItemInHand().getItemMeta().getPersistentDataContainer().has(Main.keyStick)) {
            event.setCancelled(true);
            if (processingClickEvent) return;
            processingClickEvent = true;
            Block block = event.getClickedBlock();

            BlockData blockData = block.getBlockData();
            BlockState blockState = block.getState();
            List<String> blockStates = new ArrayList<>();

            if (blockData instanceof Directional && Main.isAllowBlockState("directional")) {
                blockStates.add("directional");
            }
            if (blockData instanceof Orientable && Main.isAllowBlockState("orientable")) {
                blockStates.add("orientable");
            }
            if (blockData instanceof Powerable && Main.isAllowBlockState("powerable")) {
                blockStates.add("powerable");
            }
            if (blockData instanceof Waterlogged && Main.isAllowBlockState("waterlogged")) {
                blockStates.add("waterlogged");
            }
            if (blockData instanceof Bisected && Main.isAllowBlockState("bisected")) {
                blockStates.add("bisected");
            }
            if (blockData instanceof Ageable && Main.isAllowBlockState("ageable")) {
                blockStates.add("ageable");
            }
            if (blockData instanceof Rail && Main.isAllowBlockState("rail")) {
                blockStates.add("rail");
            }
            if (blockData instanceof Rotatable && Main.isAllowBlockState("rotatable")) {
                blockStates.add("rotatable");
            }
            if (blockData instanceof Stairs && Main.isAllowBlockState("stairs")) {
                blockStates.add("stairs");
            }
            if (blockData instanceof Bed && Main.isAllowBlockState("bed")) {
                blockStates.add("bed");
            }
            if (blockData instanceof Chest && Main.isAllowBlockState("chest")) {
                blockStates.add("chest");
            }
            if (blockData instanceof Cake && Main.isAllowBlockState("cake")) {
                blockStates.add("cake");
            }
            if (blockData instanceof Bamboo && Main.isAllowBlockState("bamboo")) {
                blockStates.add("bamboo");
            }
            if (blockData instanceof Openable && Main.isAllowBlockState("openable")) {
                blockStates.add("openable");
            }
            if (blockData instanceof Beehive && Main.isAllowBlockState("beehive")) {
                blockStates.add("beehive");
            }
            if (blockData instanceof Bell && Main.isAllowBlockState("bell")) {
                blockStates.add("bell");
            }
            if (blockData instanceof BigDripleaf && Main.isAllowBlockState("big_dripleaf")) {
                blockStates.add("big_dripleaf");
            }
            if (blockData instanceof Lightable && Main.isAllowBlockState("lightable")) {
                blockStates.add("lightable");
            }
            if (blockData instanceof BrewingStand && Main.isAllowBlockState("brewing_stand_bottles")) {
                blockStates.add("brewing_stand_bottle_0");
                blockStates.add("brewing_stand_bottle_1");
                blockStates.add("brewing_stand_bottle_2");
            }
            if (blockData instanceof FaceAttachable && Main.isAllowBlockState("face_attachable")) {
                blockStates.add("face_attachable");
            }
            if (blockData instanceof Campfire && Main.isAllowBlockState("campfire")) {
                blockStates.add("campfire");
            }
            if (blockData instanceof Candle && Main.isAllowBlockState("candle")) {
                blockStates.add("candle");
            }
            if (blockData instanceof Levelled && Main.isAllowBlockState("levelled")) {
                blockStates.add("levelled");
            }
            if (blockData instanceof ChiseledBookshelf && Main.isAllowBlockState("chiseled_bookshelf_slots")) {
                blockStates.add("chiseled_bookshelf_slot_0");
                blockStates.add("chiseled_bookshelf_slot_1");
                blockStates.add("chiseled_bookshelf_slot_2");
                blockStates.add("chiseled_bookshelf_slot_3");
                blockStates.add("chiseled_bookshelf_slot_4");
                blockStates.add("chiseled_bookshelf_slot_5");
            }
            if (blockData instanceof Wall && Main.isAllowBlockState("wall")) {
                blockStates.add("wall_north");
                blockStates.add("wall_east");
                blockStates.add("wall_south");
                blockStates.add("wall_west");
                blockStates.add("wall_up");
            }
            if (blockData instanceof MultipleFacing && Main.isAllowBlockState("multiple_facing")) {
                MultipleFacing multipleFacing = (MultipleFacing) blockData;
                List<BlockFace> faces = new ArrayList<>(multipleFacing.getAllowedFaces());
                for (BlockFace face : faces) {
                    blockStates.add("multiple_facing_" + face.toString().toLowerCase());
                }
            }
            if (blockData instanceof Attachable && Main.isAllowBlockState("attachable")) {
                blockStates.add("attachable");
            }
            if (blockData instanceof Gate && Main.isAllowBlockState("gate")) {
                blockStates.add("gate");
            }
            if (blockData instanceof Snowable && Main.isAllowBlockState("snowable")) {
                blockStates.add("snowable");
            }
            if (blockData instanceof Hangable && Main.isAllowBlockState("hangable")) {
                blockStates.add("hangable");
            }
            if (blockData instanceof NoteBlock) {
                if (Main.isAllowBlockState("noteblock_note")) {
                    blockStates.add("noteblock_note");
                }
                if (Main.isAllowBlockState("noteblock_instrument")) {
                    blockStates.add("noteblock_instrument");
                }
            }
            if (blockData instanceof PinkPetals && Main.isAllowBlockState("pink_petals")) {
                blockStates.add("pink_petals");
            }
            if (blockData instanceof Piston && Main.isAllowBlockState("piston")) {
                blockStates.add("piston");
            }
            if (blockData instanceof PistonHead) {
                if (Main.isAllowBlockState("piston_head_type")) {
                    blockStates.add("piston_head_type");
                }
                if (Main.isAllowBlockState("piston_head_short")) {
                    blockStates.add("piston_head_short");
                }
            }
            if (blockData instanceof PointedDripstone && Main.isAllowBlockState("dripstone_thickness")) {
                blockStates.add("dripstone_thickness");
            }
            if (blockData instanceof Comparator && Main.isAllowBlockState("comparator")) {
                blockStates.add("comparator");
            }
            if (blockData instanceof RedstoneWire && Main.isAllowBlockState("redstone_wire")) {
                blockStates.add("redstone_wire_north");
                blockStates.add("redstone_wire_east");
                blockStates.add("redstone_wire_south");
                blockStates.add("redstone_wire_west");
            }
            if (blockData instanceof Repeater) {
                if (Main.isAllowBlockState("repeater_delay")) {
                    blockStates.add("repeater_delay");
                }
                if (Main.isAllowBlockState("repeater_locked")) {
                    blockStates.add("repeater_locked");
                }
            }
            if (blockData instanceof RespawnAnchor && Main.isAllowBlockState("respawn_anchor")) {
                blockStates.add("charges");
            }
            if (blockData instanceof Scaffolding && Main.isAllowBlockState("scaffolding")) {
                blockStates.add("scaffolding");
            }
            if (blockData instanceof SculkCatalyst && Main.isAllowBlockState("sculk_catalyst")) {
                blockStates.add("sculk_catalyst");
            }
            if (blockData instanceof SculkSensor && Main.isAllowBlockState("sculk_sensor")) {
                blockStates.add("sculk_sensor");
            }
            if (blockData instanceof SculkShrieker && Main.isAllowBlockState("sculk_shrieker")) {
                blockStates.add("sculk_shrieker");
            }
            if (blockData instanceof SeaPickle && Main.isAllowBlockState("sea_pickle")) {
                blockStates.add("sea_pickle");
            }
            if (blockData instanceof Slab && Main.isAllowBlockState("slab")) {
                blockStates.add("slab");
            }
            if (blockData instanceof Snow && Main.isAllowBlockState("snow")) {
                blockStates.add("snow");
            }
            if (blockData instanceof TurtleEgg) {
                if (Main.isAllowBlockState("turtle_egg_hatch")) {
                    blockStates.add("turtle_egg_hatch");
                }
                if(Main.isAllowBlockState("turtle_egg_eggs")) {
                    blockStates.add("turtle_egg_eggs");
                }
            }



            if (!blockStates.isEmpty()) {
                if (event.getAction().isRightClick()) {
                    blockStateIndex = (blockStateIndex) % blockStates.size();

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("turtle_egg_hatch")) {
                        TurtleEgg turtleEgg = (TurtleEgg) blockData;
                        int maxHatches = turtleEgg.getMaximumHatch() + 1;
                        int hatches = turtleEgg.getHatch();
                        int newHatches = ((hatches + 1) % maxHatches);
                        turtleEgg.setHatch(newHatches);
                        blockState.setBlockData(turtleEgg);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newHatches);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("turtle_egg_eggs")) {
                        TurtleEgg turtleEgg = (TurtleEgg) blockData;
                        int maxEggs = turtleEgg.getMaximumEggs();
                        int eggs = turtleEgg.getEggs();
                        int newEggs = ((eggs) % maxEggs) + 1;
                        turtleEgg.setEggs(newEggs);
                        blockState.setBlockData(turtleEgg);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newEggs);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("snow")) {
                        Snow snow = (Snow) blockData;
                        int level = snow.getLayers();
                        int maxLevel = snow.getMaximumLayers();
                        int newLevel = ((level) % maxLevel) + 1;
                        snow.setLayers(newLevel);
                        blockState.setBlockData(snow);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newLevel);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("slab")) {
                        Slab slab = (Slab) blockData;
                        Slab.Type type = slab.getType();
                        Slab.Type[] typesArray = new Slab.Type[]{
                                Slab.Type.BOTTOM,
                                Slab.Type.TOP,
                                Slab.Type.DOUBLE
                        };
                        List<Slab.Type> types = new ArrayList<>();
                        for (Slab.Type state : typesArray) {
                            if (Main.isAllowedState("slab", state.toString().toLowerCase())) {
                                types.add(state);
                            } else {
                                if (state == type) {
                                    return;
                                }
                            }
                        }
                        int index = types.indexOf(type);
                        int size = types.size();
                        int newIndex = (index + 1) % size;
                        slab.setType(types.get(newIndex));
                        blockState.setBlockData(slab);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + types.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("sea_pickle")) {
                        SeaPickle seaPickle = (SeaPickle) blockData;
                        int maxPickles = seaPickle.getMaximumPickles();
                        int pickles = seaPickle.getPickles();
                        int newPickles = ((pickles) % maxPickles) + 1;
                        seaPickle.setPickles(newPickles);
                        blockState.setBlockData(seaPickle);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newPickles);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("sculk_shrieker")) {
                        SculkShrieker sculkShrieker = (SculkShrieker) blockData;
                        sculkShrieker.setCanSummon(!sculkShrieker.isCanSummon());
                        blockState.setBlockData(sculkShrieker);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + sculkShrieker.isCanSummon());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("sculk_sensor")) {
                        SculkSensor sculkSensor = (SculkSensor) blockData;
                        SculkSensor.Phase phase = sculkSensor.getPhase();
                        SculkSensor.Phase[] phasesArray = new SculkSensor.Phase[]{
                                SculkSensor.Phase.ACTIVE,
                                SculkSensor.Phase.COOLDOWN,
                                SculkSensor.Phase.INACTIVE
                        };
                        List<SculkSensor.Phase> phases = new ArrayList<>();
                        for (SculkSensor.Phase state : phasesArray) {
                            if (Main.isAllowedState("sculk_sensor", state.toString().toLowerCase())) {
                                phases.add(state);
                            } else {
                                if (state == phase) {
                                    return;
                                }
                            }
                        }
                        int index = phases.indexOf(phase);
                        int size = phases.size();
                        int newIndex = (index + 1) % size;
                        sculkSensor.setPhase(phases.get(newIndex));
                        blockState.setBlockData(sculkSensor);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + phases.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("sculk_catalyst")) {
                        SculkCatalyst sculkCatalyst = (SculkCatalyst) blockData;
                        sculkCatalyst.setBloom(!sculkCatalyst.isBloom());

                        blockState.setBlockData(sculkCatalyst);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + sculkCatalyst.isBloom());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("scaffolding")) {
                        Scaffolding scaffolding = (Scaffolding) blockData;
                        scaffolding.setBottom(!scaffolding.isBottom());

                        blockState.setBlockData(scaffolding);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + scaffolding.isBottom());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("charges")) {
                        RespawnAnchor respawnAnchor = (RespawnAnchor) blockData;
                        int charges = respawnAnchor.getCharges();
                        int maxCharges = respawnAnchor.getMaximumCharges() + 1;
                        int newCharges = ((charges + 1) % maxCharges);
                        respawnAnchor.setCharges(newCharges);

                        blockState.setBlockData(respawnAnchor);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newCharges);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("repeater_locked")) {
                        Repeater repeater = (Repeater) blockData;
                        repeater.setLocked(!repeater.isLocked());

                        blockState.setBlockData(repeater);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + repeater.isLocked());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("repeater_delay")) {
                        Repeater repeater = (Repeater) blockData;
                        int delay = repeater.getDelay();
                        int maxDelay = repeater.getMaximumDelay();
                        int newDelay = ((delay) % maxDelay) + 1;
                        repeater.setDelay(newDelay);

                        blockState.setBlockData(repeater);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newDelay);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("redstone_wire_west")) {
                        RedstoneWire redstoneWire = (RedstoneWire) blockData;
                        RedstoneWire.Connection connection = redstoneWire.getFace(BlockFace.WEST);
                        RedstoneWire.Connection[] connectionsArray = new RedstoneWire.Connection[]{
                                RedstoneWire.Connection.UP,
                                RedstoneWire.Connection.SIDE,
                                RedstoneWire.Connection.NONE
                        };
                        List<RedstoneWire.Connection> connections = new ArrayList<>();
                        for (RedstoneWire.Connection state : connectionsArray) {
                            if (Main.isAllowedState("redstone_wire", state.toString().toLowerCase())) {
                                connections.add(state);
                            } else {
                                if (state == connection) {
                                    return;
                                }
                            }
                        }
                        int index = connections.indexOf(connection);
                        int size = connections.size();
                        int newIndex = (index + 1) % size;
                        redstoneWire.setFace(BlockFace.WEST, connections.get(newIndex));
                        blockState.setBlockData(redstoneWire);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + connections.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("redstone_wire_south")) {
                        RedstoneWire redstoneWire = (RedstoneWire) blockData;
                        RedstoneWire.Connection connection = redstoneWire.getFace(BlockFace.SOUTH);
                        RedstoneWire.Connection[] connectionsArray = new RedstoneWire.Connection[]{
                                RedstoneWire.Connection.UP,
                                RedstoneWire.Connection.SIDE,
                                RedstoneWire.Connection.NONE
                        };
                        List<RedstoneWire.Connection> connections = new ArrayList<>();
                        for (RedstoneWire.Connection state : connectionsArray) {
                            if (Main.isAllowedState("redstone_wire", state.toString().toLowerCase())) {
                                connections.add(state);
                            } else {
                                if (state == connection) {
                                    return;
                                }
                            }
                        }
                        int index = connections.indexOf(connection);
                        int size = connections.size();
                        int newIndex = (index + 1) % size;
                        redstoneWire.setFace(BlockFace.SOUTH, connections.get(newIndex));
                        blockState.setBlockData(redstoneWire);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + connections.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("redstone_wire_east")) {
                        RedstoneWire redstoneWire = (RedstoneWire) blockData;
                        RedstoneWire.Connection connection = redstoneWire.getFace(BlockFace.EAST);
                        RedstoneWire.Connection[] connectionsArray = new RedstoneWire.Connection[]{
                                RedstoneWire.Connection.UP,
                                RedstoneWire.Connection.SIDE,
                                RedstoneWire.Connection.NONE
                        };
                        List<RedstoneWire.Connection> connections = new ArrayList<>();
                        for (RedstoneWire.Connection state : connectionsArray) {
                            if (Main.isAllowedState("redstone_wire", state.toString().toLowerCase())) {
                                connections.add(state);
                            } else {
                                if (state == connection) {
                                    return;
                                }
                            }
                        }
                        int index = connections.indexOf(connection);
                        int size = connections.size();
                        int newIndex = (index + 1) % size;
                        redstoneWire.setFace(BlockFace.EAST, connections.get(newIndex));
                        blockState.setBlockData(redstoneWire);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + connections.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("redstone_wire_north")) {
                        RedstoneWire redstoneWire = (RedstoneWire) blockData;
                        RedstoneWire.Connection connection = redstoneWire.getFace(BlockFace.NORTH);
                        RedstoneWire.Connection[] connectionsArray = new RedstoneWire.Connection[]{
                                RedstoneWire.Connection.UP,
                                RedstoneWire.Connection.SIDE,
                                RedstoneWire.Connection.NONE
                        };
                        List<RedstoneWire.Connection> connections = new ArrayList<>();
                        for (RedstoneWire.Connection state : connectionsArray) {
                            if (Main.isAllowedState("redstone_wire", state.toString().toLowerCase())) {
                                connections.add(state);
                            } else {
                                if (state == connection) {
                                    return;
                                }
                            }
                        }
                        int index = connections.indexOf(connection);
                        int size = connections.size();
                        int newIndex = (index + 1) % size;
                        redstoneWire.setFace(BlockFace.NORTH, connections.get(newIndex));
                        blockState.setBlockData(redstoneWire);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + connections.get(newIndex));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("comparator")) {
                        Comparator comparator = (Comparator) blockData;
                        Comparator.Mode mode = comparator.getMode();
                        Comparator.Mode[] modesArray = new Comparator.Mode[]{
                                Comparator.Mode.SUBTRACT,
                                Comparator.Mode.COMPARE
                        };
                        List<Comparator.Mode> modes = new ArrayList<>();
                        for (Comparator.Mode state : modesArray) {
                            if (Main.isAllowedState("comparator", state.toString().toLowerCase())) {
                                modes.add(state);
                            } else {
                                if (state == mode) {
                                    return;
                                }
                            }
                        }
                        int index = modes.indexOf(mode);
                        int size = modes.size();
                        int newIndex = (index + 1) % size;
                        comparator.setMode(modes.get(newIndex));
                        blockState.setBlockData(comparator);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + comparator.getMode());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("dripstone_thickness")) {
                        PointedDripstone pointedDripstone = (PointedDripstone) blockData;
                        PointedDripstone.Thickness thickness = pointedDripstone.getThickness();
                        PointedDripstone.Thickness[] thicknessesArray = new PointedDripstone.Thickness[]{
                                PointedDripstone.Thickness.TIP,
                                PointedDripstone.Thickness.TIP_MERGE,
                                PointedDripstone.Thickness.FRUSTUM,
                                PointedDripstone.Thickness.MIDDLE,
                                PointedDripstone.Thickness.BASE
                        };
                        List<PointedDripstone.Thickness> thicknesses = new ArrayList<>();
                        for (PointedDripstone.Thickness state : thicknessesArray) {
                            if (Main.isAllowedState("dripstone_thickness", state.toString().toLowerCase())) {
                                thicknesses.add(state);
                            } else {
                                if (state == thickness) {
                                    return;
                                }
                            }
                        }
                        int index = thicknesses.indexOf(thickness);
                        int size = thicknesses.size();
                        int newIndex = (index + 1) % size;
                        pointedDripstone.setThickness(thicknesses.get(newIndex));
                        blockState.setBlockData(pointedDripstone);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + thicknesses.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("piston_head_type")) {
                        PistonHead pistonHead = (PistonHead) blockData;
                        PistonHead.Type type = pistonHead.getType();
                        PistonHead.Type[] typesArray = new PistonHead.Type[] {
                                PistonHead.Type.NORMAL,
                                PistonHead.Type.STICKY
                        };
                        List<PistonHead.Type> types = new ArrayList<>();
                        for (PistonHead.Type state : typesArray) {
                            if (Main.isAllowedState("piston_head_type", state.toString().toLowerCase())) {
                                types.add(state);
                            } else {
                                if (state == type) {
                                    return;
                                }
                            }
                        }
                        int index = types.indexOf(type);
                        int size = types.size();
                        int newIndex = (index + 1) % size;
                        pistonHead.setType(types.get(newIndex));
                        blockState.setBlockData(pistonHead);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + pistonHead.getType());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("piston_head_short")) {
                        PistonHead pistonHead = (PistonHead) blockData;
                        pistonHead.setShort(!pistonHead.isShort());
                        blockState.setBlockData(pistonHead);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + pistonHead.isShort());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("piston")) {
                        Piston piston = (Piston) blockData;
                        piston.setExtended(!piston.isExtended());
                        blockState.setBlockData(piston);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + piston.isExtended());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("pink_petals")) {
                        PinkPetals pinkPetals = (PinkPetals) blockData;
                        int flowers = pinkPetals.getFlowerAmount();
                        int maxFlowers = pinkPetals.getMaximumFlowerAmount();
                        int newFlowers = (flowers + 1) % maxFlowers;
                        pinkPetals.setFlowerAmount(newFlowers);
                        blockState.setBlockData(pinkPetals);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newFlowers);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("noteblock_instrument")) {
                        NoteBlock noteBlock = (NoteBlock) blockData;
                        Instrument instrument = noteBlock.getInstrument();
                        Instrument[] instrumentsArray = new Instrument[]{
                                Instrument.BANJO,
                                Instrument.BASS_DRUM,
                                Instrument.BASS_GUITAR,
                                Instrument.BELL,
                                Instrument.BIT,
                                Instrument.CHIME,
                                Instrument.COW_BELL,
                                Instrument.CREEPER,
                                Instrument.CUSTOM_HEAD,
                                Instrument.DIDGERIDOO,
                                Instrument.DRAGON,
                                Instrument.FLUTE,
                                Instrument.GUITAR,
                                Instrument.IRON_XYLOPHONE,
                                Instrument.PIANO,
                                Instrument.PIGLIN,
                                Instrument.PLING,
                                Instrument.SNARE_DRUM,
                                Instrument.SKELETON,
                                Instrument.STICKS,
                                Instrument.WITHER_SKELETON,
                                Instrument.ZOMBIE,
                                Instrument.XYLOPHONE
                        };
                        List<Instrument> instruments = new ArrayList<>();
                        for (Instrument state : instrumentsArray) {
                            if (Main.isAllowedState("noteblock_instrument", state.toString().toLowerCase())) {
                                instruments.add(state);
                            } else {
                                if (state == instrument) {
                                    return;
                                }
                            }
                        }
                        int index = instruments.indexOf(instrument);
                        int size = instruments.size();
                        int newIndex = (index + 1) % size;
                        noteBlock.setInstrument(instruments.get(newIndex));
                        blockState.setBlockData(noteBlock);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + instruments.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("noteblock_note")) {
                        NoteBlock noteBlock = (NoteBlock) blockData;
                        int octave = noteBlock.getNote().getOctave();
                        int octaves = 24;
                        int newOctave = (octave + 1) % octaves;
                        noteBlock.setNote(Note.natural(newOctave, noteBlock.getNote().getTone()));

                        blockState.setBlockData(noteBlock);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + octaves);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("hangable")) {
                        Hangable hangable = (Hangable) blockData;
                        hangable.setHanging(!hangable.isHanging());
                        blockState.setBlockData(hangable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + hangable.isHanging());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("snowable")) {
                        Snowable snowable = (Snowable) blockData;
                        snowable.setSnowy(!snowable.isSnowy());
                        blockState.setBlockData(snowable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + snowable.isSnowy());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("gate")) {
                        Gate gate = (Gate) blockData;
                        gate.setInWall(!gate.isInWall());
                        blockState.setBlockData(gate);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + gate.isInWall());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("attachable")) {
                        Attachable attachable = (Attachable) blockData;
                        attachable.setAttached(!attachable.isAttached());
                        blockState.setBlockData(attachable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + attachable.isAttached());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("multiple_facing_down")) {
                        MultipleFacing multipleFacing = (MultipleFacing) blockData;
                        multipleFacing.setFace(BlockFace.DOWN, !multipleFacing.hasFace(BlockFace.DOWN));
                        blockState.setBlockData(multipleFacing);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + multipleFacing.hasFace(BlockFace.DOWN));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("multiple_facing_up")) {
                        MultipleFacing multipleFacing = (MultipleFacing) blockData;
                        multipleFacing.setFace(BlockFace.UP, !multipleFacing.hasFace(BlockFace.UP));
                        blockState.setBlockData(multipleFacing);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + multipleFacing.hasFace(BlockFace.UP));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("multiple_facing_west")) {
                        MultipleFacing multipleFacing = (MultipleFacing) blockData;
                        multipleFacing.setFace(BlockFace.WEST, !multipleFacing.hasFace(BlockFace.WEST));
                        blockState.setBlockData(multipleFacing);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + multipleFacing.hasFace(BlockFace.WEST));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("multiple_facing_south")) {
                        MultipleFacing multipleFacing = (MultipleFacing) blockData;
                        multipleFacing.setFace(BlockFace.SOUTH, !multipleFacing.hasFace(BlockFace.SOUTH));
                        blockState.setBlockData(multipleFacing);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + multipleFacing.hasFace(BlockFace.SOUTH));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("multiple_facing_east")) {
                        MultipleFacing multipleFacing = (MultipleFacing) blockData;
                        multipleFacing.setFace(BlockFace.EAST, !multipleFacing.hasFace(BlockFace.EAST));
                        blockState.setBlockData(multipleFacing);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + multipleFacing.hasFace(BlockFace.EAST));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("multiple_facing_north")) {
                        MultipleFacing multipleFacing = (MultipleFacing) blockData;
                        multipleFacing.setFace(BlockFace.NORTH, !multipleFacing.hasFace(BlockFace.NORTH));
                        blockState.setBlockData(multipleFacing);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + multipleFacing.hasFace(BlockFace.NORTH));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("wall_up")) {
                        Wall wall = (Wall) blockData;
                        wall.setUp(!wall.isUp());
                        blockState.setBlockData(wall);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + wall.isUp());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("wall_west")) {
                        Wall wall = (Wall) blockData;
                        Wall.Height height = wall.getHeight(BlockFace.WEST);
                        Wall.Height[] heightsArray = new Wall.Height[]{
                                Wall.Height.LOW,
                                Wall.Height.TALL,
                                Wall.Height.NONE
                        };
                        List<Wall.Height> heights = new ArrayList<>();
                        for (Wall.Height state : heightsArray) {
                            if (Main.isAllowedState("wall", state.toString().toLowerCase())) {
                                heights.add(state);
                            } else {
                                if (state == height) {
                                    return;
                                }
                            }
                        }
                        int index = heights.indexOf(height);
                        int size = heights.size();
                        int newIndex = (index + 1) % size;
                        wall.setHeight(BlockFace.WEST, heights.get(newIndex));
                        blockState.setBlockData(wall);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + heights.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("wall_south")) {
                        Wall wall = (Wall) blockData;
                        Wall.Height height = wall.getHeight(BlockFace.SOUTH);
                        Wall.Height[] heightsArray = new Wall.Height[]{
                                Wall.Height.LOW,
                                Wall.Height.TALL,
                                Wall.Height.NONE
                        };
                        List<Wall.Height> heights = new ArrayList<>();
                        for (Wall.Height state : heightsArray) {
                            if (Main.isAllowedState("wall", state.toString().toLowerCase())) {
                                heights.add(state);
                            } else {
                                if (state == height) {
                                    return;
                                }
                            }
                        }
                        int index = heights.indexOf(height);
                        int size = heights.size();
                        int newIndex = (index + 1) % size;
                        wall.setHeight(BlockFace.SOUTH, heights.get(newIndex));
                        blockState.setBlockData(wall);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + heights.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("wall_east")) {
                        Wall wall = (Wall) blockData;
                        Wall.Height height = wall.getHeight(BlockFace.EAST);
                        Wall.Height[] heightsArray = new Wall.Height[]{
                                Wall.Height.LOW,
                                Wall.Height.TALL,
                                Wall.Height.NONE
                        };
                        List<Wall.Height> heights = new ArrayList<>();
                        for (Wall.Height state : heightsArray) {
                            if (Main.isAllowedState("wall", state.toString().toLowerCase())) {
                                heights.add(state);
                            } else {
                                if (state == height) {
                                    return;
                                }
                            }
                        }
                        int index = heights.indexOf(height);
                        int size = heights.size();
                        int newIndex = (index + 1) % size;
                        wall.setHeight(BlockFace.EAST, heights.get(newIndex));
                        blockState.setBlockData(wall);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + heights.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("wall_north")) {
                        Wall wall = (Wall) blockData;
                        Wall.Height height = wall.getHeight(BlockFace.NORTH);
                        Wall.Height[] heightsArray = new Wall.Height[]{
                                Wall.Height.LOW,
                                Wall.Height.TALL,
                                Wall.Height.NONE
                        };
                        List<Wall.Height> heights = new ArrayList<>();
                        for (Wall.Height state : heightsArray) {
                            if (Main.isAllowedState("wall", state.toString().toLowerCase())) {
                                heights.add(state);
                            } else {
                                if (state == height) {
                                    return;
                                }
                            }
                        }
                        int index = heights.indexOf(height);
                        int size = heights.size();
                        int newIndex = (index + 1) % size;
                        wall.setHeight(BlockFace.NORTH, heights.get(newIndex));
                        blockState.setBlockData(wall);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + heights.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("chiseled_bookshelf_slot_5")) {
                        ChiseledBookshelf chiseledBookshelf = (ChiseledBookshelf) blockData;
                        chiseledBookshelf.setSlotOccupied(5, !chiseledBookshelf.isSlotOccupied(5));
                        blockState.setBlockData(chiseledBookshelf);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + chiseledBookshelf.isSlotOccupied(5));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("chiseled_bookshelf_slot_4")) {
                        ChiseledBookshelf chiseledBookshelf = (ChiseledBookshelf) blockData;
                        chiseledBookshelf.setSlotOccupied(4, !chiseledBookshelf.isSlotOccupied(4));
                        blockState.setBlockData(chiseledBookshelf);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + chiseledBookshelf.isSlotOccupied(4));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("chiseled_bookshelf_slot_3")) {
                        ChiseledBookshelf chiseledBookshelf = (ChiseledBookshelf) blockData;
                        chiseledBookshelf.setSlotOccupied(3, !chiseledBookshelf.isSlotOccupied(3));
                        blockState.setBlockData(chiseledBookshelf);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + chiseledBookshelf.isSlotOccupied(3));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("chiseled_bookshelf_slot_2")) {
                        ChiseledBookshelf chiseledBookshelf = (ChiseledBookshelf) blockData;
                        chiseledBookshelf.setSlotOccupied(2, !chiseledBookshelf.isSlotOccupied(2));
                        blockState.setBlockData(chiseledBookshelf);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + chiseledBookshelf.isSlotOccupied(2));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("chiseled_bookshelf_slot_1")) {
                        ChiseledBookshelf chiseledBookshelf = (ChiseledBookshelf) blockData;
                        chiseledBookshelf.setSlotOccupied(1, !chiseledBookshelf.isSlotOccupied(1));
                        blockState.setBlockData(chiseledBookshelf);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + chiseledBookshelf.isSlotOccupied(1));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("chiseled_bookshelf_slot_0")) {
                        ChiseledBookshelf chiseledBookshelf = (ChiseledBookshelf) blockData;
                        chiseledBookshelf.setSlotOccupied(0, !chiseledBookshelf.isSlotOccupied(0));
                        blockState.setBlockData(chiseledBookshelf);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + chiseledBookshelf.isSlotOccupied(0));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("cave_wines")) {
                        CaveVines caveVines = (CaveVines) blockData;
                        caveVines.setBerries(!caveVines.isBerries());
                        blockState.setBlockData(caveVines);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + caveVines.isBerries());
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("levelled")) {
                        Levelled levelled = (Levelled) blockData;
                        int offset = 0;
                        if (block.getType().equals(Material.LAVA_CAULDRON) || block.getType().equals(Material.POWDER_SNOW_CAULDRON) || block.getType().equals(Material.WATER_CAULDRON)) {
                            offset = 1;
                        }
                        int maxLevel = levelled.getMaximumLevel() + 1 - offset;
                        int level = levelled.getLevel();
                        int newLevel = ((level + 1) % maxLevel) + offset;
                        levelled.setLevel(newLevel);
                        blockState.setBlockData(levelled);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newLevel);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("candle")) {
                        Candle candle = (Candle) blockData;
                        int maxCandles = candle.getMaximumCandles() + 1;
                        int candles = candle.getCandles();
                        int newCandles = (candles + 1) % maxCandles;
                        candle.setCandles(newCandles);
                        blockState.setBlockData(candle);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newCandles);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("campfire")) {
                        Campfire campfire = (Campfire) blockData;
                        campfire.setSignalFire(!campfire.isSignalFire());
                        blockState.setBlockData(campfire);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + campfire.isSignalFire());
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("face_attachable")) {
                        FaceAttachable faceAttachable = (FaceAttachable) blockData;
                        FaceAttachable.AttachedFace attachedFace = faceAttachable.getAttachedFace();
                        FaceAttachable.AttachedFace[] attachedFacesArray = new FaceAttachable.AttachedFace[]{
                                FaceAttachable.AttachedFace.CEILING,
                                FaceAttachable.AttachedFace.FLOOR,
                                FaceAttachable.AttachedFace.WALL
                        };
                        List<FaceAttachable.AttachedFace> attachedFaces = new ArrayList<>();
                        for (FaceAttachable.AttachedFace state : attachedFacesArray) {
                            if (Main.isAllowedState("face_attachable", state.toString().toLowerCase())) {
                                attachedFaces.add(state);
                            } else {
                                if (state == attachedFace) {
                                    return;
                                }
                            }
                        }
                        int index = attachedFaces.indexOf(attachedFace);
                        int size = attachedFaces.size();
                        int newIndex = (index + 1) % size;
                        faceAttachable.setAttachedFace(attachedFaces.get(newIndex));
                        blockState.setBlockData(faceAttachable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + attachedFaces.get(newIndex));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("brewing_stand_bottle_2")) {
                        BrewingStand brewingStand = (BrewingStand) blockData;
                        brewingStand.setBottle(2, !brewingStand.hasBottle(2));
                        blockState.setBlockData(brewingStand);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + brewingStand.hasBottle(2));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("brewing_stand_bottle_1")) {
                        BrewingStand brewingStand = (BrewingStand) blockData;
                        brewingStand.setBottle(1, !brewingStand.hasBottle(1));
                        blockState.setBlockData(brewingStand);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + brewingStand.hasBottle(1));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("brewing_stand_bottle_0")) {
                        BrewingStand brewingStand = (BrewingStand) blockData;
                        brewingStand.setBottle(0, !brewingStand.hasBottle(0));
                        blockState.setBlockData(brewingStand);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + brewingStand.hasBottle(0));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("lightable")) {
                        Lightable lightable = (Lightable) blockData;
                        lightable.setLit(!lightable.isLit());
                        blockState.setBlockData(lightable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + lightable.isLit());
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("big_dripleaf")) {
                        BigDripleaf bigDripleaf = (BigDripleaf) blockData;
                        BigDripleaf.Tilt tilt = bigDripleaf.getTilt();
                        BigDripleaf.Tilt[] tiltsArray = new BigDripleaf.Tilt[]{
                                BigDripleaf.Tilt.NONE,
                                BigDripleaf.Tilt.PARTIAL,
                                BigDripleaf.Tilt.UNSTABLE,
                                BigDripleaf.Tilt.FULL
                        };
                        List<BigDripleaf.Tilt> tilts = new ArrayList<>();
                        for (BigDripleaf.Tilt state : tiltsArray) {
                            if (Main.isAllowedState("big_dripleaf", state.toString().toLowerCase())) {
                                tilts.add(state);
                            } else {
                                if (state == tilt) {
                                    return;
                                }
                            }
                        }
                        int index = tilts.indexOf(tilt);
                        int size = tilts.size();
                        int newIndex = (index + 1) % size;
                        bigDripleaf.setTilt(tilts.get(newIndex));
                        blockState.setBlockData(bigDripleaf);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + tilts.get(newIndex));
                    }


                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("bell")) {
                        Bell bell = (Bell) blockData;
                        Bell.Attachment attachment = bell.getAttachment();
                        Bell.Attachment[] attachmentsArray = new Bell.Attachment[]{
                                Bell.Attachment.CEILING,
                                Bell.Attachment.FLOOR,
                                Bell.Attachment.DOUBLE_WALL,
                                Bell.Attachment.SINGLE_WALL
                        };
                        List<Bell.Attachment> attachments = new ArrayList<>();
                        for (Bell.Attachment state : attachmentsArray) {
                            if (Main.isAllowedState("bell", state.toString().toLowerCase())) {
                                attachments.add(state);
                            } else {
                                if (state == attachment) {
                                    return;
                                }
                            }
                        }
                        int index = attachments.indexOf(attachment);
                        int size = attachments.size();
                        int newIndex = (index + 1) % size;
                        bell.setAttachment(attachments.get(newIndex));
                        blockState.setBlockData(bell);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + attachments.get(newIndex));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("beehive")) {
                        Beehive beehive = (Beehive) blockData;
                        int maxLevel = beehive.getMaximumHoneyLevel() + 1;
                        int level = beehive.getHoneyLevel();
                        int newLevel = (level + 1) % maxLevel;
                        beehive.setHoneyLevel(newLevel);
                        blockState.setBlockData(beehive);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newLevel);
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("openable")) {
                        Openable openable = (Openable) blockData;
                        openable.setOpen(!openable.isOpen());
                        blockState.setBlockData(openable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + openable.isOpen());
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("bamboo")) {
                        Bamboo bamboo = (Bamboo) blockData;
                        Bamboo.Leaves leaf = bamboo.getLeaves();
                        Bamboo.Leaves[] leavesArray = new Bamboo.Leaves[]{
                                Bamboo.Leaves.LARGE,
                                Bamboo.Leaves.SMALL,
                                Bamboo.Leaves.NONE
                        };
                        List<Bamboo.Leaves> leaves = new ArrayList<>();
                        for (Bamboo.Leaves state : leavesArray) {
                            if (Main.isAllowedState("bamboo", state.toString().toLowerCase())) {
                                leaves.add(state);
                            } else {
                                if (state == leaf) {
                                    return;
                                }
                            }
                        }
                        int index = leaves.indexOf(leaf);
                        int size = leaves.size();
                        int newIndex = (index + 1) % size;
                        bamboo.setLeaves(leaves.get(newIndex));
                        blockState.setBlockData(bamboo);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + leaves.get(newIndex));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("cake")) {
                        Cake cake = (Cake) blockData;
                        int maxBites = cake.getMaximumBites() + 1;
                        int bite = cake.getBites();
                        int newBite = (bite + 1) % maxBites;
                        cake.setBites(newBite);
                        blockState.setBlockData(cake);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + bite);
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("chest")) {
                        Chest chest = (Chest) blockData;
                        Chest.Type type = chest.getType();
                        Chest.Type[] typesArray = new Chest.Type[]{
                                Chest.Type.LEFT,
                                Chest.Type.RIGHT,
                                Chest.Type.SINGLE,
                        };
                        List<Chest.Type> types = new ArrayList<>();
                        for (Chest.Type state : typesArray) {
                            if (Main.isAllowedState("chest", state.toString().toLowerCase())) {
                                types.add(state);
                            } else {
                                if (state == type) {
                                    return;
                                }
                            }
                        }
                        int index = types.indexOf(type);
                        int size = types.size();
                        int newIndex = (index + 1) % size;
                        chest.setType(types.get(newIndex));
                        blockState.setBlockData(chest);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + types.get(newIndex));

                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("bed")) {
                        Bed bed = (Bed) blockData;
                        Bed.Part part = bed.getPart();
                        Bed.Part[] partsArray = new Bed.Part[]{
                                Bed.Part.HEAD,
                                Bed.Part.FOOT
                        };
                        List<Bed.Part> parts = new ArrayList<>();
                        for (Bed.Part state : partsArray) {
                            if (Main.isAllowedState("bed", state.toString().toLowerCase())) {
                                parts.add(state);
                            } else {
                                if (state == part) {
                                    return;
                                }
                            }
                        }
                        int index = parts.indexOf(part);
                        int size = parts.size();
                        int newIndex = (index + 1) % size;
                        bed.setPart(parts.get(newIndex));
                        blockState.setBlockData(bed);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + bed.getPart());
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("directional")) {
                        Directional directional = (Directional) blockData;
                        List<BlockFace> faces = new ArrayList<>(directional.getFaces());
                        BlockFace face = directional.getFacing();
                        int index = faces.indexOf(face);
                        int size = faces.size();
                        int newIndex = (index + 1) % size;
                        directional.setFacing(faces.get(newIndex));
                        blockState.setBlockData(directional);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + faces.get(newIndex));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("rotatable")) {
                        Rotatable rotatable = (Rotatable) blockData;
                        BlockFace rotation = rotatable.getRotation();
                        BlockFace[] rotationsArray = new BlockFace[]{
                                BlockFace.NORTH,
                                BlockFace.NORTH_NORTH_EAST,
                                BlockFace.NORTH_EAST,
                                BlockFace.EAST_NORTH_EAST,
                                BlockFace.EAST,
                                BlockFace.EAST_SOUTH_EAST,
                                BlockFace.SOUTH_EAST,
                                BlockFace.SOUTH_SOUTH_EAST,
                                BlockFace.SOUTH,
                                BlockFace.SOUTH_SOUTH_WEST,
                                BlockFace.SOUTH_WEST,
                                BlockFace.WEST_SOUTH_WEST,
                                BlockFace.WEST,
                                BlockFace.WEST_NORTH_WEST,
                                BlockFace.NORTH_WEST,
                                BlockFace.NORTH_NORTH_WEST,
                        };
                        List<BlockFace> rotations = new ArrayList<>();
                        for (BlockFace state : rotationsArray) {
                            if (Main.isAllowedState("rotatable", state.toString().toLowerCase())) {
                                rotations.add(state);
                            } else {
                                if (state == rotation) {
                                    return;
                                }
                            }
                        }
                        int index = rotations.indexOf(rotation);
                        int size = rotations.size();
                        int newIndex = (index + 1) % size;
                        rotatable.setRotation(rotations.get(newIndex));
                        blockState.setBlockData(rotatable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + rotations.get(newIndex));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("orientable")) {
                        Orientable orientable = (Orientable) blockData;
                        Axis axis = orientable.getAxis();
                        List<Axis> axesArray = new ArrayList<>(orientable.getAxes());
                        List<Axis> axes = new ArrayList<>();
                        for (Axis state : axesArray) {
                            if (Main.isAllowedState("orientable.axis", state.toString().toLowerCase())) {
                                axes.add(state);
                            } else {
                                if (state == axis) {
                                    return;
                                }
                            }
                        }
                        int index = axes.indexOf(axis);
                        int size = axes.size();
                        int newIndex = (index + 1) % size;
                        orientable.setAxis(axes.get(newIndex));
                        blockState.setBlockData(orientable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + axes.get(newIndex));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("bisected")) {
                        Bisected bisected = (Bisected) blockData;
                        Bisected.Half half = bisected.getHalf();
                        Bisected.Half[] halfsArray = new Bisected.Half[] {
                                Bisected.Half.TOP,
                                Bisected.Half.BOTTOM
                        };
                        List<Bisected.Half> halfs = new ArrayList<>();
                        for (Bisected.Half state : halfsArray) {
                            if (Main.isAllowedState("bisected.half", state.toString().toLowerCase())) {
                                halfs.add(state);
                            } else {
                                if (state == half) {
                                    return;
                                }
                            }
                        }
                        int index = halfs.indexOf(half);
                        int size = halfs.size();
                        int newIndex = (index + 1) % size;
                        bisected.setHalf(halfs.get(newIndex));
                        blockState.setBlockData(bisected);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + bisected.getHalf());
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("waterlogged")) {
                        Waterlogged waterlogged = (Waterlogged) blockData;
                        waterlogged.setWaterlogged(!waterlogged.isWaterlogged());
                        blockState.setBlockData(waterlogged);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + waterlogged.isWaterlogged());
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("powerable")) {
                        Powerable powerable = (Powerable) blockData;
                        powerable.setPowered(!powerable.isPowered());
                        blockState.setBlockData(powerable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + powerable.isPowered());
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("ageable")) {
                        Ageable ageable = (Ageable) blockData;
                        int age = ageable.getAge();
                        int maxAge = ageable.getMaximumAge() + 1;
                        int newAge = (age + 1) % maxAge;
                        ageable.setAge(newAge);
                        blockState.setBlockData(ageable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newAge);
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("rail")) {
                        Rail rail = (Rail) blockData;
                        Rail.Shape shape = rail.getShape();
                        List<Rail.Shape> shapesArray = new ArrayList<>(rail.getShapes());
                        List<Rail.Shape> shapes = new ArrayList<>();
                        for (Rail.Shape state : shapesArray) {
                            if (Main.isAllowedState("rail.shape", state.toString().toLowerCase())) {
                                shapes.add(state);
                            } else {
                                if (state == shape) {
                                    return;
                                }
                            }
                        }
                        int index = shapes.indexOf(shape);
                        int size = shapes.size();
                        int newIndex = (index + 1) % size;
                        rail.setShape(shapes.get(newIndex));
                        blockState.setBlockData(rail);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + shapes.get(newIndex));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("stairs")) {
                        Stairs stairs = (Stairs) blockData;
                        Stairs.Shape shape = stairs.getShape();
                        Stairs.Shape[] shapesArray = new Stairs.Shape[]{
                                Stairs.Shape.INNER_LEFT,
                                Stairs.Shape.INNER_RIGHT,
                                Stairs.Shape.OUTER_LEFT,
                                Stairs.Shape.OUTER_RIGHT,
                                Stairs.Shape.STRAIGHT,
                        };
                        List<Stairs.Shape> shapes = new ArrayList<>();
                        for (Stairs.Shape state : shapesArray) {
                            if (Main.isAllowedState("stairs.shape", state.toString().toLowerCase())) {
                                shapes.add(state);
                            } else {
                                if (state == shape) {
                                    return;
                                }
                            }
                        }
                        int index = shapes.indexOf(shape);
                        int size = shapes.size();
                        int newIndex = (index + 1) % size;
                        stairs.setShape(shapes.get(newIndex));
                        blockState.setBlockData(stairs);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + shapes.get(newIndex));
                    }


                } else if (event.getAction().isLeftClick()) {
                    blockStateIndex = (blockStateIndex + 1) % blockStates.size();
                    event.getPlayer().sendActionBar(blockStates.get(blockStateIndex));
                }
            }


            blockState.update(false, false);
        }

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            processingClickEvent = false;
        }, 1L);
    }
}

