
package test.janus.data;



import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.janus.fluentSql.SqlCreator.create;
import static org.janus.fluentSql.SqlCreator.select;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.janus.actions.DataValue;
import org.janus.actions.HandleValue;
import org.janus.data.DataDescription;
import org.janus.data.DataDescriptionImpl;
import org.janus.database.DataContextWithConnection;
import org.janus.database.SqlStatement;
import org.junit.Before;
import org.junit.Test;

import test.janus.db.ConnectionSource;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;

public class SqlStatementTest {
    public static final Logger LOG = Logger.getLogger(SqlStatementTest.class);

	public SqlStatementTest() {
	}

	@Before
	public void prepare() throws Exception {
		DataSource dataSource = ConnectionSource.getDataSource();
		try (Connection con = dataSource.getConnection()) {
			Object sql = create("VENDOR").field("ID").t_int().field("NAME")
					.t_char(20);
			Statement stmt = con.createStatement();
			stmt.execute(sql.toString());
			stmt.close();
		} catch (SQLException ex) {
			if (ex.getErrorCode() != 30000) {
				LOG.error("Fehler",ex);
			} else {
			    LOG.warn(ex);
			}
		}

		Operation operation = sequenceOf(deleteAllFrom("VENDOR"),
				insertInto("VENDOR").columns("ID", "NAME").values(1, "Amazon")
						.values(2, "PriceMinister").build());
		DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource),
				operation);
		// or without DataSource:
		// DbSetup dbSetup = new DbSetup(new
		// DriverManagerDestination(TEST_DB_URL, TEST_DB_USER,
		// TEST_DB_PASSWORD), operation);
		dbSetup.launch();
	}

	@Test
	public void test1() {
		DataDescriptionImpl description = new DataDescriptionImpl();

		Object sql = select().column("NAME").from("VENDOR").where().field("ID")
				.eq().integer(1);

		try {
			TestAction testAction = new TestAction();
			SqlStatement stmt = new SqlStatement("test", sql.toString());
			stmt.addAction(testAction);
			stmt.configure(description);

			DataContextWithConnection context = new DataContextWithConnection(
					description);
			context.setConnectionSource(ConnectionSource.getDataSource());
			stmt.perform(context);

			assertEquals(1, testAction.performed);

		} catch (Exception e) {
			LOG.error("unerwartete Exception",e);;
			fail(e.getMessage());
		}
	}

	@Test
	public void test2() {
		DataDescriptionImpl description = new DataDescriptionImpl();

		Object sql = select().column("ID").column("NAME").from("VENDOR")
				.orderBy().column(1);

		try {
			TestAction testAction = new TestAction();
			DataValue a = new HandleValue("a");
			DataValue b = new HandleValue("b");

			SqlStatement stmt = new SqlStatement("test", sql.toString());
			stmt.addAction(testAction);
			stmt.addValue(a);
			stmt.addValue(b);

			stmt.configure(description);

			DataContextWithConnection context = new DataContextWithConnection(
					description);
			context.setConnectionSource(ConnectionSource.getDataSource());
			stmt.perform(context);

			assertEquals("PriceMinister", b.getObject(context).toString()
					.trim());
			assertEquals(2, testAction.performed);

		} catch (Exception e) {
		    LOG.error("unerwartete Exception ",e);
			fail(e.getMessage());
		}
	}

	@Test
	public void test3() {
		DataDescriptionImpl description = new DataDescriptionImpl();

		Object sql = select().column("ID").column("NAME").from("VENDOR")
				.orderBy().column(1);

		try {
			TestAction testAction = new TestAction();
			DataValue a = new HandleValue("a");
			DataValue b = new HandleValue("b");

			SqlStatement stmt = new SqlStatement("test", sql.toString());
			stmt.prepare(false);
			stmt.addAction(testAction);
			stmt.addValue(a);
			stmt.addValue(b);

			stmt.configure(description);

			DataContextWithConnection context = new DataContextWithConnection(
					description);
			context.setConnectionSource(ConnectionSource.getDataSource());
			stmt.perform(context);

			assertEquals("PriceMinister", b.getObject(context).toString()
					.trim());
			assertEquals(2, testAction.performed);

		} catch (Exception e) {
		    LOG.error("unerwartete Exception ",e);
			fail(e.getMessage());
		}
	}

}
