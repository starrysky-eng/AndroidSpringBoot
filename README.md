# AndroidSpringBoot
### **SpringBoot Connect To MySql**

自动生成表

@Entity 用Entity修饰实体类并同时根据类中的成员变数生成表与列 表名自动以类名显示

**要达到以上操作还需要以下几点**

1. application.properties文件中的设置必须要有以下几点

```jsx
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

 2.  启动类

```jsx
@EntityScan(basePackages = ["com.example.DIM.model"])
```
