package com.vuta.datagenerator.core;

import java.util.Arrays;
import java.util.function.Supplier;

import com.vuta.datagenerator.core.exception.GeneratorArgumentsException;
import com.vuta.datagenerator.core.exception.GeneratorException;

// @formatter:off
/**
 * @author Vuta Alexandru https://vuta-alexandru.com Created at 22 janv. 2019
 *         contact email: verso.930[at]gmail.com
 */
// @formatter:on
public abstract class GeneratorType<T> implements Supplier<T> {

  protected Supplier<T> supplier;
  protected GeneratorProperties properties;
  protected StrategyEnum strategy;
  protected String[] args;

  /**
   * Initialize the generator with given arguments
   * 
   * 
   * @param args are used to generate the value, and will not be interpreted the
   *             same for each strategy
   * @throws GeneratorException if the parameters are invalid
   */
  public void initialize(StrategyEnum strategy, String... args) throws GeneratorException {

    // check arguments validity
    if (args != null && properties.getMaxArgs() < args.length && properties.getMinArgs() > args.length) {
      throw new GeneratorArgumentsException("ARGUMENTS ERROR:", properties);
    }

    // check if strategy is supported
    if (!supportStrategy(strategy)) {
      throw new GeneratorException(String.format("Wrong strategy '%s'. Supported: %s", strategy.name(),
          Arrays.asList(properties.getStrategies())));
    }

    this.strategy = strategy;
    this.args = args;

  }

  /**
   * Get supplier value
   * 
   * @return Supplier
   */
  @Override
  public T get() {
    return supplier.get();
  }

  public StrategyEnum getCurrentstrategy() {
    return strategy;
  }

  boolean supportStrategy(StrategyEnum strategy) {
    return Arrays.asList(properties.getStrategies()).contains(strategy);
  }

  /**
   * Get the generator properties like min/max arguments, strategies available
   * 
   * @return
   */
  public GeneratorProperties getProperties() {
    return properties;
  }

}
