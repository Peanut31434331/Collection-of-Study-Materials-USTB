/**
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.minijava;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.test.minijava.minijava.ClassDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.ClassDeclaration#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.ClassDeclaration#getQualifiedNameList <em>Qualified Name List</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.ClassDeclaration#getVarDeclarations <em>Var Declarations</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.ClassDeclaration#getMethodDeclarations <em>Method Declarations</em>}</li>
 * </ul>
 *
 * @see org.xtext.test.minijava.minijava.MinijavaPackage#getClassDeclaration()
 * @model
 * @generated
 */
public interface ClassDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getClassDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.ClassDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Qualified Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name</em>' reference.
   * @see #setQualifiedName(ClassDeclaration)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getClassDeclaration_QualifiedName()
   * @model
   * @generated
   */
  ClassDeclaration getQualifiedName();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.ClassDeclaration#getQualifiedName <em>Qualified Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name</em>' reference.
   * @see #getQualifiedName()
   * @generated
   */
  void setQualifiedName(ClassDeclaration value);

  /**
   * Returns the value of the '<em><b>Qualified Name List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name List</em>' containment reference.
   * @see #setQualifiedNameList(QualifiedNameList)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getClassDeclaration_QualifiedNameList()
   * @model containment="true"
   * @generated
   */
  QualifiedNameList getQualifiedNameList();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.ClassDeclaration#getQualifiedNameList <em>Qualified Name List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name List</em>' containment reference.
   * @see #getQualifiedNameList()
   * @generated
   */
  void setQualifiedNameList(QualifiedNameList value);

  /**
   * Returns the value of the '<em><b>Var Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.test.minijava.minijava.VarDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Declarations</em>' containment reference list.
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getClassDeclaration_VarDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<VarDeclaration> getVarDeclarations();

  /**
   * Returns the value of the '<em><b>Method Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.test.minijava.minijava.Method}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Declarations</em>' containment reference list.
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getClassDeclaration_MethodDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<Method> getMethodDeclarations();

} // ClassDeclaration
