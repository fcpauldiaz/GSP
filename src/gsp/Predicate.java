/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Apr 11, 2017
**/

package gsp;

import java.util.Objects;

/**
 *
 * @author SDX
 */
public class Predicate {
    
    private String identifier;
    private int cantParams;

    public Predicate(String identifier, int cantParams) {
        this.identifier = identifier;
        this.cantParams = cantParams;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getCantParams() {
        return cantParams;
    }

    public void setCantParams(int cantParams) {
        this.cantParams = cantParams;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.identifier);
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
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Predicates{" + "identifier=" + identifier + ", cantParams=" + cantParams + '}';
    }
    
    

}
