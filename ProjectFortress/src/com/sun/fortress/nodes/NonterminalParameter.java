package com.sun.fortress.nodes;

import java.lang.String;
import java.math.BigInteger;
import java.io.Writer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import com.sun.fortress.nodes_util.*;
import com.sun.fortress.parser_util.*;
import com.sun.fortress.parser_util.precedence_opexpr.*;
import com.sun.fortress.useful.*;
import edu.rice.cs.plt.tuple.Option;

/**
 * Class NonterminalParameter, a component of the ASTGen-generated composite hierarchy.
 * Note: null is not allowed as a value for any field.
 * @version  Generated automatically by ASTGen at Thu Oct 11 03:24:55 EDT 2018
 */
@SuppressWarnings("unused")
public class NonterminalParameter extends AbstractNode {
    private final Id _name;
    private final BaseType _paramType;

    /**
     * Constructs a NonterminalParameter.
     * @throws java.lang.IllegalArgumentException  If any parameter to the constructor is null.
     */
    public NonterminalParameter(ASTNodeInfo in_info, Id in_name, BaseType in_paramType) {
        super(in_info);
        if (in_name == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'name' to the NonterminalParameter constructor was null");
        }
        _name = in_name;
        if (in_paramType == null) {
            throw new java.lang.IllegalArgumentException("Parameter 'paramType' to the NonterminalParameter constructor was null");
        }
        _paramType = in_paramType;
    }

    final public Id getName() { return _name; }
    final public BaseType getParamType() { return _paramType; }

    public <RetType> RetType accept(AbstractNodeVisitor<RetType> visitor) {
        return visitor.forNonterminalParameter(this);
    }

    public <RetType> RetType accept(NodeVisitor<RetType> visitor) {
        return visitor.forNonterminalParameter(this);
    }

    public void accept(AbstractNodeVisitor_void visitor) {
        visitor.forNonterminalParameter(this);
    }

    public void accept(NodeVisitor_void visitor) {
        visitor.forNonterminalParameter(this);
    }

    /**
     * Implementation of equals that is based on the values of the fields of the
     * object. Thus, two objects created with identical parameters will be equal.
     */
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if ((obj.getClass() != this.getClass()) || (obj.hashCode() != this.hashCode())) {
            return false;
        }
        else {
            NonterminalParameter casted = (NonterminalParameter) obj;
            ASTNodeInfo temp_info = getInfo();
            ASTNodeInfo casted_info = casted.getInfo();
            if (!(temp_info == casted_info || temp_info.equals(casted_info))) return false;
            Id temp_name = getName();
            Id casted_name = casted.getName();
            if (!(temp_name == casted_name || temp_name.equals(casted_name))) return false;
            BaseType temp_paramType = getParamType();
            BaseType casted_paramType = casted.getParamType();
            if (!(temp_paramType == casted_paramType || temp_paramType.equals(casted_paramType))) return false;
            return true;
        }
    }


    /**
     * Implementation of hashCode that is consistent with equals.  The value of
     * the hashCode is formed by XORing the hashcode of the class object with
     * the hashcodes of all the fields of the object.
     */
    public int generateHashCode() {
        int code = getClass().hashCode();
        ASTNodeInfo temp_info = getInfo();
        code ^= temp_info.hashCode();
        Id temp_name = getName();
        code ^= temp_name.hashCode();
        BaseType temp_paramType = getParamType();
        code ^= temp_paramType.hashCode();
        return code;
    }

    /**
     * Empty constructor, for reflective access.  Clients are 
     * responsible for manually instantiating each field.
     */
    protected NonterminalParameter() {
        _name = null;
        _paramType = null;
    }

    /**
     * Single Span constructor, for template gap access.  Clients are 
     * responsible for never accessing other fields than the gapId and 
     * templateParams.
     */
    protected NonterminalParameter(ASTNodeInfo info) {
        super(info);
        _name = null;
        _paramType = null;
    }

    public void walk(TreeWalker w) {
        if (w.visitNode(this, "NonterminalParameter", 3)) {
            ASTNodeInfo temp_info = getInfo();
            if (w.visitNodeField("info", temp_info)) {
                temp_info.walk(w);
                w.endNodeField("info", temp_info);
            }
            Id temp_name = getName();
            if (w.visitNodeField("name", temp_name)) {
                temp_name.walk(w);
                w.endNodeField("name", temp_name);
            }
            BaseType temp_paramType = getParamType();
            if (w.visitNodeField("paramType", temp_paramType)) {
                temp_paramType.walk(w);
                w.endNodeField("paramType", temp_paramType);
            }
            w.endNode(this, "NonterminalParameter", 3);
        }
    }

}
