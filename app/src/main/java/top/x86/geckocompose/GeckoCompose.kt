package top.x86.geckocompose

import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoSession.ContentDelegate
import org.mozilla.geckoview.GeckoView


@Composable
fun GeckoComposeView(session: GeckoSession, runtime: GeckoRuntime, url: String) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = {context ->
            Log.d("GeckoComposeView", "创建GeckoView")
            GeckoView(context).apply {
                session.open(runtime)
                setSession(session)
            }
        },
        update = {
            it.session!!.loadUri(url)
        }
    )
}