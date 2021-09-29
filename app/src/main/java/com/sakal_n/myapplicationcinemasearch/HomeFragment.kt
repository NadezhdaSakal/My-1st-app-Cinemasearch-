package com.sakal_n.myapplicationcinemasearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import java.util.*
import android.transition.Scene
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import kotlinx.android.synthetic.main.merge_home_screen_content.*


class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film("The father", R.drawable.the_father, "A man refuses all assistance from his daughter as he ages. As he tries to make sense of his changing circumstances, he begins to doubt his loved ones, his own mind and even the fabric of his reality.\n" +
                "\n"),
        Film("A quiet place. Part II",R.drawable.a_quiet_place_partll, "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize the creatures that hunt by sound are not the only threats lurking beyond the sand path.\n" +
                "\n"),
        Film("Black Widow", R.drawable.black_widow, "Natasha Romanoff confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises.\n" +
                "\n"),
        Film("Mare of Easttown", R.drawable.mare_of_easttown, "A detective in a small Pennsylvania town investigates a local murder while trying to keep her life from falling apart.\n" +
                "\n"),
        Film("Nine perfect strangers", R.drawable.nine_perfect_strangers, "Nine stressed city dwellers visit a boutique health-and-wellness resort that promises healing and transformation. The resort's director is a woman on a mission to reinvigorate their tired minds and bodies.\n" +
                "\n"),
        Film("The Suecide Squad", R.drawable.the_suecide_squad,"Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.\n" +
                "\n"),
        Film("The wolf of Wall Street", R.drawable.the_wolf_of_wall_street, "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.\n" +
                "\n")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scene = Scene.getSceneForLayout(home_fragment_root, R.layout.merge_home_screen_content, requireContext())

        val searchSlide = Slide(Gravity.TOP).addTarget(R.id.search_view)

        val recyclerSlide = Slide(Gravity.BOTTOM).addTarget(R.id.main_recycler)

        val customTransition = TransitionSet().apply {
            duration = 500
            addTransition(recyclerSlide)
            addTransition(searchSlide)
        }
        TransitionManager.go(scene, customTransition)

        search_view.setOnClickListener {
            search_view.isIconified = false
        }

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                val result = filmsDataBase.filter {
                    it.title.toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))
                }
                filmsAdapter.addItems(result)
                return true
            }
        })

        initRecyckler()
        filmsAdapter.addItems(filmsDataBase)
    }

    private fun initRecyckler() {

        main_recycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {

                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())

            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }

    }

}
