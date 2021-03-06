/********************************************************************************
 Copyright 2008,2012, Oracle and/or its affiliates.
 All rights reserved.


 Use is subject to license terms.

 This distribution may include materials developed by third parties.

 ********************************************************************************/

package com.sun.fortress.runtimeSystem;
import jsr166y.ForkJoinPool;

public class FortressTaskRunnerGroup extends ForkJoinPool {
    public static class FortressForkJoinWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
        public FortressTaskRunner newThread(FortressTaskRunnerGroup group) {
            return new FortressTaskRunner(group);
        }

        public FortressTaskRunner newThread(ForkJoinPool pool) {
            return new FortressTaskRunner((FortressTaskRunnerGroup) pool);
        }
    }

    static final FortressForkJoinWorkerThreadFactory factory = new FortressForkJoinWorkerThreadFactory();

    public FortressTaskRunnerGroup(int groupSize) {
        super(groupSize, factory);
    }

    private static boolean envToBoolean(String s) {
        return s != null && s.length() > 0 &&
               s.substring(0,1).matches("[TtYy]");
    }

    public void printStatistics() {
        String printOnOutput = System.getenv("FORTRESS_THREAD_STATISTICS");
        if (envToBoolean(printOnOutput))
            System.out.println(toString());
    }
}
