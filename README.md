# JUnit Test with MetaCoding                

## 테스트를 하는 이유

사과주스 만들기 (본코드)

1. 사과와 물을 전달한다. - 있는지 체크
2. 사과와 물을 갈아버린다. - 1cm 이하로 갈아졌는지 체크
3. 설탕을 첨가한다. - 당도가 5% 이상인지 체크
4. 주스통에 음료를 넣는다. - 1cm 이하만 들어가는 깔떼기를 통해 주스통에 80%이상 들어왔는지 체크

만약 이러한 과정을 거져서 만들어지는 사과주스에서 한 통을 꺼내서 확인해 보니 주스가 들어있지 않았다.   
그렇다면, 어디서부터 문제가 발생했는지 어떻게 확인이 가능할까?
1~4번의 기능 각각을 테스트 해보면 어떤 기능에서 문제가 발생했는지 확인이 가능하다.   
__그럼 굳이 테스트 케이스를 작성할 필요가 없지 않은가라는 의문을 가질 수 있다.__  

그 때 소비자들로부터 요구사항이 들어온다.    
사과주스의 식감을 위해 2cm로 갈아주세요.    

개발자는 해당 기능을 담당하는 2번째 기능을 수정하였다. 그럼 쉽게 끝이 난걸까?   
아쉽지만 4번째 기능에서도 문제가 발생하게 된다. 이러한 문제들은 코드가 늘어날 수록 기하급수적으로 많아지게 된다.   
그렇기에 1~4번까지의 전체 테스트 케이스가 있어야 통합테스트를 통해서 중간에 변경되어도 다른 영향 받는 부분에서 어떤 문제가 발생했는지를 쉽게 확인이 가능하다.

### 정리 
- 메서드는 하나의 기능만 담당한다. - 책임을 분리시킬 수 있기 때문에
- 각 기능마다 테스트 코드를 작성하면 유지 보수하기 좋다. 
- 시간 단축 (생산성 향상)

