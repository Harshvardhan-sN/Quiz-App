package QuizApp.com

object Const {

    const val USER_NAME: String= "user_name"
    const val TOTAL_QUESTION: String= "Total_question"
    const val CORRECT_ANS: String = "correct_answer"




    fun getQues(): ArrayList<Question> {
        val quesList = ArrayList<Question>()

        // 1
        val q1 = Question(
            1,"What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina","Turkey"
            ,"USA","Austria",
            1
        )
        quesList.add(q1)

        // 2
        val q2 = Question(
            2,"What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Denmark","Australia"
            ,"Kuwait","Sweden",
            2
        )
        quesList.add(q2)

        // 3
        val q3 = Question(
            3,"What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Iran","Germany"
            ,"New Zealand","India",
            4
        )
        quesList.add(q3)

        // 4
        val q4 = Question(
            4,"What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Belgium","Fiji"
            ,"Germany","Austria",
            3
        )
        quesList.add(q4)

        // 5
        val q5 = Question(
            5,"What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Fiji","Australia"
            ,"Iran","Brazil",
            1
        )
        quesList.add(q5)

        // 6
        val q6 = Question(
            6,"What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "India","Germany"
            ,"Belgium","Brazil",
            4
        )
        quesList.add(q6)

        // 7
        val q7 = Question(
            7,"What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Sri Lanka","Belgium"
            ,"America","Germany",
            2
        )
        quesList.add(q7)

        // 8
        val q8 = Question(
            8,"What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Congo Republic","Australia"
            ,"New Zealand","Kenya",
            3
        )
        quesList.add(q8)

        // 9
        val q9 = Question(
            9,"What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark","Oman"
            ,"Kuwait","Indonesia",
            1
        )
        quesList.add(q9)

        // 10
        val q10 = Question(
            10,"What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "England","Morocco"
            ,"Italy","Kuwait",
            4
        )
        quesList.add(q10)



        return quesList
    }
}