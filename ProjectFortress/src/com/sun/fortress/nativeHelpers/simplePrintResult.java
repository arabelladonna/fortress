/*******************************************************************************
 Copyright 2009, Oracle and/or its affiliates.
 All rights reserved.


 Use is subject to license terms.

 This distribution may include materials developed by third parties.

 ******************************************************************************/

package com.sun.fortress.nativeHelpers;
// For Debugging the bytecode generator 

public class simplePrintResult {

    public static void nativePrintZZ32(int x) {
        System.out.println("result = " + x);
    }
}
