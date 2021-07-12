package com.vodafone.unitytest.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.unity3d.nativecommunication.IUnityReceiver
import com.unity3d.nativecommunication.UnityReceiver
import com.unity3d.nativecommunication.UnitySender
import com.unity3d.player.UnityPlayer
import com.vodafone.unitytest.R

class MainFragment : Fragment(), IUnityReceiver {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var unityPlayer: UnityPlayer? = null
    private var frameLayoutForUnity: FrameLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val root = inflater.inflate(R.layout.main_fragment, container, false)
        UnityReceiver.SetListener(this)
        unityPlayer = UnityPlayer(activity)
        frameLayoutForUnity = root as FrameLayout
        frameLayoutForUnity!!.addView(
            unityPlayer!!.view,
            FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT
        )
        unityPlayer!!.requestFocus()
        unityPlayer!!.windowFocusChanged(true)


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadModel()
    }

    private fun loadModel() {
//        UnitySender.LoadScene("ModelScene")
    }

    override fun onDestroy() {
        unityPlayer!!.quit()
        super.onDestroy()
    }

    override fun onPause() {
        super.onPause()
        unityPlayer!!.pause()
    }

    override fun onResume() {
        super.onResume()
        unityPlayer!!.resume()
    }

    override fun onSceneLoaded(sceneName: String?) {
        Toast.makeText(activity, sceneName, Toast.LENGTH_SHORT).show()
    }
}