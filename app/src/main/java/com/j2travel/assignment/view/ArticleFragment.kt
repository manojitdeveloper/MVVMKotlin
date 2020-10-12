package com.j2travel.assignment.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.j2travel.assignment.R

/**
 * A simple [Fragment] subclass.
 */
class ArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the adapter_article_list for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)
    }


}
