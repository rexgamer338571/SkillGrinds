package dev.ng5m.skillgrinds.command;

import dev.ng5m.skillgrinds.util.Shared;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class CUpdate {
    public static void update() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL("https://raw.githubusercontent.com/rexgamer338571/SkillGrinds/main/updaterData/SkillGrinds-1.0.jar").openStream()); FileOutputStream fileOutputStream = new FileOutputStream("/plugins/SkillGrinds-1.0.jar")) {
            byte[] buffer = new byte[1024];
            int bytes;

            while ((bytes = bufferedInputStream.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, bytes);
            }

            Shared.plugin.getLogger().info("Updated SkillGrinds plugin to the latest version!");
        } catch (IOException x) {
            Shared.plugin.getLogger().warning("Couldn't update SkillGrinds");
        }
    }
}
