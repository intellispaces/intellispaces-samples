package intellispaces.samples.helloworld;

import intellispaces.core.IntellispacesFramework;
import intellispaces.core.annotation.Inject;
import intellispaces.core.annotation.Module;
import intellispaces.core.annotation.Startup;
import intellispaces.core.space.transition.TransitionFunctions;
import intellispaces.ixora.cli.CliConfiguration;
import intellispaces.ixora.cli.ConsoleDomain;
import intellispaces.ixora.cli.MovableConsole;

/**
 * This module demonstrates the output to the console.<p/>
 *
 * Unit {@link CliConfiguration} is included to this module. In this unit the projection with name 'console' and referred to module CLI console is defined.
 */
@Module(units = CliConfiguration.class)
public class HelloWorldSample5 {

  /**
   * This method will be invoked automatically after the module is started.<p/>
   *
   * The values of method arguments will be injected automatically.
   *
   * @param console value of the projection named 'console'.
   */
  @Startup
  public void startup(@Inject MovableConsole console) {
    // Get identifier of the transition 'Console::println'
    String tid = TransitionFunctions.getTransitionId(ConsoleDomain.class, ConsoleDomain::println, "");

    // Move CLI console through transition defined by ID tid
    console.moveThru(tid, "Hello, world!");
  }

  /**
   * In the main method, we load and run the IntelliSpaces framework module.
   */
  public static void main(String[] args) {
    IntellispacesFramework.loadModule(HelloWorldSample5.class, args);
  }
}
