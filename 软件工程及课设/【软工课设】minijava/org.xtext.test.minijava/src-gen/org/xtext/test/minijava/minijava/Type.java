/**
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.minijava;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.test.minijava.minijava.Type#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Type#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Type#getVarList <em>Var List</em>}</li>
 * </ul>
 *
 * @see org.xtext.test.minijava.minijava.MinijavaPackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' attribute.
   * @see #setTypeName(String)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getType_TypeName()
   * @model
   * @generated
   */
  String getTypeName();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Type#getTypeName <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' attribute.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(String value);

  /**
   * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name</em>' attribute.
   * @see #setQualifiedName(String)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getType_QualifiedName()
   * @model
   * @generated
   */
  String getQualifiedName();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Type#getQualifiedName <em>Qualified Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name</em>' attribute.
   * @see #getQualifiedName()
   * @generated
   */
  void setQualifiedName(String value);

  /**
   * Returns the value of the '<em><b>Var List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var List</em>' containment reference.
   * @see #setVarList(VarList)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getType_VarList()
   * @model containment="true"
   * @generated
   */
  VarList getVarList();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Type#getVarList <em>Var List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var List</em>' containment reference.
   * @see #getVarList()
   * @generated
   */
  void setVarList(VarList value);

} // Type
