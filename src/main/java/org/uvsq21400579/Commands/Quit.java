package org.uvsq21400579.Commands;

import org.uvsq21400579.Command;
import org.uvsq21400579.Interpreteur;

public class Quit implements Command {
  private Interpreteur interpreteur;

  /**
   * Quit Constructor
   * @param interpreteur
   */
  Quit(Interpreteur interpreteur){
    this.interpreteur = interpreteur;
  }


  @Override
  public void execute(){
    this.interpreteur.quit();
  }

}
