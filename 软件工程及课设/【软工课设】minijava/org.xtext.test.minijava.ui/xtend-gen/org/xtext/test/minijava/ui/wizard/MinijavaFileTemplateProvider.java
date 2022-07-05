/**
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.ui.wizard;

import org.eclipse.xtext.ui.wizard.template.AbstractFileTemplate;
import org.eclipse.xtext.ui.wizard.template.IFileTemplateProvider;

/**
 * Create a list with all file templates to be shown in the template new file wizard.
 * 
 * Each template is able to generate one or more files.
 */
@SuppressWarnings("all")
public class MinijavaFileTemplateProvider implements IFileTemplateProvider {
  @Override
  public AbstractFileTemplate[] getFileTemplates() {
    HelloWorldFile _helloWorldFile = new HelloWorldFile();
    return new AbstractFileTemplate[] { _helloWorldFile };
  }
}
