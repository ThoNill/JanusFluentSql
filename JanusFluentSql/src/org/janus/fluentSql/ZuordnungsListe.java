package org.janus.fluentSql;

import java.util.List; import java.util.ArrayList;

public class ZuordnungsListe extends ArrayList<Zuordnung> {

	static ZuordnungsListe zuordnungen = new ZuordnungsListe();

	public static Zuordnung find(Status von, String methode) {
		for (Zuordnung z : zuordnungen) {
			if (z.vonStatus.ordinal() == von.ordinal()
					&& z.inMethode.equals(methode)) {
				return z;
			}

		}
		return null;
	}

	public ZuordnungsListe() {
		init();
	}

	public void init() {
		add(new Zuordnung(Status.SQL, "create", Status.CREATE));
		add(new Zuordnung(Status.CREATE, "field", Status.FELDDEF_START));
		add(new Zuordnung(Status.FELDDEF_START, "t_int", Status.FELDDEF,
				"integer"));
		add(new Zuordnung(Status.FELDDEF_START, "t_char", Status.FELDDEF));
		add(new Zuordnung(Status.FELDDEF, "field", Status.FELDDEF_START));

		add(new Zuordnung(Status.SQL, "select", Status.SELECT, "select"));
		add(new Zuordnung(Status.SELECT, "column", Status.COLUMN));

		add(new Zuordnung(Status.COLUMN, "from", Status.FROM));
		add(new Zuordnung(Status.COLUMN, "column"));
		add(new Zuordnung(Status.COLUMN, "as"));

		add(new Zuordnung(Status.FROM, "alias"));
		add(new Zuordnung(Status.FROM, "and"));
		add(new Zuordnung(Status.FROM, "where", Status.WHERE_START, "where"));
		add(new Zuordnung(Status.FROM, "groupBy", Status.GROUP_START,
				"group by"));
		add(new Zuordnung(Status.FROM, "orderBy", Status.ORDER_START,
				"order by"));

		add(new Zuordnung(Status.WHERE_START, "integer", Status.WHERE_PRE_COND));
		add(new Zuordnung(Status.WHERE_START, "text", Status.WHERE_PRE_COND));
		add(new Zuordnung(Status.WHERE_START, "field", Status.WHERE_PRE_COND));
		add(new Zuordnung(Status.WHERE_START, "not", "not"));

		add(new Zuordnung(Status.WHERE_PRE_COND, "eq", Status.WHERE_WITH_COND,
				"="));
		add(new Zuordnung(Status.WHERE_PRE_COND, "neq", Status.WHERE_WITH_COND,
				"<>"));
		add(new Zuordnung(Status.WHERE_PRE_COND, "lt", Status.WHERE_WITH_COND,
				"<"));
		add(new Zuordnung(Status.WHERE_PRE_COND, "gt", Status.WHERE_WITH_COND,
				">"));
		add(new Zuordnung(Status.WHERE_PRE_COND, "geq", Status.WHERE_WITH_COND,
				">="));
		add(new Zuordnung(Status.WHERE_PRE_COND, "leq", Status.WHERE_WITH_COND,
				"<="));
		add(new Zuordnung(Status.WHERE_PRE_COND, "isNull", Status.WHERE_END,
				"is null"));
		add(new Zuordnung(Status.WHERE_PRE_COND, "notNull", Status.WHERE_END,
				"is not null"));
		add(new Zuordnung(Status.WHERE_PRE_COND, "like", Status.WHERE_END, null));

		add(new Zuordnung(Status.WHERE_WITH_COND, "integer", Status.WHERE_END));
		add(new Zuordnung(Status.WHERE_WITH_COND, "text", Status.WHERE_END));
		add(new Zuordnung(Status.WHERE_WITH_COND, "field", Status.WHERE_END));

		add(new Zuordnung(Status.WHERE_END, "and", Status.WHERE_START, "and"));
		add(new Zuordnung(Status.WHERE_END, "or", Status.WHERE_START, "or"));
		add(new Zuordnung(Status.WHERE_END, "groupBy", Status.GROUP_START,
				"group by"));
		add(new Zuordnung(Status.WHERE_END, "orderBy", Status.ORDER_START,
				"order by"));

		add(new Zuordnung(Status.GROUP_START, "column", Status.GROUP));

		add(new Zuordnung(Status.GROUP, "column", Status.GROUP));
		add(new Zuordnung(Status.GROUP, "orderBy", Status.ORDER_START,
				"order by"));
		add(new Zuordnung(Status.GROUP, "having", Status.HAVING_START, "having"));

		add(new Zuordnung(Status.ORDER_START, "column", Status.ORDER));

		add(new Zuordnung(Status.ORDER, "asc", "asc"));
		add(new Zuordnung(Status.ORDER, "desc", "desc"));
		add(new Zuordnung(Status.ORDER, "column"));

		add(new Zuordnung(Status.HAVING_START, "integer",
				Status.HAVING_PRE_COND));
		add(new Zuordnung(Status.HAVING_START, "text", Status.HAVING_PRE_COND));
		add(new Zuordnung(Status.HAVING_START, "field", Status.HAVING_PRE_COND));
		add(new Zuordnung(Status.HAVING_START, "not", "not"));

		add(new Zuordnung(Status.HAVING_PRE_COND, "eq",
				Status.HAVING_WITH_COND, "="));
		add(new Zuordnung(Status.HAVING_PRE_COND, "neq",
				Status.HAVING_WITH_COND, "<>"));
		add(new Zuordnung(Status.HAVING_PRE_COND, "lt",
				Status.HAVING_WITH_COND, "<"));
		add(new Zuordnung(Status.HAVING_PRE_COND, "gt",
				Status.HAVING_WITH_COND, ">"));
		add(new Zuordnung(Status.HAVING_PRE_COND, "geq",
				Status.HAVING_WITH_COND, ">="));
		add(new Zuordnung(Status.HAVING_PRE_COND, "leq",
				Status.HAVING_WITH_COND, "<="));

		add(new Zuordnung(Status.HAVING_WITH_COND, "integer", Status.HAVING_END));
		add(new Zuordnung(Status.HAVING_WITH_COND, "text", Status.HAVING_END));
		add(new Zuordnung(Status.HAVING_WITH_COND, "field", Status.HAVING_END));

		add(new Zuordnung(Status.HAVING_END, "and", Status.HAVING_START, "and"));
		add(new Zuordnung(Status.HAVING_END, "or", Status.HAVING_START, "or"));
		add(new Zuordnung(Status.HAVING_END, "orderBy", Status.ORDER_START,
				"order by"));

		add(new Zuordnung(Status.INCOMPLETEEXPRESSION, "value",
				Status.EXPRESSION));
		add(new Zuordnung(Status.INCOMPLETEEXPRESSION, "fo",
				Status.INCOMPLETEEXPRESSION));
		add(new Zuordnung(Status.INCOMPLETEEXPRESSION, "o",
				Status.INCOMPLETEEXPRESSION, "("));
		add(new Zuordnung(Status.INCOMPLETEEXPRESSION, "neg",
				Status.INCOMPLETEEXPRESSION, "-"));

		add(new Zuordnung(Status.EXPRESSION, "fc", Status.EXPRESSION, ")"));
		add(new Zuordnung(Status.EXPRESSION, "c", Status.EXPRESSION, ")"));
		add(new Zuordnung(Status.EXPRESSION, "plus",
				Status.INCOMPLETEEXPRESSION, "+"));
		add(new Zuordnung(Status.EXPRESSION, "minus",
				Status.INCOMPLETEEXPRESSION, "-"));
		add(new Zuordnung(Status.EXPRESSION, "mul",
				Status.INCOMPLETEEXPRESSION, "*"));
		add(new Zuordnung(Status.EXPRESSION, "div",
				Status.INCOMPLETEEXPRESSION, "/"));
		add(new Zuordnung(Status.EXPRESSION, "comma",
				Status.INCOMPLETEEXPRESSION, ","));

	}
}
