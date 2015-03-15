package org.janus.fluentSql;

public interface SQL {
	SELECT select();

	CREATE create(String name);
}