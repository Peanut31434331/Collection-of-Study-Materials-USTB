/*
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class MinijavaStandaloneSetup extends MinijavaStandaloneSetupGenerated {

	public static void doSetup() {
		new MinijavaStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
