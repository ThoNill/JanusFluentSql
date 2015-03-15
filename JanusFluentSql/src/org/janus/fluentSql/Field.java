package org.janus.fluentSql;

import org.janus.helper.DebugAssistent;

public class Field {
	Table table;
	String name;

	public Field(Table table, String name) {
		super();
		DebugAssistent.doNullCheck(table, name);

		this.table = table;
		this.name = name;
	}

	public String getName() {
		return table.getAlias() + "." + name;
	}
}
