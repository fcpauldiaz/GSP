/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Apr 13, 2017
**/

package gsp;

import java.util.ArrayList;
import parser.gspGrammarBaseVisitor;
import parser.gspGrammarParser;

/**
 *
 * @author SDX
 */
public class ParserGSP extends gspGrammarBaseVisitor {
    
    private ArrayList<Predicate> predicates;
    private String initialState = "";
    private String goalState = "";

    public ParserGSP() {
        this.predicates = new ArrayList();
    }

    @Override
    public Object visitProgram(gspGrammarParser.ProgramContext ctx) {
        super.visitProgram(ctx);
        System.out.println(this.predicates);
        System.out.println(this.initialState);
        System.out.println(this.goalState);
        return null; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    @Override
    public Object visitSingular_predicate(gspGrammarParser.Singular_predicateContext ctx) {
        String pred = ctx.getText();
        String pred1 = pred.substring(1, pred.indexOf(("(")));
        String pred2 = pred.substring(pred.indexOf("(")+1, pred.length()-1).trim();
        int cant = pred2.length() > 0 ? pred2.split(",").length: pred2.length();
        this.predicates.add(new Predicate(pred1, cant));
        //System.out.println(this.predicates);
        return super.visitSingular_predicate(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitInitial_state(gspGrammarParser.Initial_stateContext ctx) {
        initialState = ctx.getChild(1).getText();
        return super.visitInitial_state(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitGoal_state(gspGrammarParser.Goal_stateContext ctx) {
        goalState = ctx.getChild(1).getText();
        return super.visitGoal_state(ctx); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
