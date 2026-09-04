package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.PortfolioExtractRequest;
import com.vantage.elitewealth.model.response.PortfolioExtractResponse;
import com.vantage.elitewealth.service.PortfolioService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;
    private static final DateTimeFormatter ISO = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    /**
     * POST /api/portfolio/extract
     * Generic extract — caller provides full request body.
     */
    @PostMapping("/extract")
    public ResponseEntity<PortfolioExtractResponse> extract(@RequestBody PortfolioExtractRequest request) {
        return ResponseEntity.ok(portfolioService.extract(request));
    }

    /**
     * GET /api/portfolio/transactions/{entityId}?dateFrom=yyyy-MM-dd&dateTo=yyyy-MM-dd
     *
     * Convenience endpoint: builds the full extract request with sensible defaults
     * and returns the TransactionOutputModels + ValueOutputModels.
     */
    @GetMapping("/transactions/{entityId}")
    public ResponseEntity<PortfolioExtractResponse> getTransactions(
            @PathVariable String entityId,
            @RequestParam(defaultValue = "2020-01-01") String dateFrom,
            @RequestParam(defaultValue = "") String dateTo) {

        String toDate = dateTo.isBlank()
                ? LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                : dateTo;

        String dateFromIso  = toIso(dateFrom);
        String dateToIso    = toIso(toDate);
        String valueDate    = dateToIso; // value as of "today" end date

        PortfolioExtractRequest req = new PortfolioExtractRequest();
        req.setEntityIds(List.of(entityId));
        req.setValueInputModels(List.of(
                new PortfolioExtractRequest.ValueInputModel(valueDate, 5, 170)
        ));
        req.setTransactionInputModels(List.of(
                new PortfolioExtractRequest.TransactionInputModel(dateFromIso, dateToIso, 170)
        ));
        req.setAssetExposureInputModels(List.of(
                new PortfolioExtractRequest.AssetExposureInputModel(valueDate, 159, 170)
        ));

        return ResponseEntity.ok(portfolioService.extract(req));
    }

    /** Convert yyyy-MM-dd to yyyy-MM-dd'T'00:00:00 */
    private static String toIso(String date) {
        if (date.contains("T")) return date;
        return date + "T00:00:00";
    }
}
