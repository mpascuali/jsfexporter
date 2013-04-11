package com.lapis.pfexporter.impl;

import java.util.Arrays;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.lapis.pfexporter.ValueFormatterFactory;

public class ValueFormatterUtil {

	public static String transformComponentsToString(FacesContext context, UIComponent... components) {
		return transformComponentsToString(context, Arrays.asList(components));
	}
	
	public static String transformComponentsToString(FacesContext context, List<UIComponent> components) {
		StringBuilder builder = new StringBuilder();
		
		for (UIComponent component : components) {
			if (component.isRendered()) {
				builder.append(ValueFormatterFactory.getValueFormatter(context, component).formatValue(context, component));
			}
		}
		
		return builder.toString();
	}
	
}
