package masli.prof.motivator.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import masli.prof.motivator.APP
import masli.prof.motivator.APP_PREFERENCES
import masli.prof.motivator.APP_PREFERENCES_SCORE

object SharedPreferences {

    var sp: SharedPreferences? = null

    init {
        sp = APP.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
    }

    fun getScore(): Int {
        return sp?.getInt(APP_PREFERENCES_SCORE, 0) ?: throw ExceptionInInitializerError("Shared preferences is not initialized")
    }

    fun setScore(score: Int) {
        sp?.edit()?.putInt(APP_PREFERENCES_SCORE, score)?.apply()
    }
}