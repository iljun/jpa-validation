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
