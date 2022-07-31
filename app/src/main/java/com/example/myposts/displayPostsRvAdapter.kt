package com.example.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.PostListItemBinding

class displayPostsRvAdapter(var context: Context, var displayPost: List<Post>) :
    RecyclerView.Adapter<RetrofitviewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitviewHolder {
        var binding =PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RetrofitviewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrofitviewHolder, position: Int) {
        var Currentposts = displayPost.get(position)
        with(holder.binding){
            tvUserId.text=Currentposts.userId.toString()
            tvId.text=Currentposts.Id.toString()
            tvTitle.text=Currentposts.title
            tvBody.text=Currentposts.body

        }

    }

    override fun getItemCount(): Int {
        return displayPost.size

    }
}
class RetrofitviewHolder(val binding: PostListItemBinding):RecyclerView.ViewHolder(binding.root)