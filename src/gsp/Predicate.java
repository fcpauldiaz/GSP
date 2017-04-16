/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Apr 11, 2017
**/

package gsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author SDX
 */
public class Predicate {
    
    private String identifier;
    private ArrayList params;
    private ArrayList evaluated;

    public Predicate(String identifier) {
        this.params = new ArrayList();
        this.evaluated = new ArrayList();
        this.identifier = identifier;
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
    
    public Predicate cloneCustom(){
        Predicate p = new Predicate(this.getIdentifier());
        p.setParams((ArrayList)this.getParams().clone());
        return p;
    }
    
    public boolean valid(int j) {
        return !this.evaluated.contains(j);
    }
    
    public void addEvalIndex(int j) {
        this.evaluated.add(j);
    }
    
    public void clearEval() {
        this.evaluated.clear();
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getCantParams() {
        return params.size();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.identifier);
        hash = 13 * hash + Objects.hashCode(this.params);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Predicate other = (Predicate) obj;
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        if (!Objects.equals(this.params, other.params)) {
            return false;
        }
        return true;
    }

    public void setParams(ArrayList params) {
        this.params = params;
    }

    public ArrayList<String> getParams() {
        return params;
    }

   

 


    @Override
    public String toString() {
        return "Predicate{" + "identifier=" + identifier + ", params=" + params +'}';
    }
    
    
    
    
    

}
