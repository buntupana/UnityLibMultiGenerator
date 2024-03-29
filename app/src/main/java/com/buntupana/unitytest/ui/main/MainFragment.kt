package com.buntupana.unitytest.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.buntupana.unitytest.R
import com.unity3d.nativecommunication.IUnityReceiver
import com.unity3d.nativecommunication.UnityReceiver
import com.unity3d.player.UnityPlayer

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

    override fun onVideoPlayerLoaded(mediaUrl: String?, length: Float) {
        TODO("Not yet implemented")
    }

    override fun onVideoPlayerProgress(time: Float) {
        TODO("Not yet implemented")
    }

    override fun onVideoPlayerFinished() {
        TODO("Not yet implemented")
    }

    override fun onVideoPlayerError(error: String?) {
        TODO("Not yet implemented")
    }

    override fun onARPlayerLoaded(mediaUrl: String?) {
        TODO("Not yet implemented")
    }

    override fun onARPlayerProgress(progress: Float) {
        TODO("Not yet implemented")
    }

    override fun onARPlayerError(error: String?) {
        TODO("Not yet implemented")
    }

    override fun onARPlayerStatus(level: Int, status: String?, noTrackingReason: String?) {
        TODO("Not yet implemented")
    }

    override fun onARPlayerPositioned(isInverted: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onContentVersionMismatch(error: String?) {
        TODO("Not yet implemented")
    }

    override fun onVolumetricReady(mediaUrl: String?) {
        TODO("Not yet implemented")
    }

    override fun onVolumetricLoaded(mediaUrl: String?) {
        TODO("Not yet implemented")
    }

    override fun onVolumetricError(error: String?) {
        TODO("Not yet implemented")
    }

    override fun onScreenVideoSaved(path: String?) {
        TODO("Not yet implemented")
    }

    override fun onScreenShotSaved(path: String?) {
        TODO("Not yet implemented")
    }

    override fun onScreenVideoError(error: String?) {
        TODO("Not yet implemented")
    }

    override fun onScreenShotError(error: String?) {
        TODO("Not yet implemented")
    }
}