package com.ldg.ncsplayer.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.ldg.ncsplayer.ui.list.ListFragment
import com.ldg.ncsplayer.ui.player.PlayerFragment
import javax.inject.Inject

class MainFragmentFactory
@Inject constructor(): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            PlayerFragment::class.java.name->{
                PlayerFragment()
            }
            ListFragment::class.java.name->{
                ListFragment()
            }
            else ->
                super.instantiate(classLoader, className)
        }

    }
}