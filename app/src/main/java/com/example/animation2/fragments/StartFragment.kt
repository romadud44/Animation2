package com.example.animation2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.animation2.R
import com.example.animation2.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    private var binding: FragmentStartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding?.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animationFade = AnimationUtils.loadAnimation(context, R.anim.fade)
        binding?.startBTN?.setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, ListFragment())
                .commit()
        }
        binding?.startBTN?.startAnimation(animationFade)
        binding?.textViewStartTV?.startAnimation(animationFade)
        binding?.imageViewStartIV?.startAnimation(animationFade)
    }
}