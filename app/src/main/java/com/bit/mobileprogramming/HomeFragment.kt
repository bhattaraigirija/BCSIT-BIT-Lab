package com.bit.mobileprogramming

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bit.mobileprogramming.navBarItem.ProfileFragment
import java.util.Locale

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDialoge = view.findViewById<Button>(R.id.btnDialoge)
        val btnNepali = view.findViewById<Button>(R.id.btnNep)
        val btnEnglish = view.findViewById<Button>(R.id.btnEng)

        btnDialoge.setOnClickListener{

            val builder = AlertDialog.Builder(requireContext())

            builder.setTitle("Logout")
            builder.setMessage("Do you want to logout?")
            builder.setPositiveButton("Yes"){
                btnDialoge,_ ->
                //handle positive button
                btnDialoge.dismiss()
                Toast.makeText(requireContext(), "Yes Clicked", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("No"){
                btnDialoge, _ ->
                //handle negative button
                btnDialoge.dismiss()
            }

            val dialog = builder.create()
            dialog.show()
        }

        btnNepali.setOnClickListener{
            val newLang = "ne"
            saveLanguagePreference(newLang)
            setLocale(newLang, requireContext())

            // Recreate activity to reflect the change
            requireActivity().recreate()
        }

        btnEnglish.setOnClickListener{
            val newLang = "en"
            saveLanguagePreference(newLang)
            setLocale(newLang, requireContext())

            // Recreate activity to reflect the change
            requireActivity().recreate()
        }


        val lrTask = view.findViewById<LinearLayout>(R.id.taskBtn)
        val lrProfile= view.findViewById<LinearLayout>(R.id.profileSection)

        lrTask.setOnClickListener {
            val intent = Intent(requireContext(), TasksActivity::class.java)
            startActivity(intent)

        }

        lrProfile.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "Ram Limbu")

            val fragment = ProfileFragment()
            fragment.arguments = bundle
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }


//        lrProfile.setOnClickListener{
//            requireContext().supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container,ProfileFragment())
//                .addToBackStack(null)
//                .commit()
//        }
//


//        val btnExample = view.findViewById<Button>(R.id.btnClickMe)
//        btnExample.setOnClickListener {
//
//            val intent = Intent(requireContext(), FormActivity::class.java)
//            startActivity(intent)
//
//        }
    }

    fun setLocale(language: String, context: Context): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        return context.createConfigurationContext(config)
    }


    private fun saveLanguagePreference(language: String) {
        val sharedPref = requireActivity().getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
        sharedPref.edit().putString("app_lang", language).apply()
    }

    private fun getSavedLanguage(): String {
        val sharedPref = requireActivity().getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
        return sharedPref.getString("app_lang", "en") ?: "en"
    }


}
