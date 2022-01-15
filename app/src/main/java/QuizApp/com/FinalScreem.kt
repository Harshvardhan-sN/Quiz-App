package QuizApp.com

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalScreem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_screem)

        val tvName: TextView = findViewById(R.id.tv_name_final)
        val tvResult: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.bt03)

        tvName.text = intent.getStringExtra(Const.USER_NAME)

        val totalQ = intent.getIntExtra(Const.TOTAL_QUESTION,0)
        val correctAns = intent.getIntExtra(Const.CORRECT_ANS,0)

        tvResult.text = "Your Score is $correctAns out of $totalQ"

        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}