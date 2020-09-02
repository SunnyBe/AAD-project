package com.sunday.aadproject.main.util

import com.sunday.aadproject.main.entity.PagerItem

object Content {
    fun slideList() = mutableListOf<String>("Leaning Leaders", "Skill IQ Leaders")
    fun testItems(): MutableList<PagerItem> = mutableListOf(
        PagerItem(
            name = "Test User 1",
            hours = 40,
            country = "Nigeria",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png"
        ),
        PagerItem(
            name = "Test User 2",
            hours = 40,
            country = "Ghana",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png"
        ),
        PagerItem(
            name = "Test User 3",
            hours = 40,
            country = "Nigeria",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png"
        ),
        PagerItem(
            name = "Test User 4",
            hours = 40,
            country = "Ghana",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png"
        ),
        PagerItem(
            name = "Test User 5",
            hours = 40,
            country = "Nigeria",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png"
        ),
        PagerItem(
            name = "Test User 6",
            hours = 40,
            country = "Ghana",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png"
        )
    )

    fun testItems2(): MutableList<PagerItem> = mutableListOf(
        PagerItem(
            name = "Skill User 1",
            score = 240,
            country = "Nigeria",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"
        ),
        PagerItem(
            name = "Skill User 2",
            score = 290,
            country = "Ghana",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"
        ),
        PagerItem(
            name = "Skill User 3",
            score = 240,
            country = "Nigeria",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"
        ),
        PagerItem(
            name = "Skill User 4",
            score = 290,
            country = "Ghana",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"
        ),
        PagerItem(
            name = "Skill User 5",
            score = 240,
            country = "Nigeria",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"
        ),
        PagerItem(
            name = "Skill User 6",
            score = 290,
            country = "Ghana",
            badgeUrl = "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"
        )
    )
}