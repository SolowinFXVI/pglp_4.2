package org.uvsq21400579.Commands;

import java.util.Stack;
import org.uvsq21400579.Command;
import org.uvsq21400579.MoteurRPN;

public class Save implements Command {
  private MoteurRPN moteurRPN;
  private double operand;

  /**
   * Save constructor
   * @param moteurRPN
   * @param operand
   */
  public Save(MoteurRPN moteurRPN, double operand){
    this.moteurRPN = moteurRPN;
    this.operand = operand;
  }

  @Override
  public void execute() {
    this.moteurRPN.history = (Stack<Double>) this.moteurRPN.pile.clone();
    this.moteurRPN.pile.push(operand);
  }

  /**
   * @param operand
   */
  public void setOperand(double operand){
    this.operand = operand;
  }
}
