package com.example.bottomnavigationviewexample

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bottomnavigationviewexample.ui.home.HomeFragment

class free_homeFragment : Fragment() {

    // Main(FreeBottomNav)에서 free_homeFragment.newInstance()를 호출할텐데
    // 호출하면 홈프래그먼트의 메모리에 올라간 것을 가져온다.(홈으로 설정)
    companion object {
        const val TAG: String = "로그"

        fun newInstance(): free_homeFragment {
            return free_homeFragment()
        }
    }

    // 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "free_homeFragment - onCreated() called")
    }

    // fragment를 안고있는 Activity에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "free_homeFragment - onAttached() called")
    }

    // 뷰가 생성되었을 때 화면과 연결해주는 역할
    // 프래그먼트와 레이아웃을 연결시켜주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "free_homeFragment - onCreateView() called")
        return inflater.inflate(R.layout.free_fragment_home, container, false)
    }
}