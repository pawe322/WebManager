package com.pawe322.webmanager.junit.conn;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pawe322.webmanager.conn.ConnectionUtils;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ConnectionUtilsTest {
	Connection conn;

	@Before
	public void before() throws ClassNotFoundException, SQLException {
		conn = ConnectionUtils.getConnection();
	}
	
	@After
	public void after() {
		ConnectionUtils.closeQuietly(conn);
	}
	
	@Test
	public void getConnectionShouldGetConnection() throws SQLException {
		Assert.assertEquals(true, conn.isValid(100));
	}

	@Test
	public void closeQuietlyShouldEndConnection() throws SQLException {
		ConnectionUtils.closeQuietly(conn);
		Assert.assertEquals(true, conn.isClosed());
	}
}
