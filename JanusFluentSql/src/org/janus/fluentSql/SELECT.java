package org.janus.fluentSql;

public interface SELECT {

	COLUMN column(String name);

	COLUMN column(Field name);

}