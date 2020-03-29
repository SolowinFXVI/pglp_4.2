package org.uvsq21400579;

public enum CalculatriceRPN {
  CALCULATE(){
    public void run(){
      MoteurRPN moteurRPN = new MoteurRPN();
      SaisieRPN saisieRPN = new SaisieRPN(moteurRPN);
      while (true) {
        saisieRPN.getInput();
      }
    }
  };

  public abstract void run();

  /**
   * @param args
   */
  public static void main(String[] args){
    CALCULATE.run();
  }
}
