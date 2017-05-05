package cn.linpeng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import junit.framework.TestCase;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;


public class JooqTest extends TestCase {

	public void test() {
		String userName = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/library";

		try (Connection conn = DriverManager.getConnection(url, userName,
				password)) {
			DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
//			Result<Record> result = create.select().from(Author.AUTHOR).fetch();
			

//			for (Record record : result) {
//				Integer id = record.getValue(Author.AUTHOR.ID);
//				String firstName = record.getValue(Author.AUTHOR.FIRST_NAME);
//				String lastName = record.getValue(Author.AUTHOR.LAST_NAME);
//
//				System.out.println("ID: " + id + " first name: " + firstName
//						+ " last name: " + lastName);
//			}
//			List<Author> list =  create.select().from(Author.AUTHOR).fetchInto(Author.class);
//			for (Author author : list) {
//				System.out.println(author);
//			}
			// Assert.assertNotNull(result);
		}

		// For the sake of this tutorial, let's keep exception handling simple
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
