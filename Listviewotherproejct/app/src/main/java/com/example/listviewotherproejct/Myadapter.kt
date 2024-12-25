package com.example.listviewotherproejct

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listviewotherproject.R
import de.hdodenhof.circleimageview.CircleImageView

class Myadapter(val context: Activity, private val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.eachitem, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.textView3)
        val lastmsg = view.findViewById<TextView>(R.id.textView4)
        val time = view.findViewById<TextView>(R.id.lasttime)

        name.text = arrayList[position].name
        lastmsg.text = arrayList[position].lastmsg
        time.text = arrayList[position].lastmsgtime
        image.setImageResource(arrayList[position].imageid)

        return view
    }
}
