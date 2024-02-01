package com.agnitt.remember.di

import com.agnitt.remember.data.CategoryRepositoryImpl
import com.agnitt.remember.data.ItemsRepositoryImpl
import com.agnitt.remember.domain.CategoryRepository
import com.agnitt.remember.domain.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun provideItemsRepository(repo: ItemsRepositoryImpl): ItemsRepository

    @Binds
    abstract fun provideCategoryRepository(repo: CategoryRepositoryImpl): CategoryRepository

}