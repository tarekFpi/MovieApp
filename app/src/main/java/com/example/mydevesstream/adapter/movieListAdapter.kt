package com.example.mydevesstream.adapter
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydevesstream.databinding.VidoeLayoutBinding
import com.example.mydevesstream.model.movieList.Search
import com.squareup.picasso.Picasso


class MovieListAdapter(private val context: Context,
                       private var movieList: ArrayList<Search>
                       ): RecyclerView.Adapter<MovieListAdapter.MyviewHolder>() {

    private var listposition = -1
    private var clickLisiner: onItemClickLisiner? = null

  inner class MyviewHolder(val binding: VidoeLayoutBinding) : View.OnClickListener, RecyclerView.ViewHolder(binding.root) {

      init {
          itemView.setOnClickListener(this)
      }
      override fun onClick(v: View?) {
          val position: Int = adapterPosition
          clickLisiner?.OnClickLisiner(position)
      }
  }
    interface onItemClickLisiner {
        fun OnClickLisiner(position: Int)
    }

    fun setOnItemClick(clickLisiner: onItemClickLisiner?) {
        this.clickLisiner = clickLisiner!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

        val binding = VidoeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyviewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(list: ArrayList<Search>) {

        this.movieList =list
        notifyDataSetChanged()
    }

    fun filterdList(filterList: ArrayList<Search>) {

        movieList = filterList

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = movieList.size

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        val itemPosition = movieList[position]

        holder.binding.textMovieName.text ="title:"+  itemPosition.Title

        holder.binding.movieTextYear.text ="year:"+  itemPosition.Year

       Picasso.get().load(itemPosition.Poster).into(holder.binding.movieImage)

        setAnimiton(holder.itemView, position)
    }

    fun setAnimiton(viewAnimition: View, position: Int) {
        if (position > listposition) {
            val animation = android.view.animation.AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
            animation.duration = 1000
            viewAnimition.startAnimation(animation)
            listposition = position
        }
    }
}