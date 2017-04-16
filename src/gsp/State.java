/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Apr 13, 2017
**/

package gsp;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author SDX
 */
public class State {
    
    private ArrayList<Predicate> state;
    private String statement;
    private HashSet<String> blocks;

    public State() {
        this.state = new ArrayList();
        blocks = new HashSet();
    }
    
    public State cloneCustom() {
        State st = new State();
        st.setState(this.getState());
        return st;
    }

    public ArrayList<Predicate> getState() {
        return state;
    }

    public void addState(Predicate state) {
        this.state.add(state);
    }
    public void addState(ArrayList state) {
        this.state.addAll(state);
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public void setState(ArrayList<Predicate> state) {
        this.state = state;
    }

    public ArrayList<String> getBlocks() {
        return new ArrayList(blocks);
    }

    public void addBlock(String bl) {
        this.blocks.add(bl);
    }
    
    public void findBlocks() {
        for (Predicate p: this.getState()) {
            for (String st: p.getParams()) {
                this.blocks.add(st);
            }
        }
    }
    
    

    

       
    @Override
    public String toString() {
        return "State{" + "state=" + state + ", blocks=" + blocks + '}';
    }
    
    
    
    

}
