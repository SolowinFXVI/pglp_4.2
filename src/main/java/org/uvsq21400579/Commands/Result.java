package org.uvsq21400579.Commands;

import java.util.Collection;
import org.uvsq21400579.Command;
import org.uvsq21400579.MoteurRPN;

public class Result implements Command {

  private MoteurRPN moteurRPN;

  /**
   * Result constructor
   * @param moteurRPN
   */
  public Result(MoteurRPN moteurRPN){
    this.moteurRPN = moteurRPN;
  }

  /**
   * @return Collection of moteurRPN
   */
  public Collection<Double> getCollection(){
    return this.moteurRPN.returnRPN();
  }

  @Override
  public void execute() {
  }
}
