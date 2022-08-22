package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.PostListItemBinding

class displayPostsRvAdapter(var displayPost: List<Post>) :
    RecyclerView.Adapter<RetrofitviewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitviewHolder {
        var binding =PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RetrofitviewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrofitviewHolder, position: Int) {
        var currentposts = displayPost.get(position)
        with(holder.binding){
            tvUserId.text=currentposts.userId.toString()
            tvId.text=currentposts.Id.toString()
            tvTitle.text=currentposts.title
            tvBody.text=currentposts.body
            var context=holder.itemView.context
            holder.binding.cvPosts.setOnClickListener {
                val intent=Intent(context,Comments::class.java)
                intent.putExtra("POST_ID",currentposts.Id)
                context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return displayPost.size

    }
}
class RetrofitviewHolder(val binding: PostListItemBinding):RecyclerView.ViewHolder(binding.root)