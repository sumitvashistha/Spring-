/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areyes1.jgc.junit.spring;

import org.junit.runner.JUnitCore;

public class ExecuteWithRunListener
{
	public static void main(String[] args)
	{
		JUnitCore runner = new JUnitCore();
		//Adding listener here
		runner.addListener(new ExecutionListener());
		runner.run(JUnitSpringExample.class);
	}
}
