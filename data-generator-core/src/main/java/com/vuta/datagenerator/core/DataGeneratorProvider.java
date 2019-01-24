package com.vuta.datagenerator.core;

import java.nio.file.ProviderMismatchException;
import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

// @formatter:off
/**
 * @author Vuta Alexandru https://vuta-alexandru.com Created at 23 janv. 2019
 *         contact email: verso.930[at]gmail.com
 */
// @formatter:on
@SuppressWarnings("rawtypes")
public class DataGeneratorProvider {

  private static final List<GeneratorType> services = new ArrayList<>();

  static {
    ServiceLoader<GeneratorType> loader = ServiceLoader.load(GeneratorType.class);
    loader.forEach(generator -> {
      services.add(generator);
    });
  }

  // All providers
  public static List<GeneratorType> generators() {

    return new ArrayList<>(services);
  }

  // provider by name
  public static GeneratorType generator(final String generatorName) {

    // filter available generators
    List<GeneratorType> generators = services.stream()
        .filter(service -> service.getClass().getSimpleName().toUpperCase().startsWith(generatorName.toUpperCase()))
        .collect(Collectors.toList());

    // check if the result is appropriate
    if (generators.isEmpty()) {
      throw new ProviderNotFoundException(
          String.format("Generator type '%s' was not found", generatorName.toUpperCase()));
    } else if (generators.size() > 1) {
      throw new ProviderMismatchException("The provider name is ambigous. There are multiple match");
    }

    return generators.get(0);

  }

}
