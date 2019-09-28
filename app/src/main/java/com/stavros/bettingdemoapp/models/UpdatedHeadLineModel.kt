package com.stavros.bettingdemoapp.models

data class UpdatedHeadLineModel(
    val betViews: List<BetView>,
    val caption: String,
    val marketViewKey: String,
    val marketViewType: String,
    val modelType: String
) {
    data class BetView(
        val betContextId: Int,
        val betItems: List<BetItem>,
        val betViewKey: String,
        val competitor1Caption: String,
        val competitor2Caption: String,
        val displayFormat: String,
        val imageId: Int,
        val liveData: LiveData,
        val marketTags: List<Any>,
        val marketViewGroupId: Int,
        val marketViewId: Int,
        val modelType: String,
        val path: String,
        val rootMarketViewGroupId: Int,
        val startTime: String,
        val text: String,
        val title: String,
        val url: String
    ) {
        data class BetItem(
            val caption: String,
            val code: String,
            val id: Int,
            val instanceCaption: Any,
            val isAvailable: Boolean,
            val oddsText: String,
            val price: Double
        )

        data class LiveData(
            val adjustTimeMillis: Int,
            val awayPoints: Int,
            val duration: String,
            val durationSeconds: Double,
            val elapsed: String,
            val elapsedSeconds: Double,
            val homePoints: Int,
            val homePossession: Boolean,
            val isInPlay: Boolean,
            val isInPlayPaused: Boolean,
            val isInterrupted: Boolean,
            val isLive: Boolean,
            val liveStreamingCountries: String,
            val phaseCaption: String,
            val phaseCaptionLong: String,
            val phaseSysname: String,
            val quarterScores: List<QuarterScore>,
            val referenceTime: String,
            val referenceTimeUnix: Int,
            val remaining: String,
            val remainingSeconds: Double,
            val sportradarMatchId: Int,
            val supportsAchievements: Boolean,
            val supportsActions: Boolean,
            val timeToNextPhase: Any,
            val timeToNextPhaseSeconds: Any,
            val timeline: Any
        ) {
            data class QuarterScore(
                val awayScore: Int,
                val caption: String,
                val homeScore: Int
            )
        }
    }
}