package com.example.ryousuke.advancedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ryousuke.advancedrecyclerview.adapter.ToDoAdapter
import com.example.ryousuke.advancedrecyclerview.data.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //空のリストを作る, 型指定でエラーを回避→表示するクラスの方今回は(Todo型)
        var todoList = mutableListOf<Todo>()


        val adapter = ToDoAdapter(todoList)
        todo_RV.adapter = adapter

        //ここの処理の意味
        todo_RV.layoutManager = LinearLayoutManager(this)

        todo_Btn.setOnClickListener {
            val title = todo_ET.text.toString()
            val todo = Todo(title,false)

            //ここで追加
            todoList.add(todo)

            //変化があるときはこれで変化の確認をする
            adapter.notifyItemInserted(todoList.size -1)

        }
    }
}