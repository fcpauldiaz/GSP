/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Apr 13, 2017
**/

package gsp;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author SDX
 */
public class GSP<T> {

    private State state;
    private State goal;
    private ArrayList<Action> actions;
    public GSP(State init, State goal, ArrayList<Action> actions) {
        this.state = init;
        this.goal = goal;
        this.actions = actions;
        System.out.println("");
        run();
    }
    
    
    private void run() {
        ArrayList plan = new ArrayList();
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
                plan.add((String)actualValue);
            }
        }
        
        
    }
    
    public boolean statePredicate(Predicate p) {
        for(Predicate stateP: this.state.getState()) {
            if (stateP.equals(p)){
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
            
            ArrayList<Predicate> eff = a.getEffects();
            for (Predicate effect: eff) {
                if (effect.getIdentifier().equals(p.getIdentifier()) && effect.getCantParams() == p.getCantParams()){
                    String id = p.getIdentifier();
                    modifyAction(a.getPrecond(), p, a.getParams());
                    modifyAction(a.getEffects(), p, a.getParams());
                    a.setParams(p.getParams());
                    ac.add(a);
                }

            }
            
        }
        return ac;
    }
    
    
    public void modifyAction(ArrayList<Predicate> predicates, Predicate p, ArrayList action_params) {
        ArrayList<String> newParams = p.getParams();
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
    
    
    
}
