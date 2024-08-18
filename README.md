# android-shopping-cart

## Step1 구현 목록

- [x] dummy data 생성
- [x] Glide 설정
- [x] 타이틀 뷰 구현
- [x] 상품 아이템 뷰 구현
- [x] 상품 리스트 뷰 구현
- [x] dummy data 변경
- [] 테스트 코드 작성

## Step1 진행 중 의식의 흐름

- TDD로 해야 하는데... 하지만 아직 컴포즈 숙달에 좀 더 집중하고자 일단 뷰부터 구현했습니다.
- Title을 만들다가 갑자기 AppBar 관련 컴포넌트가 있을 것 같아서 찾아보니 TopAppBar라는 것이 있는 것을 알게 되었습니다. 그래서 이걸 사용해 보려고 합니다.
- LazyColumn이 있는데 왜 Column이 있을까요? 간단한 레이아웃을 그릴 때는 굳이 LazyColumn을 사용할 필요가 없을 것 같습니다. 예를 들어 스크롤이 발생하면서
  여러 데이터를 갱신할 필요가 없다면 한 번에 렌더링 되면 그만이기 때문입니다.
- ProductItem에서 컴포넌트를 더 나눠야 할까요? 아이템 내부에 각 컴포넌트도 나누면 너무 잘게 나눠진다고 느껴집니다. 그래서 일단은 하나로 묶었습니다. 