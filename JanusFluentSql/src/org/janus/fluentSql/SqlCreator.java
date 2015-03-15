package org.janus.fluentSql;

import org.janus.helper.DebugAssistent;

public class SqlCreator {

	public SqlCreator() {
	}

	private static FluentData getObject(Status status) {
		return new FluentData(status);
	}

	public static SELECT select() {
		return getObject(Status.SQL).select();
	}

	public static COLUMN select(COLUMN... columns) {
		DebugAssistent.doNullCheck(columns);

		return getObject(Status.SQL).select().append(columns)
				.setStatus(Status.COLUMN);
	}

	public static CREATE create(String table) {
		DebugAssistent.doNullCheck(table);

		return getObject(Status.SQL).create(table);
	}

	public static CREATE create(String table, FIELDDEF... fields) {
		DebugAssistent.doNullCheck(table);
		DebugAssistent.doNullCheck(fields);

		return getObject(Status.SQL).create(table).append(fields)
				.setStatus(Status.FELDDEF);
	}

	public static FELDDEF_START field(String name) {
		DebugAssistent.doNullCheck(name);

		return getObject(Status.CREATE).field(name);
	}

	public static COLUMN column(String name) {
		DebugAssistent.doNullCheck(name);

		return getObject(Status.COLUMN).append(name);
	}

	public static INCOMPLETEEXPRESSION expr() {
		return getObject(Status.INCOMPLETEEXPRESSION);
	}

}
