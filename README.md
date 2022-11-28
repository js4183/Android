# Androidstudio

<details>
    <summary>📚 First Project ~11/25</summary>

  <details>
    <summary>📚xml Code</summary>
    
```
  <?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Ex20221124"
        tools:targetApi="31">
        <activity
            android:name=".ImageActivity"
            android:exported="true">
            <meta-data
                android:name="android.app.lib_name"
                android:value="" />
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity
            android:name=".LoginActivity"
            android:exported="true">
            <meta-data
                android:name="android.app.lib_name"
                android:value="" />


        </activity>
        <activity
            android:name=".ConstraintActivity"
            android:exported="true">
            <meta-data
                android:name="android.app.lib_name"
                android:value="" />

            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <meta-data
                android:name="android.app.lib_name"
                android:value="" />
        </activity>
    </application>
</manifest>
```
  </details>
  
  ![image](https://user-images.githubusercontent.com/112377313/204168933-bdc09c6d-dda9-4d74-a6f6-3f261cc0dae6.png)

<details>
    <summary>📚MainActivity Code</summary>
    
```
package com.example.ex20221124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```
</details>
  
![image](https://user-images.githubusercontent.com/112377313/204169256-ddbe9968-217f-46c5-bd84-6f6e54dc32cb.png)
 
<details>
    <summary>📚LoginActivity Code</summary>
    
```
package com.example.ex20221124

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1. View 들의 id 값을 찾아오자 (findViewById)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPw = findViewById<EditText>(R.id.etPw)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // 2. Button 에 Event 달아주기 (setOnClickListener)
        btnLogin.setOnClickListener {

            // 2-1. EditText 에 적혀있는 email, password 값을 가져오기
            // (email, pw : 변수)---> 문자열로 형변환
            var email = etEmail.text.toString()
            var pw = etPw.text.toString()

            // 2-2. 가져온 email, pw가 smhrd@smhrd.or.kr, qwer1234 가 맞는지 판단 (조건식)
            if(email == "smhrd@smhrd.or.kr" && pw=="qwer1234"){
                // 맞다면 Toast로 "로그인 성공"
                Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()
            }
            else{
                // 틀리면 Toast로 "로그인 실패"를 띄워주세요!!!
                Toast.makeText(this,"로그인실패",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```
</details>
  
![image](https://user-images.githubusercontent.com/112377313/204169340-b5abd4fa-bba6-407f-862a-56b3d31be029.png)

  
<details>
    <summary>📚ConstraintActivity Code</summary>
    
```
package com.example.ex20221124

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// : Kotlin 에서 상속
class ConstraintActivity : AppCompatActivity() {

    // 전역변수(뷰) 선언
    lateinit var tvResult: TextView
    lateinit var etNum1: EditText
    lateinit var etNum2: EditText
    // 뷰에 대해서는 선언만 하는 거는 불가능 초기화가 꼭 이루어져야한다.
    // 그런데 lateinit이라는 키워드로 나중에 꼭 초기화를 하겠다
    // 라는 약속을 할 수 있다!

    // onCreate()는 Activity 가 실행될때 최초 딱 한번(가장 먼저) 호출되는 메서드
    // : Activity 생명주기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ***** xml 이랑 kotlin class 랑 연결하는 코드 없으면 화면 안뜸 *****
        setContentView(R.layout.activity_constraint)

        // 1. xml 의 View 에 id를 지정
        // 2. id 값을 이용해서 view 를 찾아온다. (findViewById)
        // R : 리소스(폴더).id.tvResult
        tvResult = findViewById(R.id.tvResult)
        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        // val tvResult:TextView = findViewById<TextView>(R.id.tvResult) 추론이 가능
        // id 값은 문자열로 정해줬는데 받아오는값이 Int
        // R 폴더에 모든 뷰(리소스)들의 id 값이 저장이 되는데 주소값이 저장
        // 16진수 상수형태로 저장이 되어있다 (Int)

        // ** setContentView 위로 find 할 수 없다!! **
        tvResult.setTextColor(Color.BLUE)
        tvResult.setTextColor(Color.parseColor("#ff9999"))
        // textSize 에는 Float 자료형이 들어가야 함. (f : 형변환)
        tvResult.textSize = 40.0f
        tvResult.text = "안녕하세요!"
        // charSequence 인터페이스 - String 은 CharSequence 인터페이스 상속 받는 중

        // - 더하기 버튼을 눌렀을 때 "더하기 버튼이 눌렸습니다." 라는
        // Toast 를 띄우기!
        // 이벤트를 주는 방법
        // 1) 이벤트 메소드 설계 후 뷰에 연결하기
        // 2) innerClass (Listener OnClick 구현)



        btnPlus.setOnClickListener {
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()
            var res = num1+num2
            tvResult.text = "연산결과 : $res"
            //Toast.makeText(this, "연산결과 : $res",Toast.LENGTH_SHORT).show()
        }
        btnMinus.setOnClickListener {
            // {}안에다가 기능 구현만 하면됨!! *(v->V)
            // 버튼을 눌렀을 때 "마이너스 버튼이 눌렸습니다" 토스트 띄우기
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()

            var res = num1-num2
            tvResult.text = "연산결과 : $res"
            //Toast.makeText(this, "연산결과 : $res", Toast.LENGTH_SHORT).show()

            // 1. EditText 에 적혀있는 숫자
            // etNum1, etNum2 에 있는 내용 변수 num1, num2 에 저장
            // 실제로 getText --> Editable ---> 문자열로 형변환 ---> 정수형
            // 2. num1, num2 연산 결과를 문자열로 바꿔서 set 해주세요!
            //  -1. num1, num2 연산 결과를 tvResult 에 set 해주세요!
        }
        btnMul.setOnClickListener {
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()
            var res = num1*num2
            tvResult.text = "연산결과 : $res"
            //Toast.makeText(this, "연산결과 : $res", Toast.LENGTH_SHORT).show()
        }
        btnDiv.setOnClickListener {
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()
            var res = num1/num2
            tvResult.text = "연산결과 : $res"
            //Toast.makeText(this, "연산결과 : $res", Toast.LENGTH_SHORT).show()
        }



        // 3) interface 를 상속받게 만들어서 OnClick 구현



    }// onCreate 밖

    // 이벤트 리스너는 무조건 View 매개변수를 가지고 있어야한다.
    fun myClick(view: View){
        // Toast 띄우기!
        // 1) this, ConstraintActivity.this : Toast 를 띄울 화면 정보
        // 2) 문구 (무조건 String, Int 가 허용되는 경우는 id 값만)
        // 3) Toast 에 short(3초), Long(5초) 속성 사용
         Toast.makeText(this,"더하기 버튼이 눌렸습니다.",Toast.LENGTH_SHORT).show()
        //editable -> 문자열 변환 -> 정수형으로 변환
        var num1 = etNum1.text.toString().toInt()
        var num2 = etNum2.text.toString().toInt()
        // Emulator 를 처음실행시키면 EditText 에는 아무 값도 없음 ""
        // "".toInt() NumberFormatException
        // 버튼을 눌렀을 때 적혀있는 값을 가지고 와줘야 함!!!
        var result = num1 + num2
        //tvResult.text = "연산 결과 : $result"
        //tvResult.text = result.toString()
    }



}
```
</details>
  
![image](https://user-images.githubusercontent.com/112377313/204169447-fda581e1-50a0-4ed1-9291-3f708ea4bd37.png)

  
<details>
    <summary>📚ImageActivity Code</summary>
    
```
package com.example.ex20221124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class ImageActivity : AppCompatActivity() {

    // 배열 이름
    val imgArray = intArrayOf(R.drawable.pink, R.drawable.black, R.drawable.blue, R.drawable.yellow, R.drawable.red)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        // View 의 id값 다 찾아오기
        val img = findViewById<ImageView>(R.id.img)
        val btnPre = findViewById<Button>(R.id.btnPre)
        val btnNext = findViewById<Button>(R.id.btnNext)
        
        // 이미지 값 바꾸기
        img.setImageResource(R.drawable.pink)

        var index = 0

        btnPre.setOnClickListener {
            index--
            // if (index < 0) index = imgArray.size - 1
            if(index<0){
                index = 4
            }
            img.setImageResource(imgArray[index])
        }

        btnNext.setOnClickListener {
            index ++
            // if (index > imgArray.size - 1) index = 0
            if(index>4){
                index=0
            }
            img.setImageResource(imgArray[index])
        }


        // Pre 버튼을 눌렀을 때! (setOnClickListener)
        // 1-1. index -1 감소
        // 해당 index 에 있는 img 의 id를 가져와서
        // ImageView 에 set 하자!
        // index 의 조건 : 0 보다 작으면 다시 index 값을 size-1으로 돌리자

        // 2. Next 버튼을 눌렀을 때
        // 2-1 index +1 증가
        // 해당 index 에 있는 img 의 id를 가져와서
        // ImageView 를 set 하자
        // index 의 조건 : size -1보다 크면 다시 index 값을 0으로


    }
}
```
</details>
  
xml에 있는 view를 컨트롤하기 위해서는 id값이 필요 class에서는 id값을 찾아와서(findViewById) 컨트롤한다
단, findViewById는 setContentView아래에 있어야한다!
*** 버튼 이벤트 달기 ***
1. 메서드를 속성에 달아주기 (OnClick속성)
2. innerClass로 OnClick Override : SAM (람다식에서 생략할 수 있는 경우)
3. Interface를 상속받게 만들어 준다.
  </details>
  
  
<details>
    <summary>📚 11/28</summary>
  
## 안드로이드 4대 컴포넌트
  
Intent - 중간 다리 역할
인텐트 : 메세지 객체



  
![image](https://user-images.githubusercontent.com/112377313/204172469-3d682b3f-a918-4751-bc18-a8e5efcff7fa.png)
  
  ![image](https://user-images.githubusercontent.com/112377313/204174150-feb82783-ef19-4957-a4de-02eb5a99bb74.png)


  <details>
    <summary> MainActivity Code</summary>
    
```
package com.example.ex20221128

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import java.net.URI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCall = findViewById<Button>(R.id.butCall)

        // 암묵적 intent
        // : 안드로이드 내부에 있는 어플리케이션을 실행
        // Chrome,  Camera, Message, Call

        // Intent 의 사용용도
        // 1. 액션, 데이터
        // 2. Android 4대 구성요소가의 데이터 주고 받을 때

        // Intent 객체 (메세지 객체)

        btnCall.setOnClickListener {
            // btnCall을 누르면 전화가 가게 만들어보자
            // 데이터 : 전화번호
            // URi : key, value
            // "tel:010-1234-5678" 띄어쓰기 XXXXX
            var uri = Uri.parse("tel:010-1234-5678")
            var intent = Intent(Intent.ACTION_CALL, uri)
            // Intent 실행시키기

            // permission : 권한
            // 사용자한테 권한을 줄껀지 물어봐 줘야함!

            // ActivityCompat
            // checkSelfPermission() : 지금 현재 권한이 부여되어있는지
            // (현재 페이지 정보, 어떤 권한 인지)
            // 결과값으로 승인이 되어있는지? 안되었는지? 받아온다
            if(ActivityCompat.checkSelfPermission(this, 
            android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // 승인이 안되어있는 상태라면 알림창을 띄워서 승인할 수 있도록

                // ActivityCompat 확인하는 기능 요청하는 기능이 둘다 들어가 있음
                // arrayOf(CALL_PHONE, CAMERA...)
                // requestCode : 내가 뭘 요청한건지 구분하기위한 숫자
                ActivityCompat.requestPermissions(this, 
                arrayOf(android.Manifest.permission.CALL_PHONE),0)

                return@setOnClickListener
            }

            startActivity(intent)
        }
    }
}
```
</details>
    
Mainfest.xml 에 <uses-permission android:name="android.permission.CALL_PHONE"/> 추가!
    -> 사용자 권한 받기 
    
![image](https://user-images.githubusercontent.com/112377313/204172256-727505c0-af7e-4b73-9eb6-5da58115780f.png)

  메모리 삭제 ?
  
  
  
  </details>
