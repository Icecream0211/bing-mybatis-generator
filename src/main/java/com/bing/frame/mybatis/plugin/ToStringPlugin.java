package com.bing.frame.mybatis.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class ToStringPlugin extends PluginAdapter {

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(new FullyQualifiedJavaType("java.lang.String"));
		method.setName("toString");
		String bodyLine = "return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);";
		method.addBodyLine(bodyLine);
		topLevelClass.addMethod(method);
		topLevelClass.addImportedType(new FullyQualifiedJavaType("org.apache.commons.lang3.builder.ToStringBuilder"));
		topLevelClass.addImportedType(new FullyQualifiedJavaType("org.apache.commons.lang3.builder.ToStringStyle"));
		return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	}

	public boolean validate(List<String> warnings) {
		// TODO Auto-generated method stub
		return true;
	}

	
	

}


