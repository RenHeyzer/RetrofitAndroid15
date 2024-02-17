package com.geeks.retrofitandroid15.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.geeks.retrofitandroid15.data.models.Post
import com.geeks.retrofitandroid15.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createPost()
        updatePost()
    }

    private fun createPost() = with(binding) {
        btnCreatePost.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val body = etBody.text.toString().trim()
            val newPost = Post(
                userId = 10,
                id = 101,
                title = title,
                body = body
            )

            viewModel.createNewPost(
                post = newPost,
                onSuccess = { post ->
                    Log.i("CREATE_POST", post.toString())
                },
                onFailure = { message ->
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    private fun updatePost() = with(binding) {
        btnUpdatePost.setOnClickListener {
            val postId = 19
            val title = etTitle.text.toString().trim()
            val body = etBody.text.toString().trim()
            val updatedPost = Post(
                userId = 2,
                id = postId,
                title = title,
                body = body
            )

            viewModel.updatePost(
                postId = postId,
                post = updatedPost,
                onSuccess = { post ->
                    Log.i("UPDATE_POST", post.toString())
                },
                onFailure = { message ->
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}