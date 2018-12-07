package com.kotensky.skibidichallenge.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotensky.skibidichallenge.R
import com.kotensky.skibidichallenge.listener.ListItemClickListener
import com.kotensky.skibidichallenge.model.entity.SoundBoardEntity
import kotlinx.android.synthetic.main.board_item.view.*

class BoardAdapter(private val items: ArrayList<SoundBoardEntity?>,
                   private val listItemClickListener: ListItemClickListener) : RecyclerView.Adapter<BoardAdapter.ItemViewHolder>() {


    companion object {
        const val SKIBIDI_DURATION = 1000L
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items.getOrNull(position)
        if (item != null) {
            holder.bind(item, listItemClickListener)
        }
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: SoundBoardEntity, listItemClickListener: ListItemClickListener) {
            startSkibidiAnimation(itemView)
        }

        private fun startSkibidiAnimation(itemView: View) {
//            itemView.titleTxt.startAnimation(AnimationUtils.loadAnimation(itemView.titleTxt.context, R.anim.infinity_title_anim))


            itemView.titleTxt.animate()
                    .translationY(25f)
                    .translationX(50f)
                    .setDuration(SKIBIDI_DURATION/2)
                    .withEndAction {
                        itemView.titleTxt.animate()
                                .translationY(50f)
                                .translationX(0f)
                                .setStartDelay(SKIBIDI_DURATION/6)
                                .setDuration(SKIBIDI_DURATION/4)
                                .withEndAction {
                                    itemView.titleTxt.animate()
                                            .translationY(25f)
                                            .translationX(50f)
                                            .setDuration(SKIBIDI_DURATION/2)
                                            .withEndAction {
                                                itemView.titleTxt.animate()
                                                        .translationY(0f)
                                                        .translationX(0f)
                                                        .setStartDelay(SKIBIDI_DURATION/6)
                                                        .setDuration(SKIBIDI_DURATION/4)
                                                        .withEndAction {
                                                            startSkibidiAnimation(itemView)
                                                        }
                                                        .start()
                                            }
                                            .start()
                                }
                                .start()
                    }
                    .start()

            itemView.descriptionTxt.animate()
                    .translationY(-25f)
                    .translationX(-50f)
                    .setDuration(SKIBIDI_DURATION/2)
                    .withEndAction {
                        itemView.descriptionTxt.animate()
                                .translationY(-50f)
                                .translationX(0f)
                                .setStartDelay(SKIBIDI_DURATION/6)
                                .setDuration(SKIBIDI_DURATION/4)
                                .withEndAction {
                                    itemView.descriptionTxt.animate()
                                            .translationY(-25f)
                                            .translationX(-50f)
                                            .setDuration(SKIBIDI_DURATION/2)
                                            .withEndAction {
                                                itemView.descriptionTxt.animate()
                                                        .translationY(0f)
                                                        .translationX(0f)
                                                        .setStartDelay(SKIBIDI_DURATION/6)
                                                        .setDuration(SKIBIDI_DURATION/4)
                                                        .start()
                                            }
                                            .start()
                                }
                                .start()
                    }
                    .start()

            itemView.boardItemContainer.animate()
                    .rotation(5f)
                    .translationY(5f)
                    .setDuration(SKIBIDI_DURATION/2)
                    .withEndAction {
                        itemView.boardItemContainer.animate()
                                .rotation(0f)
                                .translationY(0f)
                                .setStartDelay(SKIBIDI_DURATION/6)
                                .setDuration(SKIBIDI_DURATION/4)
                                .withEndAction {
                                    itemView.boardItemContainer.animate()
                                            .rotation(-5f)
                                            .translationY(5f)
                                            .setDuration(SKIBIDI_DURATION/2)
                                            .withEndAction {
                                                itemView.boardItemContainer.animate()
                                                        .rotation(0f)
                                                        .translationY(0f)
                                                        .setStartDelay(SKIBIDI_DURATION/6)
                                                        .setDuration(SKIBIDI_DURATION/4)
                                                        .start()
                                            }
                                            .start()
                                }
                                .start()
                    }
                    .start()
        }
    }
}