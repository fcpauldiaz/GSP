/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Apr 13, 2017
**/

package gsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

/**
 *
 * @author SDX
 */
public class GSP<T> {

    private State state;
    private State goal;
    private ArrayList<Action> plan;
    private ArrayList<Action> actions;
    public GSP(State init, State goal, ArrayList<Action> actions) {
        this.state = init;
        this.goal = goal;
        this.actions = actions;
        this.plan = new ArrayList();
        this.state.findBlocks();
        System.out.println("");
        run();
    }
    
    
    private void run() {
        Stack<T> stack = new Stack();
        System.out.println(this.state);
        System.out.println(this.goal);
        System.out.println("");
        System.out.println("");
        //stack.push(goal.);
        for (Predicate pred: this.goal.getState()) {
            stack.push((T)pred);
        }
        while(!stack.isEmpty()) {
            T actualValue = (T)stack.pop();
            if (actualValue.getClass().getName().equals("gsp.Predicate")) {
                Predicate p = (Predicate)actualValue;
                if (statePredicate(p)) {
                    continue;
                }
                //for All actions relevants
                for (Action a: getRelevantAction(p)){
                    stack.push((T)a);
                     //push preconditions
                    for (Predicate precondition: a.getPrecond()) {
                        //push each preconditionç
                        stack.push((T)precondition);
                    }
                }
            }
            else {
                //modify state
                //eliminate preconditions of actions
                //add effects of action
                Action actualAction = (Action)actualValue;
                ArrayList<Predicate> copyState = new ArrayList();
                for(Predicate p : this.state.getState())
                    copyState.add(p.cloneCustom());
                for (Predicate prAc: this.state.getState()) {
                    for (Predicate precond: actualAction.getPrecond()) {
                        if (precond.equals(prAc)){
                            copyState.remove(precond);
                        }
                        
                    }
                }
                for (Predicate effect: actualAction.getEffects()) {
                    if (!copyState.contains(effect) && !effect.getIdentifier().contains("^") && !effect.getIdentifier().contains("!")){
                        copyState.add(effect);
                    }

                }
                //fix state
                
                this.state.setState(copyState);
                plan.add((Action)actualValue);
            }
        }
        System.out.println("");
        System.out.println(plan);
        System.out.println("");
        
    }
    
    public boolean statePredicate(Predicate p) {
        for(Predicate stateP: this.state.getState()) {
            if (stateP.equals(p) || p.getIdentifier().contains("^")){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Action> getRelevantAction(Predicate p) {
        ArrayList<Action> ac = new ArrayList();
        
        ArrayList<Action> cloned = this.generateAvailableActions();
        for (Action a: cloned) {
            if (!this.plan.isEmpty()){
                if (a.getIdentifier().equals(this.plan.get(this.plan.size()-1).getIdentifier())) {
                    continue;
                }
            }
            ArrayList<Predicate> eff = a.getEffects();
            for (Predicate effect: eff) {
                if (effect.getIdentifier().equals(p.getIdentifier()) && effect.getCantParams() == p.getCantParams()){
                    ac.add(a);
                }

            }
            
        }
        return ac;
    }
    
    
    public boolean modifyAction(Action a, ArrayList<String> newParams, ArrayList<Predicate> predicates) {
        ArrayList action_params = a.getParams();
        
        
        if (action_params.size() != newParams.size()) {
            return false;
        }

        for (Predicate precond: predicates) {
            for (int i = 0; i < action_params.size(); i++) {
                for (int j = 0; j < precond.getParams().size();j++) {
                    if ( precond.getParams().get(j).equals(action_params.get(i)) && precond.valid(j)) {
                        
                        precond.getParams().set(j, newParams.get(i));
                        precond.addEvalIndex(j);
                    }
                }
            }
            precond.clearEval();
        }
        
        return true;
    }
    
    
    public ArrayList<Action> generateAvailableActions() {
        ArrayList<Action> returnArray = new ArrayList();
        for (Action action: this.actions) {
            
            HashSet<Variable> availableVariables = new HashSet();
            ArrayList<String> identifiersEvaluated = new ArrayList();
            
            ArrayList<Boolean> valids = new ArrayList();
            for (Predicate preCondition: action.getPrecond()) {
                if (preCondition.getIdentifier().contains("^")) {
                    continue;
                }
                for (Predicate statePredicate: this.state.getState()) {
                    if (statePredicate.getIdentifier().equals(preCondition.getIdentifier())) {
                        if (!identifiersEvaluated.contains(statePredicate.getIdentifier())) {
                            identifiersEvaluated.add(statePredicate.getIdentifier());
                            valids.add(true);
                            for (String pParams: action.getParams()) {
                                for (int i = 0; i < statePredicate.getParams().size();i++) {
                                    String aParams = statePredicate.getParams().get(i);
                                    if (pParams.equals(aParams)) {
                                        availableVariables.add(new Variable(aParams, i));
                                    }

                                }
                            } 
                        }
                        
                    } 
                }
            }
            if (action.getPrecond().size() - 1 == valids.size()) {
                
                Action newAction = new Action(action.getIdentifier());
                ArrayList<Predicate> preconds = new ArrayList();
                ArrayList<Predicate> effects = new ArrayList();
                for (Predicate precond: action.getPrecond()) {
                    preconds.add(precond.cloneCustom());
                }
                for (Predicate eff: action.getEffects()) {
                    effects.add(eff.cloneCustom());
                }
                ArrayList newParams = new ArrayList();
                
                for (Variable v: availableVariables) {
                    newParams.add(v.getVar());
                }
                for (Variable v: availableVariables) {
                    newParams.set(v.getIndex(), v.getVar());
                }
                newAction.setParams(action.getParams());
                newAction.setPrecond(preconds);
                newAction.setEffects(effects);
                //magia
                boolean valid1 = modifyAction(newAction, newParams, newAction.getPrecond());
                boolean valid2 = modifyAction(newAction, newParams, newAction.getEffects());
                
                newAction.setParams(newParams);
               
                
                
               
                returnArray.add(newAction);
            }
        }
        return returnArray;
    }
    
    
    
}
