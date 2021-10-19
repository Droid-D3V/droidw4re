package keystrokesmod.module.modules.client;

import keystrokesmod.modules.Module;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatSuffix extends Module {
   public static ModuleDesc a;
   private Field l = null;

   public DelayRemover() {
      super("ChatSuffix", Module.category.client, 0);
      this.registerSetting(a = new ModuleDesc("Gives you a Custom Ending to each Message."));
   }
    }

    @SubscribeEvent
        String Suffix = "DroidW4RE_GH0ST";
        if (event.getMessage().startsWith("/") || event.getMessage().startsWith(".")
                || event.getMessage().startsWith(",") || event.getMessage().startsWith("-")
                || event.getMessage().startsWith("$") || event.getMessage().startsWith("*")) return;
        event.setMessage(event.getMessage() + Suffix);
    }
