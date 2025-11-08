package com.schoppan.jokeapp.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.schoppan.jokeapp.R

class AboutFragment : Fragment(R.layout.fragment_about) {

    private var expanded = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * Alterna entre mostrar texto reduzido (3 linhas + reticências) e expandido (todo o conteúdo).
     */
    fun toggleCredits(view: View) {
        val tv = view as TextView
        if (expanded) {
            tv.maxLines = 3
            tv.ellipsize = TextUtils.TruncateAt.END
        } else {
            tv.maxLines = Int.MAX_VALUE
            tv.ellipsize = null
        }
        expanded = !expanded
    }
}
