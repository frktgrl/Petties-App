package com.ftgrl.petdomes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ftgrl.petdomes.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate (layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth
        val currentUser = auth.currentUser //Hesabı açık kullanıcı varsa

        if(currentUser !=null){

            val intent= Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }





    }

    fun signinClick( view : View) {

        val email = binding.userMail.text.toString() //email alma
        val password = binding.userPassword.text.toString() //Sifre alma

        if (email.equals("") || password.equals("")){

            Toast.makeText(this,"Enter Email",Toast.LENGTH_LONG).show()
        }else  {

            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {

                val intent = Intent (this@MainActivity, FeedActivity::class.java) //Dogru bilgilerse main activityden feed activity git
                startActivity(intent)
                finish()

            }.addOnFailureListener {

                Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }

    }

    fun signupClick( view : View) {

        val email = binding.userMail.text.toString()  //Email alma
        val password = binding.userPassword.text.toString() //Sifre Alma

        if (email.equals("") || password.equals("")) {

            Toast.makeText(this,"Enter email and password",Toast.LENGTH_LONG).show() //Email veya sifre bossa hata ver
        }else {
            //bos degilse email ve sifre al
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {

                val intent = Intent (this@MainActivity, FeedActivity::class.java) //Dogru bilgilerse main activityden feed activity git
                startActivity(intent)
                finish()
            }.addOnFailureListener {

                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()

            }

        }

    }





}