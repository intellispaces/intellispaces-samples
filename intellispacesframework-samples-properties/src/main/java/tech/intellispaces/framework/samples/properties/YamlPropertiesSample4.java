package tech.intellispaces.framework.samples.properties;

import intellispaces.ixora.mindstructs.cli.ConsoleHandle;
import tech.intellispaces.framework.core.IntellispacesFramework;
import tech.intellispaces.framework.core.annotation.Inject;
import tech.intellispaces.framework.core.annotation.Module;
import tech.intellispaces.framework.core.annotation.Projection;
import tech.intellispaces.framework.core.annotation.Properties;
import tech.intellispaces.framework.core.annotation.Startup;
import tech.mindstructs.cli.CliConfiguration;
import tech.mindstructs.snakeyaml.YamlStringToPropertiesSnakeyamlMapper;
import tech.mindstructs.structures.properties.MindstructsPropertiesToDataMapper;

/**
 * This module demonstrates reading module YAML properties.<p/>
 *
 * Three units {@link CliConfiguration}, {@link YamlStringToPropertiesSnakeyamlMapper} and {@link MindstructsPropertiesToDataMapper} are included to module.
 * Unit {@link CliConfiguration} defines the projection named 'console' referred to the module CLI console.
 * Unit {@link YamlStringToPropertiesSnakeyamlMapper} provides guide to load YAML properties.
 * Unit {@link MindstructsPropertiesToDataMapper} provides guide to map properties to data.
 */
@Module(units = { CliConfiguration.class, YamlStringToPropertiesSnakeyamlMapper.class, MindstructsPropertiesToDataMapper.class })
public abstract class YamlPropertiesSample4 {

  /**
   * Declare projection to owner address city specified by default in file 'module.yaml'.<p/>
   *
   * This abstract method will be auto implemented in wrapper class.
   */
  @Projection
  @Properties("owner.address.city")
  public abstract String ownerCity();

  /**
   * Declare projection to owner address street specified by default in file 'module.yaml'.<p/>
   *
   * This abstract method will be auto implemented in wrapper class.
   */
  @Projection
  @Properties("owner.address.street")
  public abstract String ownerStreet();

  /**
   * This method will be invoked automatically after the module is started.<p/>
   *
   * The values of method arguments will be injected automatically.
   *
   * @param console value of the projection named 'console'.
   */
  @Startup
  public void startup(@Inject ConsoleHandle console) {
    console.println("City: " + ownerCity());
    console.println("Street: " + ownerStreet());
  }

  /**
   * In the main method, we load and run the IntelliSpaces framework module.
   */
  public static void main(String[] args) {
    IntellispacesFramework.loadModule(YamlPropertiesSample4.class, args);
  }
}
