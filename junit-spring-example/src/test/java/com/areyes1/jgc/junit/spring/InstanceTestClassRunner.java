/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areyes1.jgc.junit.spring;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 *
 * @author Sumit
 */
public class InstanceTestClassRunner extends BlockJUnit4ClassRunner {

    private InstanceTestClassListener instanceSetupListener;

    public InstanceTestClassRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Object createTest() throws Exception {
        Object test = super.createTest();
        // Note that JUnit4 will call this createTest() multiple times for each
        // test method, so we need to ensure to call "beforeClassSetup" only once.
        if (test instanceof InstanceTestClassListener && instanceSetupListener == null) {
            instanceSetupListener = (InstanceTestClassListener) test;
            instanceSetupListener.beforeClassSetup();
        }
        return test;
    }

    @Override
    public void run(RunNotifier notifier) {
        super.run(notifier);
        if (instanceSetupListener != null)
            instanceSetupListener.afterClassSetup();
    }
}
