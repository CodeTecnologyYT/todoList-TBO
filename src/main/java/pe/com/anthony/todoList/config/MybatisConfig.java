package pe.com.anthony.todoList.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan(basePackages = {"pe.com.anthony.todoList.repository"}, annotationClass = Repository.class, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {
    public final String TYPE_ALIASES_PACKAGE = "pe.com.anthony.todoList";
    public final String TYPE_HANDLERS_PACKAGE = "pe.com.anthony.todoList.handler";
    public final String MAPPER_LOCATIONS_PATH = "classpath:sqlmap/mapper/*.xml";
    public final String MAPPER_LOCATIONS_CONFIG = "sqlmap/mybatis-config.xml";

    public static final String DRIVER="oracle.jdbc.driver.OracleDriver";
    public static final String URL="jdbc:oracle:thin:@192.168.1.13:1521:XE";
    public static final String USERNAME="C##BRYAN";
    public static final String PASSWORD="1234";

    @Bean( name="dataSource",destroyMethod = "")
    public DataSource getDataSource(){
        PooledDataSource datasource= new PooledDataSource();
        datasource.setDriver(DRIVER);
        datasource.setUrl(URL);
        datasource.setUsername(USERNAME);
        datasource.setPassword(PASSWORD);
        return datasource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean= new SqlSessionFactoryBean();
        configureSqlSessionFactory(sessionFactoryBean,dataSource);
        return sessionFactoryBean.getObject();
    }

    public void configureSqlSessionFactory(SqlSessionFactoryBean sessionFactoryBean,DataSource dataSource) throws IOException {
        PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
        sessionFactoryBean.setTypeHandlersPackage(TYPE_HANDLERS_PACKAGE);
        sessionFactoryBean.setConfigLocation(new ClassPathResource(MAPPER_LOCATIONS_CONFIG));
        sessionFactoryBean.setMapperLocations(pathResolver.getResources(MAPPER_LOCATIONS_PATH));
    }

}
