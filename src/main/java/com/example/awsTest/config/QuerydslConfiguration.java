package com.example.awsTest.config;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.function.Supplier;

@Configuration
public class QuerydslConfiguration {

	@PersistenceContext
	private EntityManager entityManager;
	
//	@Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setShowSql(true);
//        adapter.setDatabase(Database.MYSQL);
//       // package to CustomMysqlDialect
//        adapter.setDatabasePlatform("com.cynpd.api_v2.config.MySqlCustomDialect");
//        adapter.setGenerateDdl(false);
//        return adapter;
//    }
	
	@Bean
	public JPAQueryFactory jpaQueryFactory() {
		return new JPAQueryFactory(entityManager);
	}

	public static BooleanBuilder nullSafeBuilder(Supplier<BooleanExpression> f) {
		try {
			return new BooleanBuilder(f.get());
		} catch (IllegalArgumentException | NullPointerException e) {
			return new BooleanBuilder();
		}

		//참고 : https://www.inflearn.com/questions/94056
	}
}
