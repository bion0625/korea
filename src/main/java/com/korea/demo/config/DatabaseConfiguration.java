package com.korea.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @Configuration : 어노테이션이 선언 된 java 클래스는 스프링 IoC Container 에게 해당 파일이 환경 설정과 관련된 파일(Bean 구성 Class)이라는 것을 인식시킨다.
 * 
 * @EnableTransactionManagement : DataSourceTransactionManager @Bean 을 찾아 Transaction Manager로 사용
 * 
 * @MapperScan : 지정된 베이스 패키지에서 DAO/Repository(Mapper) 를 검색하여 등록
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.korea.demo.repository"})
public class DatabaseConfiguration {
	
	/**
	 * application.yml 의 spring.datasource.hikari 옵션을 가져온다.
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		System.out.println("데이터베이스 환경변수 읽어와서 히카리CP 객에체 Config 생성");
		return new HikariConfig();
	}
	
	/**
	 * DataSource 연결
	 * @return
	 * @throws Exception
	 */
	@Bean
	public DataSource dataSource() throws Exception {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println("데이터베이스 : " + dataSource.toString());
		return dataSource;
	}
	
	/**
	 * 트랜잭션 매니저 등록
	 * 트랜잭션 : 더 이상 쪼갤 수 없는 최소 단위의 작업이다. 
	 * 여러 단계의 작업이 처리될 경우 전체 로직이 모두 다 성공 commit / 실패 rollback 해야되는 논리적인 작업의 묶음을 의미
	 * @param dataSource
	 * @return
	 */
	@Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
		System.out.println("트랜잭션 매니저 등록");
        return new DataSourceTransactionManager(dataSource);
    }
	
	/**
	 * mybatis
	 * SqlSessionFactory : 데이터베이스의 연결과 SQL 실행에 대한 정보를 가진 객체
	 * 이 객체가 DataSource 를 참조하여 mybatis 와 DB를 연동
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		System.out.println("세션 팩토리 등록");
		PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(patternResolver.getResources("classpath:/mapper/**/*.xml"));
		return factoryBean.getObject();
	}
	
	/**
	 * mybatis
	 * SqlSessionTemplate : SqlSession 을 구현하고 코드에서 Session 를 대체하는 역할
	 * Thread safe 하게 작성되어  되었다.
	 * SqlSession 으로 작성하면 쿼리문을 수행하는 PreparedStatement 를 직접 생성하여 실행해야 하는데, mybatis 를 사용하면 해당 기능이 내부적으로 자동 처리 된다. 
	 * 
	 * @param factory
	 * @return
	 */
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
		System.out.println("세션 템플릿 등록");
		return new SqlSessionTemplate(factory);
	}
	
}
