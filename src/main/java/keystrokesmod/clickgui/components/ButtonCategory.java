//Deobfuscated with https://github.com/PetoPetko/Minecraft-Deobfuscator3000 using mappings "1.8.9"!

package keystrokesmod.clickgui.components;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import keystrokesmod.clickgui.RenderComponent;
import keystrokesmod.main.Ravenbplus;
import keystrokesmod.module.Module;
import keystrokesmod.module.modules.client.Gui;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;

public class ButtonCategory {
   public ArrayList<RenderComponent> modulesInCategory = new ArrayList();
   public Module.category categoryName;
   private boolean categoryOpened;
   private int width;
   private int y;
   private int x;
   private final int bh;
   public boolean inUse;
   public int xx;
   public int yy;
   public boolean n4m = false;
   public String pvp;
   public boolean pin = false;
   private int chromaSpeed;
   private double marginY, marginX;

   public ButtonCategory(Module.category category) {
      this.categoryName = category;
      this.width = 92;
      this.x = 5;
      this.y = 5;
      this.bh = 13;
      this.xx = 0;
      this.categoryOpened = false;
      this.inUse = false;
      this.chromaSpeed = 3;
      int tY = this.bh + 3;
      this.marginX = 80;
      this.marginY = 4.5;

      for(Iterator<Module> var3 = Ravenbplus.notAName.getm0dmanager().inCateg(this.categoryName).iterator(); var3.hasNext(); tY += 16) {
         Module mod = (Module) var3.next();
         ButtonModule b = new ButtonModule(mod, this, tY);
         this.modulesInCategory.add(b);
      }

   }

   public ButtonCategory(String d) {
      this.width = 92;
      this.x = 5;
      this.y = 5;
      this.bh = 13;
      this.xx = 0;
      this.categoryOpened = false;
      this.inUse = false;
      int tY = this.bh;
      this.pvp = d;
      this.n4m = true;
   }

   public ArrayList<RenderComponent> getModules() {
      return this.modulesInCategory;
   }

   public void setX(int n) {
      this.x = n;
      if(Ravenbplus.clientConfig != null){
         Ravenbplus.clientConfig.saveConfig();
      }
   }

   public void setY(int y) {
      this.y = y;
      if(Ravenbplus.clientConfig != null){
         Ravenbplus.clientConfig.saveConfig();
      }
   }

   public void mousePressed(boolean d) {
      this.inUse = d;
   }

   public boolean p() {
      return this.pin;
   }

   public void cv(boolean on) {
      this.pin = on;
   }

   public boolean isOpened() {
      return this.categoryOpened;
   }

   public void setOpened(boolean on) {
      this.categoryOpened = on;
      if(Ravenbplus.clientConfig != null){
         Ravenbplus.clientConfig.saveConfig();
      }
   }

   public void rf(FontRenderer renderer) {
      this.width = 92;
      if (!this.modulesInCategory.isEmpty() && this.categoryOpened) {
         int categoryHeight = 0;

         RenderComponent moduleRenderManager;
         for(Iterator moduleInCategoryIterator = this.modulesInCategory.iterator(); moduleInCategoryIterator.hasNext(); categoryHeight += moduleRenderManager.getHeight()) {
            moduleRenderManager = (RenderComponent)moduleInCategoryIterator.next();
         }

         //drawing the background for every module in the category
         net.minecraft.client.gui.Gui.drawRect(this.x - 1, this.y, this.x + this.width + 1, this.y + this.bh + categoryHeight + 4, (new Color(0, 0, 0, (int)(keystrokesmod.module.modules.client.Gui.backgroundOpacity.getInput()/100 * 255))).getRGB());
      }

      if(Gui.categoryBackground.isToggled())
         ButtonTick.renderMain((float)(this.x - 2), (float)this.y, (float)(this.x + this.width + 2), (float)(this.y + this.bh + 3), -1);
      renderer.drawString(this.n4m ? this.pvp : this.categoryName.name(), (float)(this.x + 2), (float)(this.y + 4), Color.getHSBColor((float)(System.currentTimeMillis() % (7500L / (long)this.chromaSpeed)) / (7500.0F / (float)this.chromaSpeed), 1.0F, 1.0F).getRGB(), false);
      //renderer.drawString(this.n4m ? this.pvp : this.categoryName.name(), (float)(this.x + 2), (float)(this.y + 4), ay.astolfoColorsDraw(10, 14), false);
      if (!this.n4m) {
         GL11.glPushMatrix();
         //Opened/closed unicode... :yes: :holsum: :evil:
         renderer.drawString(this.categoryOpened ? "-" : "+", (float)(this.x + marginX), (float)((double)this.y + marginY), Color.white.getRGB(), false);
         GL11.glPopMatrix();
         if (this.categoryOpened && !this.modulesInCategory.isEmpty()) {
            Iterator var5 = this.modulesInCategory.iterator();

            while(var5.hasNext()) {
               RenderComponent c2 = (RenderComponent)var5.next();
               c2.draw();
            }
         }

      }
   }

   public void r3nd3r() {
      int o = this.bh + 3;

      RenderComponent c;
      for(Iterator var2 = this.modulesInCategory.iterator(); var2.hasNext(); o += c.getHeight()) {
         c = (RenderComponent)var2.next();
         c.setModuleStartAt(o);
      }

   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public int getWidth() {
      return this.width;
   }

   public void up(int x, int y) {
      if (this.inUse) {
         this.setX(x - this.xx);
         this.setY(y - this.yy);
      }

   }

   public boolean i(int x, int y) {
      return x >= this.x + 92 - 13 && x <= this.x + this.width && (float)y >= (float)this.y + 2.0F && y <= this.y + this.bh + 1;
   }

   public boolean mousePressed(int x, int y) {
      return x >= this.x + 77 && x <= this.x + this.width - 6 && (float)y >= (float)this.y + 2.0F && y <= this.y + this.bh + 1;
   }

   public boolean insideArea(int x, int y) {
      return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.bh;
   }
}
