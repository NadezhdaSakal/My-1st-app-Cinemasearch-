package com.sakal_n.myapplicationcinemasearch.data

import com.sakal_n.myapplicationcinemasearch.R
import com.sakal_n.myapplicationcinemasearch.domain.Film


class MainRepository {
    val filmsDataBase = listOf(
        Film("The father", R.drawable.the_father, "A man refuses all assistance from his daughter as he ages. As he tries to make sense of his changing circumstances, he begins to doubt his loved ones, his own mind and even the fabric of his reality.\n",7.7f),
        Film("A quiet place. Part II",R.drawable.a_quiet_place_partll, "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize the creatures that hunt by sound are not the only threats lurking beyond the sand path.\n", 7.9f),
        Film("Black Widow", R.drawable.black_widow, "Natasha Romanoff confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises.\n", 6.7f),
        Film("Mare of Easttown", R.drawable.mare_of_easttown, "A detective in a small Pennsylvania town investigates a local murder while trying to keep her life from falling apart.\n", 8.7f),
        Film("Nine perfect strangers", R.drawable.nine_perfect_strangers, "Nine stressed city dwellers visit a boutique health-and-wellness resort that promises healing and transformation. The resort's director is a woman on a mission to reinvigorate their tired minds and bodies.\n", 9.7f),
        Film("The Suecide Squad", R.drawable.the_suecide_squad,"Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.\n", 8.6f),
        Film("The wolf of Wall Street", R.drawable.the_wolf_of_wall_street, "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.\n", 5.7f )
    )

}