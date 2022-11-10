package perso.jfalck.mooviz.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import perso.jfalck.mooviz.repository.MoviesRepository
import perso.jfalck.mooviz.repository.MoviesRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class MoviesModule {

    @Binds
    abstract fun bindMoviesRepository(
        moviesRepositoryImpl: MoviesRepositoryImpl
    ): MoviesRepository
}