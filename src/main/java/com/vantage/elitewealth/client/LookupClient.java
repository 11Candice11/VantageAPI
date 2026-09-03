package com.vantage.elitewealth.client;

import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class LookupClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public LookupClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    /**
     * Generic lookup call: GET /restApiData/Lookup/{interfaceLanguageL}/{category}/{type}
     * Returns the raw list from the upstream server.
     */
    public List<Object> getLookup(String interfaceLanguageL, String category, String type) {
        String url = baseUrl + "/restApiData/Lookup/" + interfaceLanguageL + "/" + category + "/" + type;
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    // ── Asset group ────────────────────────────────────────────────────────────

    public List<Object> getAssetClasses(String lang) {
        return getLookup(lang, "Asset", "asset-classes");
    }

    public List<Object> getAssetSubClasses(String lang) {
        return getLookup(lang, "Asset", "asset-sub-classes");
    }

    public List<Object> getInstrumentTypes(String lang) {
        return getLookup(lang, "Asset", "instrument-types");
    }

    // ── Astute group ───────────────────────────────────────────────────────────

    public List<Object> getAstuteRiskProfiles(String lang) {
        return getLookup(lang, "Astute", "risk-profiles");
    }

    public List<Object> getAstuteProductTypes(String lang) {
        return getLookup(lang, "Astute", "product-types");
    }

    // ── Cashflow group ─────────────────────────────────────────────────────────

    public List<Object> getCashflowFrequencies(String lang) {
        return getLookup(lang, "Cashflow", "frequencies");
    }

    public List<Object> getCashflowTypes(String lang) {
        return getLookup(lang, "Cashflow", "types");
    }

    // ── Entity group ───────────────────────────────────────────────────────────

    public List<Object> getAddressTypes(String lang) {
        return getLookup(lang, "Entity", "address-types");
    }

    public List<Object> getEmailTypes(String lang) {
        return getLookup(lang, "Entity", "email-types");
    }

    public List<Object> getTelephoneTypes(String lang) {
        return getLookup(lang, "Entity", "telephone-types");
    }

    public List<Object> getBankAccountTypes(String lang) {
        return getLookup(lang, "Entity", "bank-account-types");
    }

    public List<Object> getEntityTypes(String lang) {
        return getLookup(lang, "Entity", "entity-types");
    }

    public List<Object> getGenders(String lang) {
        return getLookup(lang, "Entity", "genders");
    }

    public List<Object> getMaritalStatuses(String lang) {
        return getLookup(lang, "Entity", "marital-statuses");
    }

    public List<Object> getTitles(String lang) {
        return getLookup(lang, "Entity", "titles");
    }

    public List<Object> getCountries(String lang) {
        return getLookup(lang, "Entity", "countries");
    }

    public List<Object> getRelationTypes(String lang) {
        return getLookup(lang, "Entity", "relation-types");
    }

    public List<Object> getIndustryTypes(String lang) {
        return getLookup(lang, "Entity", "industry-types");
    }

    public List<Object> getQualificationTypes(String lang) {
        return getLookup(lang, "Entity", "qualification-types");
    }

    public List<Object> getInterestTypes(String lang) {
        return getLookup(lang, "Entity", "interest-types");
    }

    // ── FNA group ──────────────────────────────────────────────────────────────

    public List<Object> getFnaCategories(String lang) {
        return getLookup(lang, "FNA", "categories");
    }

    public List<Object> getFnaRiskTypes(String lang) {
        return getLookup(lang, "FNA", "risk-types");
    }

    // ── Instrument group ───────────────────────────────────────────────────────

    public List<Object> getInstrumentStatuses(String lang) {
        return getLookup(lang, "Instrument", "statuses");
    }

    public List<Object> getCurrencies(String lang) {
        return getLookup(lang, "Instrument", "currencies");
    }

    // ── Portfolio group ────────────────────────────────────────────────────────

    public List<Object> getPortfolioTypes(String lang) {
        return getLookup(lang, "Portfolio", "portfolio-types");
    }

    public List<Object> getPortfolioStatuses(String lang) {
        return getLookup(lang, "Portfolio", "statuses");
    }

    public List<Object> getFeeTypes(String lang) {
        return getLookup(lang, "Portfolio", "fee-types");
    }

    // ── Shared group ───────────────────────────────────────────────────────────

    public List<Object> getLanguages(String lang) {
        return getLookup(lang, "Shared", "languages");
    }

    public List<Object> getTimeZones(String lang) {
        return getLookup(lang, "Shared", "time-zones");
    }

    // ── Tool group ─────────────────────────────────────────────────────────────

    public List<Object> getToolTypes(String lang) {
        return getLookup(lang, "Tool", "tool-types");
    }

    public List<Object> getToolStatuses(String lang) {
        return getLookup(lang, "Tool", "statuses");
    }
}
