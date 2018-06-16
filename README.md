# jpa-validation

validtion example

## validation
jpa를 이용하고 어노테이션을 이용한 validation

@Valid를 이용할시 MethodArgumentNotValidException이 발생하기 때문에 

@ControllerAdvice에서 처리 

* 장점
  * 어노테이션 사용으로 간결하다.
  * MethodArgumentNotValidException에서 모든 처리가 가능하다.
* 단점
  * 상세한 validation이 힘들다.
  * Dto마다 어노테이션이 필요하다.
  * 과도한 어노테이션은 가독성 저하

## validator
Spring validator를 이용한 validation 검증

BindingResult를 Exception에서 처리했으며,

메세지는 messages에 따로 저장해서 사용했다.

* 장점
 * 메세지를 한곳에서 관리 가능
* 단점
 * 메세지 파일이 너무 커진다.
 * 이미 구현된 validator를 재사용이 가능
 * Controller에 if문이 기본적으로 추가된다. -> 이부분은 추후 보완
 * 하나의 validation이 필요한 객체마다 validator가 필요하다.
