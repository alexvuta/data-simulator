package com.vuta.datagenerator.core.impl;

import java.util.Random;
import java.util.stream.Stream;

import com.vuta.datagenerator.core.GeneratorProperties.GeneratorPropertiesBuilder;
import com.vuta.datagenerator.core.GeneratorType;
import com.vuta.datagenerator.core.StrategyEnum;
import com.vuta.datagenerator.core.exception.GeneratorArgumentsException;
import com.vuta.datagenerator.core.exception.GeneratorException;

// @formatter:off
/**
 * @author Vuta Alexandru https://vuta-alexandru.com Created at 22 janv. 2019
 *         contact email: verso.930[at]gmail.com
 */
// @formatter:on
public final class IntGeneratorType extends GeneratorType<Integer> {

  Random random;

  public IntGeneratorType() {
    random = new Random();
    properties = GeneratorPropertiesBuilder.newInstance().withCode("int").withDescription("Integer type generator")
        .withMaxArgs(50).withMinArgs(1)
        .withStrategies(new StrategyEnum[] { StrategyEnum.RANDOM_LIST, StrategyEnum.RANDOM_MIN_MAX }).build();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.vuta.datagenerator.core.template.generator.TypeGenerator#initialize(com.
   * vuta.datagenerator.core.template.generator.RandomStrategyEnum,
   * java.lang.String[])
   */
  @Override
  public void initialize(StrategyEnum strategy, String... args) throws GeneratorException {

    super.initialize(strategy, args);

    // find strategy supplier
    if (strategy.equals(StrategyEnum.RANDOM_LIST)) {
      int[] numbers = Stream.of(args).mapToInt(number -> Integer.parseInt(number)).toArray();
      supplier = () -> numbers[random.nextInt(numbers.length)];
    } else if (strategy.equals(StrategyEnum.RANDOM_MIN_MAX)) {

      try {
        supplier = () -> random
            .nextInt((Integer.parseInt(args[1]) - Integer.parseInt(args[0])) + Integer.parseInt(args[0]));
      } catch (NumberFormatException e) {
        throw new GeneratorException("Min/max length value need to be integers. EG (100,200)");
      }
    } else {
      throw new GeneratorArgumentsException("STRATEGY ERROR: not available ", properties);
    }

  }

}
