package org.uvsq21400579.Commands;

import org.uvsq21400579.Command;
import org.uvsq21400579.Interpreteur;

public class Undo implements Command {

  private Interpreteur interpreteur;

  /**
   * Undo Constructor
   * @param interpreteur
   */
  public Undo(Interpreteur interpreteur){
    this.interpreteur = interpreteur;
  }

  @Override
  public void execute() {
    this.interpreteur.undo();
  }

}
