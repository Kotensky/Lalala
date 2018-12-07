package com.kotensky.skibidichallenge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.kotensky.skibidichallenge.adapter.BoardAdapter
import com.kotensky.skibidichallenge.listener.ListItemClickListener
import com.kotensky.skibidichallenge.model.entity.SoundBoardEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListItemClickListener {

    private var boardAdapter: BoardAdapter? = null
    private val items = ArrayList<SoundBoardEntity?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycler()
    }

    private fun setupRecycler() {
        items.add(SoundBoardEntity())
        items.add(SoundBoardEntity())
        items.add(SoundBoardEntity())
        items.add(SoundBoardEntity())
        items.add(SoundBoardEntity())
        items.add(SoundBoardEntity())
        items.add(SoundBoardEntity())
        boardAdapter = BoardAdapter(items, this)
        recyclerMain.adapter = boardAdapter
        recyclerMain.layoutManager = GridLayoutManager(this, 3)

    }


    override fun onItemClick(position: Int) {
    }
}
