package com.java.util.batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.java.dto.Employee;

//When job is completed
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport{
	
	private final JdbcTemplate template;
	
	JobCompletionNotificationListener(JdbcTemplate template){
		this.template= template;
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus()==BatchStatus.COMPLETED) {
			List<Employee> results= template.query("select name, emailId, marks from Employee",new RowMapper<Employee>() {
			
				@Override
				public Employee mapRow(ResultSet rs, int row) throws SQLException  {
					return new Employee(rs.getString(1), rs.getString(2), rs.getFloat(3));
				}
			});
		}
	}

}
