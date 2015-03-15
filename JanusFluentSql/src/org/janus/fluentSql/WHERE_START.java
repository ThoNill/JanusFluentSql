package org.janus.fluentSql;

public interface WHERE_START {

	WHERE_PRE_COND integer(int value);

	WHERE_PRE_COND text(int value);

	WHERE_PRE_COND field(Field value);

	WHERE_PRE_COND field(String name);

	WHERE_START not();

}