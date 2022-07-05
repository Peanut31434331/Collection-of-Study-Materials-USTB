/*
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.validation;


import org.eclipse.xtext.validation.Check;
import org.xtext.test.minijava.minijava.ClassDeclaration;
import org.xtext.test.minijava.minijava.MinijavaPackage;
import org.eclipse.xtext.EcoreUtil2
import org.xtext.test.minijava.minijava.Goal
import org.xtext.test.minijava.minijava.Method
import org.xtext.test.minijava.minijava.Variable
import org.xtext.test.minijava.minijava.MethodCall
import org.xtext.test.minijava.minijava.Statement
import org.xtext.test.minijava.minijava.Expression


/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class MinijavaValidator extends AbstractMinijavaValidator {
	
	public static val INVALID_NAME = 'invalidName'
	public static val CYCLYC_DEPENDENCE = 'cyclicDependence'
	public static val DUPLICATE_NAMES = 'duplicateNames'
	public static val WRONG_PARAMETERS = 'wrongParameters'
	public static val WRONG_RETURN = 'wrongReturn'
	public static val NO_RETURN = 'noReturn'
	public static val NOT_ARRAY = 'notArray'
	public static val NOT_INT = 'notInt'
	public static val NOT_BOOLEAN = 'notBoolean'	
	public static val TYPE_MISMATCH = 'typeMismatch'
	public static val WRONG_METHOD = 'wrongMethod'
	public static val WRONG_INSTANTIATION = 'wrongInstantiation'

	@Check(FAST)
	def checkClassName(ClassDeclaration classDecl) {
		if (!Character.isUpperCase(classDecl.name.charAt(0))) {
			warning('Name should start with a capital',
					MinijavaPackage.Literals.CLASS_DECLARATION__NAME,
					INVALID_NAME);
		}
	}
	
	// Cyclic dependence		
	@Check(FAST)
	def checkCyclicDependence(ClassDeclaration classDecl) {
		var extendedClass = classDecl.qualifiedName;
		while (extendedClass !== null && extendedClass != classDecl) {
			extendedClass = extendedClass.qualifiedName;
		}
		
		if (extendedClass !== null) {
			error('Cyclic dependence',
					MinijavaPackage.Literals.CLASS_DECLARATION__NAME,
					CYCLYC_DEPENDENCE);
		}
	}
	
	// Duplicate names of the classes
//	@Check(FAST)
//	def checkDuplicateClassNames(ClassDeclaration classDecl) {
//		val program = EcoreUtil2.getContainerOfType(classDecl, Goal);
//
//        for (currentClassDecl : program.classDeclarations) {
//        	if ( classDecl.name.equals(currentClassDecl.name)
//        		&& classDecl != currentClassDecl ) {
//        				
//				error('Duplicate names of the classes',
//					MinijavaPackage.Literals.CLASS_DECLARATION__NAME,
//					DUPLICATE_NAMES);
//			}
//		}
//	}
	
	// Duplicate names of the Method
	@Check(FAST)
	def checkDuplicateMethodNames(Method method) {
		val classDecl = EcoreUtil2.getContainerOfType(method, ClassDeclaration);

        for (currentMethod : classDecl.methodDeclarations) {
        	if ( method.name.equals(currentMethod.name)
        		&& method != currentMethod ) {
        				
				error('Duplicate names of the methods',
					MinijavaPackage.Literals.METHOD__NAME,
					DUPLICATE_NAMES);
			}
		}
	}
	

	
	// No return statement for the method
	@Check(FAST)
	def checkReturnExistance(Method method) {
		if (method.returnExpression == null) {
					
			error('No return statement for the method',
				MinijavaPackage.Literals.METHOD__RETURN_EXPRESSION,
				NO_RETURN);
		}
	}	
		


}

