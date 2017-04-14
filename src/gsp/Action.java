/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Apr 11, 2017
**/

package gsp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author SDX
 */
public class Action {
    
    private String identifier;
    private ArrayList<String> params;
    private ArrayList<Predicate> precond;
    private ArrayList<Predicate> effects;
    private String newIdentifier;

    public Action(String identifier) {
        this.identifier = identifier;
        this.precond = new ArrayList();
        this.effects = new ArrayList();
        this.params = new ArrayList();
        if (identifier.contains("(")) {
            if (identifier.contains("^")) {
                String[] ids = identifier.split("\\^");
                this.identifier = identifier;
                for (int i = 0; i < ids.length;i++) {
                    String newId = ids[i];
                    String id = newId.substring(newId.indexOf("(")+1, newId.indexOf(")"));
                    this.params.addAll(Arrays.asList(id.split(",")));
                }
            } else {
                this.identifier = identifier.substring(0, identifier.indexOf("("));
                String id = identifier.substring(identifier.indexOf("(")+1, identifier.indexOf(")"));
                this.params.addAll(Arrays.asList(id.split(",")));
            }
        }
         
    }
    
    
    public Action cloneCustom() {
        Action cloned = new Action(this.getIdentifier());
        cloned.setParams(this.getParams());
        cloned.setPrecond(this.getPrecond());
        cloned.setEffects(this.getEffects());
        cloned.setNewIdentifier(this.getNewIdentifier());
        return cloned;
    }

    public void setPrecond(ArrayList<Predicate> precond) {
        this.precond = precond;
    }

    public void setEffects(ArrayList<Predicate> effects) {
        this.effects = effects;
    }
    
    
    
    public void addPrecond(Predicate precond) {
        this.precond.add(precond);
    }
    
    public void addEffect(Predicate effect) {
        this.effects.add(effect);
    }
    
    public void addParam(String str) {
        this.params.add(str);
    }

    public void setParams(ArrayList<String> params) {
        this.params = params;
    }
    

    public ArrayList<String> getParams() {
        return params;
    }
    
    

    public String getIdentifier() {
        return identifier;
    }

    public ArrayList<Predicate> getPrecond() {
        return precond;
    }

    public ArrayList<Predicate> getEffects() {
        return effects;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getNewIdentifier() {
        return newIdentifier;
    }

    public void setNewIdentifier(String newIdentifier) {
        this.newIdentifier = newIdentifier;
    }
    
    
    

    @Override
    public String toString() {
        return "Actions{" + "identifier=" + identifier + "\n"+
               "precond=" + precond + "\n" +
               "effects=" + effects + '}';
    }
    
    
    
    

}
