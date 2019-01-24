package com.vuta.datagenerator.core.impl;

import static org.assertj.core.api.Assertions.assertThat;

import com.vuta.datagenerator.core.DataGeneratorProvider;
import com.vuta.datagenerator.core.GeneratorType;
import com.vuta.datagenerator.core.StrategyEnum;
import com.vuta.datagenerator.core.exception.GeneratorException;

import junit.framework.TestCase;

// @formatter:off
/**
 * @author Vuta Alexandru https://vuta-alexandru.com Created at 20 janv. 2019
 *         contact email: verso.930[at]gmail.com
 */
// @formatter:on
public class RandomIntOperatorTests extends TestCase {

  @SuppressWarnings("unchecked")
  GeneratorType<Integer> generator = DataGeneratorProvider.generator("int");

  public void testFixedValue() throws GeneratorException {

    generator.initialize(StrategyEnum.RANDOM_LIST, "150");
    assertThat(generator.get()).isEqualTo(150);
    assertThat(generator.get()).isEqualTo(150);
    assertThat(generator.get()).isEqualTo(150);
    assertThat(generator.get()).isEqualTo(150);

  }

  public void testMaxValue() throws GeneratorException {
    generator.initialize(StrategyEnum.RANDOM_MIN_MAX, "0", "150");
    assertThat(generator.get()).isBetween(0, 150);
    assertThat(generator.get()).isBetween(0, 150);
    assertThat(generator.get()).isBetween(0, 150);
  }

}
