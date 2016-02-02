/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areyes1.jgc.junit.spring.bcus;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Sumit
 */
public class MyRunner extends SpringJUnit4ClassRunner {

    public MyRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override public void run(RunNotifier notifier){
        notifier.addListener(new JUnitExecutionListener());
        super.run(notifier);
    }
}
