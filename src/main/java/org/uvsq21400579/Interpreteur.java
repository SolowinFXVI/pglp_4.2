package org.uvsq21400579;

import java.util.Stack;

public class Interpreteur {
  public Stack<Double> history = new Stack<>();
  public Stack<Double> pile;

  /**
   * Interpreteur constructor
   */
  Interpreteur(){
    this.pile = new Stack<>();
  }

  public void undo(){
    pile=history;
  }

  public void quit(){
    System.out.println("End");
    Runtime.getRuntime().exit(0);
  }
}
