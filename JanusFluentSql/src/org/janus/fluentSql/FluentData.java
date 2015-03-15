package org.janus.fluentSql;

import org.janus.helper.DebugAssistent;

public class FluentData extends SqlTextBuilder implements SQL, COLUMN, CREATE,
		EXPRESSION, FELDDEF_START, FIELDDEF, FROM, GROUP, GROUP_START,
		HAVING_END, HAVING_PRE_COND, HAVING_START, HAVING_WITH_COND,
		INCOMPLETEEXPRESSION, ORDER, ORDER_START, SELECT, WHERE_END,
		WHERE_PRE_COND, WHERE_START, WHERE_WITH_COND {

	public FluentData(Status status) {
		super(status);
	}

	public FluentData append(String text) {
		DebugAssistent.doNullCheck(text);

		put(text);
		return this;
	}

	@Override
	public FluentData setStatus(Status status) {
		super.setStatus(status);
		return this;
	}

	public FluentData append(Reduziert... fields) {
		append(",", fields);
		return this;
	}

	@Override
	public FluentData alias(String name) {
		DebugAssistent.doNullCheck(name);

		changeStatus(name);
		return this;
	}

	@Override
	public FluentData create(String name) {
		DebugAssistent.doNullCheck(name);

		changeStatus("create table " + name + " (");
		return this;
	}

	@Override
	public FluentData select() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData and() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData and(String name) {
		DebugAssistent.doNullCheck(name);

		switch (getStatus()) {
		case FROM:
			changeStatus(", " + name);
		}
		return this;
	}

	@Override
	public FluentData as(String name) {
		DebugAssistent.doNullCheck(name);

		/*
		 * switch (getStatus()) { case COLUMN : statusWechseln("\"" + name +
		 * "\""); case COLUMN : statusWechseln("\"" + name + "\""); }
		 */
		changeStatus("as \"" + name + "\"");
		return this;
	}

	@Override
	public FluentData asc() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData c() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData column(Field field) {
		DebugAssistent.doNullCheck(field);

		changeStatus(getKommaText() + field.getName());
		return this;
	}

	@Override
	public FluentData column(int value) {
		changeStatus(getKommaText() + value);
		return this;
	}

	@Override
	public FluentData column(String name) {
		DebugAssistent.doNullCheck(name);

		changeStatus(getKommaText() + name);
		return this;
	}

	@Override
	public FluentData comma() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData desc() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData div() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData eq() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData fc(Function f) {
		DebugAssistent.doNullCheck(f);

		changeStatus();
		return this;
	}

	@Override
	public FluentData field(Field value) {
		DebugAssistent.doNullCheck(value);

		changeStatus(value.getName());
		return this;
	}

	@Override
	public FluentData field(String name) {
		DebugAssistent.doNullCheck(name);

		changeStatus(getKommaText() + name);
		return this;
	}

	@Override
	public FluentData fo(Function f) {
		DebugAssistent.doNullCheck(f);

		changeStatus(f.getName() + "(");
		return this;
	}

	@Override
	public FluentData from(String name) {
		DebugAssistent.doNullCheck(name);

		changeStatus("from " + name);
		return this;
	}

	@Override
	public FluentData geq() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData groupBy() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData gt() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData having() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData integer(int value) {
		changeStatus("" + value);
		return this;
	}

	@Override
	public FluentData leq() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData lt() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData minus() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData mul() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData neg() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData neq() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData not() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData o() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData or() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData orderBy() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData plus() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData t_char(int count) {
		changeStatus("char(" + count + ")");
		return this;
	}

	@Override
	public FluentData t_int() {
		changeStatus();
		return this;
	}

	@Override
	public FluentData text(int value) {
		changeStatus("\"" + value + "\"");
		return this;
	}

	@Override
	public FluentData value(Field field) {
		DebugAssistent.doNullCheck(field);

		changeStatus(field.getName());
		return this;
	}

	@Override
	public FluentData value(int value) {
		changeStatus("" + value);
		return this;
	}

	@Override
	public FluentData value(String name) {
		DebugAssistent.doNullCheck(name);

		changeStatus("\"" + name + "\"");
		return this;
	}

	@Override
	public FluentData where() {
		changeStatus();
		return this;
	}

	@Override
	protected String getTextAtTheEnd() {
		if (getStatus().ordinal() == Status.FELDDEF.ordinal()) {
			return getText() + " )";
		} else {
			return getText();
		}
	}

	@Override
	public WHERE_END like(String text) {
		DebugAssistent.doNullCheck(text);

		changeStatus("like ( \"" + text + "\" )");
		return this;

	}

	@Override
	public WHERE_END isNull() {
		changeStatus();
		return this;
	}

	@Override
	public WHERE_END notNull() {
		changeStatus();
		return this;
	}

}
