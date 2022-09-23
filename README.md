# Android_StopWatch
안드로이드 스탑워치

# 화면
![image](https://user-images.githubusercontent.com/108244911/191909588-0e31da74-1b12-43e5-8aab-de1c415cf9a6.png)

# 추가했던 기능
※ RECORD 버튼 추가
처음엔 또 다른 `Chronometer2를` 만들어 `android:visibility="invisible"` 로 만들어 RECORD버튼을 클릭 시 `visible` 로 변환하여 보이게 끔 할려고 했다.

하지만`invisible` 일 때 스톱워치는 작동하지 않았으며, 클릭 시 0:00으로 고정된 값으로 나왔다.

# 해결방법
`android:textColor="@color/white"` 

`-->``binding.recordText.setTextColor(Color.parseColor("#000000"))` 

글자를 배경색이랑 같은 색으로 만들어주고 클릭 시 배경이랑 대비되는 색으로 바꿔주는 형식으로 바꿈
