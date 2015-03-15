package org.janus.fluentSql;

public class Table {

	private String name = null;
	private String alias = null;

	public Table() {
		super();
	}

	public Table alias(String alias) {
		Table t = new Table();
		t.name = getClass().getSimpleName().toLowerCase();
		t.alias = alias;
		return t;
	}

	public String getName() {
		if (name == null) {
			return getClass().getSimpleName().toLowerCase();
		}
		return name;
	}

	public String getAlias() {
		if (alias == null) {
			return getClass().getSimpleName().toLowerCase();
		}
		return alias;
	}

}
