/**
 * generated by Xtext 2.25.0
 */
package org.xtext.test.minijava.ui.wizard;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.wizard.template.AbstractFileTemplate;
import org.eclipse.xtext.ui.wizard.template.FileTemplate;
import org.eclipse.xtext.ui.wizard.template.IFileGenerator;
import org.eclipse.xtext.ui.wizard.template.StringSelectionTemplateVariable;

@FileTemplate(label = "Hello World", icon = "file_template.png", description = "Create a hello world for Minijava.")
@SuppressWarnings("all")
public final class HelloWorldFile extends AbstractFileTemplate {
  private final StringSelectionTemplateVariable helloName = this.combo("Hello Name:", new String[] { "Xtext", "World", "Foo", "Bar" }, "The name to say \'Hello\' to");
  
  @Override
  public void generateFiles(final IFileGenerator generator) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("?folder?/?name?.minijava");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* This is an example model");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("*/");
    _builder_1.newLine();
    _builder_1.append("Hello ?helloName?!");
    _builder_1.newLine();
    generator.generate(_builder, _builder_1);
  }
}
