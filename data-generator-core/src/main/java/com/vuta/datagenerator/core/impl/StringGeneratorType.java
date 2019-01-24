package com.vuta.datagenerator.core.impl;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

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
public final class StringGeneratorType extends GeneratorType<String> {

  Random random;

  public StringGeneratorType() {
    random = new Random();
    properties = GeneratorPropertiesBuilder.newInstance().withCode("string").withDescription("Integer type generator")
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

    if (strategy.equals(StrategyEnum.RANDOM_LIST)) {
      supplier = () -> args[random.nextInt(args.length)];
    } else if (strategy.equals(StrategyEnum.RANDOM_MIN_MAX)) {

      try {
        supplier = () -> RandomStringUtils.randomAlphabetic(
            random.nextInt((Integer.parseInt(args[1]) - Integer.parseInt(args[0])) + Integer.parseInt(args[0])));
      } catch (NumberFormatException e) {
        throw new GeneratorArgumentsException("Min/max length value need to be integers:", properties);
      }

    }

  }

}
