package com.example.todoska

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemList)
        val items = arrayListOf<Item>()



        items.add(Item(1,"sofa","Диван","Хороший","Сделан из высококачетсвенных материалов",19000))
        items.add(Item(2,"light","Свет","Яркий","10000 Ватт",100))
        items.add(Item(3,"kitchen","Кухня","Современная","Сделана из высококачетсвенных материалов",75000))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}