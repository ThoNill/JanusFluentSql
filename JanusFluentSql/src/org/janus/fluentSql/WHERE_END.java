package org.janus.fluentSql;

public interface WHERE_END {

	WHERE_START and();

	WHERE_START or();

	GROUP_START groupBy();

	ORDER_START orderBy();

}