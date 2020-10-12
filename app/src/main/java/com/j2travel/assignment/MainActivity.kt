package com.j2travel.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.j2travel.assignment.view.ArticleListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_container, ArticleListFragment()).commit()
    }
}
