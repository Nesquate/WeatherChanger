package tw.nesquate.weatherchanger.item;

import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CallThunderItem extends SimplePolymerItem {

    public CallThunderItem(Settings settings, Item polymerItem) {
        super(settings, polymerItem);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.PAPER;
    }

    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, TooltipContext context, @Nullable ServerPlayerEntity player) {
        ItemStack item = PolymerItemUtils.createItemStack(itemStack, context, player);
        item.addEnchantment(Enchantments.LURE,0 );
        return item;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.weatherchanger.call_thunder_item.tooltip").formatted(Formatting.YELLOW));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if(world.getRegistryKey() != World.OVERWORLD){
            user.sendMessage(Text.translatable("text.weatherchanger.error_not_in_overworld").formatted(Formatting.RED));
            return TypedActionResult.fail(itemStack);
        }

        if(world.isRaining() || world.isThundering()){
            user.sendMessage(Text.translatable("text.weatherchanger.error_is_raining").formatted(Formatting.RED));
            return TypedActionResult.fail(itemStack);
        }

        world.getServer().getWorld(World.OVERWORLD).setWeather(0,3600,true,true);
        itemStack.decrement(1);
        user.sendMessage(Text.translatable("text.weatherchanger.successful_thundering").formatted(Formatting.GREEN));
        world.getServer().getPlayerManager().broadcast(Text.translatable("text.weatherchanger.player_call_thundering", user.getName()).formatted(Formatting.YELLOW), false);

        return TypedActionResult.success(itemStack);
    }
}
