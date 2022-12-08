package com.example.fullstackapplication.board

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.fullstackapplication.R
import com.example.fullstackapplication.utils.FBAuth
import com.example.fullstackapplication.utils.FBdatabase
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output.ByteArrayOutputStream
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class BoardWriteActivity : AppCompatActivity() {

    lateinit var imgLoad: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_write)

        // id값 찾아오기
        imgLoad = findViewById(R.id.imgLoad)
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etContent = findViewById<EditText>(R.id.etContent)
        val imgWrite = findViewById<ImageView>(R.id.imgWrite)

        // 갤러리로 이동해서 이미지를 받아오는
        imgLoad.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            launcher.launch(intent)
        }

        // 모든 값(title content )을 Firebase 에 저장시켜줘야함
        imgWrite.setOnClickListener {
            val title = etTitle.text.toString()
            val content = etContent.text.toString()

            // board
            // - key (게시물의 고유한 uid :  push() )
            //      - boardVO(title, content, 사용자 uid, time)
//            FBdatabase.getBoardRef()
//                .push()
//                .setValue(BoardVO("1","1","1","1"))

            // auth
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()
            // 실제 데이터를 넣어주자
            // setValue 가 되기전에 미리 BoardVO가 저장될 key값(uid_)을 만들기
            var key =FBdatabase.getBoardRef().push().key.toString()
            FBdatabase.getBoardRef().child(key).setValue(BoardVO(title, content, uid, time))
            imgUpload(key)
            finish() // 이전페이지로 돌아가기
        }
    } // onCreate 밖

    fun imgUpload(key : String) {

        val storage = Firebase.storage
        val storageRef = storage.reference
        val mountainsRef = storageRef.child("$key.png")

        imgLoad.isDrawingCacheEnabled = true
        imgLoad.buildDrawingCache()
        val bitmap = (imgLoad.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        // 50~60 으로 설정 100은 무리있을수있음?
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos)
        val data = baos.toByteArray()

        // storage 저장 경로
        var uploadTask = mountainsRef.putBytes(data)
        uploadTask.addOnFailureListener {
            // 실패했을 경우
        }.addOnSuccessListener { taskSnapshot ->
            // 성공했을 경우
        }
    }

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            imgLoad.setImageURI(it.data?.data)
        }

    }
}