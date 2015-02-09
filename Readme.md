# Mybatis Pagination
Mybatis 的分页插件，支持Mysql、MSSQL、Oracle、MSSQL2005、Postgre SQL、DB2.
在[sogyf/mybatis-pagination](https://github.com/sogyf/mybatis-pagination) 的基础上实现

## 如何使用
1.
2.
3.

## 其他 

### 为什么写这个插件
Mybatis自带的分页实现，在数据量大的时候（通常在1w条以上），存在性能问题。见测试PaginationQueryTest，下面是测试结果：

    执行mybatis自带分页查询，总记录数：10000，每页10，共1000页
    用时(毫秒)：4954
    
    执行分页插件查询，总记录数：10000，每页10，共1000页
    用时(毫秒)：4694
    
    执行分页插件查询，总记录数：100000，每页10，共10000页
    用时(毫秒)：105678
    
    执行mybatis自带分页查询，总记录数：100000，每页10，共10000页
    用时(毫秒)：217643


### 反馈

### ToDo

