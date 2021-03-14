package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IndividualDaoJdbc {

	@Autowired
	JdbcTemplate jdbc;

	public int insertMember(String userid)  throws DataAccessException {


		int rowNumber = jdbc.update("insert into line_member("
				+ " userid)"
				+ " values(?)"
				, userid);

		return rowNumber;

	}

	public int deleteMember(String userid)  throws DataAccessException {


		int rowNumber = jdbc.update("delete from line_member where userid=?", userid);

		return rowNumber;

	}

}
