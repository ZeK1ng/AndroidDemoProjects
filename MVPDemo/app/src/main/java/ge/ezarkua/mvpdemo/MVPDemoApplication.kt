package ge.ezarkua.mvpdemo

import android.app.Application
import ge.ezarkua.mvpdemo.data.DemoDatabase

class MVPDemoApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        DemoDatabase.createDatabase(this)
    }
}