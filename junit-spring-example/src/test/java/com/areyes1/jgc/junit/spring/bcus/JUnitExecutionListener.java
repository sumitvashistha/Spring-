package com.areyes1.jgc.junit.spring.bcus;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 *
 * @author Sumit
 */
public class JUnitExecutionListener extends RunListener {

    private final static String FAILED = "F";
    private final static String PASSED = ".";
    private final static String SKIPPED = "S";

    private Class currentTestClass;

    private final long TIME_TO_CONSIDER_SLOW = 200;
    private List<String> slowTests = new ArrayList<String>();

    long startTimer;

    private PrintStream stream() {
        try {
            return new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return System.out;
        }
    }

    @Override
    public void testRunStarted(Description description) throws Exception {
        stream().println();
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        if (result.getRunTime() > TIME_TO_CONSIDER_SLOW) {
            stream().println(currentTestClass + ": " + result.getRunTime() + "ms");
        }
    }

    @Override
    public void testStarted(Description description) throws Exception {
        if (!description.getTestClass().equals(currentTestClass)) {
            currentTestClass = description.getTestClass();
            startTimer = System.currentTimeMillis();
        }
    }

    @Override
    public void testFinished(Description description) throws Exception {
        stream().println(description.getTestClass() + ":" + description.getMethodName());
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        stream().println(failure.getTestHeader() + ":" + failure.getDescription().getMethodName());
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
    }

    @Override
    public void testIgnored(Description description) throws Exception {
    }
}
