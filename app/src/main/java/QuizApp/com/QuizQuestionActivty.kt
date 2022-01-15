package QuizApp.com

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionActivty : AppCompatActivity(), View.OnClickListener {

    private var nCurrPosition: Int = 1
    private var nQList: ArrayList<Question>? = null
    private var nSelectedOp: Int = 0

    private var nUserName: String? = null
    private var nCorrectAns: Int = 0

    private var proBar: ProgressBar? = null
    private var tvPro: TextView? = null
    private var tvQuestion: TextView? = null
    private var image: ImageView? = null

    private var tvOp1: TextView? = null
    private var tvOp2: TextView? = null
    private var tvOp3: TextView? = null
    private var tvOp4: TextView? = null

    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question_activty)

        nUserName = intent.getStringExtra(Const.USER_NAME)

        proBar = findViewById(R.id.proBar)
        tvPro = findViewById(R.id.tvPro)
        tvQuestion = findViewById(R.id.tv1)
        image = findViewById(R.id.img1)
        tvOp1 = findViewById(R.id.op1)
        tvOp2 = findViewById(R.id.op2)
        tvOp3 = findViewById(R.id.op3)
        tvOp4 = findViewById(R.id.op4)

        btnSubmit = findViewById(R.id.bt02)

        tvOp1?.setOnClickListener(this)
        tvOp2?.setOnClickListener(this)
        tvOp3?.setOnClickListener(this)
        tvOp4?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)

        nQList = Const.getQues()

        setQuestion()


    }

    private fun setQuestion() {

        defaultOp()

        val q: Question = nQList!![nCurrPosition - 1]
        image?.setImageResource(q.Image)

        proBar?.progress = nCurrPosition
        tvPro?.text = "$nCurrPosition / ${proBar?.max}"

        tvQuestion?.text = q.question

        tvOp1?.text = q.optionOne
        tvOp2?.text = q.optionTwo
        tvOp3?.text = q.optionThree
        tvOp4?.text = q.optionFour

        if(nCurrPosition == nQList!!.size){
            btnSubmit?.text = "Finish"
        }
        else{
            btnSubmit?.text = "Submit"
        }
    }

    private fun defaultOp(){
        val option =  ArrayList<TextView>()
        tvOp1?.let {
            option.add(0,it)
        }
        tvOp2?.let {
            option.add(1,it)
        }
        tvOp3?.let {
            option.add(2,it)
        }
        tvOp4?.let {
            option.add(3,it)
        }

        for(i in option){
            i.setTextColor(Color.parseColor("#FFFFFFFF"))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(
                this,
                //R.drawable.defualt_option_border_bg
                R.drawable.selection_border_bg
            )
        }
    }
    private fun nSelectedOp(tv: TextView, setOp: Int){
        defaultOp()

        nSelectedOp = setOp
        tv.setTextColor(Color.parseColor("#ccff33"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.defualt_option_border_bg
            // R.drawable.selection_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.op1 ->{
                tvOp1?.let {
                    nSelectedOp(it,1)
                }
            }
            R.id.op2 ->{
                tvOp2?.let {
                    nSelectedOp(it,2)
                }
            }
            R.id.op3 ->{
                tvOp3?.let {
                    nSelectedOp(it,3)
                }
            }
            R.id.op4 ->{
                tvOp4?.let {
                    nSelectedOp(it,4)
                }
            }
            R.id.bt02 ->{
                if(nSelectedOp == 0){
                    nCurrPosition++
                    when{
                        nCurrPosition <= nQList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            val intent= Intent(this, FinalScreem::class.java)
                            intent.putExtra(Const.USER_NAME, nUserName)
                            intent.putExtra(Const.CORRECT_ANS, nCorrectAns)
                            intent.putExtra(Const.TOTAL_QUESTION, nQList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = nQList?.get(nCurrPosition - 1)
                    if(question!!.correctAns != nSelectedOp){
                        ansView(nSelectedOp,R.drawable.wrong_correct_defualt_option_border_bg)
                    }
                    else{
                        nCorrectAns++
                    }
                    ansView(question.correctAns,R.drawable.correct_defualt_option_border_bg)

                    if(nCurrPosition == nQList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else{
                        btnSubmit?.text = "Next Question"

                    }
                    nSelectedOp = 0;
                }
            }
        }
    }
    private fun ansView(answer: Int,drawView: Int){
        when(answer){
            1 -> {
                tvOp1?.background = ContextCompat.getDrawable(
                    this,
                    drawView
                )
            }
            2 -> {
                tvOp2?.background = ContextCompat.getDrawable(
                    this,
                    drawView
                )
            }
            3 -> {
                tvOp3?.background = ContextCompat.getDrawable(
                    this,
                    drawView
                )
            }
            4 -> {
                tvOp4?.background = ContextCompat.getDrawable(
                    this,
                    drawView
                )
            }
        }
    }

}

