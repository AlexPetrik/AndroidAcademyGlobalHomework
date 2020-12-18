package ru.alexpetrik.androidacademyglobalhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorListAdapter(): RecyclerView.Adapter<ActorListViewHolder>() {

    private var actors: List<Actor> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorListViewHolder =
        ActorListViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_actor, parent, false))

    override fun onBindViewHolder(holder: ActorListViewHolder, position: Int) {
        holder.onBind(actors[position])
    }

    override fun getItemCount() = actors.size

    fun bindMovies(newActors: List<Actor>) {
        actors = newActors
        notifyDataSetChanged()
    }
}

class ActorListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val actorNameTextView: TextView = itemView.findViewById(R.id.actor_name)
    private val actorImgImageView: ImageView = itemView.findViewById(R.id.actor_avatar)

    fun onBind(actor: Actor) {
        actorNameTextView.text = actor.name
        actorImgImageView.setImageResource(actor.photo)
    }

}
