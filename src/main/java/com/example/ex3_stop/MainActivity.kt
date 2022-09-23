package com.example.ex3_stop

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import com.example.ex3_stop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //스탑워치를 멈춘 시간
    var pauseTime = 0L
    //뒤로가기버튼의 시간 계산용
    var initTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //스탑워치 기능 구현
        //시작버튼
        binding.startBtn.setOnClickListener {
            //스탑워치 시간 = 부팅부터 현재까지 시간 + 멈춘시간
            binding.chronometer.base=SystemClock.elapsedRealtime()+pauseTime

            binding.chronometer.start() // 스톱워치 시작

            binding.startBtn.isEnabled=false // 선택했다는 표시
            binding.stopBtn.isEnabled=true
            binding.resetBtn.isEnabled=true
        }
        //스탑버튼
        binding.stopBtn.setOnClickListener {
            //멈춘 시간 = 스탑워치 시간 - SystemClock.elpasedRealtime()
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()

            binding.chronometer.stop()  //스톱워치 멈춤

            binding.startBtn.isEnabled=true
            binding.stopBtn.isEnabled=false // 선택했다는 표시
            binding.resetBtn.isEnabled=true
        }
        //리셋버튼
        binding.resetBtn.setOnClickListener {
            //멈춘 시간 초기화
            pauseTime = 0L

            binding.chronometer.base = SystemClock.elapsedRealtime()

            binding.chronometer.stop()

            binding.startBtn.isEnabled=true
            binding.stopBtn.isEnabled=true
            binding.resetBtn.isEnabled=false // 선택했다는 표시
        }

        //기록버튼
        binding.recordBtn.setOnClickListener {
            binding.recordText.text = binding.chronometer.text  // text타입으로 받기
            binding.recordText.setTextColor(Color.parseColor("#000000")) // Text 색깔 변경
            Log.d("myLog","${binding.chronometer.text}")
            Log.d("myLog","${binding.chronometer.base}")
        }

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode === KeyEvent.KEYCODE_BACK){
            //뒤로가기버튼을 처음 눌렀거나, 누른지 3초가 지났을 때
            if(System.currentTimeMillis() - initTime > 3000){
                //LENGTH_SHORT : 메세지 보여주는 시간을 짧게 해줌
                Toast.makeText(this,"종료하려면 한 번 더 누르세요!", Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

}


