package org.uvsq21400579;

import static org.junit.Assert.assertEquals;

import java.util.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uvsq21400579.Commands.Apply;
import org.uvsq21400579.Commands.Result;
import org.uvsq21400579.Commands.Save;
import org.uvsq21400579.Commands.Undo;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    MoteurRPN moteurRPN;
    @Before
    public void initialize(){
        moteurRPN = new MoteurRPN();
    }

    @Test
    public void testStack(){
        moteurRPN.pile.push(3.0);
        assertEquals(3.0, moteurRPN.pile.pop(),0);
    }

    @Test
    public void testSave(){
        Save save = new Save(moteurRPN, 3.0);
        save.execute();
        save.setOperand(2.0);
        save.execute();
        assertEquals(2.0, moteurRPN.pile.pop(),0);
        assertEquals(3.0, moteurRPN.pile.pop(),0);
    }

    @Test
    public void testUndo(){
        Save save = new Save(moteurRPN, 3);
        Undo undo = new Undo(moteurRPN);
        save.execute();
        save.setOperand(2);
        save.execute();
        undo.execute();
        assertEquals(3, moteurRPN.pile.pop(),0.0);
    }

    @Test
    public void testApply() {
        Save save = new Save(moteurRPN, 3.0);
        Apply apply = new Apply(moteurRPN,Operator.MOINS);
        save.execute();
        save.setOperand(4);
        save.execute();
        apply.execute();
        assertEquals(-1.0, moteurRPN.pile.pop(), 0);
    }

    @Test
    public void testResult(){
        Stack<Double> tmp = new Stack<>();
        Stack<Double> tmp2 = new Stack<>();
        Save save = new Save(moteurRPN, 3);
        Result ret = new Result(moteurRPN);
        save.execute();
        save.setOperand(2.0);
        save.execute();
        ret.execute();
        tmp2.addAll(ret.getCollection());
        tmp.push(3.0);
        tmp.push(2.0);
        assertEquals(tmp,tmp2);
    }

    /**
     * Test for a long operation
     */
    @Test //((15 / (7 - (1 + 1))) / 3) - (2 + (1 + 1)) = 5, input = 15 7 1 1 + - / 3 * 2 1 1 + + -
    public void combinaison(){
        Save save = new Save(moteurRPN, 15);
        Apply apply = new Apply(moteurRPN,Operator.PLUS);
        save.execute();
        save.setOperand(7);
        save.execute();
        save.setOperand(1);
        save.execute();
        save.setOperand(1);
        save.execute();
        apply.execute();
        apply.setOperator(Operator.MOINS);
        apply.execute();
        apply.setOperator(Operator.DIV);
        apply.execute();
        save.setOperand(3);
        save.execute();
        apply.setOperator(Operator.MULT);
        apply.execute();
        save.setOperand(2);
        save.execute();
        save.setOperand(1);
        save.execute();
        save.setOperand(1);
        save.execute();
        apply.setOperator(Operator.PLUS);
        apply.execute();
        apply.setOperator(Operator.PLUS);
        apply.execute();
        apply.setOperator(Operator.MOINS);
        apply.execute();
        assertEquals(5, moteurRPN.pile.pop(), 0.0);
    }
}
