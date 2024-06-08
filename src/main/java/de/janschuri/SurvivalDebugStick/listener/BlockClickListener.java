package de.janschuri.SurvivalDebugStick.listener;

import de.janschuri.SurvivalDebugStick.SurvivalDebugStick;
import de.janschuri.lunaticlib.platform.bukkit.util.EventUtils;
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
    private final SurvivalDebugStick plugin;

    public BlockClickListener(SurvivalDebugStick plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null
                && event.getPlayer().getItemInHand().getItemMeta() != null
                && event.getPlayer().getItemInHand().getItemMeta().getPersistentDataContainer().has(SurvivalDebugStick.KEY_STICK)) {
            event.setCancelled(true);
            if (processingClickEvent) return;
            processingClickEvent = true;
            Block block = event.getClickedBlock();

            if (!EventUtils.isAllowedBreakBlock(event.getPlayer(), block)) {
                return;
            }

            BlockData blockData = block.getBlockData();
            BlockState blockState = block.getState();
            List<String> blockStates = new ArrayList<>();

            if (blockData instanceof Directional && SurvivalDebugStick.getPluginConfig().isAllowBlockState("directional")) {
                blockStates.add("directional");
            }
            if (blockData instanceof Orientable && SurvivalDebugStick.getPluginConfig().isAllowBlockState("orientable")) {
                blockStates.add("orientable");
            }
            if (blockData instanceof Powerable && SurvivalDebugStick.getPluginConfig().isAllowBlockState("powerable")) {
                blockStates.add("powerable");
            }
            if (blockData instanceof Waterlogged && SurvivalDebugStick.getPluginConfig().isAllowBlockState("waterlogged")) {
                blockStates.add("waterlogged");
            }
            if (blockData instanceof Bisected && SurvivalDebugStick.getPluginConfig().isAllowBlockState("bisected")) {
                blockStates.add("bisected");
            }
            if (blockData instanceof Ageable && SurvivalDebugStick.getPluginConfig().isAllowBlockState("ageable")) {
                blockStates.add("ageable");
            }
            if (blockData instanceof Rail && SurvivalDebugStick.getPluginConfig().isAllowBlockState("rail")) {
                blockStates.add("rail");
            }
            if (blockData instanceof Rotatable && SurvivalDebugStick.getPluginConfig().isAllowBlockState("rotatable")) {
                blockStates.add("rotatable");
            }
            if (blockData instanceof Stairs && SurvivalDebugStick.getPluginConfig().isAllowBlockState("stairs")) {
                blockStates.add("stairs");
            }
            if (blockData instanceof Bed && SurvivalDebugStick.getPluginConfig().isAllowBlockState("bed")) {
                blockStates.add("bed");
            }
            if (blockData instanceof Chest && SurvivalDebugStick.getPluginConfig().isAllowBlockState("chest")) {
                blockStates.add("chest");
            }
            if (blockData instanceof Cake && SurvivalDebugStick.getPluginConfig().isAllowBlockState("cake")) {
                blockStates.add("cake");
            }
            if (blockData instanceof Bamboo && SurvivalDebugStick.getPluginConfig().isAllowBlockState("bamboo")) {
                blockStates.add("bamboo");
            }
            if (blockData instanceof Openable && SurvivalDebugStick.getPluginConfig().isAllowBlockState("openable")) {
                blockStates.add("openable");
            }
            if (blockData instanceof Beehive && SurvivalDebugStick.getPluginConfig().isAllowBlockState("beehive")) {
                blockStates.add("beehive");
            }
            if (blockData instanceof Bell && SurvivalDebugStick.getPluginConfig().isAllowBlockState("bell")) {
                blockStates.add("bell");
            }
            if (blockData instanceof BigDripleaf && SurvivalDebugStick.getPluginConfig().isAllowBlockState("big_dripleaf")) {
                blockStates.add("big_dripleaf");
            }
            if (blockData instanceof Lightable && SurvivalDebugStick.getPluginConfig().isAllowBlockState("lightable")) {
                blockStates.add("lightable");
            }
            if (blockData instanceof BrewingStand && SurvivalDebugStick.getPluginConfig().isAllowBlockState("brewing_stand_bottles")) {
                blockStates.add("brewing_stand_bottle_0");
                blockStates.add("brewing_stand_bottle_1");
                blockStates.add("brewing_stand_bottle_2");
            }
            if (blockData instanceof FaceAttachable && SurvivalDebugStick.getPluginConfig().isAllowBlockState("face_attachable")) {
                blockStates.add("face_attachable");
            }
            if (blockData instanceof Campfire && SurvivalDebugStick.getPluginConfig().isAllowBlockState("campfire")) {
                blockStates.add("campfire");
            }
            if (blockData instanceof Candle && SurvivalDebugStick.getPluginConfig().isAllowBlockState("candle")) {
                blockStates.add("candle");
            }
            if (blockData instanceof Levelled && SurvivalDebugStick.getPluginConfig().isAllowBlockState("levelled")) {
                blockStates.add("levelled");
            }
            if (blockData instanceof ChiseledBookshelf && SurvivalDebugStick.getPluginConfig().isAllowBlockState("chiseled_bookshelf_slots")) {
                blockStates.add("chiseled_bookshelf_slot_0");
                blockStates.add("chiseled_bookshelf_slot_1");
                blockStates.add("chiseled_bookshelf_slot_2");
                blockStates.add("chiseled_bookshelf_slot_3");
                blockStates.add("chiseled_bookshelf_slot_4");
                blockStates.add("chiseled_bookshelf_slot_5");
            }
            if (blockData instanceof Wall && SurvivalDebugStick.getPluginConfig().isAllowBlockState("wall")) {
                blockStates.add("wall_north");
                blockStates.add("wall_east");
                blockStates.add("wall_south");
                blockStates.add("wall_west");
                blockStates.add("wall_up");
            }
            if (blockData instanceof MultipleFacing && SurvivalDebugStick.getPluginConfig().isAllowBlockState("multiple_facing")) {
                MultipleFacing multipleFacing = (MultipleFacing) blockData;
                List<BlockFace> faces = new ArrayList<>(multipleFacing.getAllowedFaces());
                for (BlockFace face : faces) {
                    blockStates.add("multiple_facing_" + face.toString().toLowerCase());
                }
            }
            if (blockData instanceof Attachable && SurvivalDebugStick.getPluginConfig().isAllowBlockState("attachable")) {
                blockStates.add("attachable");
            }
            if (blockData instanceof Gate && SurvivalDebugStick.getPluginConfig().isAllowBlockState("gate")) {
                blockStates.add("gate");
            }
            if (blockData instanceof Snowable && SurvivalDebugStick.getPluginConfig().isAllowBlockState("snowable")) {
                blockStates.add("snowable");
            }
            if (blockData instanceof Hangable && SurvivalDebugStick.getPluginConfig().isAllowBlockState("hangable")) {
                blockStates.add("hangable");
            }
            if (blockData instanceof NoteBlock) {
                if (SurvivalDebugStick.getPluginConfig().isAllowBlockState("noteblock_note")) {
                    blockStates.add("noteblock_note");
                }
                if (SurvivalDebugStick.getPluginConfig().isAllowBlockState("noteblock_instrument")) {
                    blockStates.add("noteblock_instrument");
                }
            }
            if (blockData instanceof PinkPetals && SurvivalDebugStick.getPluginConfig().isAllowBlockState("pink_petals")) {
                blockStates.add("pink_petals");
            }
            if (blockData instanceof Piston && SurvivalDebugStick.getPluginConfig().isAllowBlockState("piston")) {
                blockStates.add("piston");
            }
            if (blockData instanceof PistonHead) {
                if (SurvivalDebugStick.getPluginConfig().isAllowBlockState("piston_head_type")) {
                    blockStates.add("piston_head_type");
                }
                if (SurvivalDebugStick.getPluginConfig().isAllowBlockState("piston_head_short")) {
                    blockStates.add("piston_head_short");
                }
            }
            if (blockData instanceof PointedDripstone && SurvivalDebugStick.getPluginConfig().isAllowBlockState("dripstone_thickness")) {
                blockStates.add("dripstone_thickness");
            }
            if (blockData instanceof Comparator && SurvivalDebugStick.getPluginConfig().isAllowBlockState("comparator")) {
                blockStates.add("comparator");
            }
            if (blockData instanceof RedstoneWire && SurvivalDebugStick.getPluginConfig().isAllowBlockState("redstone_wire")) {
                blockStates.add("redstone_wire_north");
                blockStates.add("redstone_wire_east");
                blockStates.add("redstone_wire_south");
                blockStates.add("redstone_wire_west");
            }
            if (blockData instanceof Repeater) {
                if (SurvivalDebugStick.getPluginConfig().isAllowBlockState("repeater_delay")) {
                    blockStates.add("repeater_delay");
                }
                if (SurvivalDebugStick.getPluginConfig().isAllowBlockState("repeater_locked")) {
                    blockStates.add("repeater_locked");
                }
            }
            if (blockData instanceof RespawnAnchor && SurvivalDebugStick.getPluginConfig().isAllowBlockState("respawn_anchor")) {
                blockStates.add("charges");
            }
            if (blockData instanceof Scaffolding && SurvivalDebugStick.getPluginConfig().isAllowBlockState("scaffolding")) {
                blockStates.add("scaffolding");
            }
            if (blockData instanceof SculkCatalyst && SurvivalDebugStick.getPluginConfig().isAllowBlockState("sculk_catalyst")) {
                blockStates.add("sculk_catalyst");
            }
            if (blockData instanceof SculkSensor && SurvivalDebugStick.getPluginConfig().isAllowBlockState("sculk_sensor")) {
                blockStates.add("sculk_sensor");
            }
            if (blockData instanceof SculkShrieker && SurvivalDebugStick.getPluginConfig().isAllowBlockState("sculk_shrieker")) {
                blockStates.add("sculk_shrieker");
            }
            if (blockData instanceof SeaPickle && SurvivalDebugStick.getPluginConfig().isAllowBlockState("sea_pickle")) {
                blockStates.add("sea_pickle");
            }
            if (blockData instanceof Slab && SurvivalDebugStick.getPluginConfig().isAllowBlockState("slab")) {
                blockStates.add("slab");
            }
            if (blockData instanceof Snow && SurvivalDebugStick.getPluginConfig().isAllowBlockState("snow")) {
                blockStates.add("snow");
            }
            if (blockData instanceof TurtleEgg) {
                if (SurvivalDebugStick.getPluginConfig().isAllowBlockState("turtle_egg_hatch")) {
                    blockStates.add("turtle_egg_hatch");
                }
                if(SurvivalDebugStick.getPluginConfig().isAllowBlockState("turtle_egg_eggs")) {
                    blockStates.add("turtle_egg_eggs");
                }
            }



            if (!blockStates.isEmpty()) {
                if (event.getAction().isRightClick()) {
                    blockStateIndex = (blockStateIndex) % blockStates.size();
                    String blockStateKey = blockStates.get(blockStateIndex);

                    if (blockStateKey.equalsIgnoreCase("turtle_egg_hatch")) {
                        TurtleEgg newBlockData = (TurtleEgg) blockData;
                        int maxValue = newBlockData.getMaximumHatch() + 1;
                        int value = newBlockData.getHatch();
                        int newValue = ((value + 1) % maxValue);
                        newBlockData.setHatch(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("turtle_egg_eggs")) {
                        TurtleEgg newBlockData = (TurtleEgg) blockData;
                        int maxValue = newBlockData.getMaximumEggs();
                        int value = newBlockData.getEggs();
                        int newValue = ((value) % maxValue) + 1;
                        newBlockData.setEggs(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("snow")) {
                        Snow newBlockData = (Snow) blockData;
                        int value = newBlockData.getLayers();
                        int maxValue = newBlockData.getMaximumLayers();
                        int newValue = ((value) % maxValue) + 1;
                        newBlockData.setLayers(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("slab")) {
                        Slab newBlockData = (Slab) blockData;
                        Slab.Type value = newBlockData.getType();
                        Slab.Type[] statesArray = new Slab.Type[]{
                                Slab.Type.BOTTOM,
                                Slab.Type.TOP,
                                Slab.Type.DOUBLE
                        };
                        List<Slab.Type> states = new ArrayList<>();
                        for (Slab.Type state : statesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("slab", state.toString())) {
                                states.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = states.indexOf(value);
                        int size = states.size();
                        int newIndex = (index + 1) % size;
                        Slab.Type newValue = states.get(newIndex);
                        newBlockData.setType(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("sea_pickle")) {
                        SeaPickle newBlockData = (SeaPickle) blockData;
                        int maxValue = newBlockData.getMaximumPickles();
                        int value = newBlockData.getPickles();
                        int newValue = ((value) % maxValue) + 1;
                        newBlockData.setPickles(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("sculk_shrieker")) {
                        SculkShrieker newBlockData = (SculkShrieker) blockData;
                        boolean newValue = !newBlockData.isShrieking();
                        newBlockData.setCanSummon(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("sculk_sensor")) {
                        SculkSensor newBlockData = (SculkSensor) blockData;
                        SculkSensor.Phase value = newBlockData.getPhase();
                        SculkSensor.Phase[] statesArray = new SculkSensor.Phase[]{
                                SculkSensor.Phase.ACTIVE,
                                SculkSensor.Phase.COOLDOWN,
                                SculkSensor.Phase.INACTIVE
                        };
                        List<SculkSensor.Phase> states = new ArrayList<>();
                        for (SculkSensor.Phase state : statesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("sculk_sensor", state.toString().toLowerCase())) {
                                states.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = states.indexOf(value);
                        int size = states.size();
                        int newIndex = (index + 1) % size;
                        SculkSensor.Phase newValue = states.get(newIndex);
                        newBlockData.setPhase(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("sculk_catalyst")) {
                        SculkCatalyst newBlockData = (SculkCatalyst) blockData;
                        boolean newValue = !newBlockData.isBloom();
                        newBlockData.setBloom(newValue);

                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("scaffolding")) {
                        Scaffolding newBlockData = (Scaffolding) blockData;
                        boolean newValue = !newBlockData.isBottom();
                        newBlockData.setBottom(newValue);

                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("charges")) {
                        RespawnAnchor newBlockData = (RespawnAnchor) blockData;
                        int value = newBlockData.getCharges();
                        int maxValue = newBlockData.getMaximumCharges() + 1;
                        int newValue = ((value + 1) % maxValue);
                        newBlockData.setCharges(newValue);

                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("repeater_locked")) {
                        Repeater newBlockData = (Repeater) blockData;
                        boolean newValue = !newBlockData.isLocked();
                        newBlockData.setLocked(newValue);

                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("repeater_delay")) {
                        Repeater newBlockData = (Repeater) blockData;
                        int value = newBlockData.getDelay();
                        int maxValue = newBlockData.getMaximumDelay();
                        int newValue = ((value) % maxValue) + 1;
                        newBlockData.setDelay(newValue);

                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(blockStateKey + ": " + newValue);
                    }
                    if (blockStateKey.equalsIgnoreCase("redstone_wire_west")) {
                        RedstoneWire newBlockData = (RedstoneWire) blockData;
                        RedstoneWire.Connection value = newBlockData.getFace(BlockFace.WEST);
                        RedstoneWire.Connection[] valuesArray = new RedstoneWire.Connection[]{
                                RedstoneWire.Connection.UP,
                                RedstoneWire.Connection.SIDE,
                                RedstoneWire.Connection.NONE
                        };
                        List<RedstoneWire.Connection> values = new ArrayList<>();
                        for (RedstoneWire.Connection state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("redstone_wire", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        RedstoneWire.Connection newValue = values.get(newIndex);
                        newBlockData.setFace(BlockFace.WEST, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("redstone_wire_south")) {
                        RedstoneWire newBlockData = (RedstoneWire) blockData;
                        RedstoneWire.Connection value = newBlockData.getFace(BlockFace.SOUTH);
                        RedstoneWire.Connection[] valueArray = new RedstoneWire.Connection[]{
                                RedstoneWire.Connection.UP,
                                RedstoneWire.Connection.SIDE,
                                RedstoneWire.Connection.NONE
                        };
                        List<RedstoneWire.Connection> values = new ArrayList<>();
                        for (RedstoneWire.Connection state : valueArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("redstone_wire", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        RedstoneWire.Connection newValue = values.get(newIndex);
                        newBlockData.setFace(BlockFace.SOUTH, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("redstone_wire_east")) {
                        RedstoneWire newBlockData = (RedstoneWire) blockData;
                        RedstoneWire.Connection value = newBlockData.getFace(BlockFace.EAST);
                        RedstoneWire.Connection[] valuesArray = new RedstoneWire.Connection[]{
                                RedstoneWire.Connection.UP,
                                RedstoneWire.Connection.SIDE,
                                RedstoneWire.Connection.NONE
                        };
                        List<RedstoneWire.Connection> values = new ArrayList<>();
                        for (RedstoneWire.Connection state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("redstone_wire", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        RedstoneWire.Connection newValue = values.get(newIndex);
                        newBlockData.setFace(BlockFace.EAST, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("redstone_wire_north")) {
                        RedstoneWire newBlockData = (RedstoneWire) blockData;
                        RedstoneWire.Connection value = newBlockData.getFace(BlockFace.NORTH);
                        RedstoneWire.Connection[] valuesArray = new RedstoneWire.Connection[]{
                                RedstoneWire.Connection.UP,
                                RedstoneWire.Connection.SIDE,
                                RedstoneWire.Connection.NONE
                        };
                        List<RedstoneWire.Connection> values = new ArrayList<>();
                        for (RedstoneWire.Connection state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("redstone_wire", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        RedstoneWire.Connection newValue = values.get(newIndex);
                        newBlockData.setFace(BlockFace.NORTH, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("comparator")) {
                        Comparator newBlockData = (Comparator) blockData;
                        Comparator.Mode value = newBlockData.getMode();
                        Comparator.Mode[] valuesArray = new Comparator.Mode[]{
                                Comparator.Mode.SUBTRACT,
                                Comparator.Mode.COMPARE
                        };
                        List<Comparator.Mode> values = new ArrayList<>();
                        for (Comparator.Mode state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("comparator", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Comparator.Mode newValue = values.get(newIndex);
                        newBlockData.setMode(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("dripstone_thickness")) {
                        PointedDripstone newBlockData = (PointedDripstone) blockData;
                        PointedDripstone.Thickness value = newBlockData.getThickness();
                        PointedDripstone.Thickness[] valuesArray = new PointedDripstone.Thickness[]{
                                PointedDripstone.Thickness.TIP,
                                PointedDripstone.Thickness.TIP_MERGE,
                                PointedDripstone.Thickness.FRUSTUM,
                                PointedDripstone.Thickness.MIDDLE,
                                PointedDripstone.Thickness.BASE
                        };
                        List<PointedDripstone.Thickness> values = new ArrayList<>();
                        for (PointedDripstone.Thickness state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("dripstone_thickness", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        PointedDripstone.Thickness newValue = values.get(newIndex);
                        newBlockData.setThickness(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("piston_head_type")) {
                        PistonHead newBlockData = (PistonHead) blockData;
                        PistonHead.Type value = newBlockData.getType();
                        PistonHead.Type[] valuesArray = new PistonHead.Type[] {
                                PistonHead.Type.NORMAL,
                                PistonHead.Type.STICKY
                        };
                        List<PistonHead.Type> values = new ArrayList<>();
                        for (PistonHead.Type state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("piston_head_type", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        PistonHead.Type newValue = values.get(newIndex);
                        newBlockData.setType(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("piston_head_short")) {
                        PistonHead newBlockData = (PistonHead) blockData;
                        boolean newValue = !newBlockData.isShort();
                        newBlockData.setShort(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("piston")) {
                        Piston newBlockData = (Piston) blockData;
                        boolean newValue = !newBlockData.isExtended();
                        newBlockData.setExtended(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("pink_petals")) {
                        PinkPetals newBlockData = (PinkPetals) blockData;
                        int value = newBlockData.getFlowerAmount();
                        int maxValue = newBlockData.getMaximumFlowerAmount();
                        int newValue = (value + 1) % maxValue;
                        newBlockData.setFlowerAmount(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("noteblock_instrument")) {
                        NoteBlock newBlockData = (NoteBlock) blockData;
                        Instrument value = newBlockData.getInstrument();
                        Instrument[] valuesArray = new Instrument[]{
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
                        List<Instrument> values = new ArrayList<>();
                        for (Instrument state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("noteblock_instrument", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Instrument newValue = values.get(newIndex);
                        newBlockData.setInstrument(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("noteblock_note")) {
                        NoteBlock newBlockData = (NoteBlock) blockData;
                        int value = newBlockData.getNote().getOctave();
                        int maxValue = 24;
                        int newValue = (value + 1) % maxValue;
                        newBlockData.setNote(Note.natural(newValue, newBlockData.getNote().getTone()));

                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("hangable")) {
                        Hangable newBlockData = (Hangable) blockData;
                        boolean newValue = !newBlockData.isHanging();
                        newBlockData.setHanging(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("snowable")) {
                        Snowable newBlockData = (Snowable) blockData;
                        boolean newValue = !newBlockData.isSnowy();
                        newBlockData.setSnowy(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("gate")) {
                        Gate newBlockData = (Gate) blockData;
                        boolean newValue = !newBlockData.isInWall();
                        newBlockData.setInWall(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("attachable")) {
                        Attachable newBlockData = (Attachable) blockData;
                        boolean newValue = !newBlockData.isAttached();
                        newBlockData.setAttached(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("multiple_facing_down")) {
                        MultipleFacing newBlockData = (MultipleFacing) blockData;
                        boolean newValue = !newBlockData.hasFace(BlockFace.DOWN);
                        newBlockData.setFace(BlockFace.DOWN, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("multiple_facing_up")) {
                        MultipleFacing newBlockData = (MultipleFacing) blockData;
                        boolean newValue = !newBlockData.hasFace(BlockFace.UP);
                        newBlockData.setFace(BlockFace.UP, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("multiple_facing_west")) {
                        MultipleFacing newBlockData = (MultipleFacing) blockData;
                        boolean newValue = !newBlockData.hasFace(BlockFace.WEST);
                        newBlockData.setFace(BlockFace.WEST, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("multiple_facing_south")) {
                        MultipleFacing newBlockData = (MultipleFacing) blockData;
                        boolean newValue = !newBlockData.hasFace(BlockFace.SOUTH);
                        newBlockData.setFace(BlockFace.SOUTH, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("multiple_facing_east")) {
                        MultipleFacing newBlockData = (MultipleFacing) blockData;
                        boolean newValue = !newBlockData.hasFace(BlockFace.EAST);
                        newBlockData.setFace(BlockFace.EAST, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("multiple_facing_north")) {
                        MultipleFacing newBlockData = (MultipleFacing) blockData;
                        boolean newValue = !newBlockData.hasFace(BlockFace.NORTH);
                        newBlockData.setFace(BlockFace.NORTH, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("wall_up")) {
                        Wall newBlockData = (Wall) blockData;
                        boolean newValue = !newBlockData.isUp();
                        newBlockData.setUp(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("wall_west")) {
                        Wall newBlockData = (Wall) blockData;
                        Wall.Height value = newBlockData.getHeight(BlockFace.WEST);
                        Wall.Height[] valuesArray = new Wall.Height[]{
                                Wall.Height.LOW,
                                Wall.Height.TALL,
                                Wall.Height.NONE
                        };
                        List<Wall.Height> values = new ArrayList<>();
                        for (Wall.Height state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("wall", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Wall.Height newValue = values.get(newIndex);
                        newBlockData.setHeight(BlockFace.WEST, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("wall_south")) {
                        Wall newBlockData = (Wall) blockData;
                        Wall.Height value = newBlockData.getHeight(BlockFace.SOUTH);
                        Wall.Height[] valuesArray = new Wall.Height[]{
                                Wall.Height.LOW,
                                Wall.Height.TALL,
                                Wall.Height.NONE
                        };
                        List<Wall.Height> values = new ArrayList<>();
                        for (Wall.Height state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("wall", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Wall.Height newValue = values.get(newIndex);
                        newBlockData.setHeight(BlockFace.SOUTH, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("wall_east")) {
                        Wall newBlockData = (Wall) blockData;
                        Wall.Height value = newBlockData.getHeight(BlockFace.EAST);
                        Wall.Height[] valuesArray = new Wall.Height[]{
                                Wall.Height.LOW,
                                Wall.Height.TALL,
                                Wall.Height.NONE
                        };
                        List<Wall.Height> values = new ArrayList<>();
                        for (Wall.Height state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("wall", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Wall.Height newValue = values.get(newIndex);
                        newBlockData.setHeight(BlockFace.EAST, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("wall_north")) {
                        Wall newBlockData = (Wall) blockData;
                        Wall.Height value = newBlockData.getHeight(BlockFace.NORTH);
                        Wall.Height[] valuesArray = new Wall.Height[]{
                                Wall.Height.LOW,
                                Wall.Height.TALL,
                                Wall.Height.NONE
                        };
                        List<Wall.Height> values = new ArrayList<>();
                        for (Wall.Height state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("wall", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Wall.Height newValue = values.get(newIndex);
                        newBlockData.setHeight(BlockFace.NORTH, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("chiseled_bookshelf_slot_5")) {
                        ChiseledBookshelf newBlockData = (ChiseledBookshelf) blockData;
                        boolean newValue = !newBlockData.isSlotOccupied(5);
                        newBlockData.setSlotOccupied(5, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("chiseled_bookshelf_slot_4")) {
                        ChiseledBookshelf newBlockData = (ChiseledBookshelf) blockData;
                        boolean newValue = !newBlockData.isSlotOccupied(4);
                        newBlockData.setSlotOccupied(4, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("chiseled_bookshelf_slot_3")) {
                        ChiseledBookshelf newBlockData = (ChiseledBookshelf) blockData;
                        boolean newValue = !newBlockData.isSlotOccupied(3);
                        newBlockData.setSlotOccupied(3, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("chiseled_bookshelf_slot_2")) {
                        ChiseledBookshelf newBlockData = (ChiseledBookshelf) blockData;
                        boolean newValue = !newBlockData.isSlotOccupied(2);
                        newBlockData.setSlotOccupied(2, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("chiseled_bookshelf_slot_1")) {
                        ChiseledBookshelf newBlockData = (ChiseledBookshelf) blockData;
                        boolean newValue = !newBlockData.isSlotOccupied(1);
                        newBlockData.setSlotOccupied(1, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("chiseled_bookshelf_slot_0")) {
                        ChiseledBookshelf newBlockData = (ChiseledBookshelf) blockData;
                        boolean newValue = !newBlockData.isSlotOccupied(0);
                        newBlockData.setSlotOccupied(0, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("cave_wines")) {
                        CaveVines newBlockData = (CaveVines) blockData;
                        boolean newValue = !newBlockData.isBerries();
                        newBlockData.setBerries(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("levelled")) {
                        Levelled newBlockData = (Levelled) blockData;
                        int offset = 0;
                        if (block.getType().equals(Material.LAVA_CAULDRON) || block.getType().equals(Material.POWDER_SNOW_CAULDRON) || block.getType().equals(Material.WATER_CAULDRON)) {
                            offset = 1;
                        }
                        int maxValue = newBlockData.getMaximumLevel() + 1 - offset;
                        int value = newBlockData.getLevel();
                        int newValue = ((value + 1) % maxValue) + offset;
                        newBlockData.setLevel(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("candle")) {
                        Candle newBlockData = (Candle) blockData;
                        int maxValue = newBlockData.getMaximumCandles() + 1;
                        int value = newBlockData.getCandles();
                        int newValue = (value + 1) % maxValue;
                        newBlockData.setCandles(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("campfire")) {
                        Campfire newBlockData = (Campfire) blockData;
                        boolean newValue = !newBlockData.isSignalFire();
                        newBlockData.setSignalFire(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("face_attachable")) {
                        FaceAttachable newBlockData = (FaceAttachable) blockData;
                        FaceAttachable.AttachedFace value = newBlockData.getAttachedFace();
                        FaceAttachable.AttachedFace[] valuesArray = new FaceAttachable.AttachedFace[]{
                                FaceAttachable.AttachedFace.CEILING,
                                FaceAttachable.AttachedFace.FLOOR,
                                FaceAttachable.AttachedFace.WALL
                        };
                        List<FaceAttachable.AttachedFace> values = new ArrayList<>();
                        for (FaceAttachable.AttachedFace state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("face_attachable", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        FaceAttachable.AttachedFace newValue = values.get(newIndex);
                        newBlockData.setAttachedFace(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("brewing_stand_bottle_2")) {
                        BrewingStand newBlockData = (BrewingStand) blockData;
                        boolean newValue = !newBlockData.hasBottle(2);
                        newBlockData.setBottle(2, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("brewing_stand_bottle_1")) {
                        BrewingStand newBlockData = (BrewingStand) blockData;
                        boolean newValue = !newBlockData.hasBottle(1);
                        newBlockData.setBottle(1, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("brewing_stand_bottle_0")) {
                        BrewingStand newBlockData = (BrewingStand) blockData;
                        boolean newValue = !newBlockData.hasBottle(0);
                        newBlockData.setBottle(0, newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("lightable")) {
                        Lightable newBlockData = (Lightable) blockData;
                        boolean newValue = !newBlockData.isLit();
                        newBlockData.setLit(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("big_dripleaf")) {
                        BigDripleaf newBlockData = (BigDripleaf) blockData;
                        BigDripleaf.Tilt value = newBlockData.getTilt();
                        BigDripleaf.Tilt[] valuesArray = new BigDripleaf.Tilt[]{
                                BigDripleaf.Tilt.NONE,
                                BigDripleaf.Tilt.PARTIAL,
                                BigDripleaf.Tilt.UNSTABLE,
                                BigDripleaf.Tilt.FULL
                        };
                        List<BigDripleaf.Tilt> values = new ArrayList<>();
                        for (BigDripleaf.Tilt state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("big_dripleaf", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        BigDripleaf.Tilt newValue = values.get(newIndex);
                        newBlockData.setTilt(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }


                    if (blockStateKey.equalsIgnoreCase("bell")) {
                        Bell newBlockData = (Bell) blockData;
                        Bell.Attachment value = newBlockData.getAttachment();
                        Bell.Attachment[] valuesArray = new Bell.Attachment[]{
                                Bell.Attachment.CEILING,
                                Bell.Attachment.FLOOR,
                                Bell.Attachment.DOUBLE_WALL,
                                Bell.Attachment.SINGLE_WALL
                        };
                        List<Bell.Attachment> values = new ArrayList<>();
                        for (Bell.Attachment state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("bell", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Bell.Attachment newValue = values.get(newIndex);
                        newBlockData.setAttachment(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("beehive")) {
                        Beehive newBlockData = (Beehive) blockData;
                        int maxValue = newBlockData.getMaximumHoneyLevel() + 1;
                        int value = newBlockData.getHoneyLevel();
                        int newValue = (value + 1) % maxValue;
                        newBlockData.setHoneyLevel(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("openable")) {
                        Openable newBlockData = (Openable) blockData;
                        boolean newValue = !newBlockData.isOpen();
                        newBlockData.setOpen(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("bamboo")) {
                        Bamboo newBlockData = (Bamboo) blockData;
                        Bamboo.Leaves value = newBlockData.getLeaves();
                        Bamboo.Leaves[] valuesArray = new Bamboo.Leaves[]{
                                Bamboo.Leaves.LARGE,
                                Bamboo.Leaves.SMALL,
                                Bamboo.Leaves.NONE
                        };
                        List<Bamboo.Leaves> values = new ArrayList<>();
                        for (Bamboo.Leaves state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("bamboo", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Bamboo.Leaves newValue = values.get(newIndex);
                        newBlockData.setLeaves(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("cake")) {
                        Cake newBlockData = (Cake) blockData;
                        int maxValue = newBlockData.getMaximumBites() + 1;
                        int value = newBlockData.getBites();
                        int newValue = (value + 1) % maxValue;
                        newBlockData.setBites(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("chest")) {
                        Chest newBlockData = (Chest) blockData;
                        Chest.Type value = newBlockData.getType();
                        Chest.Type[] valuesArray = new Chest.Type[]{
                                Chest.Type.LEFT,
                                Chest.Type.RIGHT,
                                Chest.Type.SINGLE,
                        };
                        List<Chest.Type> values = new ArrayList<>();
                        for (Chest.Type state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("chest", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Chest.Type newValue = values.get(newIndex);
                        newBlockData.setType(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));

                    }
                    if (blockStateKey.equalsIgnoreCase("bed")) {
                        Bed newBlockData = (Bed) blockData;
                        Bed.Part value = newBlockData.getPart();
                        Bed.Part[] valuesArray = new Bed.Part[]{
                                Bed.Part.HEAD,
                                Bed.Part.FOOT
                        };
                        List<Bed.Part> values = new ArrayList<>();
                        for (Bed.Part state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("bed", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Bed.Part newValue = values.get(newIndex);
                        newBlockData.setPart(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }
                    if (blockStateKey.equalsIgnoreCase("directional")) {
                        Directional newBlockData = (Directional) blockData;
                        BlockFace value = newBlockData.getFacing();
                        BlockFace[] valuesArray = newBlockData.getFaces().toArray(new BlockFace[0]);

                        List<BlockFace> values = new ArrayList<>();
                        for (BlockFace state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("bed", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        BlockFace newValue = values.get(newIndex);
                        newBlockData.setFacing(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("rotatable")) {
                        Rotatable newBlockData = (Rotatable) blockData;
                        BlockFace value = newBlockData.getRotation();
                        BlockFace[] valuesArray = new BlockFace[]{
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
                        List<BlockFace> values = new ArrayList<>();
                        for (BlockFace state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("rotatable", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        BlockFace newValue = values.get(newIndex);
                        newBlockData.setRotation(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("orientable")) {
                        Orientable newBlockData = (Orientable) blockData;
                        Axis axis = newBlockData.getAxis();
                        Axis[] valuesArray = newBlockData.getAxes().toArray(new Axis[0]);
                        List<Axis> values = new ArrayList<>();
                        for (Axis state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("orientable.axis", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == axis) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(axis);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Axis newValue = values.get(newIndex);
                        newBlockData.setAxis(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("bisected")) {
                        Bisected newBlockData = (Bisected) blockData;
                        Bisected.Half value = newBlockData.getHalf();
                        Bisected.Half[] valuesArray = new Bisected.Half[] {
                                Bisected.Half.TOP,
                                Bisected.Half.BOTTOM
                        };
                        List<Bisected.Half> values = new ArrayList<>();
                        for (Bisected.Half state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("bisected.half", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Bisected.Half newValue = values.get(newIndex);
                        newBlockData.setHalf(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("waterlogged")) {
                        Waterlogged newBlockData = (Waterlogged) blockData;
                        boolean newValue = !newBlockData.isWaterlogged();
                        newBlockData.setWaterlogged(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("powerable")) {
                        Powerable newBlockData = (Powerable) blockData;
                        boolean newValue = !newBlockData.isPowered();
                        newBlockData.setPowered(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("ageable")) {
                        Ageable newBlockData = (Ageable) blockData;
                        int value = newBlockData.getAge();
                        int maxValue = newBlockData.getMaximumAge() + 1;
                        int newValue = (value + 1) % maxValue;
                        newBlockData.setAge(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("rail")) {
                        Rail newBlockData = (Rail) blockData;
                        Rail.Shape value = newBlockData.getShape();
                        Rail.Shape[] valuesArray = newBlockData.getShapes().toArray(new Rail.Shape[0]);
                        List<Rail.Shape> values = new ArrayList<>();
                        for (Rail.Shape state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("rail.shape", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Rail.Shape newValue = values.get(newIndex);
                        newBlockData.setShape(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }

                    if (blockStateKey.equalsIgnoreCase("stairs")) {
                        Stairs newBlockData = (Stairs) blockData;
                        Stairs.Shape value = newBlockData.getShape();
                        Stairs.Shape[] valuesArray = new Stairs.Shape[]{
                                Stairs.Shape.INNER_LEFT,
                                Stairs.Shape.INNER_RIGHT,
                                Stairs.Shape.OUTER_LEFT,
                                Stairs.Shape.OUTER_RIGHT,
                                Stairs.Shape.STRAIGHT,
                        };
                        List<Stairs.Shape> values = new ArrayList<>();
                        for (Stairs.Shape state : valuesArray) {
                            if (SurvivalDebugStick.getPluginConfig().isAllowedState("stairs.shape", state.toString().toLowerCase())) {
                                values.add(state);
                            } else {
                                if (state == value) {
                                    return;
                                }
                            }
                        }
                        int index = values.indexOf(value);
                        int size = values.size();
                        int newIndex = (index + 1) % size;
                        Stairs.Shape newValue = values.get(newIndex);
                        newBlockData.setShape(newValue);
                        blockState.setBlockData(newBlockData);
                        event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStateKey, String.valueOf(newValue)));
                    }


                } else if (event.getAction().isLeftClick()) {
                    blockStateIndex = (blockStateIndex + 1) % blockStates.size();
                    event.getPlayer().sendActionBar(SurvivalDebugStick.getLanguageConfig().getActionBarMessage(blockStates.get(blockStateIndex)));
                }
            }


            blockState.update(false, false);
        }

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            processingClickEvent = false;
        }, 1L);
    }
}

