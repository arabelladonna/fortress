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

/** A parametric abstract implementation of a visitor over StaticArg that returns a value.
 ** This visitor implements the visitor interface with methods that 
 ** first visit children, and then call forCASEOnly(), passing in 
 ** the values of the visits of the children. (CASE is replaced by the case name.)
 ** By default, each of forCASEOnly delegates to a more general case; at the
 ** top of this delegation tree is defaultCase(), which (unless overridden)
 ** throws an exception.
 **/
@SuppressWarnings(value={"unused"})
public abstract class TemplateStaticArgDepthFirstVisitor<RetType> extends StaticArgVisitorLambda<RetType> {
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultCase(StaticArg that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    /* Methods to handle a node after recursion. */
    public RetType forStaticArgOnly(StaticArg that) {
        return defaultCase(that);
    }

    public RetType forTypeArgOnly(TypeArg that) {
        return forStaticArgOnly(that);
    }

    public RetType forIntArgOnly(IntArg that) {
        return forStaticArgOnly(that);
    }

    public RetType forBoolArgOnly(BoolArg that) {
        return forStaticArgOnly(that);
    }

    public RetType forOpArgOnly(OpArg that) {
        return forStaticArgOnly(that);
    }

    public RetType forDimArgOnly(DimArg that) {
        return forStaticArgOnly(that);
    }

    public RetType forUnitArgOnly(UnitArg that) {
        return forStaticArgOnly(that);
    }

    public RetType for_SyntaxTransformationStaticArgOnly(_SyntaxTransformationStaticArg that) {
        return forStaticArgOnly(that);
    }

    public RetType for_SyntaxTransformationTypeArgOnly(_SyntaxTransformationTypeArg that) {
        return forTypeArgOnly(that);
    }

    public RetType for_SyntaxTransformationIntArgOnly(_SyntaxTransformationIntArg that) {
        return forIntArgOnly(that);
    }

    public RetType for_SyntaxTransformationBoolArgOnly(_SyntaxTransformationBoolArg that) {
        return forBoolArgOnly(that);
    }

    public RetType for_SyntaxTransformationOpArgOnly(_SyntaxTransformationOpArg that) {
        return forOpArgOnly(that);
    }

    public RetType for_SyntaxTransformationDimArgOnly(_SyntaxTransformationDimArg that) {
        return forDimArgOnly(that);
    }

    public RetType for_SyntaxTransformationUnitArgOnly(_SyntaxTransformationUnitArg that) {
        return forUnitArgOnly(that);
    }

    public RetType for_EllipsesStaticArgOnly(_EllipsesStaticArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesTypeArgOnly(_EllipsesTypeArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesIntArgOnly(_EllipsesIntArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesBoolArgOnly(_EllipsesBoolArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesOpArgOnly(_EllipsesOpArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesDimArgOnly(_EllipsesDimArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType for_EllipsesUnitArgOnly(_EllipsesUnitArg that) {
        return defaultEllipsesNodeCase(that);
    }

    public RetType forTemplateGapStaticArgOnly(TemplateGapStaticArg that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapTypeArgOnly(TemplateGapTypeArg that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapIntArgOnly(TemplateGapIntArg that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapBoolArgOnly(TemplateGapBoolArg that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapOpArgOnly(TemplateGapOpArg that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapDimArgOnly(TemplateGapDimArg that) {
        return defaultTemplateGapCase(that);
    }

    public RetType forTemplateGapUnitArgOnly(TemplateGapUnitArg that) {
        return defaultTemplateGapCase(that);
    }


    /** Methods to recur on each child. */
    public RetType forTypeArg(TypeArg that) {
        return forTypeArgOnly(that);
    }

    public RetType forIntArg(IntArg that) {
        return forIntArgOnly(that);
    }

    public RetType forBoolArg(BoolArg that) {
        return forBoolArgOnly(that);
    }

    public RetType forOpArg(OpArg that) {
        return forOpArgOnly(that);
    }

    public RetType forDimArg(DimArg that) {
        return forDimArgOnly(that);
    }

    public RetType forUnitArg(UnitArg that) {
        return forUnitArgOnly(that);
    }

    public RetType for_SyntaxTransformationStaticArg(_SyntaxTransformationStaticArg that) {
        return for_SyntaxTransformationStaticArgOnly(that);
    }

    public RetType for_SyntaxTransformationTypeArg(_SyntaxTransformationTypeArg that) {
        return for_SyntaxTransformationTypeArgOnly(that);
    }

    public RetType for_SyntaxTransformationIntArg(_SyntaxTransformationIntArg that) {
        return for_SyntaxTransformationIntArgOnly(that);
    }

    public RetType for_SyntaxTransformationBoolArg(_SyntaxTransformationBoolArg that) {
        return for_SyntaxTransformationBoolArgOnly(that);
    }

    public RetType for_SyntaxTransformationOpArg(_SyntaxTransformationOpArg that) {
        return for_SyntaxTransformationOpArgOnly(that);
    }

    public RetType for_SyntaxTransformationDimArg(_SyntaxTransformationDimArg that) {
        return for_SyntaxTransformationDimArgOnly(that);
    }

    public RetType for_SyntaxTransformationUnitArg(_SyntaxTransformationUnitArg that) {
        return for_SyntaxTransformationUnitArgOnly(that);
    }

    public RetType for_EllipsesStaticArg(_EllipsesStaticArg that) {
        return for_EllipsesStaticArgOnly(that);
    }

    public RetType for_EllipsesTypeArg(_EllipsesTypeArg that) {
        return for_EllipsesTypeArgOnly(that);
    }

    public RetType for_EllipsesIntArg(_EllipsesIntArg that) {
        return for_EllipsesIntArgOnly(that);
    }

    public RetType for_EllipsesBoolArg(_EllipsesBoolArg that) {
        return for_EllipsesBoolArgOnly(that);
    }

    public RetType for_EllipsesOpArg(_EllipsesOpArg that) {
        return for_EllipsesOpArgOnly(that);
    }

    public RetType for_EllipsesDimArg(_EllipsesDimArg that) {
        return for_EllipsesDimArgOnly(that);
    }

    public RetType for_EllipsesUnitArg(_EllipsesUnitArg that) {
        return for_EllipsesUnitArgOnly(that);
    }

    public RetType forTemplateGapStaticArg(TemplateGapStaticArg that) {
        return forTemplateGapStaticArgOnly(that);
    }

    public RetType forTemplateGapTypeArg(TemplateGapTypeArg that) {
        return forTemplateGapTypeArgOnly(that);
    }

    public RetType forTemplateGapIntArg(TemplateGapIntArg that) {
        return forTemplateGapIntArgOnly(that);
    }

    public RetType forTemplateGapBoolArg(TemplateGapBoolArg that) {
        return forTemplateGapBoolArgOnly(that);
    }

    public RetType forTemplateGapOpArg(TemplateGapOpArg that) {
        return forTemplateGapOpArgOnly(that);
    }

    public RetType forTemplateGapDimArg(TemplateGapDimArg that) {
        return forTemplateGapDimArgOnly(that);
    }

    public RetType forTemplateGapUnitArg(TemplateGapUnitArg that) {
        return forTemplateGapUnitArgOnly(that);
    }

    /** Defaultcases for nonstandard classes. */
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultTemplateGapCase(TemplateGap that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }
    /**
     * This method is run for all cases that are not handled elsewhere.
     * By default, an exception is thrown; subclasses may override this behavior.
     * @throws IllegalArgumentException
    **/
    public RetType defaultEllipsesNodeCase(_Ellipses that) {
        throw new IllegalArgumentException("Visitor " + getClass().getName() + " does not support visiting values of type " + that.getClass().getName());
    }

    public RetType recur(StaticArg that) {
        return that.accept(this);
    }
}
