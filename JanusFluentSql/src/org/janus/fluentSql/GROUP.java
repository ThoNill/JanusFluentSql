package org.janus.fluentSql;

public interface GROUP {

	GROUP column(int value);

	GROUP column(Field value);

	ORDER_START orderBy();

	HAVING_START having();

}