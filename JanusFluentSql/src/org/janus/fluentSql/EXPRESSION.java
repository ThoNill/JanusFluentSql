package org.janus.fluentSql;

public interface EXPRESSION {

	INCOMPLETEEXPRESSION minus();

	EXPRESSION c();

	EXPRESSION fc(Function f);

	INCOMPLETEEXPRESSION comma();

	INCOMPLETEEXPRESSION plus();

	INCOMPLETEEXPRESSION mul();

	INCOMPLETEEXPRESSION div();

}