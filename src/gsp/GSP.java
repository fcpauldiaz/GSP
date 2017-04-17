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
    private Stack stack;
    public GSP(State init, State goal, ArrayList<Action> actions) {
        this.state = init;
        this.goal = goal;
        this.actions = actions;
        this.plan = new ArrayList();
        this.stack = new Stack();
        this.state.findBlocks();
        System.out.println("");
        run();
    }
    
    
    private void run() {
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
                this.state.setState(copyState);
                this.state.findBlocks();
                //fix state, sometimes the state is not complete
                for (String block: this.state.getBlocks()) {
                    boolean clear = true; 
                    for (Predicate curState: this.state.getState()) {
                        if (curState.getIdentifier().equals("On")) {
                            if (curState.getParams().get(1).equals(block)) {
                                clear = false;
                            }
                        }
                    }
                    if (clear && !block.isEmpty()) {
                        Predicate newP = new Predicate("Clear("+block+")");
                        if (!copyState.contains(newP))
                            copyState.add(newP);
                    }
                }
                
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
        
        Action a = null;
        if (p.getIdentifier().equals("On")) {
            a = cloned.get(0);
        }
        if (p.getIdentifier().equals("OnTable") || p.getIdentifier().equals("AE")) {
            a = cloned.get(3);
        }
        if (p.getIdentifier().equals("Hold")) {
            //verificar si pickup cumple en el estado actual
            a = cloned.get(2);
            boolean valid = verifyState(a);
            if (!valid) {
                a = cloned.get(1);
//                if (!plan.isEmpty()){
//                    if (a.getIdentifier().equals(plan.get(plan.size()-1).getIdentifier())) {
//                        a = cloned.get(3);
//                        
//                        boolean valid1 = modifyAction(a, p, a.getPrecond());
//                        boolean valid2 = modifyAction(a, p, a.getEffects());
//                        if (valid1 && valid2 && ac.size() < 1){
//                            a.setParams(p.getParams());
//                            ac.add(a);
//                        }
//                        return ac;
//                    } 
//                }
//                
            }
            //si no es unstack
        }
        if (p.getIdentifier().equals("Clear")) {
            //verificar si putdown cumple en el estado actual
            //si no es stack
            a = cloned.get(3);
            boolean valid = verifyState(a);
            if (!valid) {
                a = cloned.get(1);
            }
            
        }
        
        ArrayList<Predicate> eff = a.getEffects();
        for (Predicate effect: eff) {
            if (effect.getIdentifier().equals(p.getIdentifier()) && effect.getCantParams() == p.getCantParams()){
                String id = p.getIdentifier();
                boolean valid = modifyAction(a, p, a.getPrecond());
                boolean valid2 = modifyAction(a, p, a.getEffects());
                if (valid && valid2 && ac.size() < 1){
                    a.setParams(p.getParams());
                    ac.add(a);
                }
            }

        }
            
        
        return ac;
    }
    
    public boolean verifyState(Action a){
        ArrayList<Predicate> eff = a.getPrecond();
        boolean valid = true;
        for (Predicate effect: eff) {
            boolean innerValid = false;
            if (effect.getIdentifier().contains("^")) {
                continue;
            }
            for (Predicate currenState: state.getState()){
                if (effect.equals(currenState)){
                    innerValid = true;
                }
            }
            
            if (innerValid == false) {
                valid = false;
            }

        }
        return valid;
    }
    
    
    public boolean modifyAction(Action a, Predicate p, ArrayList<Predicate> predicates) {
        ArrayList action_params = a.getParams();
        
        ArrayList<String> newParams = p.getParams();
        //revisar los params del predicado relevante y la acción
        if (newParams.size() != action_params.size()) {
           //check preconditions of current action on current state
            ArrayList<Predicate> predicatesSatisfy = new ArrayList();
            ArrayList<String> rep = new ArrayList();
            ArrayList<Predicate> repeated = new ArrayList();
            for (Predicate precondition: a.getPrecond()) {
                for (Predicate prState: state.getState()) {
                    if (precondition.getIdentifier().equals(prState.getIdentifier())) {
                        if (rep.contains(prState.getIdentifier())) {
                            repeated.add(prState);
                            int iR = -1; //repeated index
                            for (int i = 0; i <  predicatesSatisfy.size();i++) {
                                if ( predicatesSatisfy.get(i).getIdentifier().equals(prState.getIdentifier())) {
                                    //remove and add to repeated
                                    iR = i;
                                }
                            }
                            if (iR != -1) {
                                Predicate removed = predicatesSatisfy.remove(iR);
                                repeated.add(removed);
                            }
                        } else {
                            predicatesSatisfy.add(prState);
                            rep.add(prState.getIdentifier());
                        }
                    }
                }
            }
            //if no enough preconditions were found in current state for current action
            if (a.getPrecond().size() - 1 > predicatesSatisfy.size() + repeated.size()) {
                return false;
            }
            //check the combinations of the predicates
            //and keep the one that generates the desired predicate p
            ArrayList<Predicate> valid = new ArrayList();
            System.out.println(repeated);
            System.out.println(predicatesSatisfy);
            if (a.getIdentifier().equals("Unstack")) {
                for (Predicate satisfy: predicatesSatisfy) {
                    for (Predicate reped: repeated) {
                        ArrayList sParams = satisfy.getParams();
                        ArrayList rParams = reped.getParams();
                        if ((reped.getIdentifier().equals("Clear") && satisfy.getIdentifier().equals("On") )||
                            (reped.getIdentifier().equals("On") && satisfy.getIdentifier().equals("Clear") )) {
                            if (sParams.get(0).equals(rParams.get(0))) {
                                valid.add(reped);
                            }
                            
                        }
                    }
                }
                predicatesSatisfy.addAll(valid);
                boolean reInsert = true;
                for (Predicate sat: predicatesSatisfy) {
                    if (sat.getParams().containsAll(p.getParams())) {
                        reInsert = false;
                    }
                }
                if (reInsert == true) {
                    stack.add(p);
                }
                
                if (predicatesSatisfy.size() == a.getPrecond().size() - 1) {
                    
                    for (Predicate validated : predicatesSatisfy) {
                        if (validated.getIdentifier().equals("On")) {
                            newParams = validated.getParams();
                            p.setParams(newParams);
                        }
                    }
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
