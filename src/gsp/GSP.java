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
        
        ArrayList<Action> cloned = new ArrayList();
        for(Action a : this.actions)
            cloned.add(a.cloneCustom());
        for (Action a: cloned) {
            if (!this.plan.isEmpty()){
                if (a.getIdentifier().equals(this.plan.get(this.plan.size()-1).getIdentifier())) {
                    continue;
                }
            }
            ArrayList<Predicate> eff = a.getEffects();
            for (Predicate effect: eff) {
                if (effect.getIdentifier().equals(p.getIdentifier()) && effect.getCantParams() == p.getCantParams()){
                    String id = p.getIdentifier();
                    boolean valid = modifyAction(a, p, a.getPrecond());
                    boolean valid2 = modifyAction(a, p, a.getEffects());
                    if (valid && valid2){
                        a.setParams(p.getParams());
                        ac.add(a);
                    }
                }

            }
            
        }
        return ac;
    }
    
    
    public boolean modifyAction(Action a, Predicate p, ArrayList<Predicate> predicates) {
        ArrayList action_params = a.getParams();
        
        ArrayList<String> newParams = p.getParams();
        //revisar los params del predicado relevante y la acción
        if (newParams.size() != action_params.size()) {
            ArrayList newPrm = new ArrayList();
            for (Predicate assoc: state.getState()) {
                ArrayList<String> prm = assoc.getParams();
                if (prm.containsAll(newParams)) {
                    for (String str: prm) {
                        if (!newParams.contains(str)) {
                            newPrm.add(0, str);
                        }
                    }
                }
            }
            newParams.addAll(0, newPrm);
            if (newParams.size() != action_params.size()) {
                //second try;
                //check all effects of current action
                for (Predicate effects: a.getEffects()) {
                    for (Predicate goals: this.goal.getState()) {
                        if (goals.getIdentifier().equals(effects.getIdentifier())) {
                            ArrayList<String> goalParams = goals.getParams();
                            //check if preconditions are met in current state;
                            boolean valid = true;
                            for (Predicate precondition: a.getPrecond()) {
                                boolean innerValid = false;
                                for (Predicate stateC: this.state.getState()) {
                                    if (stateC.getIdentifier().equals(precondition.getIdentifier()) && 
                                        (!Collections.disjoint(goalParams, goals.getParams())) ) {
                                        innerValid = true;
                                    }
                                }
                                valid = true;
                                if (innerValid == false) {
                                    valid = false;
                                }
                            }
                            if (valid == true) {
                                if (newParams.size() < 2){
                                    newParams.addAll(goalParams);
                                }
                                System.out.println(newParams);
                                newParams.remove("");
                            }
                            
                        }
                    }
                }
                if (newParams.size() != action_params.size()) {
                    //compare with current goal
                    //build params upon that
                    return false;
                }
               
            }

        }
        if (!newParams.equals(action_params)) {
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
        }
        return true;
    }
    
    
    
}
