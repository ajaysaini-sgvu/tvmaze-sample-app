/*
 * Copyright 2018 Ajay Saini
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.lovoo.android.ui.episode

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lovoo.android.R
import com.lovoo.android.data.model.episode.EpisodeResponse
import kotlinx.android.synthetic.main.episode_list_item.view.*

class EpisodeAdapter(private val episodes: List<EpisodeResponse>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.episode_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(episodes[position])
    }

    override fun getItemCount() = episodes.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(episodeResponse: EpisodeResponse) {

            itemView.episode_number_text.text = episodeResponse.name
            itemView.release_date_text.text = episodeResponse.airdate

            itemView.setOnClickListener {
                onItemClickListener.onClick(episodeResponse)
            }
        }
    }

    interface OnItemClickListener {
        fun onClick(episode: EpisodeResponse)
    }

}