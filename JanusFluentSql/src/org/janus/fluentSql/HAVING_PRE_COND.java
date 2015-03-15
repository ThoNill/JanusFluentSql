package org.janus.fluentSql;

public interface HAVING_PRE_COND {

	HAVING_WITH_COND eq();

	HAVING_WITH_COND neq();

	HAVING_WITH_COND gt();

	HAVING_WITH_COND lt();

	HAVING_WITH_COND geq();

	HAVING_WITH_COND leq();
}