package tech.iosd.gemselections.Retrofit;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingPapasamyamReportRequest;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingPartnerReport;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingSimpleRequest;
import tech.iosd.gemselections.Retrofit.RequestModels.NumerologyReportRequest;
import tech.iosd.gemselections.Retrofit.RequestModels.PdfRequestModel;
import tech.iosd.gemselections.Retrofit.RequestModels.SipmleMoonPhaseRequst;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologyComplexRequest;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequest;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequestTwo;
import tech.iosd.gemselections.Retrofit.ResponseModels.AyanmshaResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.BasicAstroDetailsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.BasicAstroPlanetsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.BasicAstroResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.BasicGemSuggestionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.BasicPanchangResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.CompositeHoroscopeResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.CurrentCharDashaResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.CurrentYoginiDashaResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.DailyTransitsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.FriendshipReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.GeneralAscendantReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.GeneralHoroscopeChartReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.GeneralHouseReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.GeneralMoonBioRythmResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.GeneralPlanetNatureResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.KalSarpaDetailsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.KarmaDestinyResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.LifeForecastResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.LoveCompatibilityResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.LunarMetricsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MadhyaBhavResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MajorCharDashaResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MajorYoginiDashaResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.ManglikDetailResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchAshtakootPointsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchAstroDetailsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchBirthDetailResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchDashakootPointsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchMakingDetailedReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchMakingReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchManglikReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchObstructionsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchPercentageResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchPlanetDetailsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchSimpleReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MonthlyPredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MonthlyTransitResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.NextPredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.NumeroDailyPredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.NumeroFavTimeResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.NumeroGemSuggestionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.NumeroPlaceVastuResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.NumerologyReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PapasamyamDetailsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PartnerReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PdfHoroscopeResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PersonalityReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PersonalizedPlanetPredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PitraDoshResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PlanetPanchangResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.ResponseForMoonPhaseReport;
import tech.iosd.gemselections.Retrofit.ResponseModels.RomanticCoupleForecastResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.RomanticForecastResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.RomanticPersonalityResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.SolarReturnHouseResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.SolarReturnPlanetsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.SolarReturnResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.SubCharDashaResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.WeeklyPredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.WeeklyTransitResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.WesternChartResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.WesternHoroscopeResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.ZodiacCompatibilityResponse;

/**
 * Created by anubhavmalik on 04/03/18.
 */

public interface AstrologyApiInterface {

    String HEADER_TOKEN = "Basic NjAxNjk2Ojg1MTBlNTM3YmNjNDI0ZTE1NGEzODYwZTcwZTkyMjA5"; //follow convention if using somewhere else


    /**
     * --------------------------------------------------------------------DAILY HOROSCOPE -------------------------------------------------------------
     */


    @POST("sun_sign_prediction/daily/{horoscope}")
    Call<PredictionResponse> getTodaysHoroscope(
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );

    @POST("horoscope_prediction/daily/next/{horoscope}")
    Call<NextPredictionResponse> getNextHoroscope(
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );

    @POST("horoscope_prediction/daily/previous/{horoscope}")
    Call<NextPredictionResponse> getPreviousHoroscope(
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );

    @POST("horoscope_prediction/weekly/{horoscope}")
    Call<WeeklyPredictionResponse> getWeeklyHoroscope(
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );

    @POST("horoscope_prediction/monthly/{horoscope}")
    Call<MonthlyPredictionResponse> getMonthlyHoroscope(
            @Header("Authorization") String token,
            @Path("horoscope") String horoscope
    );

    /**
     * ------------------------------------------------------------WESTERN ASTROLOGY ---------------------------------------------------------
     */


    @Headers("Content-Type:application/json")
    @POST("western_horoscope")
    Call<WesternHoroscopeResponse> getWesternHoroscope(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("western_chart_data")
    Call<WesternChartResponse> getWesternHoroscopeChart(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("tropical_transits/daily")
    Call<DailyTransitsResponse> getDailyTransit(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequestTwo westernAstrologySimpleRequestTwo
    );

    @POST("tropical_transits/weekly")
    Call<WeeklyTransitResponse> getWeeklyTransit(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequestTwo westernAstrologySimpleRequestTwo
    );

    @POST("tropical_transits/monthly")
    Call<MonthlyTransitResponse> getMonthlyTransit(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequestTwo westernAstrologySimpleRequestTwo
    );

    @POST("solar_return_details")
    Call<SolarReturnResponse> getSolarReturn(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("solar_return_planets")
    Call<List<SolarReturnPlanetsResponse>> getSolarReturnPlanet(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("solar_return_house_cusps")
    Call<SolarReturnHouseResponse> getSolarReturnHouse(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("lunar_metrics")
    Call<LunarMetricsResponse> getLunarMetrics(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("composite_horoscope")
    Call<CompositeHoroscopeResponse> getCompositeHoroscope(
            @Header("Authorization") String token,
            @Body WesternAstrologyComplexRequest westernAstrologyComplexRequest
    );

    @POST("synastry_horoscope")
    Call<CompositeHoroscopeResponse> getSynastryHoroscope(
            @Header("Authorization") String token,
            @Body WesternAstrologyComplexRequest westernAstrologyComplexRequest
    );

    @POST("personality_report/tropical")
    Call<PersonalityReportResponse> getPersonalityReport(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("romantic_personality_report/tropical")
    Call<RomanticPersonalityResponse> getRomanticPersonalityReport(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );
    //add planet Name
    @POST("personalized_planet_prediction/daily/{planetName}")
    Call<PersonalizedPlanetPredictionResponse> getPersonalizedPrediction(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("life_forecast_report/tropical")
    Call<LifeForecastResponse> getLifeForecastReport(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("romantic_forecast_report/tropical")
    Call<RomanticForecastResponse> getRomanticForecastReport(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("friendship_report/tropical")
    Call<FriendshipReportResponse> getFriendshipReport(
            @Header("Authorization") String token,
            @Body WesternAstrologyComplexRequest westernAstrologyComplexRequest
    );

    @POST("karma_destiny_report/tropical")
    Call<KarmaDestinyResponse> getKarmaReport(
            @Header("Authorization") String token,
            @Body WesternAstrologyComplexRequest westernAstrologyComplexRequest
    );

    @POST("love_compatibility_report/tropical")
    Call<LoveCompatibilityResponse> getLoveCompatibilityReport(
            @Header("Authorization") String token,
            @Body WesternAstrologyComplexRequest westernAstrologyComplexRequest
    );

    @POST("romantic_forecast_couple_report/tropical")
    Call<RomanticCoupleForecastResponse> getRomanticCoupleForecast(
            @Header("Authorization") String token,
            @Body WesternAstrologyComplexRequest westernAstrologyComplexRequest
    );

    @POST("zodiac_compatibility/{zodiacName}/{partnerZodiacName}")
    Call<ZodiacCompatibilityResponse> getZodiacCompatibility(
            @Header("Authorization") String token,
            @Path("zodiacName") String zodiacName,
            @Path("partnerZodiacName") String partnerZodiacName
    );

    @POST("compatibility/{sunSign}/{risingSign}/{partnerSunSign}/{partnerRisingSign}")
    Call<SunsignCompatibilityResponse> getSunSignCompatibilityReport(
            @Header("Authorization") String token,
            @Path("sunSign") String sunSign,
            @Path("risingSign") String risingSun,
            @Path("partnerSunSign") String partnerSunSign,
            @Path("partnerRisingSign") String partnerRisingSign
    );


    /**
     * --------------------------------------------------------------MATCH MAKING----------------------------------------------------------------
     */


    @POST("match_birth_details")
    Call<MatchBirthDetailResponse> getMatchBirthDetailsResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("match_ashtakoot_points")
    Call<MatchAshtakootPointsResponse> getMatchAshtakootPointsResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("match_obstructions")
    Call<MatchObstructionsResponse> getMatchObstructionsResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("match_astro_details")
    Call<MatchAstroDetailsResponse> getMatchAstroDetailsResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("match_planet_details")
    Call<MatchPlanetDetailsResponse> getMAtchPlanetDetailsResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("match_manglik_report")
    Call<MatchManglikReportResponse> getMatchManglikReportResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("match_making_report")
    Call<MatchMakingReportResponse> getMatchMakingReportResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("match_simple_report")
    Call<MatchSimpleReportResponse> getMatchSimpleReportResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("match_making_detailed_report")
    Call<MatchMakingDetailedReportResponse> getMatchMakingDetailedReportResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("match_dashakoot_points")
    Call<MatchDashakootPointsResponse> getMatchMakingDashakootPointsResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("match_percentage")
    Call<MatchPercentageResponse> getMatchPercentageResponse(@Header("Authorization") String token, @Body MatchMakingSimpleRequest matchMakingSimpleRequest);

    @POST("partner_report")
    Call<PartnerReportResponse> getPartnerReportResponse(@Header("Authorization") String token, @Body MatchMakingPartnerReport matchMakingPartnerReport);

    @POST("papasamyam_details")
    Call<PapasamyamDetailsResponse> getPapaResponse(@Header("Authorization") String token, @Body MatchMakingPapasamyamReportRequest matchMakingPapasamyamReportRequest);


    /**
     * ---------------------------------------------------------------PDF HOROSCOPE----------------------------------------------------------
     */

    @Headers("Content-Type:application/json")
    @POST("basic_horoscope_pdf")
    Call<PdfHoroscopeResponse> sendPdfDetails(
            @Header("Authorization") String token,
            @Body PdfRequestModel pdfRequestModel
    );

    @POST
    Call<ResponseBody> getPdfHoroscope(
            @Header("Authorization") String token,
            @Url String url);

    /**
     * ----------------------------------------------------------- Indian Astrology ---------------------------------------------------------
     */

    @POST("general_house_report/{planet_name}")
    Call<GeneralHouseReportResponse> getGeneralHouseReport(
            @Header("Authorization") String token,
            @Path("planet_name") String planetName,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("general_ascendant_report")
    Call<GeneralAscendantReportResponse> getGeneralAscendantReport(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("planet_nature")
    Call<GeneralPlanetNatureResponse> getGeneralPlanetNatureReport(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("moon_biorhythm")
    Call<GeneralMoonBioRythmResponse> getGeneralMoonBioRythmReport(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("horo_chart/MOON")
    Call<List<GeneralHoroscopeChartReportResponse>> getGeneralHoroscopeChartReport(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("kalsarpa_details")
    Call<KalSarpaDetailsResponse> getKalSarpaDetails(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("birth_details")
    Call<BasicAstroResponse> getBasicAstro(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("astro_details")
    Call<BasicAstroDetailsResponse> getBasicAstroDetails(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("planets")
    Call<List<BasicAstroPlanetsResponse>> getBasicAstroPlanets(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("bhav_madhya")
    Call<MadhyaBhavResponse> getBasicAstroMadhyaBhav(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("ayanamsha")
    Call<List<AyanmshaResponse>> getAyanmsha(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("major_chardasha")
    Call<List<MajorCharDashaResponse>> getMajorCharDasha(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("current_chardasha")
    Call<CurrentCharDashaResponse> getCurrentCharDasha(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("sub_chardasha")
    Call<SubCharDashaResponse> getSubCharDasha(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("sub_sub_chardasha")
    Call<CurrentCharDashaResponse> getSubSubCharDasha(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("basic_gem_suggestion")
    Call<BasicGemSuggestionResponse> getBasicGemSuggestion(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("numero_gem_suggestion")
    Call<NumeroGemSuggestionResponse> getNumeroGemSuggestion(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("basic_panchang")
    Call<BasicPanchangResponse> getBasicPanchang(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("planet_panchang")
    Call<List<PlanetPanchangResponse>> getPlanetPanchang(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("major_yogini_dasha")
    Call<List<MajorYoginiDashaResponse>> getMajorYoginiDasha(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("current_yogini_dasha")
    Call<CurrentYoginiDashaResponse> getCurrentYoginiDasha(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest);

    @POST("numero_report")
    Call<NumerologyReportResponse> getNumerologyReport(
            @Header("Authorization") String token,
            @Body NumerologyReportRequest numerologyReportRequest);

    @POST("numero_fav_time")
    Call<NumeroFavTimeResponse> getNumeroFavTime(
            @Header("Authorization") String token,
            @Body NumerologyReportRequest numerologyReportRequest);

    @POST("numero_place_vastu")
    Call<NumeroPlaceVastuResponse> getNumeroPlaceVastu(
            @Header("Authorization") String token,
            @Body NumerologyReportRequest numerologyReportRequest);

    @POST("numero_prediction/daily")
    Call<NumeroDailyPredictionResponse> getNumeroDailyPrediction(
            @Header("Authorization") String token,
            @Body NumerologyReportRequest numerologyReportRequest);

    @POST("manglik")
    Call<ManglikDetailResponse> getManglikDetails(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("pitra_dosha_report")
    Call<PitraDoshResponse> getPitraDoshDetails(
            @Header("Authorization") String token,
            @Body WesternAstrologySimpleRequest westernAstrologySimpleRequest
    );

    @POST("moon_phase_report")
    Call<ResponseForMoonPhaseReport> getMoonPhaseReport(
            @Header("Authorization") String token, @Body SipmleMoonPhaseRequst sipmleMoonPhaseRequst
            );
}
