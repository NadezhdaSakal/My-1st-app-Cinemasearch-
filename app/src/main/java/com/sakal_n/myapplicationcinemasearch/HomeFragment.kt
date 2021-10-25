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


class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film("The father", R.drawable.the_father, "A man refuses all assistance from his daughter as he ages. As he tries to make sense of his changing circumstances, he begins to doubt his loved ones, his own mind and even the fabric of his reality.\n",7.7f),
        Film("A quiet place. Part II",R.drawable.a_quiet_place_partll, "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize the creatures that hunt by sound are not the only threats lurking beyond the sand path.\n", 7.9f),
        Film("Black Widow", R.drawable.black_widow, "Natasha Romanoff confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises.\n", 6.7f),
        Film("Mare of Easttown", R.drawable.mare_of_easttown, "A detective in a small Pennsylvania town investigates a local murder while trying to keep her life from falling apart.\n", 8.7f),
        Film("Nine perfect strangers", R.drawable.nine_perfect_strangers, "Nine stressed city dwellers visit a boutique health-and-wellness resort that promises healing and transformation. The resort's director is a woman on a mission to reinvigorate their tired minds and bodies.\n", 9.7f),
        Film("The Suecide Squad", R.drawable.the_suecide_squad,"Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.\n", 8.6f),
        Film("The wolf of Wall Street", R.drawable.the_wolf_of_wall_street, "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.\n", 5.7f )
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

        AnimationHelper.performFragmentCircularRevealAnimation(home_fragment_root, requireActivity(), 1)

        initSearchView()

        //находим наш RV
        initRecyckler()
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }

    private fun initSearchView() {


        search_view.setOnClickListener {
            search_view.isIconified = false
        }

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                val result = filmsDataBase.filter {
                    it.title.toLowerCase(Locale.getDefault())
                        .contains(newText.toLowerCase(Locale.getDefault()))
                }
                filmsAdapter.addItems(result)
                return true
            }
        })


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
