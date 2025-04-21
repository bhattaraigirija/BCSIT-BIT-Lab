package com.bit.mobileprogramming.navBarItem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bit.mobileprogramming.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Safe way to read arguments
        val name = arguments?.getString("name")
        name?.let {
            Toast.makeText(requireContext(), "Name: $it", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
