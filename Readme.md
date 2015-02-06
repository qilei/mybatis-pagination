# Mybatis Pagination
Mybatis 的分页插件，支持Mysql、MSSQL、Oracle、MSSQL2005、Postgre SQL、DB2.

## 如何使用
1.
2.
3.

## 其他 

### 为什么写这个插件
1. Mybatis自带的分页实现，

### 源码

### 反馈

### ToDo

## Basic Usage
in the Mybatis config, add the plugin.
	
	 <plugins>
        <plugin interceptor="org.mybatis.pagination.PaginationInterceptor">
              <property name="dbms" value="mysql"/>
              <property name="sqlRegex" value=".*findAll.*"/>
        </plugin>
    </plugins>

* `dbms`，database type. MYSQL\MSSQL\ORACLE\MSSQL2005\DB2
* `sqlRegex` the mapper method/ sql mapper xml's id, regex string.
	* example `.*findAll.*` contain `findAll` query sql

### Sql Mapper config
	
	<select id="findAllDict"
            resultType="org.noo.module.Dict">
        SELECT
          ID,CREATORTIME,DATASOURCE,DATATYPE,DICTNAME,DICTNUMBER,ENABLE,RENEWTIME,SORT
         from CD_DICT ORDER BY SORT
    </select>

# Spring usage

@see [config](https://github.com/yfyang/mybatis-pagination/blob/master/src/test/resources/spring/test-context.xml) And [TestCase](https://github.com/yfyang/mybatis-pagination/tree/master/src/test/java/org/mybatis/pagination/service)

# Maven Usage

1. add repositories into you project `pom.xml`

        <repositories>
            <repository>
                <id>yfyang-mvn-repo</id>
                <url>https://raw.github.com/yfyang/mybatis-pagination/mvn-repo/</url>
                <snapshots>
                    <enabled>true</enabled>
                    <updatePolicy>always</updatePolicy>
                </snapshots>
            </repository>
        </repositories>

2. add propertie into `pom.xml`:properties
		
        <properties>
            <org.mybatis.pagination.version>0.0.3</org.mybatis.pagination.version>
        </properties>

3. add dependency into `pom.xml`

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-pagination</artifactId>
            <version>${org.mybatis.pagination.version}</version>
        </dependency>
