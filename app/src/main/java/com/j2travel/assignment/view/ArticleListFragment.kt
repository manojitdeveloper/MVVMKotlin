package com.j2travel.assignment.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.j2travel.assignment.R
import com.j2travel.assignment.adapter.ArticleListAdapter
import com.j2travel.assignment.model.Articles
import com.j2travel.assignment.viewmodel.ArticleViewModel
import kotlinx.android.synthetic.main.fragment_article_list.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Article List Fragment Class
 */
class ArticleListFragment : Fragment() {

    private val artcleListModel: ArticleViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_article_list, container, false)
    }

    override fun onStart() {
        super.onStart()

        val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(requireView().context, RecyclerView.VERTICAL, false)

        getItemsFromViewModel()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipe_refreshing_layout.setOnRefreshListener {
            getItemsFromViewModel()
            swipe_refreshing_layout.isRefreshing = false
        }

    }

    private fun getItemsFromViewModel() {

        artcleListModel.getArticles()

        artcleListModel.articleList.observe(viewLifecycleOwner, Observer(function = fun(articles: List<Articles>?) {
            articles?.let {

                var productListAdapter: ArticleListAdapter = ArticleListAdapter(articles)
                recyclerView.adapter = productListAdapter
            }
        }))

    }

}
