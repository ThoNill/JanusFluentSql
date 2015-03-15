package org.janus.fluentSql;

public interface FROM {

	WHERE_START where();

	GROUP_START groupBy();

	ORDER_START orderBy();

	FROM and(String name);

	FROM alias(String name);

}