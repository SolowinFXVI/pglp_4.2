package org.uvsq21400579;

public enum Operator {
  PLUS("+"){
    public double eval(double op1, double op2){
      return op1 + op2;
    }
  },
  MOINS("-"){
    public double eval(double op1, double op2){
      return op2 - op1;
    }
  },
  DIV("/"){
    public double eval(double op1, double op2){
      return op2/op1;
    }
  },
  MULT("*"){
    public double eval(double op1, double op2){
      return op1*op2;
    }
  };

  private String symbol;

  /**
   * Operator Constructor
   * @param symbol
   */
  Operator(String symbol){
    this.symbol = symbol;
  }

  public String getSymbol() {
    return this.symbol;
  }

  /**
   * @param op1
   * @param op2
   * @return result of the operation
   */
  public abstract double eval(double op1, double op2);

  /**
   * @param input
   * @return returns on Operator from an input String
   */
  public static Operator getOperatorFromInput(String input){
    for (Operator operator : values()){
      String ope = operator.getSymbol();
      if(input.equals(ope)){
        return operator;
      }
    }
    throw new IllegalArgumentException();
  }
}
