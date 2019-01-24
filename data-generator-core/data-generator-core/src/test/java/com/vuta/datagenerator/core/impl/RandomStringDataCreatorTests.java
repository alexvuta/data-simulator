package com.vuta.datagenerator.core.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

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
public class RandomStringDataCreatorTests extends TestCase {

  @SuppressWarnings({ "unchecked" })
  GeneratorType<String> dataGenerator = DataGeneratorProvider.generator("string");

  public void testFixedString() throws GeneratorException {

    // prepare custom args
    String[] testStringValues = new String[] { "test string 1", "test2", "abcd abcd -abc-abc" };

    // initialize generator
    dataGenerator.initialize(StrategyEnum.RANDOM_LIST, testStringValues);

    // assert that generated value is in the list
    assertThat(dataGenerator.get()).isIn(Arrays.asList(testStringValues));
  }

}
