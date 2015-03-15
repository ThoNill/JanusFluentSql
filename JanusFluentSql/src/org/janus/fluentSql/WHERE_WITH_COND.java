package org.janus.fluentSql;

public interface WHERE_WITH_COND {

	WHERE_END integer(int value);

	WHERE_END text(int value);

	WHERE_END field(Field value);

	WHERE_PRE_COND field(String name);

}