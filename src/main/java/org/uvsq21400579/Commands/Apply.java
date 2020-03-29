package org.uvsq21400579.Commands;

import java.util.Stack;
import org.uvsq21400579.Command;
import org.uvsq21400579.MoteurRPN;
import org.uvsq21400579.Operator;

public class Apply implements Command {
  private MoteurRPN moteurRPN;
  private Operator operator;

  /**
   * Apply constructor.
   * @param moteurRPN
   * @param operator
   */
  public Apply(MoteurRPN moteurRPN, Operator operator){
    this.moteurRPN = moteurRPN;
    this.operator = operator;
  }

  /**
   * Operator setter.
   * @param operator
   */
  public void setOperator(Operator operator){
    this.operator = operator;
  }


  @Override
  public void execute() {
    double tmp = 0.0;
    if(this.moteurRPN.pile.size() > 1) {
      this.moteurRPN.history = (Stack<Double>) this.moteurRPN.pile.clone();
      tmp = operator.eval(this.moteurRPN.pile.pop(),this.moteurRPN.pile.pop());
    }
    this.moteurRPN.pile.push(tmp);
  }
}
