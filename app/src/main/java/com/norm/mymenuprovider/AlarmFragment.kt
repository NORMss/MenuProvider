package com.norm.mymenuprovider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuProvider

class AlarmFragment : Fragment(), MenuProvider {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().addMenuProvider(this, viewLifecycleOwner)
    }

    companion object {
        @JvmStatic
        fun newInstance() = AlarmFragment()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.alarm_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.android -> {
                Toast.makeText(requireContext(), "Android", Toast.LENGTH_SHORT).show()
            }

            R.id.house -> {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.host, MainFragment.newInstance())
                    .commit()
            }

            R.id.item3 -> {
                Toast.makeText(requireContext(), "Item3", Toast.LENGTH_SHORT).show()
            }

            R.id.item4 -> {
                Toast.makeText(requireContext(), "Item4", Toast.LENGTH_SHORT).show()
            }

            R.id.item5 -> {
                Toast.makeText(requireContext(), "Item5", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}