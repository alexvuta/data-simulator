package com.vuta.datagenerator.core.exception;

import com.vuta.datagenerator.core.GeneratorProperties;

// @formatter:off
/**
 * @author Vuta Alexandru https://vuta-alexandru.com Created at 23 janv. 2019
 *         contact email: verso.930[at]gmail.com
 */
// @formatter:on
public class GeneratorArgumentsException extends GeneratorException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * @param message
   */
  public GeneratorArgumentsException(String message, GeneratorProperties properties) {
    super(String.format("%s: %s", message, properties.toString()));
    // TODO Auto-generated constructor stub
  }

}
