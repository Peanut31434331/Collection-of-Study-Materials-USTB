/**
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.minijava;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.test.minijava.minijava.Variable#getVariableType <em>Variable Type</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Variable#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.xtext.test.minijava.minijava.MinijavaPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends EObject
{
  /**
   * Returns the value of the '<em><b>Variable Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable Type</em>' containment reference.
   * @see #setVariableType(Type)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getVariable_VariableType()
   * @model containment="true"
   * @generated
   */
  Type getVariableType();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Variable#getVariableType <em>Variable Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Type</em>' containment reference.
   * @see #getVariableType()
   * @generated
   */
  void setVariableType(Type value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getVariable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Variable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Variable
