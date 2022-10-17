# student_management_system

Student Management System ( Spring Boot + Thymeleaf)

create database sms
use root as username and root as password
or configure application.props**

spring.datasource.url=jdbc:mysql://localhost:3306/sms?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
spring.datasource.password=root

#Hibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

#Hibernate  auto ddl
spring.jpa.hibernate.ddl-auto=update

logging.level.org.hibernate.sql=DEBUG

#verbose Mysql
spring.jpa.show-sql=true
