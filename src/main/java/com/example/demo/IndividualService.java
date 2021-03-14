package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IndividualService {

	@Autowired
	IndividualDaoJdbc individualDao;

	public void insert(String userid) {

		System.out.println("insert member");

		int rowNumber = individualDao.insertMember(userid);

		if(rowNumber > 0) {
			System.out.println("Success");
		}

	}


}
