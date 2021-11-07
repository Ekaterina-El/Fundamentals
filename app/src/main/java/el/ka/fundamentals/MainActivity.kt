package el.ka.fundamentals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoList = mutableListOf(
            Todo("Купить короссовки", false),
            Todo("Пробежать 10 км", true),
            Todo("Побывать за границей", false),
        )

        val adapter = TodoAdapter(todoList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        addTodo.setOnClickListener {
            todoList.add(Todo(etTodo.text.toString(), false))
            adapter.notifyItemInserted(todoList.size)
            etTodo.setText("")
        }
    }
}