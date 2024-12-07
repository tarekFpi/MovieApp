package com.example.mydevesstream.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mydevesstream.R

import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage


class OnboardingActivity : AppCompatActivity() {

    private var fragmentManager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)


        fragmentManager = supportFragmentManager


        val paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataforOnboarding())
        val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()

        fragmentTransaction.add(R.id.frame_layout, paperOnboardingFragment)

        paperOnboardingFragment.setOnRightOutListener {
            // Start the home page activity when swiping past the last screen
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Finish onboarding activity to prevent returning
        }
        fragmentTransaction.commit()

        }

    private fun getDataforOnboarding(): ArrayList<PaperOnboardingPage> {

        val source = PaperOnboardingPage(
            "Movie",
            "Our website and service uses cookies and similar technologies to provide",
            Color.parseColor("#ffb174"),
            R.drawable.image1,
            R.drawable.baseline_arrow_circle_right_24
        )
        val source1 = PaperOnboardingPage(
            "Movie",
            "Our website and service uses cookies and similar technologies to provide",
            Color.parseColor("#22eaaa"),
            R.drawable.image1,
            R.drawable.baseline_arrow_circle_right_24
        )
        val source2 = PaperOnboardingPage(
            "Movie",
            "Our website and service uses cookies and similar technologies to provide",
            Color.parseColor("#ee5a5a"),
            R.drawable.image1,
            R.drawable.baseline_arrow_circle_right_24
        )

        // array list is used to store
        // data of onbaording screen
        val elements = ArrayList<PaperOnboardingPage>()
        // all the sources(data to show on screens)
        // are added to array list
        elements.add(source)
        elements.add(source1)
        elements.add(source2)


        return elements
    }



    }
