package com.ray.mvvmdemo.model.data


import com.google.gson.annotations.SerializedName

class FlightModel : ArrayList<FlightModel.flightModelItem>(){
    data class flightModelItem(
        @SerializedName("crew")
        var crew: List<Any>,
        @SerializedName("details")
        var details: String,
        @SerializedName("flight_number")
        var flightNumber: Int,
        @SerializedName("is_tentative")
        var isTentative: Boolean,
        @SerializedName("last_date_update")
        var lastDateUpdate: String,
        @SerializedName("last_ll_launch_date")
        var lastLlLaunchDate: String,
        @SerializedName("last_ll_update")
        var lastLlUpdate: String,
        @SerializedName("last_wiki_launch_date")
        var lastWikiLaunchDate: String,
        @SerializedName("last_wiki_revision")
        var lastWikiRevision: String,
        @SerializedName("last_wiki_update")
        var lastWikiUpdate: String,
        @SerializedName("launch_date_local")
        var launchDateLocal: String,
        @SerializedName("launch_date_source")
        var launchDateSource: String,
        @SerializedName("launch_date_unix")
        var launchDateUnix: Int,
        @SerializedName("launch_date_utc")
        var launchDateUtc: String,
        @SerializedName("launch_failure_details")
        var launchFailureDetails: LaunchFailureDetails,
        @SerializedName("launch_site")
        var launchSite: LaunchSite,
        @SerializedName("launch_success")
        var launchSuccess: Boolean,
        @SerializedName("launch_window")
        var launchWindow: Int,
        @SerializedName("launch_year")
        var launchYear: String,
        @SerializedName("links")
        var links: Links,
        @SerializedName("mission_id")
        var missionId: List<Any>,
        @SerializedName("mission_name")
        var missionName: String,
        @SerializedName("rocket")
        var rocket: Rocket,
        @SerializedName("ships")
        var ships: List<Any>,
        @SerializedName("static_fire_date_unix")
        var staticFireDateUnix: Int,
        @SerializedName("static_fire_date_utc")
        var staticFireDateUtc: String,
        @SerializedName("tbd")
        var tbd: Boolean,
        @SerializedName("telemetry")
        var telemetry: Telemetry,
        @SerializedName("tentative_max_precision")
        var tentativeMaxPrecision: String,
        @SerializedName("timeline")
        var timeline: Timeline,
        @SerializedName("upcoming")
        var upcoming: Boolean
    ) {
        data class LaunchFailureDetails(
            @SerializedName("altitude")
            var altitude: Int,
            @SerializedName("reason")
            var reason: String,
            @SerializedName("time")
            var time: Int
        )
    
        data class LaunchSite(
            @SerializedName("site_id")
            var siteId: String,
            @SerializedName("site_name")
            var siteName: String,
            @SerializedName("site_name_long")
            var siteNameLong: String
        )
    
        data class Links(
            @SerializedName("article_link")
            var articleLink: Any,
            @SerializedName("flickr_images")
            var flickrImages: List<Any>,
            @SerializedName("mission_patch")
            var missionPatch: Any,
            @SerializedName("mission_patch_small")
            var missionPatchSmall: Any,
            @SerializedName("presskit")
            var presskit: Any,
            @SerializedName("reddit_campaign")
            var redditCampaign: Any,
            @SerializedName("reddit_launch")
            var redditLaunch: Any,
            @SerializedName("reddit_media")
            var redditMedia: Any,
            @SerializedName("reddit_recovery")
            var redditRecovery: Any,
            @SerializedName("video_link")
            var videoLink: Any,
            @SerializedName("wikipedia")
            var wikipedia: Any,
            @SerializedName("youtube_id")
            var youtubeId: Any
        )
    
        data class Rocket(
            @SerializedName("fairings")
            var fairings: Fairings,
            @SerializedName("first_stage")
            var firstStage: FirstStage,
            @SerializedName("rocket_id")
            var rocketId: String,
            @SerializedName("rocket_name")
            var rocketName: String,
            @SerializedName("rocket_type")
            var rocketType: String,
            @SerializedName("second_stage")
            var secondStage: SecondStage
        ) {
            data class Fairings(
                @SerializedName("recovered")
                var recovered: Any,
                @SerializedName("recovery_attempt")
                var recoveryAttempt: Any,
                @SerializedName("reused")
                var reused: Any,
                @SerializedName("ship")
                var ship: Any
            )
    
            data class FirstStage(
                @SerializedName("cores")
                var cores: List<Core>
            ) {
                data class Core(
                    @SerializedName("block")
                    var block: Int,
                    @SerializedName("core_serial")
                    var coreSerial: Any,
                    @SerializedName("flight")
                    var flight: Any,
                    @SerializedName("gridfins")
                    var gridfins: Any,
                    @SerializedName("land_success")
                    var landSuccess: Any,
                    @SerializedName("landing_intent")
                    var landingIntent: Any,
                    @SerializedName("landing_type")
                    var landingType: Any,
                    @SerializedName("landing_vehicle")
                    var landingVehicle: Any,
                    @SerializedName("legs")
                    var legs: Any,
                    @SerializedName("reused")
                    var reused: Any
                )
            }
    
            data class SecondStage(
                @SerializedName("block")
                var block: Int,
                @SerializedName("payloads")
                var payloads: List<Payload>
            ) {
                data class Payload(
                    @SerializedName("customers")
                    var customers: List<String>,
                    @SerializedName("manufacturer")
                    var manufacturer: String,
                    @SerializedName("nationality")
                    var nationality: String,
                    @SerializedName("norad_id")
                    var noradId: List<Any>,
                    @SerializedName("orbit")
                    var orbit: String,
                    @SerializedName("orbit_params")
                    var orbitParams: OrbitParams,
                    @SerializedName("payload_id")
                    var payloadId: String,
                    @SerializedName("payload_mass_kg")
                    var payloadMassKg: Any,
                    @SerializedName("payload_mass_lbs")
                    var payloadMassLbs: Any,
                    @SerializedName("payload_type")
                    var payloadType: String,
                    @SerializedName("reused")
                    var reused: Boolean
                ) {
                    data class OrbitParams(
                        @SerializedName("apoapsis_km")
                        var apoapsisKm: Any,
                        @SerializedName("arg_of_pericenter")
                        var argOfPericenter: Any,
                        @SerializedName("eccentricity")
                        var eccentricity: Any,
                        @SerializedName("epoch")
                        var epoch: Any,
                        @SerializedName("inclination_deg")
                        var inclinationDeg: Any,
                        @SerializedName("lifespan_years")
                        var lifespanYears: Any,
                        @SerializedName("longitude")
                        var longitude: Any,
                        @SerializedName("mean_anomaly")
                        var meanAnomaly: Any,
                        @SerializedName("mean_motion")
                        var meanMotion: Any,
                        @SerializedName("periapsis_km")
                        var periapsisKm: Any,
                        @SerializedName("period_min")
                        var periodMin: Any,
                        @SerializedName("raan")
                        var raan: Any,
                        @SerializedName("reference_system")
                        var referenceSystem: String,
                        @SerializedName("regime")
                        var regime: String,
                        @SerializedName("semi_major_axis_km")
                        var semiMajorAxisKm: Any
                    )
                }
            }
        }
    
        data class Telemetry(
            @SerializedName("flight_club")
            var flightClub: Any
        )
    
        data class Timeline(
            @SerializedName("beco")
            var beco: Int,
            @SerializedName("center_core_entry_burn")
            var centerCoreEntryBurn: Int,
            @SerializedName("center_core_landing")
            var centerCoreLanding: Int,
            @SerializedName("center_stage_sep")
            var centerStageSep: Int,
            @SerializedName("engine_chill")
            var engineChill: Int,
            @SerializedName("fairing_deploy")
            var fairingDeploy: Int,
            @SerializedName("go_for_launch")
            var goForLaunch: Int,
            @SerializedName("go_for_prop_loading")
            var goForPropLoading: Int,
            @SerializedName("ignition")
            var ignition: Int,
            @SerializedName("liftoff")
            var liftoff: Int,
            @SerializedName("maxq")
            var maxq: Int,
            @SerializedName("meco")
            var meco: Int,
            @SerializedName("payload_deploy")
            var payloadDeploy: Int,
            @SerializedName("prelaunch_checks")
            var prelaunchChecks: Int,
            @SerializedName("propellant_pressurization")
            var propellantPressurization: Int,
            @SerializedName("seco-1")
            var seco1: Int,
            @SerializedName("seco-2")
            var seco2: Int,
            @SerializedName("seco-3")
            var seco3: Int,
            @SerializedName("seco-4")
            var seco4: Int,
            @SerializedName("second_stage_ignition")
            var secondStageIgnition: Int,
            @SerializedName("second_stage_restart")
            var secondStageRestart: Int,
            @SerializedName("side_core_boostback")
            var sideCoreBoostback: Int,
            @SerializedName("side_core_entry_burn")
            var sideCoreEntryBurn: Int,
            @SerializedName("side_core_landing")
            var sideCoreLanding: Int,
            @SerializedName("side_core_sep")
            var sideCoreSep: Int,
            @SerializedName("stage1_lox_loading")
            var stage1LoxLoading: Int,
            @SerializedName("stage1_rp1_loading")
            var stage1Rp1Loading: Int,
            @SerializedName("stage2_lox_loading")
            var stage2LoxLoading: Int,
            @SerializedName("stage2_rp1_loading")
            var stage2Rp1Loading: Int,
            @SerializedName("webcast_liftoff")
            var webcastLiftoff: Any
        )
    }
}