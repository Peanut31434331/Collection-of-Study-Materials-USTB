/**
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.minijava.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.test.minijava.minijava.Goal;
import org.xtext.test.minijava.minijava.MinijavaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.test.minijava.minijava.impl.GoalImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.impl.GoalImpl#getImportdecl <em>Importdecl</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.impl.GoalImpl#getClassDeclarations <em>Class Declarations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoalImpl extends MinimalEObjectImpl.Container implements Goal
{
  /**
   * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected static final String PACKAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected String package_ = PACKAGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getImportdecl() <em>Importdecl</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImportdecl()
   * @generated
   * @ordered
   */
  protected EList<String> importdecl;

  /**
   * The cached value of the '{@link #getClassDeclarations() <em>Class Declarations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassDeclarations()
   * @generated
   * @ordered
   */
  protected EList<EObject> classDeclarations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GoalImpl()
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
    return MinijavaPackage.Literals.GOAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getPackage()
  {
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPackage(String newPackage)
  {
    String oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MinijavaPackage.GOAL__PACKAGE, oldPackage, package_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getImportdecl()
  {
    if (importdecl == null)
    {
      importdecl = new EDataTypeEList<String>(String.class, this, MinijavaPackage.GOAL__IMPORTDECL);
    }
    return importdecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<EObject> getClassDeclarations()
  {
    if (classDeclarations == null)
    {
      classDeclarations = new EObjectContainmentEList<EObject>(EObject.class, this, MinijavaPackage.GOAL__CLASS_DECLARATIONS);
    }
    return classDeclarations;
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
      case MinijavaPackage.GOAL__CLASS_DECLARATIONS:
        return ((InternalEList<?>)getClassDeclarations()).basicRemove(otherEnd, msgs);
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
      case MinijavaPackage.GOAL__PACKAGE:
        return getPackage();
      case MinijavaPackage.GOAL__IMPORTDECL:
        return getImportdecl();
      case MinijavaPackage.GOAL__CLASS_DECLARATIONS:
        return getClassDeclarations();
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
      case MinijavaPackage.GOAL__PACKAGE:
        setPackage((String)newValue);
        return;
      case MinijavaPackage.GOAL__IMPORTDECL:
        getImportdecl().clear();
        getImportdecl().addAll((Collection<? extends String>)newValue);
        return;
      case MinijavaPackage.GOAL__CLASS_DECLARATIONS:
        getClassDeclarations().clear();
        getClassDeclarations().addAll((Collection<? extends EObject>)newValue);
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
      case MinijavaPackage.GOAL__PACKAGE:
        setPackage(PACKAGE_EDEFAULT);
        return;
      case MinijavaPackage.GOAL__IMPORTDECL:
        getImportdecl().clear();
        return;
      case MinijavaPackage.GOAL__CLASS_DECLARATIONS:
        getClassDeclarations().clear();
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
      case MinijavaPackage.GOAL__PACKAGE:
        return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
      case MinijavaPackage.GOAL__IMPORTDECL:
        return importdecl != null && !importdecl.isEmpty();
      case MinijavaPackage.GOAL__CLASS_DECLARATIONS:
        return classDeclarations != null && !classDeclarations.isEmpty();
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
    result.append(" (package: ");
    result.append(package_);
    result.append(", importdecl: ");
    result.append(importdecl);
    result.append(')');
    return result.toString();
  }

} //GoalImpl
