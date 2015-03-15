package org.janus.fluentSql;

public interface INCOMPLETEEXPRESSION {

	INCOMPLETEEXPRESSION neg();

	INCOMPLETEEXPRESSION o();

	INCOMPLETEEXPRESSION fo(Function f);

	EXPRESSION value(String name);

	EXPRESSION value(int value);

	EXPRESSION value(Field field);

}