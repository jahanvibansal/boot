package com.java.util.batch;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.java.dto.Employee;

@Configuration
public class BatchJobConfiguration {

	@Autowired
	public DataSource datasource;

	@Autowired
	public JobBuilderFactory jobBuilder;

	@Autowired
	public StepBuilderFactory stepBuilder;

	@Bean
	public FlatFileItemReader<Employee> reader() {
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("employee.csv"));
		reader.setLineMapper(new DefaultLineMapper<Employee>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {

					{
						setNames(new String[] { "name", "emailId", "marks" });
					}
				});

				setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
					{
						setTargetType(Employee.class);
					}
				});
			}

		});

		return reader;
	}
	
	@Bean
	public EmployeeProcessor getProcessor() {
		return new EmployeeProcessor();
	}
	
	@Bean public JdbcBatchItemWriter<Employee> writer(){
		JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<Employee>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		writer.setSql("Insert into Employee (name, emailId, marks) values (:name, :emailId, :marks)");
		writer.setDataSource(datasource);
		return writer;
	}
	
	@Bean public Job importUserJob(JobCompletionNotificationListener listener) {
		return jobBuilder.get("importUserJob").incrementer(new RunIdIncrementer())
				.listener(listener).flow(step1()).end().build();
	}

	private Step step1() {
		return stepBuilder.get("step1").<Employee, Employee>chunk(10).reader(reader()).processor(getProcessor()).writer(writer()).build();
	}
}
