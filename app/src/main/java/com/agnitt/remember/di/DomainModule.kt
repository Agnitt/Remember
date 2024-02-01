package com.agnitt.remember.di

import com.agnitt.remember.domain.CategoryInteractor
import com.agnitt.remember.domain.CategoryInteractorImpl
import com.agnitt.remember.domain.CommonInteractor
import com.agnitt.remember.domain.CommonInteractorImpl
import com.agnitt.remember.domain.ItemInteractor
import com.agnitt.remember.domain.ItemInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun provideItemInteractor(interactor: ItemInteractorImpl): ItemInteractor

    @Binds
    abstract fun provideCategoryInteractor(interactor: CategoryInteractorImpl): CategoryInteractor

    @Binds
    abstract fun provideCommonInteractor(interactor: CommonInteractorImpl): CommonInteractor

}