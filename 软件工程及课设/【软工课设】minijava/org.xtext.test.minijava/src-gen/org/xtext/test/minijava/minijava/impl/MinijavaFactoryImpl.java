/**
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.minijava.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.test.minijava.minijava.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MinijavaFactoryImpl extends EFactoryImpl implements MinijavaFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MinijavaFactory init()
  {
    try
    {
      MinijavaFactory theMinijavaFactory = (MinijavaFactory)EPackage.Registry.INSTANCE.getEFactory(MinijavaPackage.eNS_URI);
      if (theMinijavaFactory != null)
      {
        return theMinijavaFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MinijavaFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MinijavaFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MinijavaPackage.GOAL: return createGoal();
      case MinijavaPackage.QUALIFIED_NAME_LIST: return createQualifiedNameList();
      case MinijavaPackage.QUALIFIED_NAME_LI: return createQualifiedNameLi();
      case MinijavaPackage.MAIN_CLASS: return createMainClass();
      case MinijavaPackage.CLASS_DECLARATION: return createClassDeclaration();
      case MinijavaPackage.TYPE: return createType();
      case MinijavaPackage.VAR_DECLARATION: return createVarDeclaration();
      case MinijavaPackage.VARIABLE: return createVariable();
      case MinijavaPackage.VAR_LIST: return createVarList();
      case MinijavaPackage.VAR_LI: return createVarLi();
      case MinijavaPackage.METHOD: return createMethod();
      case MinijavaPackage.STATEMENT: return createStatement();
      case MinijavaPackage.EXPR: return createExpr();
      case MinijavaPackage.METHOD_CALL: return createMethodCall();
      case MinijavaPackage.NUMBER_VALUE: return createNumberValue();
      case MinijavaPackage.EXPRESSION: return createExpression();
      case MinijavaPackage.ADDITION: return createAddition();
      case MinijavaPackage.MULTIPLICATION: return createMultiplication();
      case MinijavaPackage.POINT: return createPoint();
      case MinijavaPackage.SQUARE_BRACKETS: return createSquareBrackets();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Goal createGoal()
  {
    GoalImpl goal = new GoalImpl();
    return goal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QualifiedNameList createQualifiedNameList()
  {
    QualifiedNameListImpl qualifiedNameList = new QualifiedNameListImpl();
    return qualifiedNameList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QualifiedNameLi createQualifiedNameLi()
  {
    QualifiedNameLiImpl qualifiedNameLi = new QualifiedNameLiImpl();
    return qualifiedNameLi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MainClass createMainClass()
  {
    MainClassImpl mainClass = new MainClassImpl();
    return mainClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClassDeclaration createClassDeclaration()
  {
    ClassDeclarationImpl classDeclaration = new ClassDeclarationImpl();
    return classDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VarDeclaration createVarDeclaration()
  {
    VarDeclarationImpl varDeclaration = new VarDeclarationImpl();
    return varDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VarList createVarList()
  {
    VarListImpl varList = new VarListImpl();
    return varList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VarLi createVarLi()
  {
    VarLiImpl varLi = new VarLiImpl();
    return varLi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Method createMethod()
  {
    MethodImpl method = new MethodImpl();
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expr createExpr()
  {
    ExprImpl expr = new ExprImpl();
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MethodCall createMethodCall()
  {
    MethodCallImpl methodCall = new MethodCallImpl();
    return methodCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NumberValue createNumberValue()
  {
    NumberValueImpl numberValue = new NumberValueImpl();
    return numberValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Addition createAddition()
  {
    AdditionImpl addition = new AdditionImpl();
    return addition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Multiplication createMultiplication()
  {
    MultiplicationImpl multiplication = new MultiplicationImpl();
    return multiplication;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Point createPoint()
  {
    PointImpl point = new PointImpl();
    return point;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SquareBrackets createSquareBrackets()
  {
    SquareBracketsImpl squareBrackets = new SquareBracketsImpl();
    return squareBrackets;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MinijavaPackage getMinijavaPackage()
  {
    return (MinijavaPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MinijavaPackage getPackage()
  {
    return MinijavaPackage.eINSTANCE;
  }

} //MinijavaFactoryImpl
