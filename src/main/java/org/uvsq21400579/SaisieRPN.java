package org.uvsq21400579;

import java.util.Scanner;
import java.util.regex.Pattern;
import org.uvsq21400579.Commands.CalculatorCommand;

public class SaisieRPN {
  private Scanner scanner;
  private CalculatorCommand command;

  /**
   * SaisieRPN constructor
   * @param moteurRPN
   */
  SaisieRPN(MoteurRPN moteurRPN){
    this.scanner = new Scanner(System.in,"UTF-8");
    this.command = new CalculatorCommand();
    this.command.createCommandList(moteurRPN);
  }

  /**
   * Gets user input
   */
  public void getInput(){
    String input = this.scanner.nextLine();
    if(Pattern.matches("[-+]?[0-9]*\\.?[0-9]+",input)){
      this.command.setOperand(Double.parseDouble(input));
      this.command.executeCommand("save");
    }
    else if(input.equals("/") || input.equals("*") || input.equals("+") || input.equals("-")){
      this.command.setOperator(Operator.getOperatorFromInput(input));
      this.command.executeCommand("apply");
    }
    else {
      this.command.executeCommand(input);
    }
  }
}
