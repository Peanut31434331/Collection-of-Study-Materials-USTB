/**
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.minijava;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getAddition <em>Addition</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getMultiplication <em>Multiplication</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getNegationOrPointExpression <em>Negation Or Point Expression</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getPoint <em>Point</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getExpressionType <em>Expression Type</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getRight <em>Right</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getSquareBrackets <em>Square Brackets</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getPrimary <em>Primary</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getType <em>Type</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getNumber <em>Number</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getMethodCall <em>Method Call</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.Expr#getLeft <em>Left</em>}</li>
 * </ul>
 *
 * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr()
 * @model
 * @generated
 */
public interface Expr extends EObject
{
  /**
   * Returns the value of the '<em><b>Addition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Addition</em>' containment reference.
   * @see #setAddition(Expr)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_Addition()
   * @model containment="true"
   * @generated
   */
  Expr getAddition();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getAddition <em>Addition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Addition</em>' containment reference.
   * @see #getAddition()
   * @generated
   */
  void setAddition(Expr value);

  /**
   * Returns the value of the '<em><b>Multiplication</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplication</em>' containment reference.
   * @see #setMultiplication(Expr)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_Multiplication()
   * @model containment="true"
   * @generated
   */
  Expr getMultiplication();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getMultiplication <em>Multiplication</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplication</em>' containment reference.
   * @see #getMultiplication()
   * @generated
   */
  void setMultiplication(Expr value);

  /**
   * Returns the value of the '<em><b>Negation Or Point Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Negation Or Point Expression</em>' containment reference.
   * @see #setNegationOrPointExpression(Expr)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_NegationOrPointExpression()
   * @model containment="true"
   * @generated
   */
  Expr getNegationOrPointExpression();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getNegationOrPointExpression <em>Negation Or Point Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Negation Or Point Expression</em>' containment reference.
   * @see #getNegationOrPointExpression()
   * @generated
   */
  void setNegationOrPointExpression(Expr value);

  /**
   * Returns the value of the '<em><b>Point</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Point</em>' containment reference.
   * @see #setPoint(Expr)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_Point()
   * @model containment="true"
   * @generated
   */
  Expr getPoint();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getPoint <em>Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Point</em>' containment reference.
   * @see #getPoint()
   * @generated
   */
  void setPoint(Expr value);

  /**
   * Returns the value of the '<em><b>Expression Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression Type</em>' attribute.
   * @see #setExpressionType(String)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_ExpressionType()
   * @model
   * @generated
   */
  String getExpressionType();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getExpressionType <em>Expression Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression Type</em>' attribute.
   * @see #getExpressionType()
   * @generated
   */
  void setExpressionType(String value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expr)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_Right()
   * @model containment="true"
   * @generated
   */
  Expr getRight();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expr value);

  /**
   * Returns the value of the '<em><b>Square Brackets</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Square Brackets</em>' containment reference.
   * @see #setSquareBrackets(Expr)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_SquareBrackets()
   * @model containment="true"
   * @generated
   */
  Expr getSquareBrackets();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getSquareBrackets <em>Square Brackets</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Square Brackets</em>' containment reference.
   * @see #getSquareBrackets()
   * @generated
   */
  void setSquareBrackets(Expr value);

  /**
   * Returns the value of the '<em><b>Primary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primary</em>' containment reference.
   * @see #setPrimary(Expr)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_Primary()
   * @model containment="true"
   * @generated
   */
  Expr getPrimary();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getPrimary <em>Primary</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Primary</em>' containment reference.
   * @see #getPrimary()
   * @generated
   */
  void setPrimary(Expr value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expr)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_Expression()
   * @model containment="true"
   * @generated
   */
  Expr getExpression();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expr value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' reference.
   * @see #setVariable(Variable)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_Variable()
   * @model
   * @generated
   */
  Variable getVariable();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getVariable <em>Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(Variable value);

  /**
   * Returns the value of the '<em><b>Number</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' containment reference.
   * @see #setNumber(NumberValue)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_Number()
   * @model containment="true"
   * @generated
   */
  NumberValue getNumber();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getNumber <em>Number</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' containment reference.
   * @see #getNumber()
   * @generated
   */
  void setNumber(NumberValue value);

  /**
   * Returns the value of the '<em><b>Method Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Call</em>' containment reference.
   * @see #setMethodCall(MethodCall)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_MethodCall()
   * @model containment="true"
   * @generated
   */
  MethodCall getMethodCall();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getMethodCall <em>Method Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Call</em>' containment reference.
   * @see #getMethodCall()
   * @generated
   */
  void setMethodCall(MethodCall value);

  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expr)
   * @see org.xtext.test.minijava.minijava.MinijavaPackage#getExpr_Left()
   * @model containment="true"
   * @generated
   */
  Expr getLeft();

  /**
   * Sets the value of the '{@link org.xtext.test.minijava.minijava.Expr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expr value);

} // Expr
