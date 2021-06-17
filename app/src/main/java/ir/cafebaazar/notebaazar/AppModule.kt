package ir.cafebaazar.notebaazar

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.cafebaazar.notebaazar.data.db.ApplicationDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        ApplicationDatabase::class.java,
        "NoteBaazarDatabase"
    ).build()

    @Singleton
    @Provides
    fun provideNoteDao(applicationDatabase: ApplicationDatabase) = applicationDatabase.noteDao()

    @Singleton
    @Provides
    fun provideFolderDao(applicationDatabase: ApplicationDatabase) = applicationDatabase.folderDao()
}