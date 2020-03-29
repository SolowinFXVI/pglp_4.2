package org.uvsq21400579.Commands;

import java.util.HashMap;
import java.util.Map;
import org.uvsq21400579.Command;
import org.uvsq21400579.MoteurRPN;
import org.uvsq21400579.Operator;

public class CalculatorCommand {
  private Map<String, Command> commands;
  private MoteurRPN moteurRPN;

  /**
   * CalculatorCommand constructor
   */
  public CalculatorCommand(){
    this.commands = new HashMap<>();
  }

  /**
   * Adds a Command to the HashMap
   * @param name
   * @param command
   */
  public void addCommand(String name, Command command){
    this.commands.put(name, command);
  }

  /**
   * @param operand
   */
  public void setOperand(Double operand){
    Save save;
    if(this.commands.containsKey("save")){
      save = (Save) this.commands.get("save");
      save.setOperand(operand);
    }
  }

  /**
   * @param operator
   */
  public void setOperator(Operator operator){
    Apply apply;
    if(this.commands.containsKey("apply")){
      apply = (Apply) this.commands.get("apply");
      apply.setOperator(operator);
    }
  }

  /**
   * @param name
   */
  public void executeCommand(String name){
    if(this.commands.containsKey(name)){
      this.commands.get(name).execute();
      System.out.println(this.moteurRPN.returnRPN());
    }
  }

  /**
   * Add all the current available commands
   * @param moteurRPN
   */
  public void createCommandList(MoteurRPN moteurRPN){
    this.moteurRPN = moteurRPN;
    this.addCommand("undo", new Undo(moteurRPN));
    this.addCommand("quit", new Quit(moteurRPN));
    this.addCommand("result", new Result(moteurRPN));
    this.addCommand("save", new Save(moteurRPN, 0.0));
    this.addCommand("apply", new Apply(moteurRPN, Operator.PLUS));
  }
}
