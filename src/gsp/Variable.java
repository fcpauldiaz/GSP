/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Apr 16, 2017
**/

package gsp;

import java.util.Objects;

/**
 *
 * @author SDX
 */
public class Variable {

    private String var;
    private int index;

    public Variable(String var, int index) {
        this.var = var;
        this.index = index;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Variable other = (Variable) obj;
        if (!Objects.equals(this.var, other.var)) {
            return false;
        }
        if (this.index != other.index) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Variable{" + "var=" + var + ", index=" + index + '}';
    }
    
    
}
