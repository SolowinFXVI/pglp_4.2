package org.uvsq21400579;

import java.util.Collection;
import java.util.Collections;

public class MoteurRPN extends Interpreteur {

  public MoteurRPN() {
    super();
  }

  /**
   * @return Collection of pile of MoteurRPN
   */
  public Collection<Double> returnRPN() {
    return Collections.unmodifiableCollection(this.pile);
  }
}
