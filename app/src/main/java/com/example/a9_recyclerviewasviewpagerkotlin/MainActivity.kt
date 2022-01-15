package com.example.a9_recyclerviewasviewpagerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.a6_recyclerviewinsidenestedscrollviewkotlin.User
import com.example.a6_recyclerviewinsidenestedscrollviewkotlin.UserAdapter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList: ArrayList<User>
    lateinit var userAdapter: UserAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        userArrayList = ArrayList()
        userAdapter = UserAdapter(this, userArrayList)
        for (i in 0..49) {
            userArrayList.add(User("James"))
        }
        recyclerView.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
        recyclerView.setAdapter(userAdapter)
        recyclerView.setNestedScrollingEnabled(true)

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        recyclerView.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val layoutManager = (recyclerView.layoutManager as LinearLayoutManager?)!!
                val activePosition = layoutManager.findFirstVisibleItemPosition()
                if (activePosition == RecyclerView.NO_POSITION) return
                Toast.makeText(
                    applicationContext,
                    activePosition.toString() + "th page",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }
}