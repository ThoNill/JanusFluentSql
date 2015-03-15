package org.janus.fluentSql;

public interface HAVING_START {

	HAVING_PRE_COND integer(int value);

	HAVING_PRE_COND text(int value);

	HAVING_PRE_COND field(Field value);

	HAVING_START not();

}