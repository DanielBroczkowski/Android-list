package com.example.appki1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //lateinit var textVIew1:TextView
    var list = mutableListOf<User>(User(1,"aa","bb"),User(2,"aa","bb"),User(3,"aa","bb"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView.text=savedInstanceState?.getString(STRING_KEY)?:getString(R.string.button_dodaj_text)

        button_add.setOnClickListener{
            textView.text ="${user_name.text}, ${user_forename.text}"
            var lastId = 1
            if(list.size != 0){
                lastId = list[list.size-1].ajdi + 1
            }

            Toast.makeText(this, lastId.toString(), Toast.LENGTH_SHORT).show()
            var newUser = User(lastId, user_name.text.toString(),user_forename.text.toString())
            list.add(newUser)
            loadData()
        }

        loadData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STRING_KEY, textView.text.toString())
    }
    companion object{
        var STRING_KEY = "user_key"
    }

    fun loadData(){
        //var users = dbHelper.allUse
        val adapter = UserListAdapter(list)
        list_of_users.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        list_of_users.adapter = adapter
    }
}
