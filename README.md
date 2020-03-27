### lombok

- @Data : Getter, Setter, ToString, @EqualsAndHashCode 을 모두 포함하는 어노테이션
- 기존에 쓰던 이클립스에서 이 프로젝트를 import시 lombok 관련 설정들이 다 에러가 났다. java -jar lombok.jar를 해도 해결되지 않았고 기존 이클립스에 설정된  lombok.jar를 지우고 m2프로젝트의 lombok.jar로 java -jar 로 실행하면 해당 문제가 해결된다.

 
### session 

- JSESSIONID로 유저를 판별한다.


### spring 

- name 속성을 통해서도 bean을 찾을 수 있다.
- di : 생성자를 통해 주입할때는 런타임에 한번만 주입이 필요할 경우에 사용하고 setter를 통해 주입할 경우에는 디펜던시의 상태의 변경이 필요한 경우에 사용한다. 보통은 프로그램의 복잡도가 높아지기 때문에 생성자를 사용하는 것이 좋다.
- @Autowired : bean & bean 의 관계를 연결시켜준다.
- @Configuration : bean으로 등록되고 스프링 설정과 관련된 것이라는 것을 알려준다.
- bean의 이름은 그 메소드명으로 설정된다.
- @Component : 런타임에 동작하고 자동적으로 detecting하여 bean으로 등록한다. 
- @Repository : dao에서 엑세스 할 수 있는 bean이다라고 하는 설정.
- @Service : 비즈니스로직의 서비스를 당당하믄 bean이다. 
- spring-context-indexer : ComponentScan을 빠르게 하기 위한 indexer. build시에 META-INF하위에 spring.componeents가 생긴다.
- @Bean에 initMethod, destroyMethod 를 지정 할 수 있다.

### Annotation VS XML

- xml로 설정시 장점은 xml만 보고도 스프링의 설정을 볼 수 있고 코드와 분리가 가능하다. 하지만 설정이 많을 경우 xml이 너무 커져 보기 힘들어진다. 
- Annotaion을 사용시 코드와 설정의 분리가 애매해질 수 있다. 결국 상황에 따라 적절하게 사용해야 한다. 
