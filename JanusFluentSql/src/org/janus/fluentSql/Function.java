package org.janus.fluentSql;

import org.janus.helper.DebugAssistent;

public class Function {

	public static final Function max = new Function("max");
	public static final Function min = new Function("min");
	public static final Function sum = new Function("sum");

	private String name;

	public Function(String name) {
		DebugAssistent.doNullCheck(name);

		this.name = name;
	}

	public String getName() {
		return name;
	}

}
