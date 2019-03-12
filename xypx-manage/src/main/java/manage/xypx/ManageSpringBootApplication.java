package manage.xypx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages="manage.xypx.DAO")//扫描所有映射接口
@SpringBootApplication
public class ManageSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageSpringBootApplication.class, args);
	}

}
