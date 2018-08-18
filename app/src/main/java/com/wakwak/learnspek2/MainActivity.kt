package com.wakwak.learnspek2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.wakwak.learnspek2.di.module.MainModule
import com.wakwak.learnspek2.presentation.main.MainPresenter
import com.wakwak.learnspek2.presentation.main.MainView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject { it.plus(MainModule()).inject(this) }
        presenter.attach(this)
        presenter.getGitHubUser()
    }

    override fun showGitHubUser(json: String) {
        textView.text = json
    }

    override fun showMessage(message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }
}
