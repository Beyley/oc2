package li.cil.oc2.common.container;

import li.cil.oc2.client.gui.MachineTerminalWidget;
import li.cil.oc2.common.bus.CommonDeviceBusController;
import li.cil.oc2.common.energy.FixedEnergyStorage;
import li.cil.oc2.common.entity.RobotEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.network.NetworkHooks;

public final class RobotTerminalContainer extends AbstractRobotContainer {
    public static void createServer(final RobotEntity robot, final FixedEnergyStorage energy, final CommonDeviceBusController busController, final ServerPlayer player) {
        NetworkHooks.openGui(player, new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return robot.getName();
            }

            @Override
            public AbstractContainerMenu createMenu(final int id, final Inventory inventory, final Player player) {
                return new RobotTerminalContainer(id, robot, createEnergyInfo(energy, busController));
            }
        }, b -> b.writeVarInt(robot.getId()));
    }

    public static RobotTerminalContainer createClient(final int id, final Inventory inventory, final FriendlyByteBuf data) {
        final int entityId = data.readVarInt();
        final Entity entity = inventory.player.level.getEntity(entityId);
        if (!(entity instanceof RobotEntity)) {
            throw new IllegalArgumentException();
        }
        return new RobotTerminalContainer(id, (RobotEntity) entity, createEnergyInfo());
    }

    ///////////////////////////////////////////////////////////////////

    private RobotTerminalContainer(final int id, final RobotEntity robot, final ContainerData energyInfo) {
        super(Containers.ROBOT_TERMINAL.get(), id, robot, energyInfo);

        final ItemStackHandler inventory = robot.getInventory();
        for (int slot = 0; slot < inventory.getSlots(); slot++) {
            final int x = (MachineTerminalWidget.WIDTH - inventory.getSlots() * SLOT_SIZE) / 2 + 1 + slot * SLOT_SIZE;
            addSlot(new SlotItemHandler(inventory, slot, x, MachineTerminalWidget.HEIGHT + 4));
        }
    }
}
