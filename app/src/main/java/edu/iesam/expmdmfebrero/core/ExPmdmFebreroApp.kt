package edu.iesam.expmdmfebrero.core

import android.app.Application
import edu.iesam.expmdmfebrero.core.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
//import org.koin.ksp.generated.module

class ExPmdmFebreroApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ExPmdmFebreroApp)
            //modules(AppModule().module)
        }
    }
}