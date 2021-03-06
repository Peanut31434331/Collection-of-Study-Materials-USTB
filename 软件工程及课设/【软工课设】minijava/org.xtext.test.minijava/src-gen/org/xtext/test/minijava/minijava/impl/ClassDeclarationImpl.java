/**
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.minijava.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.test.minijava.minijava.ClassDeclaration;
import org.xtext.test.minijava.minijava.Method;
import org.xtext.test.minijava.minijava.MinijavaPackage;
import org.xtext.test.minijava.minijava.QualifiedNameList;
import org.xtext.test.minijava.minijava.VarDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.test.minijava.minijava.impl.ClassDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.impl.ClassDeclarationImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.impl.ClassDeclarationImpl#getQualifiedNameList <em>Qualified Name List</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.impl.ClassDeclarationImpl#getVarDeclarations <em>Var Declarations</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.impl.ClassDeclarationImpl#getMethodDeclarations <em>Method Declarations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassDeclarationImpl extends MinimalEObjectImpl.Container implements ClassDeclaration
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedName()
   * @generated
   * @ordered
   */
  protected ClassDeclaration qualifiedName;

  /**
   * The cached value of the '{@link #getQualifiedNameList() <em>Qualified Name List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedNameList()
   * @generated
   * @ordered
   */
  protected QualifiedNameList qualifiedNameList;

  /**
   * The cached value of the '{@link #getVarDeclarations() <em>Var Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarDeclarations()
   * @generated
   * @ordered
   */
  protected EList<VarDeclaration> varDeclarations;

  /**
   * The cached value of the '{@link #getMethodDeclarations() <em>Method Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodDeclarations()
   * @generated
   * @ordered
   */
  protected EList<Method> methodDeclarations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassDeclarationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MinijavaPackage.Literals.CLASS_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MinijavaPackage.CLASS_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ClassDeclaration getQualifiedName()
  {
    if (qualifiedName != null && qualifiedName.eIsProxy())
    {
      InternalEObject oldQualifiedName = (InternalEObject)qualifiedName;
      qualifiedName = (ClassDeclaration)eResolveProxy(oldQualifiedName);
      if (qualifiedName != oldQualifiedName)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
      }
    }
    return qualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDeclaration basicGetQualifiedName()
  {
    return qualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQualifiedName(ClassDeclaration newQualifiedName)
  {
    ClassDeclaration oldQualifiedName = qualifiedName;
    qualifiedName = newQualifiedName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QualifiedNameList getQualifiedNameList()
  {
    return qualifiedNameList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualifiedNameList(QualifiedNameList newQualifiedNameList, NotificationChain msgs)
  {
    QualifiedNameList oldQualifiedNameList = qualifiedNameList;
    qualifiedNameList = newQualifiedNameList;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME_LIST, oldQualifiedNameList, newQualifiedNameList);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQualifiedNameList(QualifiedNameList newQualifiedNameList)
  {
    if (newQualifiedNameList != qualifiedNameList)
    {
      NotificationChain msgs = null;
      if (qualifiedNameList != null)
        msgs = ((InternalEObject)qualifiedNameList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME_LIST, null, msgs);
      if (newQualifiedNameList != null)
        msgs = ((InternalEObject)newQualifiedNameList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME_LIST, null, msgs);
      msgs = basicSetQualifiedNameList(newQualifiedNameList, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME_LIST, newQualifiedNameList, newQualifiedNameList));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<VarDeclaration> getVarDeclarations()
  {
    if (varDeclarations == null)
    {
      varDeclarations = new EObjectContainmentEList<VarDeclaration>(VarDeclaration.class, this, MinijavaPackage.CLASS_DECLARATION__VAR_DECLARATIONS);
    }
    return varDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Method> getMethodDeclarations()
  {
    if (methodDeclarations == null)
    {
      methodDeclarations = new EObjectContainmentEList<Method>(Method.class, this, MinijavaPackage.CLASS_DECLARATION__METHOD_DECLARATIONS);
    }
    return methodDeclarations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME_LIST:
        return basicSetQualifiedNameList(null, msgs);
      case MinijavaPackage.CLASS_DECLARATION__VAR_DECLARATIONS:
        return ((InternalEList<?>)getVarDeclarations()).basicRemove(otherEnd, msgs);
      case MinijavaPackage.CLASS_DECLARATION__METHOD_DECLARATIONS:
        return ((InternalEList<?>)getMethodDeclarations()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MinijavaPackage.CLASS_DECLARATION__NAME:
        return getName();
      case MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME:
        if (resolve) return getQualifiedName();
        return basicGetQualifiedName();
      case MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME_LIST:
        return getQualifiedNameList();
      case MinijavaPackage.CLASS_DECLARATION__VAR_DECLARATIONS:
        return getVarDeclarations();
      case MinijavaPackage.CLASS_DECLARATION__METHOD_DECLARATIONS:
        return getMethodDeclarations();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MinijavaPackage.CLASS_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME:
        setQualifiedName((ClassDeclaration)newValue);
        return;
      case MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME_LIST:
        setQualifiedNameList((QualifiedNameList)newValue);
        return;
      case MinijavaPackage.CLASS_DECLARATION__VAR_DECLARATIONS:
        getVarDeclarations().clear();
        getVarDeclarations().addAll((Collection<? extends VarDeclaration>)newValue);
        return;
      case MinijavaPackage.CLASS_DECLARATION__METHOD_DECLARATIONS:
        getMethodDeclarations().clear();
        getMethodDeclarations().addAll((Collection<? extends Method>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MinijavaPackage.CLASS_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME:
        setQualifiedName((ClassDeclaration)null);
        return;
      case MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME_LIST:
        setQualifiedNameList((QualifiedNameList)null);
        return;
      case MinijavaPackage.CLASS_DECLARATION__VAR_DECLARATIONS:
        getVarDeclarations().clear();
        return;
      case MinijavaPackage.CLASS_DECLARATION__METHOD_DECLARATIONS:
        getMethodDeclarations().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MinijavaPackage.CLASS_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME:
        return qualifiedName != null;
      case MinijavaPackage.CLASS_DECLARATION__QUALIFIED_NAME_LIST:
        return qualifiedNameList != null;
      case MinijavaPackage.CLASS_DECLARATION__VAR_DECLARATIONS:
        return varDeclarations != null && !varDeclarations.isEmpty();
      case MinijavaPackage.CLASS_DECLARATION__METHOD_DECLARATIONS:
        return methodDeclarations != null && !methodDeclarations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ClassDeclarationImpl
