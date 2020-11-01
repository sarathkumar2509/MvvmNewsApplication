package com.androiddevs.mvvmnewsapp.newsapp.repository

import com.androiddevs.mvvmnewsapp.newsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.newsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.newsapp.models.Article

class NewsRepository(
    val db : ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode : String , pageNumber : Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)


    suspend fun searchNews(searchuery : String , pageNumber: Int)=
        RetrofitInstance.api.searchForNews(searchuery,pageNumber)

    suspend fun upsert(article : Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)


}