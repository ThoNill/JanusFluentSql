package test.janus.data;

import static org.janus.fluentSql.Function.max;
import static org.janus.fluentSql.SqlCreator.column;
import static org.janus.fluentSql.SqlCreator.create;
import static org.janus.fluentSql.SqlCreator.expr;
import static org.janus.fluentSql.SqlCreator.field;
import static org.janus.fluentSql.SqlCreator.select;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static test.janus.tables.Tables.adresse;
import static test.janus.tables.Tables.blz;
import static test.janus.tables.Tables.kunde;

import org.apache.log4j.Logger;
import org.janus.fluentSql.Field;
import org.junit.Test;

public class FluentSqlTest {
    private static final String EXCEPTION_ERWARTET = "Exception erwartet";
    private static final Logger LOG = Logger.getLogger(FluentSqlTest.class);


	public FluentSqlTest() {
	}

	@Test
	public void selectTest() {
		Object s = select();
		try {
			s.toString();
			fail("Es trat keine Exception auf!");
		} catch (Exception e1) {
		    LOG.error(EXCEPTION_ERWARTET,e1);
		}

		s = select().column("name").from("kunde");
		assertEquals("select name from kunde", s.toString());

		s = select().column("name").column("plz").from("kunde");
		assertEquals("select name , plz from kunde", s.toString());

		s = select().column("name").as("Kundenname").column("plz")
				.from("kunde");
		assertEquals("select name as \"Kundenname\" , plz from kunde",
				s.toString());

		s = select(column("name").as("Kundenname"), column("plz"))
				.from("kunde");
		assertEquals("select name as \"Kundenname\" , plz from kunde",
				s.toString());

		s = select(column("name").as("Kundenname"), column("plz"))
				.from("kunde").alias("a");
		assertEquals("select name as \"Kundenname\" , plz from kunde a",
				s.toString());

		s = select(column("name").as("Kundenname"), column("plz"))
				.from("kunde").and("adresse").alias("a");
		assertEquals(
				"select name as \"Kundenname\" , plz from kunde , adresse a",
				s.toString());

	}

	@Test
	public void whereTest() {

		Object s = null;
		try {
			s = select(column("name").as("Kundenname"), column("plz"))
					.from("kunde").and("adresse").alias("a").where();
			s.toString();
			fail("Es trat keine Exception auf!");
		} catch (Exception e1) {
		    LOG.error(EXCEPTION_ERWARTET,e1);
		}
		try {
			s = select(column("name").as("Kundenname"), column("plz"))
					.from("kunde").and("adresse").alias("a").where()
					.field(kunde.name());
			s.toString();
			fail("Es trat keine Exception auf!");
		} catch (Exception e1) {
		    LOG.error(EXCEPTION_ERWARTET,e1);
		}
		try {
			s = select(column("name").as("Kundenname"), column("plz"))
					.from("kunde").and("adresse").alias("a").where()
					.field(kunde.name()).eq();
			s.toString();
			fail("Es trat keine Exception auf!");
		} catch (Exception e1) {
		    LOG.error(EXCEPTION_ERWARTET,e1);
		}

		s = select(column("name").as("Kundenname"), column("plz"))
				.from("kunde").and("adresse").alias("a").where()
				.field(kunde.name()).eq().field(blz.iban());
		assertEquals(
				"select name as \"Kundenname\" , plz from kunde , adresse a where kunde.name = blz.iban",
				s.toString());

		s = select(column("name").as("Kundenname"), column("plz"))
				.from("kunde").and("adresse").alias("a").where()
				.field(kunde.name()).isNull();
		assertEquals(
				"select name as \"Kundenname\" , plz from kunde , adresse a where kunde.name is null",
				s.toString());

		s = select(column("name").as("Kundenname"), column("plz"))
				.from("kunde").and("adresse").alias("a").where()
				.field(kunde.name()).notNull();
		assertEquals(
				"select name as \"Kundenname\" , plz from kunde , adresse a where kunde.name is not null",
				s.toString());

		s = select(column("name").as("Kundenname"), column("plz"))
				.from("kunde").and("adresse").alias("a").where()
				.field(kunde.name()).like("a%");
		assertEquals(
				"select name as \"Kundenname\" , plz from kunde , adresse a where kunde.name like ( \"a%\" )",
				s.toString());

	}

	@Test
	public void groupByTest() {
		Object s = null;
		try {
			s = select(column("name").as("Kundenname"), column("plz"))
					.from("kunde").and("adresse").alias("a").where()
					.field(kunde.name()).eq().field(blz.iban()).groupBy();
			s.toString();
			fail("Es trat keine Exception auf!");
		} catch (Exception e1) {
		    LOG.error(EXCEPTION_ERWARTET,e1);
		}
		s = select(column("name").as("Kundenname"), column("plz"))
				.from("kunde").and("adresse").alias("a").where()
				.field(kunde.name()).eq().field(blz.iban()).groupBy()
				.column(blz.iban());
		assertEquals(
				"select name as \"Kundenname\" , plz from kunde , adresse a where kunde.name = blz.iban group by blz.iban",
				s.toString());

	}

	@Test
	public void orderByTest() {
		Object s = null;
		try {
			s = select(column("name").as("Kundenname"), column("plz"))
					.from("kunde").and("adresse").alias("a").where()
					.field(kunde.name()).eq().field(blz.iban()).groupBy()
					.column(blz.iban()).orderBy();
			s.toString();
			fail("Es trat keine Exception auf!");
		} catch (Exception e1) {
		    LOG.error(EXCEPTION_ERWARTET,e1);
		}
		s = select(column("name").as("Kundenname"), column("plz"))
				.from("kunde").and("adresse").alias("a").where()
				.field(kunde.name()).eq().field(blz.iban()).groupBy()
				.column(blz.iban()).orderBy().column(blz.iban());
		assertEquals(
				"select name as \"Kundenname\" , plz from kunde , adresse a where kunde.name = blz.iban group by blz.iban order by blz.iban",
				s.toString());

		s = select(column("name").as("Kundenname"), column("plz"))
				.from("kunde").and("adresse").alias("a").where()
				.field(kunde.name()).eq().field(blz.iban()).groupBy()
				.column(blz.iban()).orderBy().column(blz.iban()).desc();
		assertEquals(
				"select name as \"Kundenname\" , plz from kunde , adresse a where kunde.name = blz.iban group by blz.iban order by blz.iban desc",
				s.toString());

	}

	@Test
	public void createTest() {
		Object s = create("Kunde");

		try {
			s.toString();
			fail("Es trat keine Exception auf!");
		} catch (Exception e1) {
		    LOG.error(EXCEPTION_ERWARTET,e1);
		}

		s = create("Kunde").field("name").t_char(20);
		assertEquals("create table Kunde ( name char(20) )", s.toString());

		s = create("Kunde").field("name").t_char(20).field("plz").t_char(10);
		assertEquals("create table Kunde ( name char(20) , plz char(10) )",
				s.toString());

		s = create("Kunde", field("name").t_char(20), field("plz").t_char(10));
		assertEquals("create table Kunde ( name char(20) , plz char(10) )",
				s.toString());

	}

	@Test
	public void tableTest() {
		Field s = kunde.name();
		assertEquals("kunde.name", s.getName());

		s = blz.iban();
		assertEquals("blz.iban", s.getName());

		Object o = select().column(kunde.name()).column(adresse.ort())
				.from("kunde");
		assertEquals("select kunde.name , adresse.ort from kunde", o.toString());

	}

	@Test
	public void expressionTest() {
		Object s = expr().value(2).plus().fo(max).value(kunde.name()).fc(max);
		assertEquals("2 + max( kunde.name )", s.toString());

		s = expr().value(kunde.name()).plus().neg().value(blz.iban());
		assertEquals("kunde.name + - blz.iban", s.toString());

	}

}
