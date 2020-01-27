# 生成代码
```
用法:
-DprojectPath=? -Ddatabase=? -DpkgName=? -DtablePrefix=* -Dhost=127.0.0.1 -Dport=3306 -DuserName=root -DuserPwd=123456
实例:
java -DprojectPath=$(pwd)/xxx -Ddatabase=auth8 -DpkgName=io.cutita.dao -DtablePrefix=t_ -jar tools/generator-all-1.0.0.jar
```
# 修改pom.xml
```
	<dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```
