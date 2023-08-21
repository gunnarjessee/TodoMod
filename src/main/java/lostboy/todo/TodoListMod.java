package lostboy.todo;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(TodoListMod.MOD_ID)
public class TodoListMod  {

	public static final String MOD_ID = "todolist";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//
	public TodoListMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register the commonSetup method for modloading
		modEventBus.addListener(this::commonSetup);
	}
	private void commonSetup(final FMLCommonSetupEvent event)
	{
		// Some common setup code
		LOGGER.info("Setting up common");

	}
}