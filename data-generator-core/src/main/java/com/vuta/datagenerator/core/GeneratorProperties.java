package com.vuta.datagenerator.core;

import java.util.Arrays;

// @formatter:off
/**
 * @author Vuta Alexandru https://vuta-alexandru.com Created at 23 janv. 2019
 *         contact email: verso.930[at]gmail.com
 */
// @formatter:on
public final class GeneratorProperties {

  private int maxArgs;
  private int minArgs;
  private String code;
  private String description;
  private StrategyEnum[] strategies;

  protected GeneratorProperties() {
  }

  protected GeneratorProperties(int maxArgs, int minArgs, String code, String description, StrategyEnum[] strategies) {
    super();
    this.maxArgs = maxArgs;
    this.minArgs = minArgs;
    this.code = code;
    this.description = description;
    this.strategies = strategies;
  }

  public int getMaxArgs() {
    return maxArgs;
  }

  public int getMinArgs() {
    return minArgs;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  public StrategyEnum[] getStrategies() {
    return strategies;
  }

  @Override
  public String toString() {
    return "GeneratorProperties [maxArgs=" + maxArgs + ", minArgs=" + minArgs + ", code=" + code + ", description="
        + description + ", strategies=" + Arrays.toString(strategies) + "]";
  }

  public static class GeneratorPropertiesBuilder {

    private int maxArgs;
    private int minArgs;
    private String code;
    private String description;
    private StrategyEnum[] strategies;

    public static GeneratorPropertiesBuilder newInstance() {
      return new GeneratorPropertiesBuilder();
    }

    public GeneratorPropertiesBuilder withMaxArgs(int maxArgs) {
      this.maxArgs = maxArgs;
      return this;
    }

    public GeneratorPropertiesBuilder withMinArgs(int minArgs) {
      this.minArgs = minArgs;
      return this;
    }

    public GeneratorPropertiesBuilder withCode(String code) {
      this.code = code;
      return this;
    }

    public GeneratorPropertiesBuilder withDescription(String description) {
      this.description = description;
      return this;
    }

    public GeneratorPropertiesBuilder withStrategies(StrategyEnum[] strategies) {
      this.strategies = strategies;
      return this;
    }

    public GeneratorProperties build() {
      return new GeneratorProperties(maxArgs, minArgs, code, description, strategies);
    }
  }

}
