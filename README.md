### lombok

- @Data : Getter, Setter, ToString, @EqualsAndHashCode 을 모두 포함하는 어노테이션

 
### session 

- JSESSIONID로 유저를 판별한다.


### spring 

- name 속성을 통해서도 bean을 찾을 수 있다.
- di : 생성자를 통해 주입할때는 런타임에 한번만 주입이 필요할 경우에 사용하고 setter를 통해 주입할 경우에는 디펜던시의 상태의 변경이 필요한 경우에 사용한다. 보통은 프로그램의 복잡도가 높아지기 때문에 생성자를 사용하는 것이 좋다.