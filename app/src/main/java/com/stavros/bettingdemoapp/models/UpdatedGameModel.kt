package com.stavros.bettingdemoapp.models

data class UpdatedGameModel(
    val betViews: List<BetView>,
    val caption: String,
    val hasHighlights: Boolean,
    val marketViewKey: String,
    val marketViewType: String,
    val modelType: String,
    val totalCount: Int
) {
    data class BetView(
        val betViewKey: String,
        val competitionContextCaption: String,
        val competitions: List<Competition>,
        val marketCaptions: List<MarketCaption>,
        val modelType: String,
        val totalCount: Int
    ) {
        data class Competition(
            val betContextId: Int,
            val caption: String,
            val events: List<Event>,
            val regionCaption: String
        ) {
            data class Event(
                val additionalCaptions: AdditionalCaptions,
                val betContextId: Int,
                val hasBetContextInfo: Boolean,
                val isHighlighted: Boolean,
                val liveData: LiveData,
                val markets: List<Market>,
                val path: String
            ) {
                data class AdditionalCaptions(
                    val competitor1: String,
                    val competitor1ImageId: Int,
                    val competitor2: String,
                    val competitor2ImageId: Int,
                    val type: Int
                )

                data class LiveData(
                    val adjustTimeMillis: Int,
                    val awayPoints: Int,
                    val duration: String,
                    val durationSeconds: Int,
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
                    val quarterScores: Any,
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
                )

                data class Market(
                    val betItems: List<BetItem>,
                    val betTypeSysname: String,
                    val marketId: Int
                ) {
                    data class BetItem(
                        val caption: String,
                        val code: String,
                        val id: Int,
                        val instanceCaption: String,
                        val isAvailable: Boolean,
                        val oddsText: String,
                        val price: Double
                    )
                }
            }
        }

        data class MarketCaption(
            val betCaptions: Any,
            val betTypeSysname: String,
            val marketCaption: String
        )
    }
}