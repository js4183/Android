# Androidstudio

<details>
    <summary>đ First Project ~11/25</summary>

  <details>
    <summary>đxml Code</summary>
    
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
    <summary>đMainActivity Code</summary>
    
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
    <summary>đLoginActivity Code</summary>
    
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

        // 1. View ë¤ě id ę°ě ě°žěě¤ě (findViewById)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPw = findViewById<EditText>(R.id.etPw)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // 2. Button ě Event ëŹěěŁźę¸° (setOnClickListener)
        btnLogin.setOnClickListener {

            // 2-1. EditText ě ě íěë email, password ę°ě ę°ě ¸ě¤ę¸°
            // (email, pw : ëłě)---> ëŹ¸ěě´ëĄ íëłí
            var email = etEmail.text.toString()
            var pw = etPw.text.toString()

            // 2-2. ę°ě ¸ě¨ email, pwę° smhrd@smhrd.or.kr, qwer1234 ę° ë§ëě§ íë¨ (ěĄ°ęą´ě)
            if(email == "smhrd@smhrd.or.kr" && pw=="qwer1234"){
                // ë§ë¤ëŠ´ ToastëĄ "ëĄęˇ¸ě¸ ěąęłľ"
                Toast.makeText(this,"ëĄęˇ¸ě¸ ěąęłľ",Toast.LENGTH_SHORT).show()
            }
            else{
                // íëŚŹëŠ´ ToastëĄ "ëĄęˇ¸ě¸ ě¤í¨"ëĽź ëěěŁźě¸ě!!!
                Toast.makeText(this,"ëĄęˇ¸ě¸ě¤í¨",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
```
</details>
  
![image](https://user-images.githubusercontent.com/112377313/204169340-b5abd4fa-bba6-407f-862a-56b3d31be029.png)

  
<details>
    <summary>đConstraintActivity Code</summary>
    
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

// : Kotlin ěě ěě
class ConstraintActivity : AppCompatActivity() {

    // ě ě­ëłě(ëˇ°) ě ě¸
    lateinit var tvResult: TextView
    lateinit var etNum1: EditText
    lateinit var etNum2: EditText
    // ëˇ°ě ëí´ěë ě ě¸ë§ íë ęą°ë ëśę°ëĽ ě´ę¸°íę° ęź­ ě´ëŁ¨ě´ě ¸ěźíë¤.
    // ęˇ¸ë°ë° lateinitě´ëźë í¤ěëëĄ ëě¤ě ęź­ ě´ę¸°íëĽź íę˛ ë¤
    // ëźë ě˝ěě í  ě ěë¤!

    // onCreate()ë Activity ę° ě¤íë ë ěľě´ ëą íë˛(ę°ěĽ ë¨źě ) í¸ěśëë ëŠěë
    // : Activity ěëŞěŁźę¸°
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ***** xml ě´ë kotlin class ë ě°ę˛°íë ě˝ë ěěźëŠ´ íëŠ´ ěë¸ *****
        setContentView(R.layout.activity_constraint)

        // 1. xml ě View ě idëĽź ě§ě 
        // 2. id ę°ě ě´ěŠí´ě view ëĽź ě°žěě¨ë¤. (findViewById)
        // R : ëŚŹěě¤(í´ë).id.tvResult
        tvResult = findViewById(R.id.tvResult)
        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        // val tvResult:TextView = findViewById<TextView>(R.id.tvResult) ěśëĄ ě´ ę°ëĽ
        // id ę°ě ëŹ¸ěě´ëĄ ě í´ě¤Źëë° ë°ěě¤ëę°ě´ Int
        // R í´ëě ëŞ¨ë  ëˇ°(ëŚŹěě¤)ë¤ě id ę°ě´ ě ěĽě´ ëëë° ěŁźěę°ě´ ě ěĽ
        // 16ě§ě ěěííëĄ ě ěĽě´ ëě´ěë¤ (Int)

        // ** setContentView ěëĄ find í  ě ěë¤!! **
        tvResult.setTextColor(Color.BLUE)
        tvResult.setTextColor(Color.parseColor("#ff9999"))
        // textSize ěë Float ěëŁíě´ ë¤ě´ę°ěź í¨. (f : íëłí)
        tvResult.textSize = 40.0f
        tvResult.text = "ěëíě¸ě!"
        // charSequence ě¸í°íě´ě¤ - String ě CharSequence ě¸í°íě´ě¤ ěě ë°ë ě¤

        // - ëíę¸° ë˛íźě ëë ě ë "ëíę¸° ë˛íźě´ ëë ¸ěľëë¤." ëźë
        // Toast ëĽź ëě°ę¸°!
        // ě´ë˛¤í¸ëĽź ěŁźë ë°Šë˛
        // 1) ě´ë˛¤í¸ ëŠěë ě¤ęł í ëˇ°ě ě°ę˛°íę¸°
        // 2) innerClass (Listener OnClick ęľŹí)



        btnPlus.setOnClickListener {
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()
            var res = num1+num2
            tvResult.text = "ě°ě°ę˛°ęłź : $res"
            //Toast.makeText(this, "ě°ě°ę˛°ęłź : $res",Toast.LENGTH_SHORT).show()
        }
        btnMinus.setOnClickListener {
            // {}ěěë¤ę° ę¸°ëĽ ęľŹíë§ íëŠ´ë¨!! *(v->V)
            // ë˛íźě ëë ě ë "ë§ě´ëě¤ ë˛íźě´ ëë ¸ěľëë¤" í ě¤í¸ ëě°ę¸°
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()

            var res = num1-num2
            tvResult.text = "ě°ě°ę˛°ęłź : $res"
            //Toast.makeText(this, "ě°ě°ę˛°ęłź : $res", Toast.LENGTH_SHORT).show()

            // 1. EditText ě ě íěë ěŤě
            // etNum1, etNum2 ě ěë ë´ěŠ ëłě num1, num2 ě ě ěĽ
            // ě¤ě ëĄ getText --> Editable ---> ëŹ¸ěě´ëĄ íëłí ---> ě ěí
            // 2. num1, num2 ě°ě° ę˛°ęłźëĽź ëŹ¸ěě´ëĄ ë°ężě set í´ěŁźě¸ě!
            //  -1. num1, num2 ě°ě° ę˛°ęłźëĽź tvResult ě set í´ěŁźě¸ě!
        }
        btnMul.setOnClickListener {
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()
            var res = num1*num2
            tvResult.text = "ě°ě°ę˛°ęłź : $res"
            //Toast.makeText(this, "ě°ě°ę˛°ęłź : $res", Toast.LENGTH_SHORT).show()
        }
        btnDiv.setOnClickListener {
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()
            var res = num1/num2
            tvResult.text = "ě°ě°ę˛°ęłź : $res"
            //Toast.makeText(this, "ě°ě°ę˛°ęłź : $res", Toast.LENGTH_SHORT).show()
        }



        // 3) interface ëĽź ěěë°ę˛ ë§ë¤ě´ě OnClick ęľŹí



    }// onCreate ë°

    // ě´ë˛¤í¸ ëŚŹě¤ëë ëŹ´ěĄ°ęą´ View ë§¤ę°ëłěëĽź ę°ě§ęł  ěě´ěźíë¤.
    fun myClick(view: View){
        // Toast ëě°ę¸°!
        // 1) this, ConstraintActivity.this : Toast ëĽź ëě¸ íëŠ´ ě ëł´
        // 2) ëŹ¸ęľŹ (ëŹ´ěĄ°ęą´ String, Int ę° íěŠëë ę˛˝ě°ë id ę°ë§)
        // 3) Toast ě short(3ě´), Long(5ě´) ěěą ěŹěŠ
         Toast.makeText(this,"ëíę¸° ë˛íźě´ ëë ¸ěľëë¤.",Toast.LENGTH_SHORT).show()
        //editable -> ëŹ¸ěě´ ëłí -> ě ěíěźëĄ ëłí
        var num1 = etNum1.text.toString().toInt()
        var num2 = etNum2.text.toString().toInt()
        // Emulator ëĽź ě˛ěě¤íěí¤ëŠ´ EditText ěë ěëŹ´ ę°ë ěě ""
        // "".toInt() NumberFormatException
        // ë˛íźě ëë ě ë ě íěë ę°ě ę°ě§ęł  ěě¤ěź í¨!!!
        var result = num1 + num2
        //tvResult.text = "ě°ě° ę˛°ęłź : $result"
        //tvResult.text = result.toString()
    }



}
```
</details>
  
![image](https://user-images.githubusercontent.com/112377313/204169447-fda581e1-50a0-4ed1-9291-3f708ea4bd37.png)

  
<details>
    <summary>đImageActivity Code</summary>
    
```
package com.example.ex20221124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class ImageActivity : AppCompatActivity() {

    // ë°°ě´ ě´ëŚ
    val imgArray = intArrayOf(R.drawable.pink, R.drawable.black, R.drawable.blue, R.drawable.yellow, R.drawable.red)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        // View ě idę° ë¤ ě°žěě¤ę¸°
        val img = findViewById<ImageView>(R.id.img)
        val btnPre = findViewById<Button>(R.id.btnPre)
        val btnNext = findViewById<Button>(R.id.btnNext)
        
        // ě´ëŻ¸ě§ ę° ë°ęž¸ę¸°
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


        // Pre ë˛íźě ëë ě ë! (setOnClickListener)
        // 1-1. index -1 ę°ě
        // í´ëš index ě ěë img ě idëĽź ę°ě ¸ěě
        // ImageView ě set íě!
        // index ě ěĄ°ęą´ : 0 ëł´ë¤ ěěźëŠ´ ë¤ě index ę°ě size-1ěźëĄ ëëŚŹě

        // 2. Next ë˛íźě ëë ě ë
        // 2-1 index +1 ěŚę°
        // í´ëš index ě ěë img ě idëĽź ę°ě ¸ěě
        // ImageView ëĽź set íě
        // index ě ěĄ°ęą´ : size -1ëł´ë¤ íŹëŠ´ ë¤ě index ę°ě 0ěźëĄ


    }
}
```
</details>
  
xmlě ěë viewëĽź ěť¨í¸ëĄ¤íę¸° ěí´ěë idę°ě´ íě classěěë idę°ě ě°žěěě(findViewById) ěť¨í¸ëĄ¤íë¤
ë¨, findViewByIdë setContentViewěëě ěě´ěźíë¤!
*** ë˛íź ě´ë˛¤í¸ ëŹę¸° ***
1. ëŠěëëĽź ěěąě ëŹěěŁźę¸° (OnClickěěą)
2. innerClassëĄ OnClick Override : SAM (ëë¤ěěě ěëľí  ě ěë ę˛˝ě°)
3. InterfaceëĽź ěěë°ę˛ ë§ë¤ě´ ě¤ë¤.
  </details>
  
  
<details>
    <summary>đ 11/28</summary>
  
## ěëëĄě´ë 4ë ěť´íŹëí¸
- Activity íëŠ´ě ęľŹěą
- Service (Backgrounděě ëě) Activityěě íëŠ´ë§ ëşęą°
- BR(Broadcast Receiver) ě¸ëś ě í¸ ę°ě§
- CP(Content Provider) ě ëł´ëĽź ě ěĄíęł ě í  ë ě ëł´ëĽź ëę˛¨ě¤



### 4ë ęľŹěąěěę° ě ëł´ëĽź ë§¤ę°íë -> Intent
Intent - ě¤ę° ë¤ëŚŹ ě­í  4ë ęľŹěąěě ě¤ę°ë¤ëŚŹě­í ě íë ëŠě¸ě§ ę°ě˛´
ě¸íí¸ : ëŠě¸ě§ ę°ě˛´

ëŞěě  explicit
- ěĄě(VIEW, WEB_SEARCH, CALL, DIAL, ...)
ěĄě+ë°ě´í°
- ěĄě(ěš´ëŠëź, ěšěěš, ëŹ¸ěëŠě¸ě§)
ëŹľěě  implicit
- ęľŹěąěěë¤ëźëŚŹ ë°ě´í°ëĽź ěŁźęł ë°ęą°ë, ě´ëí  ë ěŹěŠíë ě¸íí¸
1) startActivity(ě¸íí¸) ---> ë¨ë°ŠíĽ (ë°ě´í°ëĽź ěŁźęą°ë or ë°ëë¤)
2) startActivityForResult(ě¸íí¸, requestCode) ---> ěë°ŠíĽ (ë°ě´í°ëĽź ěŁźęł  ë°ě)
  
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

        // ěëŹľě  intent
        // : ěëëĄě´ë ë´ëśě ěë ě´íëŚŹěźě´ěě ě¤í
        // Chrome,  Camera, Message, Call

        // Intent ě ěŹěŠěŠë
        // 1-1. ěĄě, ë°ě´í°
        // 1-2 ěĄě -> Camera
        // 2. Android 4ë ęľŹěąěěę°ě ë°ě´í° ěŁźęł  ë°ě ë

        // Intent ę°ě˛´ (ëŠě¸ě§ ę°ě˛´)

        btnCall.setOnClickListener {
            // btnCallě ëëĽ´ëŠ´ ě íę° ę°ę˛ ë§ë¤ě´ëł´ě
            // ë°ě´í° : ě íë˛í¸
            // URi : key, value
            // "tel:010-1234-5678"
            var uri = Uri.parse("tel:010-1234-5678")
            var intent = Intent(Intent.ACTION_CALL, uri)
            // Intent ě¤íěí¤ę¸°

            // permission : ęśí
            // ěŹěŠěíí ęśíě ě¤ęťě§ ëŹźě´ë´ ě¤ěźí¨!

            // ActivityCompat
            // checkSelfPermission() : ě§ę¸ íěŹ ęśíě´ ëśěŹëě´ěëě§
            // (íěŹ íě´ě§ ě ëł´, ě´ë¤ ęśí ě¸ě§)
            // ę˛°ęłźę°ěźëĄ ěšě¸ě´ ëě´ěëě§? ěëěëě§? ë°ěě¨ë¤
            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // ěšě¸ě´ ěëě´ěë ěíëźëŠ´ ěëŚźě°˝ě ëěě ěšě¸í  ě ěëëĄ

                // ActivityCompat íě¸íë ę¸°ëĽ ěě˛­íë ę¸°ëĽě´ ëë¤ ë¤ě´ę° ěě
                // arrayOf(CALL_PHONE, CAMERA...)
                // requestCode : ë´ę° ë­ ěě˛­íęą´ě§ ęľŹëśíę¸°ěí ěŤě
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),0)

                return@setOnClickListener
            }

            startActivity(intent)
        }
        
        // btnWebě í´ëŚ­íëŠ´ ęľŹę¸ ííě´ě§ę° ëł´ě´ę˛ ë§ë¤ę¸°
        btnWeb.setOnClickListener { 
            // ë°ě´í° : ęľŹę¸ ěŁźě (http://www.google.co.kr)
            var uri = Uri.parse("http://www.google.co.kr")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        // btnGoogleě í´ëŚ­íëŠ´ ęľŹę¸ ë§ľě ëł´ě´ę˛ ë§ë¤ę¸°
        btnGoogle.setOnClickListener {
            // ěĄě, ë°ě´í°
            // ë°ě´í° (get ë°Šě) : ęľŹę¸ ë§ľě get ë°Šě /keyword='content'
            // ęľŹę¸ ë§ľ ěŁźě /ę˛˝ë,ěë
            var uri = Uri.parse("https://google.com/maps?q=35.14670147841655,126.92215633785938")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        // í´ëŚ­íě ë í´ëš í¤ěëëĄ ęľŹę¸ ę˛ě
        btnSearch.setOnClickListener {
            // 1. ę˛ěíë intent ëĽź íë ěěąíë¤.
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            // 2. ę˛ěíęł  ěśě í¤ěëëĽź ě¸íí¸ě ëŁě´ě¤ë¤.
            intent.putExtra(SearchManager.QUERY,"ěëëĄě´ë")
            // 3. intent ě¤í
            startActivity(intent)
        }

        // btnSms ëĽź í´ëŚ­íëŠ´ ëŹ¸ěëĽź ëł´ë´ë íě´ě§ëĄ ě´ëí ë¤ě
        // ë´ěŠě ęşźë´ěŹ ěě 
        btnSms.setOnClickListener {
            var intent = Intent(Intent.ACTION_SENDTO)
            // ëŹ¸ě ë´ěŠ í¤ę°, ë´ěŠ
            // "sms_body"ëźë Key ę°ě´ value ę° ëŹ¸ěë´ěŠěě ęľŹëśí  ě ěë¤.
            intent.putExtra("sms_body","ěëíě¸ě ěŁźěëŻźěëë¤.")
            // ëęľŹíí ëł´ëźęťě§ě ëí ë°ě´í° tel: ---> Uri
            intent.data = Uri.parse("smsto:"+Uri.encode("010-1234-5678"))
            startActivity(intent)
        }

        // ěŹě§ ě°ę¸°
        // MediaStore : Emulator ěě ëěí  ě ěë ěš´ëŠëź, ě ěĽě
        btnPhoto.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }



    }
}
```
</details>
    
Mainfest.xml ě <uses-permission android:name="android.permission.CALL_PHONE"/> ěśę°!
    -> ěŹěŠě ęśí ë°ę¸° 
    
1. view idę° ě°žěě¤ę¸°
2. lvě ě´ë¤ itemě í´ëŚ­íëě§ ęľŹëś (íë¨)
3. í´ëš ěěě˝ëëĽź ë˛íźě ëë ě ë intentě ě¤ě´ě ëł´ë´ěŁźě(SecondActivityëĄ)
4. SecondActivityěě intentě ëśě´ěë ë°ě´í°ëĽź ëźě ěŹěŠ (setBackgroundě ěŹěŠ)
5. btnPreëĽź ëëĽ´ëŠ´ ě´ě íě´ě§ëĄ ëěę°ë¤

![image](https://user-images.githubusercontent.com/112377313/204199539-d493c8d3-ea2b-4959-9187-f58f883714aa.png)

* Stackě˛ëź ěě. -> finishëŠěëëĽź ě´ěŠí´ ëšźë˛ë ¤ěźí¨ (ěëŞěŁźę¸°)    
    
![image](https://user-images.githubusercontent.com/112377313/204172256-727505c0-af7e-4b73-9eb6-5da58115780f.png)

  ëŠëŞ¨ëŚŹ ě­ě  ?
  
* xml -> b íëŠ´ 1ę° or 2ę° ě í
* Ctrl + Alt + L ě ë Ź ë¨ěśí¤
  
  
  
  </details>
  
<details>
    <summary>đ 11/29</summary>
    
    
<details>
        <summary>đ Ex20221129</summary>
        
### Ex01
1. MainActivityěě ë˛íźě ëëĽ´ëŠ´ Subíí ě´ë(ěě˛­) StartActivityForResult(ě¸íí¸, requestCode)
2. Subě ë˛íźě ëë ě ë EditTextě ë´ę˛¨ěë ę°ě ë¤ęł  MainěźëĄ ě¨ë¤~!
3. Mainěě ę°ě ë°ěě¤ěźíë¤
(OnActivityResult() ě¤ë˛ëźě´ëŠ -> intentěě ë°ě´í°ëĽź ęşźë´ěŁźë ëŠěë)
        
</details>
    
    
<details>
        <summary>đ 14:10~ </summary>
        
![image](https://user-images.githubusercontent.com/112377313/204446629-37a7defe-208c-404a-b817-fa32f72f921d.png)

![image](https://user-images.githubusercontent.com/112377313/204447508-01c7bd41-fcaf-4db5-87b2-1a60e90cd00d.png)
* name ěëŹ¸ě, _ ë§ ěë Ľ **
    
![image](https://user-images.githubusercontent.com/112377313/204460015-3c4a11f5-c321-43c7-892f-22a6c052409d.png)

### ListView
        
### Spinner
        
### GridView
        
</details>
    
    
</details>

<details>
        <summary>đ 11/30 </summary>
        
1. Adapter View ěŹěŠí´ě ě íë˛í¸ëś ë§ë¤ę¸°
2. SubActivityëĄ ëśí° ë°ěě¨ ę°ěźëĄ Maině ListViewě ěśę°
        
![image](https://user-images.githubusercontent.com/112377313/204676126-3741269c-beb2-40b5-8dce-fb335c8792cb.png)
        
ě´ëŻ¸ě§ ě¸í
drawable 5ę° ě´ëŻ¸ě§ ě ěĽ
        
![image](https://user-images.githubusercontent.com/112377313/204678017-daa8b8fd-a331-46f6-a4ba-5b8ff13bf42b.png)

padding -> 16dp
        
- Adapter View
- ListView
ěěŞ˝ě ěŹěŠíęł  ěë Adapterěě findViewById()ę° ęľěĽí ë§ě´ í¸ěśëë¤.
ěëëĄě´ëěě ëŠëŞ¨ëŚŹ ëŚŹěě¤ëĽź ë§ě´ ěĄěë¨šë í¨ě ě¤ íëě´ë¤!
ę°ë° -> ě ě§ëł´ě!!
        
- RecyclerView
AdapterView ë§ëë 6ë¨ęł
1) Container ę˛°ě 
2) Template ę˛°ě 
3) Item ę˛°ě 
4) Adapter ę˛°ě 
5) Containerě Adapter ëśě°Š
6) Event ě˛ëŚŹ

minSdk ë˛ě (ë ë˛¨)ěëŻ¸ ěŹëŚŹë ę˛ë§ ę°ëĽ

        
</details>

<details>
        <summary>đ 12/01 </summary>

íëĄęˇ¸ëë° ě¸ě´!!
ěŹëęłź ę¸°ęłę° ěíľ
ę¸°ęłě´
1 or 0 -> ě ëĽëĽź íëĽ´ę˛ 1, íëĽ´ě§ ěę˛ 0
1, 0 -> bit
1bit -> 2ę°ě§
2bit -> 4ę°ě§
3bit -> 8ę°ě§ : 2^3
IPv4
0 ~ 255 . 0 ~ 255. 0 ~ 255. 0 ~ 255
32bit
IPv6
128bit
127.0.0.1
int result = a + b;
10ě§ě -> ę°ëĽí ěŤěííě´ 10ę°ě§
-> 10ě´ëëŠ´ ěëŚŹę° íë ěŚę°í¨
2ě§ě -> ę°ëĽí ěŤě ííě´ 2ę°ě§
-> 2ę°ëëŠ´ ěëŚŹę° íë ěŚę°í¨
8ě§ě -> ę°ëĽí ěŤě ííě´ 8ę°ě§
-> 8ě´ëëŠ´ ěëŚŹę° íë ěŚę°
ěŹí´ ëě´ 21
-> 25(8) -> 2 x 8^1 + 5 x 8^0 = 21
16ě§ě -> ę°ëĽí ěŤě ííě´ 16ę°ě§
-> 16ě´ ëëŠ´ ěëŚżě ěŚę°
0 1 2 3 4 5 6 7 8 9 A B C D E F
255ëźë 10ě§ě -> 16ě§ě
F -> 10 -> 11 -> 12 -> 13 -> .. -> 1F -> 20
20(16) -> 16^0 x 1 + 16^1 x 2 = 33
FF
256 -> 100(16) - 1 = 0FF
1010101110101011
10001011 10101011
00011011 10101011

ë¨ě´ ě¤ęłí´ěŁźë ëëĄ ěę°ěě´ ę°ë°íë ěŹëě´ ě˝ë.

ěě¤íě ëí ě´í´ě íĽěě ěźëě ëęł  ëëŚëëĄ ě˛´ęłëĽź ę°ěśęł  ěěŁź ěě í´ëě¤ëźë ě¤ęłëĽź ëłííëŠ° ę°ë°íë ěŹëě ę°ë°ě.

ë¤í¸ěíŹ íľě 

í´ëźě´ě¸í¸ -> ěë˛ě ěě˛­
ěë˛ë -> í´ëźě´ě¸í¸ě ěëľ

Volley
ěëëĄě´ë ěąě ë¤í¸ěíšě ë ě˝ęł , ë ëš ëĽ´ę˛ íë HTTP ëźě´ë¸ëŹëŚŹ

Request -> or <- RequestQueue |Thread 1,2,... -> or <- Server ResponseListener ěëľ ě˛ëŚŹ


### JSON (Json Parser)
- ěěą-ę° ěěźëĄ

responseę° JsonObjectíě
boxOfficeResultę° JsonObject
dailyBoxOfficeList
JsonArray

10 .. arrayě íŹę¸°ë§íź ě ęˇź

1. rank
2. rankOldAndNew
3. MoviNM
4. audiAcc
5. opendt

RecyclerView
1. ě´ëě RecyclerViewëĽź ëŁěě§ ě íę¸°
2. í ěš¸ě ë¤ě´ę° ëěě¸ (Templateë§ë¤ę¸°) moviewlist.xml
3. data --->movies
4. adapter ë§ë¤ę¸° MovieAdapter
:RecyclerView.Adapter ěěë°ę˛ ë§ë¤ę¸°
5. rcě adapterě ěŠ


url=https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20221130
</details>

<details>
        <summary>đ 12/02 </summary>
       
![image](https://user-images.githubusercontent.com/112377313/205186994-b424c3d3-f046-4459-8617-36e94ba0e6a0.png)

ââAPI key ę°ě ëłľěŹí´ě ëśíëŁę¸°!!!

rank -> tvRank

Fragment -> (ëśí , ëëę¸°) ëśëśíëŠ´

ë ě´ěě&ěĄí°ëší° ě¤ě˛Š -> ě˝ëě ëłľěĄěąęłź ěĄí°ëší°ě ěëŞěŁźę¸°
ě¸íí¸ëĽź ě´ěŠí´ íëŠ´ě´ë -> íëĄęˇ¸ë¨źí¸ ë§¤ëě ę° íëŠ´ ę´ëŚŹ ( ěĄí°ëší° íëŠ´ěěě ëěí¨* )

íšě§
- íëŠ´ ëśí 
- íëŠ´ě ěŹěŹěŠěą
- ěĄí°ëší°ě ę°ě´ ë ě´ěě, ëěě˛ëŚŹ, ěëŞěŁźę¸°ëĽź ę°ě§ ëëŚ˝ě ě¸ ëŞ¨ë
- ěĄí°ëší° ë´ ěśę°/ě­ě /ě ęą° ę°ëĽ

ContraintLayout
ěě
1. ěëě 4ę°ě í­
2. ë­ í´ëŚ­íëě§ ęľŹëś

FrameLayoutě FragmentëĽź ę°ěëźěě¤ë¤


### ěëëĄě´ëěě ëšíë°ěą ë°ě´í° ë§ë¤ę¸°
- ěë˛ě ě ěĽ
- SQLite (ë´ěĽëŠëŞ¨ëŚŹ)
- FireBase : íěę°ě, ëĄęˇ¸ě¸, .. ě¸ëśě ę¸°ëĽë¤ě´ ě´ëŻ¸ ë¤ ęľŹíëě´ěě
- SharedPreference
    - Sqliteëł´ë¤ ę°ë˛źě
    - Fragmentę°ě ë°ě´í° ě ěĄ
    - ě´íëŚŹěźě´ě ě˛Ť ě¤í ę°ě§ í  ë
    - 
</details>

<details>
        <summary>đ 12/05 </summary>
    
    
Fragment (ëśí ) : ëśëśíëŠ´
kt + xml ---> Activity ěě ëśëśíëŠ´
Acitivityę°ě ë°ě´í° ě ěĄ/ě´ë intent
intent ---> AndroidManager

Fragmentę°ě ë°ě´í° ě ěĄ/ě´ë SharedPreference, intent
------> FragmentManagerę° ę´ëŚŹí¨
SharedPreference ;  Fragmentę°ě ë°ě´í° ě ěĄ/ě ě§
(ě´íëŚŹěźě´ě ě˛Ť ě¤í ę°ě§/ěë ëĄęˇ¸ě¸ í ë ěŹěŠ)

*** WebView ***
1. Layoutě WebViewěěšëĽź ě¤ě 
2. ěŁźě ě¤ëš
3. ě¤ě  ëłę˛˝ val ws = wv.settings
(JavaScriptëĽź ěŹěŠ ę°ëĽíëëĄ íěŠ)
4. WebViewě Client ě¤ě 
5. WebViewě ě¤ëší´ëě ěŁźě ě ěŠ

Firebase
- Authentication
- Realtime Database
- Storage
- Firestore Database, Hosting, Function, ML (ëě íěĽěąě ę°ě§)

ë¨ě 
- ěë˛ ěšëľ ěëě ě í (ěë˛ę° í´ě¸ě ěěš)
- Realtime DBěżźëŚŹëŹ¸ ëšě˝ (Like, OR ëŹ¸ ěŹěŠě´ ëśę°ëĽ)

ě¤ěľ ěě
- ë ě´ěě ęž¸ëŻ¸ę¸° ë° íěę°ě ëĄě§ ęľŹí
- ëŠě¸íëŠ´ ë ě´ěě ęž¸ëŻ¸ę¸°
- ííě´ě§ ë§ë¤ę¸°
- ëśë§íŹ ë° ę˛ěí ęľŹí

SplashAcitivity : ě´íëŚŹěźě´ěě ě¤íěěź°ě ë 3ě´ ę° ëł´ěź íëŠ´ ë§ë¤ę¸° (Thread ěŹěŠ)

Process(íëĄě¸ě¤) : ěť´í¨í°ěě ě°ěě ěźëĄ ě¤íëęł  ěë íëĄęˇ¸ë¨
Thread(ě¤ë ë) : ě¤ë ëë ëě ěěě ěí íëě ě¤í ë¨ě
Handler : ë¤ëĽ¸ ę°ě˛´ę° ëł´ë¸ ëŠě¸ě§ëĽź ěě , ě˛ëŚŹíë ę°ě˛´
arg1, arg2 : int
obj : Object **

### 12/5 12:00 ~ 12:50 Firebase íëĄě í¸ ë§ë¤ę¸°!!
íëĄě í¸ ë§ë¤ę¸° -> íëĄě í¸ ě´ëŚ > ëíëŻźęľ­ ě í -> ěëëĄě´ë í´ëŚ­ > main í¨í¤ě§ ëłľěŹ ëśíëŁę¸° ěą ëąëĄ > ěëëĄě´ëě Json íěź ěśę° > Project app ëëęˇ¸ě¤ëëĄ­ > íëĄě í¸ gradle id 'com.google.gms.google-services' version '4.3.13' apply false sync now BUILD SUCCESSFUL íě¸íę¸° > ëŞ¨ë gradle id 'com.google.gms.google.services' ěśę° > dependencies ěśę° sync now SUCCESSFUL íě¸! * ě ěŠě´ ěë  ę˛˝ě° app Json íěź ě­ě  í ë¤ě ěśę°í´ëł´ę¸° * > Authentication ěěíę¸° > ě´ëŠěź/ëšë°ë˛í¸ Enabled, (add new provider), anonymous Enabled, Pw 8ěëŚŹ **
<
//firebase
implementation platform('com.google.firebase:firebase-bom:30.3.1')
implementation 'com.google.firebase:firebase-database:20.0.5'
implementation 'com.google.firebase:firebase-analytics'
implementation 'com.google.firebase:firebase-crashlytics-buildtools:2.9.2'
// firebase auth
implementation 'com.google.firebase:firebase-auth-ktx:21.0.8'

// firebaseě databaseě ě ęˇźíë ¤ëŠ´
implementation 'com.google.firebase:firebase-database-ktx:20.0.6'

// firebaseě storageěŹěŠ
implementation 'com.google.firebase:firebase-storage-ktx:20.0.2'
>

Thread 
ěť´í¨í°ě ěěě ë¨ě : íëĄě¸ě¤
LOL, EXCEL, íę¸ -> ěíí¸ě¨ě´
íę¸ -> ě¸ě, ë§ěś¤ë˛ ę˛ěŹ, ę¸ě í¤ě°ę¸°, íě´í íę¸°
ex) ę¸ě íě´í ëěě ě¸ě ę°ëĽ ě¸ě ě°ë ë, íě´í ě°ë ë
Thread ëěě ě§íëë ę˛ ě˛ëź ëł´ě
ě¸ě -> íě´í
ě¸ě 4ms íě´í milli = 10 ^ -3 

</details>

<details>
        <summary> đ 12/06</summary>
    
ëëě§ę˛ě, 
    
<details>
        <summary> 1 to 25 Code</summary>
    
```

        package com.example.dooo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlin.random.Random
import kotlin.random.nextInt

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val btnGame = findViewById<Button>(R.id.btnGame)
        val numbers = ArrayList<Int>()
        var cnt = 1 // íěŹ ëëŹěź ëë ěŤě

        rdSet(numbers, cnt)


        val btns = ArrayList<Button>()

        for (i in 1..25) {
            val resId = resources.getIdentifier("btn$i", "id", packageName)
            val btn = findViewById<Button>(resId)
            btns.add(btn)
            btn.visibility = View.INVISIBLE
        }

        btnGame.setOnClickListener {

            for (i in 0 until btns.size) {
                val btn = btns.get(i)
                btnSet(btn, numbers.get(i))
                btn.setOnClickListener {
                    if (btn.text.toString().toInt() == cnt) {
                        btn.visibility = View.INVISIBLE
                        cnt++

                        if (cnt % 25 == 1) {
                            rdSet(numbers, cnt)
                            for (j in 0 until btns.size) {
                                val btn = btns.get(j)
                                btnSet(btn, numbers.get(j))
                            }
                        }

                    }
                }

            }

        }


    }

    fun btnSet(btn: Button, value: Int) {
        btn.setText(value.toString())
        btn.visibility = View.VISIBLE
    }

    fun rdSet(numbers: ArrayList<Int>, cnt: Int) {
        numbers.clear()

        for (i in cnt..cnt + 24) {
            numbers.add(i)
        }

        for (i in 0 until 100) {
            val rdNum1 = Random.nextInt(25) // 0 ~ 25
            val rdNum2 = Random.nextInt(25) // 0 ~ 25

            // ě) rdNum1 = 3, rdNum2 = 6
            val temp = numbers.get(rdNum1)
            numbers[rdNum1] = numbers[rdNum2]
            numbers[rdNum2] = temp
        }

        Log.d("ëë¤", numbers.toString())
    }
}  
```
</details>
ęľŹę¸ë§ľ ěŹěŠíę¸°
https://developers.google.com/maps/documentation/android-sdk/start?hl=ko
API Key Manifestě ěśę° XXXXX *ëł´ě´ę¸°ëëŹ¸
    
    
AIzaSyBhY9buVEiMr-vjAJjE5xknQwFVwF8Yy1s
    
![image](https://user-images.githubusercontent.com/112377313/205807608-a6929d33-2b4f-48e3-a040-49ae54ad62fd.png)
    
![image](https://user-images.githubusercontent.com/112377313/205826634-35066d09-e07a-4007-9cb9-41465155c88f.png)

![image](https://user-images.githubusercontent.com/112377313/205827256-5bb90054-22de-4032-bdb8-850b1101df12.png)

![image](https://user-images.githubusercontent.com/112377313/205849110-585c86e0-8cc1-4f4d-9ac1-42408072bbeb.png)

![image](https://user-images.githubusercontent.com/112377313/205853376-ec041daf-4233-4023-8e04-6f7e728de119.png)
    
    
    
### ě¤íěë ë ě°¸ęł *

![image](https://user-images.githubusercontent.com/112377313/205853895-3c6098df-df03-4758-b469-964787bdaa80.png)

![image](https://user-images.githubusercontent.com/112377313/205853940-7ae85cfd-ffcb-486a-b79c-5be9ceea9219.png)

</details>

<details>
        <summary> đ 12/07</summary>

![image](https://user-images.githubusercontent.com/112377313/206062883-7d6a2c83-922f-4bb6-a59f-fe19b991fd47.png)
![image](https://user-images.githubusercontent.com/112377313/206062902-e803b828-07b3-46d4-81b2-8293fe58cf12.png)
![image](https://user-images.githubusercontent.com/112377313/206063051-5c6d4f3b-9a55-4d7d-9452-8aa4c12ee04c.png)
![image](https://user-images.githubusercontent.com/112377313/206065280-b6b750a8-c63c-45bb-86bb-3192b1757612.png)
![image](https://user-images.githubusercontent.com/112377313/206065642-6293d1a1-9dc5-4923-865d-1c88bf1a0b74.png)

### Glide
- ěëëĄě´ëěě ě´ëŻ¸ě§ëĽź ëš ëĽ´ęł  í¨ě¨ě ěźëĄ ëśëŹě¤ë ëźě´ë¸ëŹëŚŹ

![image](https://user-images.githubusercontent.com/112377313/206070719-beb603ba-eeeb-4373-b3cc-2f9529d74131.png)
![image](https://user-images.githubusercontent.com/112377313/206070833-cce2098e-03d8-4515-bcf8-22445dc5083c.png)
![image](https://user-images.githubusercontent.com/112377313/206071013-97538076-3a48-47e9-aec5-05aba33d5280.png)
![image](https://user-images.githubusercontent.com/112377313/206079935-e4ca8797-751b-4671-a2cf-1283952cd25f.png)
![image](https://user-images.githubusercontent.com/112377313/206095608-4299461e-5d6e-470e-8a68-3483bfd988c4.png)
![image](https://user-images.githubusercontent.com/112377313/206095849-c160abb3-f705-4a04-8be1-285db710dc7b.png)
![image](https://user-images.githubusercontent.com/112377313/206095865-3fa4f2ea-36f0-4b24-9c4f-b8d8aa04d0b3.png)
![image](https://user-images.githubusercontent.com/112377313/206098076-15c779f4-5e4c-45f1-bffb-aed84d778114.png)

IllegalArgumentException - ěě¸ě˛ëŚŹ 

ęľŹę¸ íě´ě´ë˛ ě´ě¤ ě°ë ëłę˛˝ ě˛Ťë˛ě§¸ę˛ěę¸ ě°¸ęł  (ě­ě )
![image](https://user-images.githubusercontent.com/112377313/206114582-edb173dd-9b8a-4a0c-914e-133afe3eafba.png)
![image](https://user-images.githubusercontent.com/112377313/206114891-51adccca-a5cd-4714-b431-159b174f2865.png)






</details>
    
<details>
        <summary> đ 12/08</summary>
    
ěąíęľŹí
ListVOę° ë¤ě´ę°ë data ---> ě ě˛´ëł´ę¸°ě ěë ë°ě´í°ę° ë¤ ë¤ě´ę°ěě
getContentDataí ë Bookmarklistě ěë ë°ě´í°ë§ ę°ě ¸ěě dataě addëěźí¨
1. GetBookmarkDataę° ě¤íëě ë´ę° ě°ě ëśë§íŹ ę˛ěëŹźě uid ę°ě ę°ě ¸ě¨ë¤
// bookmarkListę° ěąěě ¸ěě´ěź 2ë˛ě´ ě§íë  ě ěě
2. getContentDataë ěěě ě ě˛´ ë°ě´í°ëĽź ę°ě ¸ě¤ëę˛ ěëëź
ëśë§íŹę°ě°íěë ë°ě´í°ě¸ě§ ěëě§ëĽź íë¨í íě ě°íěěźëŠ´ dataě add í´ěźí¨
3. ë§ě˝ě ëśë§íŹëĽź 4ę° ě°ěěźëŠ´ 4ę°ě ëí ListVOę° dataě ěśę°ëě´ěě ęą°ęł 
ęˇ¸ěšęľŹëĽź adapterëĄ ëł´ë´ě¤ě setting
4. adapter ě ěŠ

https://devris.tistory.com/14
    
</details>
    
<details>
        <summary> đ 12/09</summary>
    
```
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnKeyListener
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// 1. ë¨źě  WordleAdapterě ěěąě(context, wordleList) ě¤ě 
// 3. WordleAdapter ę° RecyclerView.Adapter<ViewHolder>ëĽź ěě
class WordleAdapter(var context: Context, var wordleList: ArrayList<WordleVO>, var answer: String) :
    RecyclerView.Adapter<WordleAdapter.ViewHolder>() {
// 4. ęľŹíëě§ ěě member ęľŹí

    // 2. inner class ViewHolder ęľŹí
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // 5. ViewHolder field ęľŹěą (etWordle1 ~ etWordle5)
        val etWordle1: EditText
        val etWordle2: EditText
        val etWordle3: EditText
        val etWordle4: EditText
        val etWordle5: EditText

        init {
            // 6. init{}, findViewById()ëĽź íľí´ etWordle1 ~ etWordle5 ě´ę¸°í
            etWordle1 = itemView.findViewById(R.id.etWordle1)
            etWordle2 = itemView.findViewById(R.id.etWordle2)
            etWordle3 = itemView.findViewById(R.id.etWordle3)
            etWordle4 = itemView.findViewById(R.id.etWordle4)
            etWordle5 = itemView.findViewById(R.id.etWordle5)

            val etList = ArrayList<EditText>()
            etList.add(etWordle1)
            etList.add(etWordle2)
            etList.add(etWordle3)
            etList.add(etWordle4)
            etList.add(etWordle5)



            for (i in 0 until 4) {
                etList.get(i).setOnKeyListener(object : OnKeyListener {
                    override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
                        if (p2?.action == KeyEvent.ACTION_DOWN) {
                            etList.get(i + 1).requestFocus()
                        }
                        return false
                    }

                })
            }

//            etWordle1.setOnKeyListener(object :OnKeyListener{
//                override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
//                    if (p1 == KeyEvent.KEYCODE_A){
//                        etWordle2.requestFocus()
//                    }
//                    return false
//                }
//
//            })

            etWordle5.setOnKeyListener(object : OnKeyListener {
                override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
                    Log.d("íě¤í¸1", p1.toString())
                    Log.d("íě¤í¸2", p1.toString())
                    // 66ě ěí°
                    if (p1 == 66 && p2?.action == KeyEvent.ACTION_UP) {
                        Log.d("íě¤í¸3", "ěí° ëëŹě§")
//                        checkAnswer(answer, etList)
//                        disableEditText(etList)

                        // ě ëľ ěŹëśě ë°ëź ěęšě ëłííë ě˝ë


                    }

                    return false
                }

            })

        }
    }

    fun enableEditText(etList: ArrayList<EditText>) {
        for (i in 0 until etList.size) {
            etList.get(i).isEnabled = true
        }
    }

    fun disableEditText(etList: ArrayList<EditText>) {
        for (i in 0 until etList.size) {
            etList.get(i).isEnabled = false
        }
    }

    fun checkAnswer(answer: String, etList: ArrayList<EditText>) {
        // a  p  p  l  e -> ě ëľ
        // a  l  b  u  m -> ěë Ľ
        // ě´ ë¸ í í í
        for (i in 0 until etList.size) {
            val answerChar: Char = answer.get(i)
            val etChar: Char = etList.get(i).text.toString().single()

            if (answerChar == etChar) {
                etList.get(i).setBackgroundColor(Color.parseColor("green"))
            } else {
                var check = true

                for (j in 0 until etList.size) {
                    if (etChar == answer.get(j)) {
                        etList.get(i).setBackgroundColor(Color.parseColor("yellow"))
                        check = false
                    }
                }

                if (check == true) {
                    etList.get(i).setBackgroundColor(Color.parseColor("gray"))
                }

            }


        }
    }

    // 7. ě¤ë˛ëźě´ëŠ ë 3ę°ě ëŠěë ęľŹí
    // 9. onCreateViewHolder() -> layoutInflator ëĽź íľí´ xml -> view ëĄ ëłí
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.wordle_list, null)

        return ViewHolder(view)
    }

    // 11. wordleList.get(position).word1 ëąě íľí´ ę°ě ęşźë´ě setText
    // 10. onBindViewHolder() -> ë§ë¤ě´ě§ holder ěě etWordle1 ~ etWordle5ëĽź
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val etList = ArrayList<EditText>()
        etList.add(holder.etWordle1)
        etList.add(holder.etWordle2)
        etList.add(holder.etWordle3)
        etList.add(holder.etWordle4)
        etList.add(holder.etWordle5)

        holder.etWordle1.setText(wordleList.get(position).word1)
        holder.etWordle2.setText(wordleList.get(position).word2)
        holder.etWordle3.setText(wordleList.get(position).word3)
        holder.etWordle4.setText(wordleList.get(position).word4)
        holder.etWordle5.setText(wordleList.get(position).word5)

        if (position == 0) {
            enableEditText(etList)
        } else {
            disableEditText(etList)
        }

        holder.etWordle5.setOnKeyListener(object : OnKeyListener {
            override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
                if(p1 == KeyEvent.KEYCODE_ENTER && p2?.action == KeyEvent.ACTION_UP){
                    if(position==wordleList.size -1){
                        Toast.makeText(context, answer, Toast.LENGTH_SHORT).show()
                    }else{
                        checkAnswer(answer, etList)
                    }
                        disableEditText(etList)

                }
                return false
            }

        })
    }

    // 8. getItemCount -> wordleList ě íŹę¸°ëĽź ëŚŹí´
    override fun getItemCount(): Int {
        return wordleList.size
    }


}
```
gradle-module
![image](https://user-images.githubusercontent.com/112377313/206650566-f0c01ea4-d9f6-4117-99f3-927cfd476316.png)
![image](https://user-images.githubusercontent.com/112377313/206650714-36202a32-7035-418f-b7ae-498914d39bea.png)
![image](https://user-images.githubusercontent.com/112377313/206652380-e452e220-1e4e-4961-a8a7-e66142d9d30d.png)


</details>

<details>
        <summary> ě˝ë í ę¸ Code</summary>
    
```

```
</details>



</details>
