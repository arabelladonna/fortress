/*******************************************************************************
 Copyright 2010, Oracle and/or its affiliates.
 All rights reserved.


 Use is subject to license terms.

 This distribution may include materials developed by third parties.

 ******************************************************************************/

package com.sun.fortress.interpreter.glue.prim;

import static com.sun.fortress.exceptions.InterpreterBug.bug;
import static com.sun.fortress.exceptions.ProgramError.error;
import com.sun.fortress.interpreter.evaluator.Environment;
import com.sun.fortress.interpreter.evaluator.EvalType;
import com.sun.fortress.interpreter.evaluator.types.FType;
import com.sun.fortress.interpreter.evaluator.types.FTypeObject;
import com.sun.fortress.interpreter.evaluator.types.FTypeGeneric;
import com.sun.fortress.interpreter.evaluator.values.*;
import com.sun.fortress.interpreter.glue.NativeMeth;
import com.sun.fortress.interpreter.glue.NativeMeth0;
import com.sun.fortress.nodes.Applicable;
import com.sun.fortress.nodes.ObjectConstructor;
import com.sun.fortress.nodes_util.NodeUtil;
import com.sun.fortress.useful.Useful;

import java.util.List;
import java.util.ArrayList;

public class ReflectGeneric extends Reflect {
    public ReflectGeneric(Environment env, FTypeObject selfType, ObjectConstructor def) {
        super(env, selfType, def);
    }

    @Override
    protected void checkType(FType ty) {
        if (!(ty instanceof FTypeGeneric)) error(ty + " is not a generic type.");
    }

    public static final class TypeApply extends NativeMeth {
        public int getArity() {
            return -1; // This will be ignored due to the new definition of init.
        }

        @Override
        protected void init(Applicable app, boolean isFunctionalMethod) {
            if (this.a != null) {
                bug("Duplicate NativeApp.init call.");
            }
            this.a = app;
            // int aty = NodeUtil.getParams(app).size();
            if (NodeUtil.getReturnType(app) == null || NodeUtil.getReturnType(app).isNone()) {
                error(app, "Please specify a Fortress return type.");
            }
        }

        public ReflectedType applyMethod(FObject self, List<FValue> args) {
            FTypeGeneric generic = (FTypeGeneric) ((ReflectedType) self).getTy();
            List<FType> typeargs = new ArrayList<FType>();
            for (FValue v : args) {
                typeargs.add(((ReflectedType) v).getTy());
            }
            return Reflect.make(generic.make(typeargs, generic.getDecl()));
        }
    }
}
