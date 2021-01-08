package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async_task.*
import java.lang.Exception

class AsyncTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)
        // Async를 실행하고 정지하는 방법
        var task : BackGroundAsyncTask? = null
        start.setOnClickListener {
            task = BackGroundAsyncTask(progressBar,comment)
            task?.execute() // nullable타입이면 ?를 적어주는 것이 센스
        }
        stop.setOnClickListener {
            task?.cancel(true)
            // cancel의 인자로 true를 넣어주는 이유는 실행을 정지할 것이냐(Interrupt Running)의 여부를 넣어주면 된다(boolean)
        }
    }
}

class BackGroundAsyncTask(
    val progressbar: ProgressBar,
    val progressText: TextView
) : AsyncTask<Int, Int, Int>() { // params, progress, result 라는 제네릭 3개를 꺽쇠안에 넣어줘야한다.
    // params --> doInBackground에서 사용할 타입
    // progress --> onProgressUpdate에서 사용할 타입
    // result --> onPostExecute에서 사용할 타입

    var percent: Int = 0
    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
        // 작업을 시작기 전(doInBackGround가 돌기 전)에는 percent를 0으로 두고 시작한다.
    }

    override fun doInBackground(vararg params: Int?): Int {
        while (isCancelled() == false) { // "완료가 되기 전 작업이 취소가 되지 않았다면"이라는 의미
            percent++
            if (percent > 100) {
                break // percent(작업의 경과도)가 100이 넘으면 break
            } else {
                publishProgress(percent)
                // 작업이 1만큼 진행되면 percent의 1이 publishProgress로 가고 결국
                // onProgressUpdate의 인자인 values로 1이 들어간다.(메인쓰레드에 표시해줘야하니까)
            }
            try {
                /* 사실 percent++을 하는 과정은 컴퓨터에게 아무것도 아니다. 그래서
                * 그냥 실행을 하면 progressBar가 차는 과정도 보이지 않고 처음부터 100으로 되어있을 것이다.
                * 우리가 과정을 확인하기 위해서는 쓰레드를 잠시 재워둘 필요가 있다.*/
                Thread.sleep(100)
            } catch (e: Exception) {
                e.printStackTrace() // Exception이 발생했으면 왜 발생했는지 찍어준다.
            }
        }
        return percent // Int를 리턴
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0] ?: 0)
        // 엘비스 연산자를 사용해서 values[0]이 null인 경우에는 0을 집어넣도록 작성한다.
        progressText.setText("퍼센트 : " + values[0])
        /*
        결국 doInBackGround의 percent가 1씩 올라갈 때마다 progressBar를 update해주는 것이다.
         */
        super.onProgressUpdate(*values)
    }


    // doInBackGround에서 리턴하는 Int타입에 onPostExecute로 들어온다.
    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다.")
    }

    override fun onCancelled() {
        // 작업이 취소된 경우에는 프로그레스바를 0으로 만들고 취소되었다는 메시지를 보여준다.
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다.")
    }
}