package HxCKDMS.HxCMagicEnergy.Registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabHxCMagicEnergy extends CreativeTabs {
    public CreativeTabHxCMagicEnergy(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return Items.apple;
    }
}
