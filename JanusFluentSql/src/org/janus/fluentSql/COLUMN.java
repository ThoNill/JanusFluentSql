package org.janus.fluentSql;

public interface COLUMN extends Reduziert {

	COLUMN as(String name);

	COLUMN column(String name);

	COLUMN column(Field name);

	FROM from(String name);

}