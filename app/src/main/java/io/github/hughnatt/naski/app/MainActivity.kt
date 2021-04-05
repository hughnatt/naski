package io.github.hughnatt.naski.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import io.github.hughnatt.naski.R

class MainActivity : AppCompatActivity() {

    // MARK - Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareView();
    }

    // MARK - Private

    private fun prepareView() {
        setContentView(R.layout.activity_main)
    }
}