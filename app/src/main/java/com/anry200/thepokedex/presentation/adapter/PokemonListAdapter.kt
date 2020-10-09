package com.anry200.thepokedex.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anry200.thepokedex.R
import com.anry200.thepokedex.domain.Pokemon
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class PokemonListAdapter: ListAdapter<Pokemon, PokemonListAdapter.PokemonViewHolder>(PokemonItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pokemon, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    class PokemonViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.name)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bindTo(pokemon: Pokemon){
            name.text = pokemon.name

            Picasso.get()
                .load(pokemon.imageUrl)
                .into(image, object: Callback {
                    override fun onSuccess() {
                        Log.d("Adapter","Loaded")
                    }

                    override fun onError(e: Exception?) {
                        Log.d("Adapter","Error", e)
                    }
                })
        }
    }

}