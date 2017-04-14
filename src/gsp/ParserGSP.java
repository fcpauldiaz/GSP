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
    private ArrayList<Action> actions;
    private State initialState;
    private State goalState;
    private Action actualAction;
    private boolean precond;

    public ParserGSP() {
        this.predicates = new ArrayList();
        this.initialState = new State();
        this.goalState = new State();
        this.actions = new ArrayList();
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
        this.predicates.add(new Predicate(pred));
        //System.out.println(this.predicates);
        return super.visitSingular_predicate(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitInitial_state(gspGrammarParser.Initial_stateContext ctx) {
        String initial = ctx.getChild(1).getText();
        String[] initials = initial.split("\\^");
        this.initialState.setStatement(initial);
        for (int i = 0; i < initials.length; i++) {
            String actual = initials[i];
            this.initialState.addState(new Predicate(actual));
        }
        return super.visitInitial_state(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitGoal_state(gspGrammarParser.Goal_stateContext ctx) {
        String goal = ctx.getChild(1).getText();
        String[] initials = goal.split("\\^");
        this.goalState.addState(new Predicate(goal));
        for (int i = 0; i < initials.length; i++) {
            String actual = initials[i];
            this.goalState.addState(new Predicate(actual));
           
        }
        return super.visitGoal_state(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    public State getInitialState() {
        return initialState;
    }

    public State getGoalState() {
        return goalState;
    }

    
    

    public ArrayList<Predicate> getPredicates() {
        return predicates;
    }

    public void setPredicates(ArrayList<Predicate> predicates) {
        this.predicates = predicates;
    }


    @Override
    public Object visitSingular_action(gspGrammarParser.Singular_actionContext ctx) {
        this.actualAction = new Action(ctx.getChild(1).getText()+ctx.getChild(2).getText()+ctx.getChild(3).getText()+ctx.getChild(4).getText());
        for (int i = 0; i < ctx.getChildCount(); i++) {
            visit(ctx.getChild(i));
        }
        this.actions.add(actualAction);
        return null;
    }

    @Override
    public Object visitPrecond(gspGrammarParser.PrecondContext ctx) {
        
        String precond_initial = ctx.getChild(1).getText();
        Predicate pred = new Predicate(precond_initial);
        this.actualAction.addPrecond(pred);
        String[] precon = precond_initial.split("\\^");
        for (int i = 0; i < precon.length; i++) {
            this.actualAction.addPrecond(new Predicate(precon[i]));
        }
        
        return super.visitPrecond(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitConjunction(gspGrammarParser.ConjunctionContext ctx) {
        
        return super.visitConjunction(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitEffects(gspGrammarParser.EffectsContext ctx) {
        String effect_initial = ctx.getChild(1).getText();
        this.actualAction.addEffect(new Predicate(effect_initial));
        String[] eff = effect_initial.split("\\^");
        for (int i = 0; i < eff.length; i++) {
            this.actualAction.addEffect(new Predicate(eff[i]));
        }
        return super.visitEffects(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Action> getActions() {
        return actions;
    }
    
    
    
    
    
    
    
    
   
    
    
}
