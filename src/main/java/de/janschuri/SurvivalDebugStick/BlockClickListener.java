package de.janschuri.SurvivalDebugStick;

import org.bukkit.Axis;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.*;
import org.bukkit.block.data.type.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Arrays;
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
        if (event.getClickedBlock() != null && event.getPlayer().getItemInHand().getType() == Material.BLAZE_ROD) {
            event.setCancelled(true);
            if (processingClickEvent) return;
            processingClickEvent = true;
            Block block = event.getClickedBlock();
            BlockData blockData = block.getBlockData();
            BlockState blockState = block.getState();
            List<String> blockStates = new ArrayList<>();

            if (blockData instanceof Directional) {
                blockStates.add("directional");
            }
            if (blockData instanceof Orientable) {
                blockStates.add("orientable");
            }
            if (blockData instanceof Powerable) {
                blockStates.add("powerable");
            }
            if (blockData instanceof Waterlogged) {
                blockStates.add("waterlogged");
            }
            if (blockData instanceof Bisected) {
                blockStates.add("bisected");
            }
            if (blockData instanceof Ageable) {
                blockStates.add("ageable");
            }
            if (blockData instanceof Rail) {
                blockStates.add("rail");
            }
            if (blockData instanceof Rotatable) {
                blockStates.add("rotatable");
            }
            if (blockData instanceof Stairs) {
                blockStates.add("stairs");
            }
            if (blockData instanceof Bed) {
                blockStates.add("bed");
            }
            if (blockData instanceof Chest) {
                blockStates.add("chest");
            }
            if (blockData instanceof Cake) {
                blockStates.add("cake");
            }
            if (blockData instanceof Bamboo) {
                blockStates.add("bamboo");
            }
            if (blockData instanceof Openable) {
                blockStates.add("openable");
            }
            if (blockData instanceof Beehive) {
                blockStates.add("beehive");
            }
            if (blockData instanceof Bell) {
                blockStates.add("bell");
            }
            if (blockData instanceof BigDripleaf) {
                blockStates.add("big_dripleaf");
            }
            if (blockData instanceof Lightable) {
                blockStates.add("lightable");
            }
            if (blockData instanceof BrewingStand) {
                blockStates.add("first_bottle");
                blockStates.add("second_bottle");
                blockStates.add("third_bottle");
            }
            if (blockData instanceof FaceAttachable) {
                blockStates.add("face_attachable");
            }
            if (blockData instanceof Campfire) {
                blockStates.add("campfire");
            }
            if (blockData instanceof Candle) {
                blockStates.add("candle");
            }
            if (blockData instanceof Levelled) {
                blockStates.add("levelled");
            }


            if (!blockStates.isEmpty()) {
                blockStateIndex = (blockStateIndex) % blockStates.size();
                event.getPlayer().sendMessage(blockStates.get(blockStateIndex));



                if (event.getAction().isRightClick()) {

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("cave_wines")) {
                        CaveVines caveVines = (CaveVines) blockData;
                        caveVines.setBerries(!caveVines.isBerries());
                        blockState.setBlockData(caveVines);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + caveVines.isBerries());
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("levelled")) {
                        Levelled levelled = (Levelled) blockData;
                        int maxLevel = levelled.getMaximumLevel();
                        int level = levelled.getLevel();
                        int newLevel = ((level + 1) % maxLevel)+1;
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
                        List<FaceAttachable.AttachedFace> attachedFaces = Arrays.asList(attachedFacesArray);
                        int index = attachedFaces.indexOf(attachedFace);
                        int size = attachedFaces.size();
                        int newIndex = (index + 1) % size;
                        faceAttachable.setAttachedFace(attachedFaces.get(newIndex));
                        blockState.setBlockData(faceAttachable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + attachedFaces.get(newIndex));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("third_bottle")) {
                        BrewingStand brewingStand = (BrewingStand) blockData;
                        brewingStand.setBottle(2, !brewingStand.hasBottle(2));
                        blockState.setBlockData(brewingStand);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + brewingStand.hasBottle(2));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("second_bottle")) {
                        BrewingStand brewingStand = (BrewingStand) blockData;
                        brewingStand.setBottle(1, !brewingStand.hasBottle(1));
                        blockState.setBlockData(brewingStand);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + brewingStand.hasBottle(1));
                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("first_bottle")) {
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
                        List<BigDripleaf.Tilt> tilts = Arrays.asList(tiltsArray);
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
                        List<Bell.Attachment> attachments = Arrays.asList(attachmentsArray);
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
                        List<Bamboo.Leaves> leaves = Arrays.asList(leavesArray);
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
                        Chest.Type type =  chest.getType();
                        Chest.Type[] typesArray = new Chest.Type[]{
                                Chest.Type.LEFT,
                                Chest.Type.RIGHT,
                                Chest.Type.SINGLE,
                        };
                        List<Chest.Type> types = Arrays.asList(typesArray);
                        int index = types.indexOf(type);
                        int size = types.size();
                        int newIndex = (index + 1) % size;
                        chest.setType(types.get(newIndex));
                        blockState.setBlockData(chest);event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + types.get(newIndex));

                    }
                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("bed")) {
                        Bed bed = (Bed) blockData;
                        Bed.Part part = bed.getPart();
                        Bed.Part newPart;

                        if (part == Bed.Part.FOOT) {
                            newPart = Bed.Part.HEAD;
                        } else {
                            newPart = Bed.Part.FOOT;
                        }
                        bed.setPart(newPart);
                        blockState.setBlockData(bed);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newPart);
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
                        List<BlockFace> rotations = Arrays.asList(rotationsArray);
                        BlockFace rotation = rotatable.getRotation();
                        int index = rotations.indexOf(rotation);
                        int size = rotations.size();
                        int newIndex = (index + 1) % size;
                        rotatable.setRotation(rotations.get(newIndex));
                        blockState.setBlockData(rotatable);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + rotations.get(newIndex));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("orientable")) {
                        Orientable orientable = (Orientable) blockData;
                        List<Axis> axes = new ArrayList<>(orientable.getAxes());
                        Axis axis = orientable.getAxis();
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
                        Bisected.Half newHalf;

                        if (half == Bisected.Half.BOTTOM) {
                            newHalf = Bisected.Half.TOP;
                        } else {
                            newHalf = Bisected.Half.BOTTOM;
                        }
                        bisected.setHalf(newHalf);
                        blockState.setBlockData(bisected);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + newHalf);
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
                        List<Rail.Shape> shapes = new ArrayList<>(rail.getShapes());
                        Rail.Shape shape = rail.getShape();
                        int index = shapes.indexOf(shape);
                        int size = shapes.size();
                        int newIndex = (index + 1) % size;
                        rail.setShape(shapes.get(newIndex));
                        blockState.setBlockData(rail);
                        event.getPlayer().sendActionBar(blockStates.get(blockStateIndex) + ": " + shapes.get(newIndex));
                    }

                    if (blockStates.get(blockStateIndex).equalsIgnoreCase("stairs")) {
                        Stairs stairs = (Stairs) blockData;
                        Stairs.Shape[] shapesArray = new Stairs.Shape[]{
                                Stairs.Shape.INNER_LEFT,
                                Stairs.Shape.INNER_RIGHT,
                                Stairs.Shape.OUTER_LEFT,
                                Stairs.Shape.OUTER_RIGHT,
                                Stairs.Shape.STRAIGHT,
                        };
                        List<Stairs.Shape> shapes = Arrays.asList(shapesArray);
                        Stairs.Shape shape = stairs.getShape();
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

            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                processingClickEvent = false;
            }, 1L);
        }
    }
}
