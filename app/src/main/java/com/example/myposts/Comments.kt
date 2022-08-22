package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myposts.databinding.ActivityCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Comments : AppCompatActivity() {
    var postId=0
    lateinit var binding:ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPost()
        fetchPostById()
        setupToolbar()
        fetchComments()

    }
    fun obtainPost(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPostById(){
        val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getPostById(postId)
        request.enqueue(object :Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post=response.body()
                    binding.tvTittle.text=post?.title
                    binding.tvBodypost.text=post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun setupToolbar(){
        setSupportActionBar(binding.tbcomments)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }
    fun fetchComments(){
        var retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=retrofit.getComments()
        request.enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.isSuccessful){
                    var commentt=response.body()?: emptyList()
                    displayComments(commentt)

                }

            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }

        })
    }
    fun displayComments(commentsList: List<Comment>){
        val commentsAdapter=CommentsRVAdapter(commentsList)
        binding.rvDisplayy.layoutManager=LinearLayoutManager(this)
        binding.rvDisplayy.adapter=commentsAdapter

    }

}


