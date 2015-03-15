package org.janus.fluentSql;

public interface ORDER {

	ORDER asc();

	ORDER desc();

	ORDER column(int value);

	ORDER column(Field value);

}