package org.janus.fluentSql;

public enum Status {
	COLUMN(false, true), CREATE, FELDDEF_START, FELDDEF(true, true), FROM(true,
			true), GROUP_START, GROUP(true, true), HAVING_END(true), HAVING_PRE_COND, HAVING_START, HAVING_WITH_COND, ORDER_START, ORDER(
			true, true), SELECT, SQL, WHERE_END(true), WHERE_PRE_COND, WHERE_START, WHERE_WITH_COND, INCOMPLETEEXPRESSION, EXPRESSION(
			true), FUNCTION;

	private boolean complete = false;
	private boolean hasCommas = false;

	private Status() {
	}

	private Status(boolean complete) {
		this.complete = complete;
	}

	private Status(boolean complete, boolean hasComma) {
		this(complete);
		this.hasCommas = hasComma;
	}

	public boolean isComplete() {
		return complete;
	}

	public boolean hasCommas() {
		return hasCommas;
	}
}
