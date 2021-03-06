/**
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.minijava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.test.minijava.minijava.MinijavaPackage;
import org.xtext.test.minijava.minijava.QualifiedNameLi;
import org.xtext.test.minijava.minijava.QualifiedNameList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Name List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.test.minijava.minijava.impl.QualifiedNameListImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.xtext.test.minijava.minijava.impl.QualifiedNameListImpl#getQualifiedNameLi <em>Qualified Name Li</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedNameListImpl extends MinimalEObjectImpl.Container implements QualifiedNameList
{
  /**
   * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedName()
   * @generated
   * @ordered
   */
  protected static final String QUALIFIED_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedName()
   * @generated
   * @ordered
   */
  protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getQualifiedNameLi() <em>Qualified Name Li</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualifiedNameLi()
   * @generated
   * @ordered
   */
  protected QualifiedNameLi qualifiedNameLi;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualifiedNameListImpl()
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
    return MinijavaPackage.Literals.QUALIFIED_NAME_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getQualifiedName()
  {
    return qualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setQualifiedName(String newQualifiedName)
  {
    String oldQualifiedName = qualifiedName;
    qualifiedName = newQualifiedName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public QualifiedNameLi getQualifiedNameLi()
  {
    return qualifiedNameLi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualifiedNameLi(QualifiedNameLi newQualifiedNameLi, NotificationChain msgs)
  {
    QualifiedNameLi oldQualifiedNameLi = qualifiedNameLi;
    qualifiedNameLi = newQualifiedNameLi;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME_LI, oldQualifiedNameLi, newQualifiedNameLi);
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
  public void setQualifiedNameLi(QualifiedNameLi newQualifiedNameLi)
  {
    if (newQualifiedNameLi != qualifiedNameLi)
    {
      NotificationChain msgs = null;
      if (qualifiedNameLi != null)
        msgs = ((InternalEObject)qualifiedNameLi).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME_LI, null, msgs);
      if (newQualifiedNameLi != null)
        msgs = ((InternalEObject)newQualifiedNameLi).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME_LI, null, msgs);
      msgs = basicSetQualifiedNameLi(newQualifiedNameLi, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME_LI, newQualifiedNameLi, newQualifiedNameLi));
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
      case MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME_LI:
        return basicSetQualifiedNameLi(null, msgs);
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
      case MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME:
        return getQualifiedName();
      case MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME_LI:
        return getQualifiedNameLi();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME:
        setQualifiedName((String)newValue);
        return;
      case MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME_LI:
        setQualifiedNameLi((QualifiedNameLi)newValue);
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
      case MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME:
        setQualifiedName(QUALIFIED_NAME_EDEFAULT);
        return;
      case MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME_LI:
        setQualifiedNameLi((QualifiedNameLi)null);
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
      case MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME:
        return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
      case MinijavaPackage.QUALIFIED_NAME_LIST__QUALIFIED_NAME_LI:
        return qualifiedNameLi != null;
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
    result.append(" (qualifiedName: ");
    result.append(qualifiedName);
    result.append(')');
    return result.toString();
  }

} //QualifiedNameListImpl
