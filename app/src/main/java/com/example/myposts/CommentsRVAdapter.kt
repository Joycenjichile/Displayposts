package com.example.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.CommentListItemBinding


//import com.example.myposts.databinding.PostListItemBinding

class CommentsRVAdapter(var commentsList: List<Comment>):RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var  binding= CommentListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentcomments= commentsList.get(position)
        with(holder.binding){
            tvPostId .text=currentcomments.postId.toString()
            tvBodyy.text=currentcomments.body
            tvIdd.text=currentcomments.Id.toString()
            tvName.text=currentcomments.name
            tvEmail.text=currentcomments.email
//            tvBodyy.text=currentcomments.body
//            var context=holder.itemView.context
//            holder.binding.cvPost.setOnClickListener {
//                val intent= Intent(context, com.example.myposts.Comments::class.java)
//                intent.putExtra("POST_ID",currentcomments.Id)
//                context.startActivity(intent)
//            }
        }

    }

    override fun getItemCount(): Int {
      return commentsList.size

    }
}
class CommentsViewHolder(val binding: CommentListItemBinding):RecyclerView.ViewHolder(binding.root)
