package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IndividualService {

	@Autowired
	IndividualDaoJdbc individualDao;

	public boolean insert(String userid) {

		int rowNumber = individualDao.insertMember(userid);

		boolean result = false;

		if(rowNumber > 0) {
			result = true;
		}

		return result;

	}


}
