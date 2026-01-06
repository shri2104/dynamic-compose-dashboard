package com.example.assignemnt.Data.fake

import com.example.assignemnt.Data.model.BannerConfig

object BannerDataGenerator {

    fun getBanner(instanceId: String): List<BannerConfig> {
        return when (instanceId) {

            "pokemon" -> listOf(
                BannerConfig("Bulbasaur", "Grass"),
                BannerConfig("Squirtle", "Water")
            )

            "cars" -> listOf(
                BannerConfig("Audi", "Premium"),
                BannerConfig("Mercedes", "Luxury")
            )

            else -> listOf(
                BannerConfig("Default", "Banner")
            )
        }
    }
}