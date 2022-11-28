package com.example.dz_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import com.example.dz_6.databinding.FragmentPlaylistBinding


class PlaylistFragment : Fragment() {
    private lateinit var binding: FragmentPlaylistBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = SongsAdapter(uploadSongs(), this::onItemClick)
        binding.rvSongs.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }

    private fun uploadSongs() = listOf(
        Music("1", "Eminem", "Хочу", "1:00"),
        Music("2", "Skillet", "10", "3:00"),
        Music("3", "Ice Cube", "баллов", "4:00"),
        Music("4", "2Pac", "за ", "5:00"),
        Music("5", "Eazy-e", "дз", "20:00"),
    )

    private fun onItemClick(title: String) {
        requireActivity().supportFragmentManager.findFragmentById(R.id.album_fragment)?.view?.isGone =
            true
        val bundle = Bundle()
        bundle.putString("Music Eminem", title)
        val singleSongFragment = SingleSongFragment()
        singleSongFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.songs_fragment, singleSongFragment).commit()
    }
}