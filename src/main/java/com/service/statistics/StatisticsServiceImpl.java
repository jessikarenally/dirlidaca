package com.service.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.problem.ProblemServiceImpl;
import com.service.user.UserServiceImpl;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	
	@Autowired
	ProblemServiceImpl problemService;
	
	@Autowired
	UserServiceImpl userService;

	@Override
	public String getGeneralStatistics() {
		long qntProblems = problemService.countProblems();
		long qntUsers = userService.countUsers();
		String result = String.format("Problemas existentes: %s \n Usuarios do sistema: %s", qntProblems, qntUsers);
		
		return result;
	}

}
