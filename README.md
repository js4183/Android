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
- Activity 화면을 구성
- Service (Background에서 동작) Activity에서 화면만 뺀거
- BR(Broadcast Receiver) 외부 신호 감지
- CP(Content Provider) 정보를 전송하고자 할 때 정보를 넘겨줌



### 4대 구성요소간 정보를 매개하는 -> Intent
Intent - 중간 다리 역할 4대 구성요소 중간다리역할을 하는 메세지 객체
인텐트 : 메세지 객체

명시적 explicit
- 액션(VIEW, WEB_SEARCH, CALL, DIAL, ...)
액션+데이터
- 액션(카메라, 웹서치, 문자메세지)
묵시적 implicit
- 구성요소들끼리 데이터를 주고받거나, 이동할 때 사용하는 인텐트
1) startActivity(인텐트) ---> 단방향 (데이터를 주거나 or 받는다)
2) startActivityForResult(인텐트, requestCode) ---> 양방향 (데이터를 주고 받음)
  
![image](https://user-images.githubusercontent.com/112377313/204172469-3d682b3f-a918-4751-bc18-a8e5efcff7fa.png)
  
  ![image](https://user-images.githubusercontent.com/112377313/204174150-feb82783-ef19-4957-a4de-02eb5a99bb74.png)

![image](https://user-images.githubusercontent.com/112377313/204180518-df2f4045-d0d3-4ef5-bbed-c78c4a858247.png)

  <details>
    <summary> MainActivity Code</summary>
    
```
package com.example.ex20221128

import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnWeb = findViewById<Button>(R.id.btnWeb)
        val btnGoogle = findViewById<Button>(R.id.btnGoogle)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val btnSms = findViewById<Button>(R.id.btnSms)
        val btnPhoto = findViewById<Button>(R.id.btnPhoto)

        // 암묵적 intent
        // : 안드로이드 내부에 있는 어플리케이션을 실행
        // Chrome,  Camera, Message, Call

        // Intent 의 사용용도
        // 1-1. 액션, 데이터
        // 1-2 액션 -> Camera
        // 2. Android 4대 구성요소가의 데이터 주고 받을 때

        // Intent 객체 (메세지 객체)

        btnCall.setOnClickListener {
            // btnCall을 누르면 전화가 가게 만들어보자
            // 데이터 : 전화번호
            // URi : key, value
            // "tel:010-1234-5678"
            var uri = Uri.parse("tel:010-1234-5678")
            var intent = Intent(Intent.ACTION_CALL, uri)
            // Intent 실행시키기

            // permission : 권한
            // 사용자한테 권한을 줄껀지 물어봐 줘야함!

            // ActivityCompat
            // checkSelfPermission() : 지금 현재 권한이 부여되어있는지
            // (현재 페이지 정보, 어떤 권한 인지)
            // 결과값으로 승인이 되어있는지? 안되었는지? 받아온다
            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // 승인이 안되어있는 상태라면 알림창을 띄워서 승인할 수 있도록

                // ActivityCompat 확인하는 기능 요청하는 기능이 둘다 들어가 있음
                // arrayOf(CALL_PHONE, CAMERA...)
                // requestCode : 내가 뭘 요청한건지 구분하기위한 숫자
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),0)

                return@setOnClickListener
            }

            startActivity(intent)
        }
        
        // btnWeb을 클릭하면 구글 홈페이지가 보이게 만들기
        btnWeb.setOnClickListener { 
            // 데이터 : 구글 주소 (http://www.google.co.kr)
            var uri = Uri.parse("http://www.google.co.kr")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        // btnGoogle을 클릭하면 구글 맵을 보이게 만들기
        btnGoogle.setOnClickListener {
            // 액션, 데이터
            // 데이터 (get 방식) : 구글 맵은 get 방식 /keyword='content'
            // 구글 맵 주소 /경도,위도
            var uri = Uri.parse("https://google.com/maps?q=35.14670147841655,126.92215633785938")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        // 클릭했을 때 해당 키워드로 구글 검색
        btnSearch.setOnClickListener {
            // 1. 검색하는 intent 를 하나 생성한다.
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            // 2. 검색하고 싶은 키워드를 인텐트에 넣어준다.
            intent.putExtra(SearchManager.QUERY,"안드로이드")
            // 3. intent 실행
            startActivity(intent)
        }

        // btnSms 를 클릭하면 문자를 보내는 페이지로 이동한 다음
        // 내용을 꺼내올 예정
        btnSms.setOnClickListener {
            var intent = Intent(Intent.ACTION_SENDTO)
            // 문자 내용 키값, 내용
            // "sms_body"라는 Key 값이 value 가 문자내용임을 구분할 수 있다.
            intent.putExtra("sms_body","안녕하세요 주상민입니다.")
            // 누구한테 보낼껀지에 대한 데이터 tel: ---> Uri
            intent.data = Uri.parse("smsto:"+Uri.encode("010-1234-5678"))
            startActivity(intent)
        }

        // 사진 찍기
        // MediaStore : Emulator 에서 동작할 수 있는 카메라, 저장소
        btnPhoto.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }



    }
}
```
</details>
    
Mainfest.xml 에 <uses-permission android:name="android.permission.CALL_PHONE"/> 추가!
    -> 사용자 권한 받기 
    
1. view id값 찾아오기
2. lv에 어떤 item을 클릭했는지 구분 (판단)
3. 해당 색상코드를 버튼을 눌렀을 때 intent에 실어서 보내주자(SecondActivity로)
4. SecondActivity에서 intent에 붙어있는 데이터를 떼서 사용 (setBackground에 사용)
5. btnPre를 누르면 이전페이지로 돌아간다

![image](https://user-images.githubusercontent.com/112377313/204199539-d493c8d3-ea2b-4959-9187-f58f883714aa.png)

* Stack처럼 쌓임. -> finish메서드를 이용해 빼버려야함 (생명주기)    
    
![image](https://user-images.githubusercontent.com/112377313/204172256-727505c0-af7e-4b73-9eb6-5da58115780f.png)

  메모리 삭제 ?
  
* xml -> b 화면 1개 or 2개 전환
* Ctrl + Alt + L 정렬 단축키
  
  
  
  </details>
  
<details>
    <summary>📚 11/29</summary>
    
    
<details>
        <summary>📚 Ex20221129</summary>
        
        ### Ex01
        1. MainActivity에서 버튼을 누르면 Sub한테 이동(요청)
        StartActivityForResult(인텐트, requestCode)
        2. Sub에 버튼을 눌렀을 때 EditText에 담겨있는 값을 들고
           Main으로 온다~!
        3. Main에서 값을 받아줘야한다
        (OnActivityResult() 오버라이딩 -> intent에서 데이터를 꺼내주는 메서드)
        
</details>
    
    
<details>
        <summary>📚 14:10~ </summary>
        
        ![image](https://user-images.githubusercontent.com/112377313/204446629-37a7defe-208c-404a-b817-fa32f72f921d.png)

        ![image](https://user-images.githubusercontent.com/112377313/204447508-01c7bd41-fcaf-4db5-87b2-1a60e90cd00d.png)
        * name 소문자, _ 만 입력 **
    
        ![image](https://user-images.githubusercontent.com/112377313/204460015-3c4a11f5-c321-43c7-892f-22a6c052409d.png)

        ### ListView
        
        
        ### Spinner
        
        
        ### GridView
        
</details>
    
    
</details>

<details>
        <summary>📚 11/30 </summary>
        
        1. Adapter View 사용해서 전화번호부 만들기
        2. SubActivity로 부터 받아온 값으로 Main에 ListView에 추가
        
        ![image](https://user-images.githubusercontent.com/112377313/204676126-3741269c-beb2-40b5-8dce-fb335c8792cb.png)
        
        이미지 세팅
        drawable 5개 이미지 저장
        
        ![image](https://user-images.githubusercontent.com/112377313/204678017-daa8b8fd-a331-46f6-a4ba-5b8ff13bf42b.png)

        padding -> 16dp
        
        - Adapter View
        - ListView
        안쪽에 사용하고 있는 Adapter에서 findViewById()가 굉장히 많이 호출된다.
        안드로이드에서 메모리 리소스를 많이 잡아먹는 함수 중 하나이다!
        개발 -> 유지보수!!
        
        - RecyclerView
        AdapterView 만드는 6단계
        1) Container 결정
        2) Template 결정
        3) Item 결정
        4) Adapter 결정
        5) Container에 Adapter 부착
        6) Event 처리
        
        minSdk 버전(레벨)의미 올리는 것만 가능

        
</details>

<details>
        <summary>📚 12/01 </summary>

프로그래밍 언어!!
사람과 기계가 소통
기계어
1 or 0 -> 전류를 흐르게 1, 흐르지 않게 0
1, 0 -> bit
1bit -> 2가지
2bit -> 4가지
3bit -> 8가지 : 2^3
IPv4
0 ~ 255 . 0 ~ 255. 0 ~ 255. 0 ~ 255
32bit
IPv6
128bit
127.0.0.1
int result = a + b;
10진수 -> 가능한 숫자표현이 10가지
-> 10이되면 자리가 하나 증가함
2진수 -> 가능한 숫자 표현이 2가지
-> 2가되면 자리가 하나 증가함
8진수 -> 가능한 숫자 표현이 8가지
-> 8이되면 자리가 하나 증감
올해 나이 21
-> 25(8) -> 2 x 8^1 + 5 x 8^0 = 21
16진수 -> 가능한 숫자 표현이 16가지
-> 16이 되면 자릿수 증가
0 1 2 3 4 5 6 7 8 9 A B C D E F
255라는 10진수 -> 16진수
F -> 10 -> 11 -> 12 -> 13 -> .. -> 1F -> 20
20(16) -> 16^0 x 1 + 16^1 x 2 = 33
FF
256 -> 100(16) - 1 = 0FF
1010101110101011
10001011 10101011
00011011 10101011

남이 설계해주는 대로 생각없이 개발하는 사람이 코더.

시스템에 대한 이해와 향상을 염두에 두고 나름대로 체계를 갖추고 아주 작은 클래스라도 설계를 병행하며 개발하는 사람은 개발자.

네트워크 통신

클라이언트 -> 서버에 요청
서버는 -> 클라이언트에 응답

Volley
안드로이드 앱의 네트워킹을 더 쉽고, 더 빠르게 하는 HTTP 라이브러리

Request -> or <- RequestQueue |Thread 1,2,... -> or <- Server ResponseListener 응답 처리


### JSON (Json Parser)
- 속성-값 쌍으로

response가 JsonObject타입
boxOfficeResult가 JsonObject
dailyBoxOfficeList
JsonArray

10 .. array의 크기만큼 접근

1. rank
2. rankOldAndNew
3. MoviNM
4. audiAcc
5. opendt

RecyclerView
1. 어디에 RecyclerView를 넣을지 정하기
2. 한 칸에 들어갈 디자인 (Template만들기) moviewlist.xml
3. data --->movies
4. adapter 만들기 MovieAdapter
:RecyclerView.Adapter 상속받게 만들기
5. rc에 adapter적용


url=https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20221130
</details>

<details>
        <summary>📚 12/02 </summary>
       
![image](https://user-images.githubusercontent.com/112377313/205186994-b424c3d3-f046-4459-8617-36e94ba0e6a0.png)

☆★API key 값은 복사해서 붙혀넣기!!!

rank -> tvRank

Fragment -> (분할, 나누기) 부분화면

레이아웃&액티비티 중첩 -> 코드의 복잡성과 액티비티의 생명주기
인텐트를 이용해 화면이동 -> 프로그먼트 매니저가 화면 관리 ( 액티비티 화면위에서 동작함* )

특징
- 화면 분할
- 화면의 재사용성
- 액티비티와 같이 레이아웃, 동작처리, 생명주기를 가진 독립적인 모듈
- 액티비티 내 추가/삭제/제거 가능

ContraintLayout
순서
1. 아래의 4개의 탭
2. 뭘 클릭했는지 구분

FrameLayout에 Fragment를 갈아끼워준다


### 안드로이드에서 비휘발성 데이터 만들기
- 서버에 저장
- SQLite (내장메모리)
- FireBase : 회원가입, 로그인, .. 세부적기능들이 이미 다 구현되어있음
- SharedPreference
    - Sqlite보다 가벼움
    - Fragment간에 데이터 전송
    - 어플리케이션 첫 실행 감지 할 때
    - 

    <details>
        <summary> 코드 토글 Code</summary>
    
```

```
</details>




</details>
