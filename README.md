# EnergyAPI Plugin - v1.0.0-a

Welcome to the **EnergyAPI** plugin! This Minecraft plugin allows you to implement and manage energy systems for items in your server. EnergyAPI is beginner-friendly and provides a powerful API to enhance the functionality of custom items with energy properties.

---

## Features

- **Energy Management**: Add energy and max energy to items.
- **Periodic Energy Updates**: Automatically recharge energy over time.
- **Custom Messages**: Display energy status to players via the action bar.
- **Easy Integration**: Use the API in your own plugins to create and manage energy-based items.

---

## Installation

1. **Download the Plugin**  
   Head to the [Releases](https://github.com/DrFreezyYT/EnergyAPI/releases) section and download the latest version of the plugin (`EnergyAPI-1.0.0-a.jar`).

2. **Place in Plugins Folder**  
   Place the downloaded `.jar` file into your server's `plugins` folder.

3. **Start Your Server**  
   Start your Minecraft server. The plugin will automatically enable and log startup messages in the console.

4. **Verify Installation**  
   Check the server console to see the startup banner and log messages from **EnergyAPI**.

---

## How to Use

### In Your Plugin

To use the **EnergyAPI** in your plugin, follow these steps:

#### 1. Add Dependency to Your Project

Include the EnergyAPI dependency in your `pom.xml` (if you're using Maven):

```xml
<repository>
    <id>freezy-repo-releases</id>
    <name>Freezy's Maven Repository</name>
    <url>https://mvn.freezy.me/releases</url>
</repository>

<dependency>
    <groupId>me.freezy.plugins</groupId>
    <artifactId>EnergyAPI</artifactId>
    <version>1.0.0-a</version>
</dependency>
```

#### 2. Update Your `plugin.yml`

Add EnergyAPI as a `depend` or `softdepend` in your `plugin.yml` file, depending on whether your plugin requires EnergyAPI to function.

**Example:**

```yaml
name: MyCustomPlugin
version: 1.0
main: com.example.myplugin.Main
api-version: 1.20

# Add as depend or softdepend
depend:
  - EnergyAPI
# OR
softdepend:
  - EnergyAPI
```

#### 3. Check if EnergyAPI is Enabled

In your plugin's main class, check if EnergyAPI is enabled before using it:

```java
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Check if EnergyAPI is enabled
        Plugin energyAPI = Bukkit.getPluginManager().getPlugin("EnergyAPI");
        if (energyAPI != null && energyAPI.isEnabled()) {
            getLogger().info("EnergyAPI detected and enabled!");
            // You can now safely use EnergyAPI's features
        } else {
            getLogger().warning("EnergyAPI is not installed or not enabled. Features depending on EnergyAPI will be disabled.");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("MyCustomPlugin is shutting down!");
    }
}
```

#### 4. Create an EnergyItem

Here's how to create a custom item with energy properties:

```java
import me.freezy.plugins.energyAPI.EnergyItem;
import org.bukkit.Material;

public class CustomItemCreator {

    public EnergyItem createEnergyItem() {
        // Create an EnergyItem with:
        // - 50 current energy
        // - 100 max energy
        // - 5 energy added per update
        return new EnergyItem(50, 100, (short) 5, Material.DIAMOND, 1);
    }
}
```

#### 5. Add to the EnergyAPI System

The EnergyAPI plugin automatically tracks all `EnergyItem` instances. Once you create an `EnergyItem`, it will be updated periodically with energy regeneration.

---

## For Players

When holding an energy item, players will see their item's energy status displayed in the action bar. For example:

```
Energy: 45.00/100.00
```

---

## API Overview

- **EnergyItem Class**:
    - `getEnergy()`: Returns the current energy of the item.
    - `setEnergy(double energy)`: Sets the item's current energy.
    - `getMaxEnergy()`: Returns the maximum energy of the item.
    - `setMaxEnergy(double maxEnergy)`: Sets the item's maximum energy.
    - `getUpdateAmount()`: Returns the amount of energy added per update.
    - `setUpdateAmount(short updateAmount)`: Sets the energy update amount.

- **EnergyAPI Class**:
    - Automatically updates energy for registered items.
    - Displays energy status via action bar to players holding energy items.

---

## Support

For any issues or feature requests, visit our [support page](https://github.com/DrFreezyYT/EnergyAPI/issues) or join the discussion in our community.

---

## License

This plugin is made with ❤️ by **DaTTV** / **Freezy**. Distributed under the MIT license. Feel free to contribute or use it in your projects!

```TXT
MIT License

Copyright (c) 2019-2024 admin@freezy.me

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

Enjoy using **EnergyAPI**! 🎉