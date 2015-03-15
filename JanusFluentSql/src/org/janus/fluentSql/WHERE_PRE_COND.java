package org.janus.fluentSql;

public interface WHERE_PRE_COND {

	WHERE_WITH_COND eq();

	WHERE_WITH_COND neq();

	WHERE_WITH_COND gt();

	WHERE_WITH_COND lt();

	WHERE_WITH_COND geq();

	WHERE_WITH_COND leq();

	WHERE_END like(String text);

	WHERE_END isNull();

	WHERE_END notNull();

}