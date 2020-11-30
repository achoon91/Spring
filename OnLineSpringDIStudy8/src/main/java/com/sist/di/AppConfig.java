package com.sist.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*
 * 		�޸� �Ҵ�
 * 		@Component : �Ϲ� Ŭ���� (VO, MainClass..)
 * 		@Repository : DAO
 * 		@Controller : Model
 * 		@Service : Manager, DAO+DAO
 * 		@RestController : ���� ���� ���� �Ϲ� ���ڿ� ���� (Ajax, React...)
 * 		======> Spring
 * 				=======
 * 				1. DI , Container ����
 * 				2. AOP VS OOP
 * 				3. DAO VS Service		
 * 
 * 		���� (Inject) (�޸𸮿� ����� ��ü �ּҸ� ������ �ö� ���),�Ϲݺ����� ����� �� ����
 * 		= @Autowired : ���������� ����� Ŭ�����߿� �´� �ּҸ� ã�Ƽ� �ڵ� ����
 * 	==============================
 * 		= @Resource 
 * 		= @Quailifier
 * 		= @Inject
 * 	=============================== Ư����ü�� ������ ���
 */


@Configuration
@ComponentScan(basePackages={"com.sist.di"})
public class AppConfig {
	
}
