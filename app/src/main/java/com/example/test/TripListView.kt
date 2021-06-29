package com.example.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TripListView (val context: Context, val tripList: ArrayList<Trip>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_trip, null)

        /* 위에서 생성된 view를 res-layout-list_trip.xml 파일의 각 View와 연결하는 과정이다. */
        val trip_name = view.findViewById<TextView>(R.id.Trip_Name)
        val trip_like = view.findViewById<TextView>(R.id.like)
        val trip_review = view.findViewById<TextView>(R.id.review)
        val trip_score = view.findViewById<TextView>(R.id.score)

        /* ArrayList<Trip>의 변수 trip의 데이터를 TextView에 담는다. */
        val trip = tripList[position]
        trip_name.text = trip.name
        trip_like.text = trip.like
        trip_review.text = trip.review
        trip_score.text = trip.score

        return view
    }

    override fun getItem(position: Int): Any {
        return tripList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return tripList.size
    }
}