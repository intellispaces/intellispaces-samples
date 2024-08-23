package intellispaces.samples.properties;

import intellispaces.core.IntellispacesFramework;
import intellispaces.core.annotation.Configuration;
import intellispaces.core.annotation.Inject;
import intellispaces.core.annotation.Module;
import intellispaces.core.annotation.Projection;
import intellispaces.core.annotation.Properties;
import intellispaces.core.annotation.Startup;
import intellispaces.ixora.cli.CliConfiguration;
import intellispaces.ixora.cli.Console;
import intellispaces.ixora.snakeyaml.YamlStringToPropertiesSnakeyamlMapper;
import intellispaces.ixora.structures.properties.PropertiesToDataIxoraMapper;
import intellispaces.samples.moduleproperties.Address;

public interface YamlPropertiesSample5 {

  /**
   * This module demonstrates reading module YAML properties.<p/>
   *
   * Three units {@link CliConfiguration}, {@link YamlStringToPropertiesSnakeyamlMapper} and {@link PropertiesToDataIxoraMapper} are included to module.
   * Unit {@link CliConfiguration} defines the projection named 'console' referred to the module CLI console.
   * Unit {@link YamlStringToPropertiesSnakeyamlMapper} provides guide to load YAML properties.
   * Unit {@link PropertiesToDataIxoraMapper} provides guide to map properties to data.
   */
  @Module(units = {
      ModuleConfiguration.class,
      CliConfiguration.class,
      YamlStringToPropertiesSnakeyamlMapper.class,
      PropertiesToDataIxoraMapper.class
  })
  abstract class MainUnit {

    /**
     * Inject projection to owner address.<p/>
     *
     * This abstract method will be auto implemented in wrapper class.
     */
    @Inject
    public abstract Address ownerAddress();

    /**
     * This method will be invoked automatically after the module is started.<p/>
     *
     * The values of all method arguments will be injected automatically.
     *
     * @param console value of the projection named 'console'.
     */
    @Startup
    public void startup(@Inject Console console) {
      console.println("City: " + ownerAddress().city());
      console.println("Street: " + ownerAddress().street());
    }

  /**
   * In the main method, we load and run the IntelliSpaces framework module.
   */
    public static void main(String[] args) {
      IntellispacesFramework.loadModule(MainUnit.class, args);
    }
  }

  @Configuration
  abstract class ModuleConfiguration {
    /**
     * Declare projection to owner address specified by default in file 'module.yaml'.<p/>
     *
     * This abstract method will be auto implemented in wrapper class.
     */
    @Projection
    @Properties("owner.address")
    public abstract Address ownerAddress();
  }
}
