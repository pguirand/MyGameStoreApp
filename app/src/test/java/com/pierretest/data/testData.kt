package com.pierretest.data

import com.pierretest.mygamestoreapp.data.model.gamesModel.MinimumSystemRequirementsModel
import com.pierretest.mygamestoreapp.data.model.gamesModel.ScreenshotModel
import com.pierretest.mygamestoreapp.data.model.gamesModel.SingleGameModel

object testData {

    val game1 = SingleGameModel(
        description = "Game description",
        developer = "Game developer",
        freetogameProfileUrl = "https://example.com/game-profile",
        gameUrl = "https://example.com/game",
        genre = "Action",
        id = 123,
        minimumSystemRequirements = MinimumSystemRequirementsModel(
            os = "Windows 10",
            processor = "Intel Core i5",
            memory = "8 GB RAM",
            graphics = "NVIDIA GeForce GTX 1050",
            storage = "50 GB available space"
        ),
        platform = "PC",
        publisher = "Game publisher",
        releaseDate = "2023-07-20",
        screenshots = listOf(
            ScreenshotModel(5, "https://example.com/screenshot1"),
            ScreenshotModel(6,"https://example.com/screenshot2")
        ),
        shortDescription = "Short game description",
        status = "Released",
        thumbnail = "https://example.com/thumbnail",
        title = "Awesome Game"
    )

    val game2 = SingleGameModel(
        description = "New game description",
        developer = "New game developer",
        freetogameProfileUrl = "https://example.com/new-game-profile",
        gameUrl = "https://example.com/new-game",
        genre = "Adventure",
        id = 456,
        // Add other properties with new values here
    )

    val game3 = SingleGameModel(
        description = "Exciting game with challenging missions",
        developer = "Game Studio X",
        freetogameProfileUrl = "https://example.com/game1-profile",
        gameUrl = "https://example.com/game1",
        genre = "RPG",
        id = 789,
        minimumSystemRequirements = MinimumSystemRequirementsModel(
            os = "Windows 7",
            processor = "Intel Core i3",
            memory = "4 GB RAM",
            graphics = "AMD Radeon HD 7850",
            storage = "30 GB available space"
        ),
        platform = "PC, Mac",
        publisher = "Game Publisher Y",
        releaseDate = "2024-02-15",
        screenshots = listOf(
            ScreenshotModel(2, "https://example.com/game1-screenshot1"),
            ScreenshotModel(3, "https://example.com/game1-screenshot2")
        ),
        shortDescription = "Embark on a thrilling adventure!",
        status = "Upcoming",
        thumbnail = "https://example.com/game1-thumbnail",
        title = "Fantastic Quest"
    )

    val game4 = SingleGameModel(
        description = "Survival game set in a post-apocalyptic world",
        developer = "Game Studio Z",
        freetogameProfileUrl = "https://example.com/game2-profile",
        gameUrl = "https://example.com/game2",
        genre = "Survival",
        id = 987,
        minimumSystemRequirements = MinimumSystemRequirementsModel(
            os = "Windows 8",
            processor = "AMD Ryzen 5",
            memory = "12 GB RAM",
            graphics = "NVIDIA GeForce GTX 1660 Ti",
            storage = "100 GB available space"
        ),
        platform = "PC, Xbox",
        publisher = "Game Publisher W",
        releaseDate = "2023-11-10",
        screenshots = listOf(
            ScreenshotModel(10, "https://example.com/game2-screenshot1"),
            ScreenshotModel(11, "https://example.com/game2-screenshot2")
        ),
        shortDescription = "Survive and explore in a desolate world!",
        status = "Released",
        thumbnail = "https://example.com/game2-thumbnail",
        title = "Apocalypse Now"
    )

    val game5 = SingleGameModel()
    val allGames = listOf(game1, game2, game3, game4, game5)

    val categoryList1 = listOf(game1, game2)
    val categoryListEmpty = listOf<SingleGameModel>()
}