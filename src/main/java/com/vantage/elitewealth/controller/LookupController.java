package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.client.LookupClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lookup")
public class LookupController {

    private final LookupClient lookupClient;

    public LookupController(LookupClient lookupClient) {
        this.lookupClient = lookupClient;
    }

    // ── Generic ─────────────────────────────────────────────────────────────

    /** GET /api/lookup/{lang}/{category}/{type} */
    @GetMapping("/{lang}/{category}/{type}")
    public ResponseEntity<List<Object>> get(
            @PathVariable String lang,
            @PathVariable String category,
            @PathVariable String type) {
        return ResponseEntity.ok(lookupClient.getLookup(lang, category, type));
    }

    // ── Asset ───────────────────────────────────────────────────────────────

    @GetMapping("/{lang}/asset/asset-classes")
    public ResponseEntity<List<Object>> getAssetClasses(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getAssetClasses(lang));
    }

    @GetMapping("/{lang}/asset/asset-sub-classes")
    public ResponseEntity<List<Object>> getAssetSubClasses(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getAssetSubClasses(lang));
    }

    @GetMapping("/{lang}/asset/instrument-types")
    public ResponseEntity<List<Object>> getInstrumentTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getInstrumentTypes(lang));
    }

    // ── Entity ──────────────────────────────────────────────────────────────

    @GetMapping("/{lang}/entity/address-types")
    public ResponseEntity<List<Object>> getAddressTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getAddressTypes(lang));
    }

    @GetMapping("/{lang}/entity/email-types")
    public ResponseEntity<List<Object>> getEmailTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getEmailTypes(lang));
    }

    @GetMapping("/{lang}/entity/telephone-types")
    public ResponseEntity<List<Object>> getTelephoneTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getTelephoneTypes(lang));
    }

    @GetMapping("/{lang}/entity/bank-account-types")
    public ResponseEntity<List<Object>> getBankAccountTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getBankAccountTypes(lang));
    }

    @GetMapping("/{lang}/entity/entity-types")
    public ResponseEntity<List<Object>> getEntityTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getEntityTypes(lang));
    }

    @GetMapping("/{lang}/entity/genders")
    public ResponseEntity<List<Object>> getGenders(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getGenders(lang));
    }

    @GetMapping("/{lang}/entity/marital-statuses")
    public ResponseEntity<List<Object>> getMaritalStatuses(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getMaritalStatuses(lang));
    }

    @GetMapping("/{lang}/entity/titles")
    public ResponseEntity<List<Object>> getTitles(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getTitles(lang));
    }

    @GetMapping("/{lang}/entity/countries")
    public ResponseEntity<List<Object>> getCountries(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getCountries(lang));
    }

    @GetMapping("/{lang}/entity/relation-types")
    public ResponseEntity<List<Object>> getRelationTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getRelationTypes(lang));
    }

    @GetMapping("/{lang}/entity/industry-types")
    public ResponseEntity<List<Object>> getIndustryTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getIndustryTypes(lang));
    }

    @GetMapping("/{lang}/entity/qualification-types")
    public ResponseEntity<List<Object>> getQualificationTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getQualificationTypes(lang));
    }

    @GetMapping("/{lang}/entity/interest-types")
    public ResponseEntity<List<Object>> getInterestTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getInterestTypes(lang));
    }

    // ── Portfolio ────────────────────────────────────────────────────────────

    @GetMapping("/{lang}/portfolio/portfolio-types")
    public ResponseEntity<List<Object>> getPortfolioTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getPortfolioTypes(lang));
    }

    @GetMapping("/{lang}/portfolio/statuses")
    public ResponseEntity<List<Object>> getPortfolioStatuses(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getPortfolioStatuses(lang));
    }

    @GetMapping("/{lang}/portfolio/fee-types")
    public ResponseEntity<List<Object>> getFeeTypes(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getFeeTypes(lang));
    }

    // ── Instrument ───────────────────────────────────────────────────────────

    @GetMapping("/{lang}/instrument/currencies")
    public ResponseEntity<List<Object>> getCurrencies(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getCurrencies(lang));
    }

    @GetMapping("/{lang}/instrument/statuses")
    public ResponseEntity<List<Object>> getInstrumentStatuses(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getInstrumentStatuses(lang));
    }

    // ── Shared ───────────────────────────────────────────────────────────────

    @GetMapping("/{lang}/shared/languages")
    public ResponseEntity<List<Object>> getLanguages(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getLanguages(lang));
    }

    @GetMapping("/{lang}/shared/time-zones")
    public ResponseEntity<List<Object>> getTimeZones(@PathVariable String lang) {
        return ResponseEntity.ok(lookupClient.getTimeZones(lang));
    }
}
