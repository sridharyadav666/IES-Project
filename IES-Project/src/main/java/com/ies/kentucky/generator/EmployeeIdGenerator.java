package com.ies.kentucky.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeIdGenerator implements IdentifierGenerator {

	
	private final String sql ="select emp_id_seq.nextval from dual";

	private final String prefix= "IES";
	String suffix = null;
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		
		try {
			
		Connection con = session.connection();
		Statement stmnt = con.createStatement();
				
		ResultSet rs = stmnt.executeQuery(sql);
		
		if(rs.next()) {
			int seqval=rs.getInt(1);
			suffix = String.valueOf(seqval);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return prefix + suffix;
	}

}
