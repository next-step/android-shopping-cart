# android-shopping-cart

## STEP-1
1. 상단 타이틀 추가
2. 상단 우측 아이콘 추가
3. 상품 목록 구현
- 상품 목록 아이템
    - 이미지
    - 상품 이름 텍스트
    - 상품 가격 텍스트

## STEP-2
1. 피드백 개선 사항
- 불필요한 Extension 제거
- products remember 제거
- columns Fixed로 수정
2. 상품 상세 화면 구현
- 상단 타이틀 구현
- 상단 좌측 아이콘 추가
- 상품 이미지
- 상품 이름
- 상품 금액
- 장바구니 담기 버튼
3. 장바구니 화면
- 상단 타이틀 구현
- 상단 좌측 아이콘 추가
4. 화면 전환 구현

## STEP-3
1. 피드백 개선 사항
- ShoppingTopBar : CenterAlignedTopAppBar 사용
- ShoppingDetailScreen : product - remember 사용
- ShoppingDetailScreen : 상품 영역, 금액 관련 영역 분리
- ShoppingDetailScreen : Column Depth 줄이기
2. 장바구니 화면 UI
- 장바구니 담긴 아이템
    - 상품 이름,사진 금액
    - 수량 텍스트
    - 수량 +,- 버튼
    - x 버튼
- 주문하기 버튼 총액 추가
3. 장바구니 기능 구현
- 상세 화면에서 장바구니 담기 기능
- 수량 조절 기능
- 수량 1개 미만 or x버튼 클릭 시 제거되는 기능
- 상품 가격 총합 표시 기능
4. 장바구니 화면 테스트

## STEP-4
1. 피드백 개선 사항
    - CartScreenTest 개선
        - mutableStateOf 사용에 대해
        - onMinusClick 등 click 이벤트 개선
    - wrapContentWidth, wrapContentHeight 관련 개선
    - CartItemComponent Preview 개선
        - 음수, 1개 인 경우
        - interactive mode 테스트
    - ShoppingCenterAlignedTopBar 장바구니 Preview
    - 사용하지 않는 ColumnScope 제거
    - ShoppingCartScreen Preview 추가
2. 상품 목록에서 상품에 상품 담기 및 수량 조절 버튼 추가
    - + 버튼 추가
    - 수량 조절 버튼 추가
    - +버튼과 수량 조절 버튼 중에 장바구니에 담겨있는 개수에 따라 알맞게 보이는 기능
    - 상품 목록의 상품 수와 장바구니 상품 수 동기화
3. 테스트

## STEP-4-1
1. 피드백 개선 사항
    - ShoppingItemComponent Preview3 제거
    - ShoppingItemComponent CounterCard - horizontalArrangement 활용
    - count 99 조건 삭제
      - 삭제 시 UI 확인
    - 사용하지 않는 Modifier 생략
